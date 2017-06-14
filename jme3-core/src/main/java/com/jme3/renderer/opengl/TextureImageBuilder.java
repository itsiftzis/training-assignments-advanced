package com.jme3.renderer.opengl;

import java.nio.ByteBuffer;

public class TextureImageBuilder {
    private int target;
    private int level;
    private int slice;
    private int sliceCount;
    private int width;
    private int height;
    private int depth;
    private int samples;
    private ByteBuffer data;

    public TextureImageBuilder setTarget(int target) {
        this.target = target;
        return this;
    }

    public TextureImageBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    public TextureImageBuilder setSlice(int slice) {
        this.slice = slice;
        return this;
    }

    public TextureImageBuilder setSliceCount(int sliceCount) {
        this.sliceCount = sliceCount;
        return this;
    }

    public TextureImageBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public TextureImageBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public TextureImageBuilder setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    public TextureImageBuilder setSamples(int samples) {
        this.samples = samples;
        return this;
    }

    public TextureImageBuilder setData(ByteBuffer data) {
        this.data = data;
        return this;
    }

    public TextureImage createTextureImage() {
        return new TextureImageBuilder().setTarget(target).setLevel(level).setSlice(slice).setSliceCount(sliceCount)
                .setWidth(width).setHeight(height).setDepth(depth).setSamples(samples).setData(data).createTextureImage();
    }
}