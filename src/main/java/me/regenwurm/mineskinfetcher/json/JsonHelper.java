package me.regenwurm.mineskinfetcher.json;

import com.google.gson.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class JsonHelper {

    private static final JsonParser JSON_PARSER = new JsonParser();
    private final JsonObject jsonObject;
    private final Gson gson;


    public JsonHelper() {
        this.jsonObject = new JsonObject();
        this.gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().setPrettyPrinting().create();
    }

    public JsonHelper(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        this.gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().setPrettyPrinting().create();

    }

    public String getString(String key) {
        if (!this.jsonObject.has(key)) return null;
        return this.jsonObject.get(key).getAsString();
    }

    public JsonHelper getDocument(String key) {
        return new JsonHelper(jsonObject.get(key).getAsJsonObject());
    }


    public Set<String> keySet(){
        Set<String> keys = new HashSet<>();
        jsonObject.entrySet().forEach(e -> {
            keys.add(e.getKey());
        });
        return keys;
    }

    public String toJsonString() {
        return gson.toJson(jsonObject.getAsJsonObject()).replace("_", "#");
    }


    public static JsonHelper load(String input) {
        return new JsonHelper(JSON_PARSER.parse(input.replace("#","_")).getAsJsonObject());
    }
    
}
