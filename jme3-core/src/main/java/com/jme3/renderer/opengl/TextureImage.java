package com.jme3.renderer.opengl;

import java.nio.ByteBuffer;

public class TextureImage {
    private final int target = 0;
    private final int level = 0;
    private final int slice = 0;
    private final int sliceCount = 0;
    private final int width = 0;
    private final int height = 0;
    private final int depth = 0;
    private final int samples = 0;
    private final ByteBuffer data = null;

    public int getTarget() {
        return target;
    }

    public int getLevel() {
        return level;
    }

    public int getSlice() {
        return slice;
    }

    public int getSliceCount() {
        return sliceCount;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public int getSamples() {
        return samples;
    }

    public ByteBuffer getData() {
        return data;
    }
}
