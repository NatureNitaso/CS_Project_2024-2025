package net.zihui.csprojmod.entity.goal.enums;

public enum LeapTypes {
    SHORT(0.8F, 0.4F),
    MEDIUM(1.2F, 0.5F),
    LONG(1.6F, 0.7F),
    EXTREME(1.5F, 1F);

    private final float horizontalStrength;
    private final float verticalaStrength;

    LeapTypes(float horizontalStrength, float verticalaStrength) {
        this.horizontalStrength = horizontalStrength;
        this.verticalaStrength = verticalaStrength;
    }

    public float getHorizontalStrength() {
        return horizontalStrength;
    }

    public float getVerticalStrength() {
        return verticalaStrength;
    }
}
