package me.regenwurm.mineskinfetcher.skin;

import me.regenwurm.mineskinfetcher.model.SkinModel;
import me.regenwurm.mineskinfetcher.variant.SkinVariant;

import java.util.UUID;

public interface MineSkin {

    long mineSkinId();
    long timeStamp();
    int views();
    String name();
    String value();
    String signature();
    String hash();
    String mineSkinUniqueId();
    UUID accountUniqueId();
    SkinModel skinModel();
    SkinVariant skinVariant();

}
