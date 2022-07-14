package me.regenwurm.mineskinfetcher;

import me.regenwurm.mineskinfetcher.exception.MineSkinFetchException;
import me.regenwurm.mineskinfetcher.json.JsonHelper;
import me.regenwurm.mineskinfetcher.model.SkinModel;
import me.regenwurm.mineskinfetcher.skin.MineSkin;
import me.regenwurm.mineskinfetcher.skin.impl.MineSkinImpl;
import me.regenwurm.mineskinfetcher.variant.SkinVariant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class MineSkinFetcher {

    private final static String ADDRESS = "https://api.mineskin.org/get/id/";


    public static MineSkin fetch(long skinId) throws MineSkinFetchException {
        URL url = null;

        try{
            url = new URL(ADDRESS + skinId);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String input;

            StringBuilder builder = new StringBuilder();
            while((input = reader.readLine()) != null) {
                builder.append(input);
            }
            reader.close();
            JsonHelper helper = JsonHelper.load(builder.toString());
            JsonHelper data = JsonHelper.load(helper.getDocument("data").toJsonString());
            JsonHelper skinData = JsonHelper.load(data.toJsonString()).getDocument("texture");

            int views = Integer.parseInt(helper.getString("views"));
            String value = skinData.getString("value");
            String signature = skinData.getString("signature");
            String hash = helper.getString("hash");
            String name = helper.getString("name");
            UUID accountUniqueId = UUID.fromString(data.getString("uuid"));
            String mineSkinUniqueId = helper.getString("uuid");
            long timestamp = Long.parseLong(helper.getString("timestamp"));
            SkinModel model = SkinModel.valueOf(helper.getString("model").toUpperCase());
            SkinVariant variant = SkinVariant.valueOf(helper.getString("variant").toUpperCase());
            return new MineSkinImpl(skinId, views, name, value, signature, hash, mineSkinUniqueId, accountUniqueId, timestamp, model, variant);
        } catch(IOException ex) {
            throw new MineSkinFetchException("Failed to fetch Skin#" + skinId + " from MineSkinAPI");
        }
    }

}
