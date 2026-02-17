package me.blackfur.zombieconversion;

public enum ConversionSetting {
    ALWAYS,
    VANILLA,
    NEVER;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
