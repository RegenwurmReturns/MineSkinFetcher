package me.regenwurm.mineskinfetcher.skin.impl;

import me.regenwurm.mineskinfetcher.model.SkinModel;
import me.regenwurm.mineskinfetcher.skin.MineSkin;
import me.regenwurm.mineskinfetcher.variant.SkinVariant;

import java.util.UUID;

public class MineSkinImpl implements MineSkin {

    private final int views;
    private final String name, value, signature, hash, mineSkinUniqueId;
    private final UUID accountUniqueId;
    private final long mineSkinId, timestamp;
    private final SkinModel skinModel;
    private final SkinVariant skinVariant;

    public MineSkinImpl(long mineSkinId, int views, String name, String value, String signature, String hash, String mineSkinUniqueId, UUID accountUniqueId, long timestamp,
                        SkinModel skinModel, SkinVariant skinVariant) {
        this.mineSkinId = mineSkinId;
        this.views = views;
        this.name = name;
        this.value = value;
        this.signature = signature;
        this.hash = hash;
        this.mineSkinUniqueId = mineSkinUniqueId;
        this.accountUniqueId = accountUniqueId;
        this.timestamp = timestamp;
        this.skinModel = skinModel;
        this.skinVariant = skinVariant;
    }

    @Override
    public long mineSkinId() {
        return mineSkinId;
    }

    @Override
    public int views() {
        return views;
    }

    @Override
    public String name() {
        return name == null ? "" : name;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String signature() {
        return signature;
    }

    @Override
    public long timeStamp() {
        return timestamp;
    }

    @Override
    public String hash() {
        return hash;
    }

    @Override
    public String mineSkinUniqueId() {
        return mineSkinUniqueId;
    }

    @Override
    public UUID accountUniqueId() {
        return accountUniqueId;
    }

    @Override
    public SkinModel skinModel() {
        return skinModel;
    }

    @Override
    public SkinVariant skinVariant() {
        return skinVariant;
    }
}
