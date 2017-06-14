package com.jme3.renderer.opengl;

import java.nio.ByteBuffer;

public class TextureImage {
    private final int target;
    private final int level;
    private final int slice;
    private final int sliceCount;
    private final int width;
    private final int height;
    private final int depth;
    private final int samples;
    private final ByteBuffer data;

    public TextureImage(int target, int level, int slice, int sliceCount, int width, int height, int depth, int samples, ByteBuffer data) {
        this.target = target;
        this.level = level;
        this.slice = slice;
        this.sliceCount = sliceCount;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.samples = samples;
        this.data = data;
    }

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
