package com.jme3.scene.shape;

public class CylinderData {
    private int axisSamples;
    private final int radialSamples;
    private final float radius;
    private final float radius2;
    private final float height;

    public CylinderData(int axisSamples, int radialSamples, float radius, float radius2, float height) {
        this.axisSamples = axisSamples;
        this.radialSamples = radialSamples;
        this.radius = radius;
        this.radius2 = radius2;
        this.height = height;
    }

    public int getAxisSamples() {
        return axisSamples;
    }

    public int getRadialSamples() {
        return radialSamples;
    }

    public float getRadius() {
        return radius;
    }

    public float getRadius2() {
        return radius2;
    }

    public float getHeight() {
        return height;
    }

    public void setAxisSamples(int axisSamples) {
        this.axisSamples = axisSamples;
    }
}
