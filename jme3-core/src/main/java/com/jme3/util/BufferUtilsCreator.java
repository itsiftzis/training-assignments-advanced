package com.jme3.util;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

import java.io.UnsupportedEncodingException;
import java.lang.ref.ReferenceQueue;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.concurrent.ConcurrentHashMap;

public class BufferUtilsCreator {
    private static BufferAllocator allocator = new PrimitiveAllocator();

    private static boolean trackDirectMemory = false;
    private static ReferenceQueue<Buffer> removeCollected = new ReferenceQueue<Buffer>();
    private static ConcurrentHashMap<BufferUtils.BufferInfo, BufferUtils.BufferInfo> trackedBuffers = new ConcurrentHashMap<BufferUtils.BufferInfo, BufferUtils.BufferInfo>();
    static BufferUtils.ClearReferences cleanupthread;

    private static boolean used;
    private static void onBufferAllocated(Buffer buffer) {
        used = true;
        if (trackDirectMemory) {
            if (BufferUtils.cleanupthread == null) {
                BufferUtils.cleanupthread = new BufferUtils.ClearReferences();
                BufferUtils.cleanupthread.start();
            }
            if (buffer instanceof ByteBuffer) {
                BufferUtils.BufferInfo info = new BufferUtils.BufferInfo(ByteBuffer.class, buffer.capacity(), buffer,
                        removeCollected);
                trackedBuffers.put(info, info);
            } else if (buffer instanceof FloatBuffer) {
                BufferUtils.BufferInfo info = new BufferUtils.BufferInfo(FloatBuffer.class, buffer.capacity() * 4, buffer,
                        removeCollected);
                trackedBuffers.put(info, info);
            } else if (buffer instanceof IntBuffer) {
                BufferUtils.BufferInfo info = new BufferUtils.BufferInfo(IntBuffer.class, buffer.capacity() * 4, buffer,
                        removeCollected);
                trackedBuffers.put(info, info);
            } else if (buffer instanceof ShortBuffer) {
                BufferUtils.BufferInfo info = new BufferUtils.BufferInfo(ShortBuffer.class, buffer.capacity() * 2, buffer,
                        removeCollected);
                trackedBuffers.put(info, info);
            } else if (buffer instanceof DoubleBuffer) {
                BufferUtils.BufferInfo info = new BufferUtils.BufferInfo(DoubleBuffer.class, buffer.capacity() * 8, buffer,
                        removeCollected);
                trackedBuffers.put(info, info);
            }

        }
    }

    /**
     * Generate a new FloatBuffer using the given array of Vector3f objects. The
     * FloatBuffer will be 3 * data.length long and contain the vector data as
     * data[0].x, data[0].y, data[0].z, data[1].x... etc.
     *
     * @param data
     *            array of Vector3f objects to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(Vector3f... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(3 * data.length);
        for (Vector3f element : data) {
            if (element != null) {
                buff.put(element.x).put(element.y).put(element.z);
            } else {
                buff.put(0).put(0).put(0);
            }
        }
        buff.flip();
        return buff;
    }

    /**
     * Generate a new FloatBuffer using the given array of Quaternion objects.
     * The FloatBuffer will be 4 * data.length long and contain the vector data.
     *
     * @param data
     *            array of Quaternion objects to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(Quaternion... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(4 * data.length);
        for (Quaternion element : data) {
            if (element != null) {
                buff.put(element.getX()).put(element.getY()).put(element.getZ()).put(element.getW());
            } else {
                buff.put(0).put(0).put(0).put(0);
            }
        }
        buff.flip();
        return buff;
    }

    /**
     * Generate a new FloatBuffer using the given array of Vector4 objects. The
     * FloatBuffer will be 4 * data.length long and contain the vector data.
     *
     * @param data
     *            array of Vector4 objects to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(Vector4f... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(4 * data.length);
        for (int x = 0; x < data.length; x++) {
            if (data[x] != null) {
                buff.put(data[x].getX()).put(data[x].getY()).put(data[x].getZ()).put(data[x].getW());
            } else {
                buff.put(0).put(0).put(0).put(0);
            }
        }
        buff.flip();
        return buff;
    }

    /**
     * Generate a new FloatBuffer using the given array of ColorRGBA objects.
     * The FloatBuffer will be 4 * data.length long and contain the color data.
     *
     * @param data
     *            array of ColorRGBA objects to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(ColorRGBA... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(4 * data.length);
        for (int x = 0; x < data.length; x++) {
            if (data[x] != null) {
                buff.put(data[x].getRed()).put(data[x].getGreen()).put(data[x].getBlue()).put(data[x].getAlpha());
            } else {
                buff.put(0).put(0).put(0).put(0);
            }
        }
        buff.flip();
        return buff;
    }

    /**
     * Generate a new FloatBuffer using the given array of float primitives.
     *
     * @param data
     *            array of float primitives to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(float... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(data.length);
        buff.clear();
        buff.put(data);
        buff.flip();
        return buff;
    }

    /**
     * Create a new FloatBuffer of an appropriate size to hold the specified
     * number of Vector3f object data.
     *
     * @param vertices
     *            number of vertices that need to be held by the newly created
     *            buffer
     * @return the requested new FloatBuffer
     */
    public static FloatBuffer createVector3Buffer(int vertices) {
        FloatBuffer vBuff = createFloatBuffer(3 * vertices);
        return vBuff;
    }

    /**
     * Create a new FloatBuffer of an appropriate size to hold the specified
     * number of Vector3f object data only if the given buffer if not already
     * the right size.
     *
     * @param buf
     *            the buffer to first check and rewind
     * @param vertices
     *            number of vertices that need to be held by the newly created
     *            buffer
     * @return the requested new FloatBuffer
     */
    public static FloatBuffer createVector3Buffer(FloatBuffer buf, int vertices) {
        if (buf != null && buf.limit() == 3 * vertices) {
            buf.rewind();
            return buf;
        }

        return createFloatBuffer(3 * vertices);
    }

    /**
     * Generate a new FloatBuffer using the given array of Vector2f objects. The
     * FloatBuffer will be 2 * data.length long and contain the vector data as
     * data[0].x, data[0].y, data[1].x... etc.
     *
     * @param data
     *            array of Vector2f objects to place into a new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(Vector2f... data) {
        if (data == null) {
            return null;
        }
        FloatBuffer buff = createFloatBuffer(2 * data.length);
        for (Vector2f element : data) {
            if (element != null) {
                buff.put(element.x).put(element.y);
            } else {
                buff.put(0).put(0);
            }
        }
        buff.flip();
        return buff;
    }

    /**
     * Create a new FloatBuffer of an appropriate size to hold the specified
     * number of Vector2f object data.
     *
     * @param vertices
     *            number of vertices that need to be held by the newly created
     *            buffer
     * @return the requested new FloatBuffer
     */
    public static FloatBuffer createVector2Buffer(int vertices) {
        FloatBuffer vBuff = createFloatBuffer(2 * vertices);
        return vBuff;
    }

    /**
     * Create a new FloatBuffer of an appropriate size to hold the specified
     * number of Vector2f object data only if the given buffer if not already
     * the right size.
     *
     * @param buf
     *            the buffer to first check and rewind
     * @param vertices
     *            number of vertices that need to be held by the newly created
     *            buffer
     * @return the requested new FloatBuffer
     */
    public static FloatBuffer createVector2Buffer(FloatBuffer buf, int vertices) {
        if (buf != null && buf.limit() == 2 * vertices) {
            buf.rewind();
            return buf;
        }

        return createFloatBuffer(2 * vertices);
    }

    /**
     * Create a new DoubleBuffer of the specified size.
     *
     * @param size
     *            required number of double to store.
     * @return the new DoubleBuffer
     */
    public static DoubleBuffer createDoubleBuffer(int size) {
        DoubleBuffer buf = allocator.allocate(8 * size).order(ByteOrder.nativeOrder()).asDoubleBuffer();
        buf.clear();
        onBufferAllocated(buf);
        return buf;
    }

    /**
     * Create a new DoubleBuffer of an appropriate size to hold the specified
     * number of doubles only if the given buffer if not already the right size.
     *
     * @param buf
     *            the buffer to first check and rewind
     * @param size
     *            number of doubles that need to be held by the newly created
     *            buffer
     * @return the requested new DoubleBuffer
     */
    public static DoubleBuffer createDoubleBuffer(DoubleBuffer buf, int size) {
        if (buf != null && buf.limit() == size) {
            buf.rewind();
            return buf;
        }

        buf = createDoubleBuffer(size);
        return buf;
    }

    /**
     * Create a new FloatBuffer of the specified size.
     *
     * @param size
     *            required number of floats to store.
     * @return the new FloatBuffer
     */
    public static FloatBuffer createFloatBuffer(int size) {
        FloatBuffer buf = allocator.allocate(4 * size).order(ByteOrder.nativeOrder()).asFloatBuffer();
        buf.clear();
        onBufferAllocated(buf);
        return buf;
    }

    /**
     * Create a new IntBuffer of the specified size.
     *
     * @param size
     *            required number of ints to store.
     * @return the new IntBuffer
     */
    public static IntBuffer createIntBuffer(int size) {
        IntBuffer buf = allocator.allocate(4 * size).order(ByteOrder.nativeOrder()).asIntBuffer();
        buf.clear();
        onBufferAllocated(buf);
        return buf;
    }

    /**
     * Create a new IntBuffer of an appropriate size to hold the specified
     * number of ints only if the given buffer if not already the right size.
     *
     * @param buf
     *            the buffer to first check and rewind
     * @param size
     *            number of ints that need to be held by the newly created
     *            buffer
     * @return the requested new IntBuffer
     */
    public static IntBuffer createIntBuffer(IntBuffer buf, int size) {
        if (buf != null && buf.limit() == size) {
            buf.rewind();
            return buf;
        }

        buf = BufferUtils.createIntBuffer(size);
        return buf;
    }

    /**
     * Create a new ByteBuffer of the specified size.
     *
     * @param size
     *            required number of ints to store.
     * @return the new IntBuffer
     */
    public static ByteBuffer createByteBuffer(int size) {
        ByteBuffer buf = allocator.allocate(size).order(ByteOrder.nativeOrder());
        buf.clear();
        onBufferAllocated(buf);
        return buf;
    }

    public static ByteBuffer createByteBuffer(String data) {
        try {
            byte[] bytes = data.getBytes("UTF-8");
            ByteBuffer bb = createByteBuffer(bytes.length);
            bb.put(bytes);
            bb.flip();
            return bb;
        } catch (UnsupportedEncodingException ex) {
            throw new UnsupportedOperationException(ex);
        }
    }

    /**
     * Create a new ShortBuffer of the specified size.
     *
     * @param size
     *            required number of shorts to store.
     * @return the new ShortBuffer
     */
    public static ShortBuffer createShortBuffer(int size) {
        ShortBuffer buf = allocator.allocate(2 * size).order(ByteOrder.nativeOrder()).asShortBuffer();
        buf.clear();
        onBufferAllocated(buf);
        return buf;
    }

    /**
     * Create a new ShortBuffer of an appropriate size to hold the specified
     * number of shorts only if the given buffer if not already the right size.
     *
     * @param buf
     *            the buffer to first check and rewind
     * @param size
     *            number of shorts that need to be held by the newly created
     *            buffer
     * @return the requested new ShortBuffer
     */
    public static ShortBuffer createShortBuffer(ShortBuffer buf, int size) {
        if (buf != null && buf.limit() == size) {
            buf.rewind();
            return buf;
        }

        buf = createShortBuffer(size);
        return buf;
    }

    public static ShortBuffer createShortBuffer(short... data) {
        if (data == null) {
            return null;
        }
        ShortBuffer buff = createShortBuffer(data.length);
        buff.clear();
        buff.put(data);
        buff.flip();
        return buff;
    }
}
