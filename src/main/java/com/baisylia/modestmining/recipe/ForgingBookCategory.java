package com.baisylia.modestmining.recipe;

import net.minecraft.util.StringRepresentable;

public enum ForgingBookCategory implements StringRepresentable {

    EQUIPMENT("equipment"),
    BUILDING("building"),
    MISC("misc");

    public static final StringRepresentable.EnumCodec<ForgingBookCategory> CODEC = StringRepresentable.fromEnum(ForgingBookCategory::values);

    private final String name;

    ForgingBookCategory(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

}