/*
 * Copyright (c) 2009-2012 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.material;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;

import java.io.IOException;

/**
 * <code>RenderState</code> specifies material rendering properties that cannot
 * be controlled by a shader on a {@link Material}. The properties
 * allow manipulation of rendering features such as depth testing, alpha blending,
 * face culling, stencil operations, and much more.
 *
 * @author Kirill Vainer
 */
public class RenderStateImpl implements RenderState { /**
 * The <code>DEFAULT</code> render state is the one used by default
 * on all materials unless changed otherwise by the user.
 *
 * <p>
 * It has the following properties:
 * <ul>
 * <li>Back Face Culling</li>
 * <li>Depth Testing Enabled</li>
 * <li>Depth Writing Enabled</li>
 * </ul>
 */
    public static RenderState DEFAULT = new RenderStateImpl();
    /**
     * The <code>NULL</code> render state is identical to the {@link RenderStateImpl#DEFAULT}
     * render state except that depth testing and face culling are disabled.
     */
    static RenderStateImpl NULL = new RenderStateImpl();
    /**
     * The <code>ADDITIONAL</code> render state is identical to the
     * {@link RenderStateImpl#DEFAULT} render state except that all apply
     * values are set to false. This allows the <code>ADDITIONAL</code> render
     * state to be combined with other state but only influencing values
     * that were changed from the original.
     */
    static RenderStateImpl ADDITIONAL = new RenderStateImpl();


    static {
        NULL.cullMode = FaceCullMode.Off;
        NULL.depthTest = false;
    }

    static {
        ADDITIONAL.applyWireFrame = false;
        ADDITIONAL.applyCullMode = false;
        ADDITIONAL.applyDepthWrite = false;
        ADDITIONAL.applyDepthTest = false;
        ADDITIONAL.applyColorWrite = false;
        ADDITIONAL.applyBlendEquation = false;
        ADDITIONAL.applyBlendEquationAlpha = false;
        ADDITIONAL.applyBlendMode = false;
        ADDITIONAL.applyPolyOffset = false;
    }
    boolean wireframe = false;
    boolean applyWireFrame = true;
    FaceCullMode cullMode = FaceCullMode.Back;
    boolean applyCullMode = true;
    boolean depthWrite = true;
    boolean applyDepthWrite = true;
    boolean depthTest = true;
    boolean applyDepthTest = true;
    boolean colorWrite = true;
    boolean applyColorWrite = true;
    BlendEquation blendEquation = BlendEquation.Add;
    boolean applyBlendEquation = true;
    BlendEquationAlpha blendEquationAlpha = BlendEquationAlpha.InheritColor;
    boolean applyBlendEquationAlpha = true;
    BlendMode blendMode = BlendMode.Off;
    boolean applyBlendMode = true;
    float offsetFactor = 0;
    float offsetUnits = 0;
    boolean offsetEnabled = false;
    boolean applyPolyOffset = true;
    boolean stencilTest = false;
    boolean applyStencilTest = false;
    float lineWidth = 1;
    boolean applyLineWidth = false;
    TestFunction depthFunc = TestFunction.LessOrEqual;
    //by default depth func will be applied anyway if depth test is applied
    boolean applyDepthFunc = false;
    StencilOperation frontStencilStencilFailOperation = StencilOperation.Keep;
    StencilOperation frontStencilDepthFailOperation = StencilOperation.Keep;
    StencilOperation frontStencilDepthPassOperation = StencilOperation.Keep;
    StencilOperation backStencilStencilFailOperation = StencilOperation.Keep;
    StencilOperation backStencilDepthFailOperation = StencilOperation.Keep;
    StencilOperation backStencilDepthPassOperation = StencilOperation.Keep;
    TestFunction frontStencilFunction = TestFunction.Always;
    TestFunction backStencilFunction = TestFunction.Always;
    int cachedHashCode = -1;
    BlendFunc sfactorRGB=BlendFunc.One;
    BlendFunc dfactorRGB=BlendFunc.Zero;
    BlendFunc sfactorAlpha=BlendFunc.One;
    BlendFunc dfactorAlpha=BlendFunc.Zero;
            
    public void write(JmeExporter ex) throws IOException {
        OutputCapsule oc = ex.getCapsule(this);
        oc.write(true, "pointSprite", false);
        oc.write(wireframe, "wireframe", false);
        oc.write(cullMode, "cullMode", FaceCullMode.Back);
        oc.write(depthWrite, "depthWrite", true);
        oc.write(depthTest, "depthTest", true);
        oc.write(colorWrite, "colorWrite", true);
        oc.write(blendMode, "blendMode", BlendMode.Off);
        oc.write(offsetEnabled, "offsetEnabled", false);
        oc.write(offsetFactor, "offsetFactor", 0);
        oc.write(offsetUnits, "offsetUnits", 0);
        oc.write(stencilTest, "stencilTest", false);
        oc.write(frontStencilStencilFailOperation, "frontStencilStencilFailOperation", StencilOperation.Keep);
        oc.write(frontStencilDepthFailOperation, "frontStencilDepthFailOperation", StencilOperation.Keep);
        oc.write(frontStencilDepthPassOperation, "frontStencilDepthPassOperation", StencilOperation.Keep);
        oc.write(backStencilStencilFailOperation, "frontStencilStencilFailOperation", StencilOperation.Keep);
        oc.write(backStencilDepthFailOperation, "backStencilDepthFailOperation", StencilOperation.Keep);
        oc.write(backStencilDepthPassOperation, "backStencilDepthPassOperation", StencilOperation.Keep);
        oc.write(frontStencilFunction, "frontStencilFunction", TestFunction.Always);
        oc.write(backStencilFunction, "backStencilFunction", TestFunction.Always);
        oc.write(blendEquation, "blendEquation", BlendEquation.Add);
        oc.write(blendEquationAlpha, "blendEquationAlpha", BlendEquationAlpha.InheritColor);
        oc.write(depthFunc, "depthFunc", TestFunction.LessOrEqual);
        oc.write(lineWidth, "lineWidth", 1);
        oc.write(sfactorRGB, "sfactorRGB", sfactorRGB);
        oc.write(dfactorRGB, "dfactorRGB", dfactorRGB);
        oc.write(sfactorAlpha, "sfactorAlpha", sfactorAlpha);
        oc.write(dfactorAlpha, "dfactorAlpha", dfactorAlpha);

        // Only "additional render state" has them set to false by default
        oc.write(applyWireFrame, "applyWireFrame", true);
        oc.write(applyCullMode, "applyCullMode", true);
        oc.write(applyDepthWrite, "applyDepthWrite", true);
        oc.write(applyDepthTest, "applyDepthTest", true);
        oc.write(applyColorWrite, "applyColorWrite", true);
        oc.write(applyBlendEquation, "applyBlendEquation", true);
        oc.write(applyBlendEquationAlpha, "applyBlendEquationAlpha", true);
        oc.write(applyBlendMode, "applyBlendMode", true);
        oc.write(applyPolyOffset, "applyPolyOffset", true);
        oc.write(applyDepthFunc, "applyDepthFunc", true);
        oc.write(applyLineWidth, "applyLineWidth", true);

    }

    public void read(JmeImporter im) throws IOException {
        InputCapsule ic = im.getCapsule(this);
        wireframe = ic.readBoolean("wireframe", false);
        cullMode = ic.readEnum("cullMode", FaceCullMode.class, FaceCullMode.Back);
        depthWrite = ic.readBoolean("depthWrite", true);
        depthTest = ic.readBoolean("depthTest", true);
        colorWrite = ic.readBoolean("colorWrite", true);
        blendMode = ic.readEnum("blendMode", BlendMode.class, BlendMode.Off);
        offsetEnabled = ic.readBoolean("offsetEnabled", false);
        offsetFactor = ic.readFloat("offsetFactor", 0);
        offsetUnits = ic.readFloat("offsetUnits", 0);
        stencilTest = ic.readBoolean("stencilTest", false);
        frontStencilStencilFailOperation = ic.readEnum("frontStencilStencilFailOperation", StencilOperation.class, StencilOperation.Keep);
        frontStencilDepthFailOperation = ic.readEnum("frontStencilDepthFailOperation", StencilOperation.class, StencilOperation.Keep);
        frontStencilDepthPassOperation = ic.readEnum("frontStencilDepthPassOperation", StencilOperation.class, StencilOperation.Keep);
        backStencilStencilFailOperation = ic.readEnum("backStencilStencilFailOperation", StencilOperation.class, StencilOperation.Keep);
        backStencilDepthFailOperation = ic.readEnum("backStencilDepthFailOperation", StencilOperation.class, StencilOperation.Keep);
        backStencilDepthPassOperation = ic.readEnum("backStencilDepthPassOperation", StencilOperation.class, StencilOperation.Keep);
        frontStencilFunction = ic.readEnum("frontStencilFunction", TestFunction.class, TestFunction.Always);
        backStencilFunction = ic.readEnum("backStencilFunction", TestFunction.class, TestFunction.Always);
        blendEquation = ic.readEnum("blendEquation", BlendEquation.class, BlendEquation.Add);
        blendEquationAlpha = ic.readEnum("blendEquationAlpha", BlendEquationAlpha.class, BlendEquationAlpha.InheritColor);
        depthFunc = ic.readEnum("depthFunc", TestFunction.class, TestFunction.LessOrEqual);
        lineWidth = ic.readFloat("lineWidth", 1);
        sfactorRGB = ic.readEnum("sfactorRGB", BlendFunc.class, BlendFunc.One);
        dfactorAlpha = ic.readEnum("dfactorRGB", BlendFunc.class, BlendFunc.Zero);
        sfactorRGB = ic.readEnum("sfactorAlpha", BlendFunc.class, BlendFunc.One);
        dfactorAlpha = ic.readEnum("dfactorAlpha", BlendFunc.class, BlendFunc.Zero);


        applyWireFrame = ic.readBoolean("applyWireFrame", true);
        applyCullMode = ic.readBoolean("applyCullMode", true);
        applyDepthWrite = ic.readBoolean("applyDepthWrite", true);
        applyDepthTest = ic.readBoolean("applyDepthTest", true);
        applyColorWrite = ic.readBoolean("applyColorWrite", true);
        applyBlendEquation = ic.readBoolean("applyBlendEquation", true);
        applyBlendEquationAlpha = ic.readBoolean("applyBlendEquationAlpha", true);
        applyBlendMode = ic.readBoolean("applyBlendMode", true);
        applyPolyOffset = ic.readBoolean("applyPolyOffset", true);
        applyDepthFunc = ic.readBoolean("applyDepthFunc", true);
        applyLineWidth = ic.readBoolean("applyLineWidth", true);

        
    }

    /**
     * Create a clone of this <code>RenderState</code>
     *
     * @return Clone of this render state.
     */
    @Override
    public RenderStateImpl clone() {
        try {
            return (RenderStateImpl) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }

    /**
     * returns true if the given renderState is equal to this one
     * @param o the renderState to compare to
     * @return true if the renderStates are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof RenderStateImpl)) {
            return false;
        }
        RenderStateImpl rs = (RenderStateImpl) o;

        if (wireframe != rs.wireframe) {
            return false;
        }

        if (cullMode != rs.cullMode) {
            return false;
        }

        if (depthWrite != rs.depthWrite) {
            return false;
        }

        if (depthTest != rs.depthTest) {
            return false;
        }
        if (depthTest) {
            if (depthFunc != rs.depthFunc) {
                return false;
            }
        }

        if (colorWrite != rs.colorWrite) {
            return false;
        }

        if (blendEquation != rs.blendEquation) {
            return false;
        }

        if (blendEquationAlpha != rs.blendEquationAlpha) {
            return false;
        }

        if (blendMode != rs.blendMode) {
            return false;
        }


        if (offsetEnabled != rs.offsetEnabled) {
            return false;
        }

        if (offsetFactor != rs.offsetFactor) {
            return false;
        }

        if (offsetUnits != rs.offsetUnits) {
            return false;
        }

        if (stencilTest != rs.stencilTest) {
            return false;
        }

        if (stencilTest) {
            if (frontStencilStencilFailOperation != rs.frontStencilStencilFailOperation) {
                return false;
            }
            if (frontStencilDepthFailOperation != rs.frontStencilDepthFailOperation) {
                return false;
            }
            if (frontStencilDepthPassOperation != rs.frontStencilDepthPassOperation) {
                return false;
            }
            if (backStencilStencilFailOperation != rs.backStencilStencilFailOperation) {
                return false;
            }
            if (backStencilDepthFailOperation != rs.backStencilDepthFailOperation) {
                return false;
            }

            if (backStencilDepthPassOperation != rs.backStencilDepthPassOperation) {
                return false;
            }
            if (frontStencilFunction != rs.frontStencilFunction) {
                return false;
            }
            if (backStencilFunction != rs.backStencilFunction) {
                return false;
            }
        }

        if(lineWidth != rs.lineWidth){
            return false;
        }
        
        if (blendMode.equals(BlendMode.Custom)) {
           return sfactorRGB==rs.getCustomSfactorRGB()
               && dfactorRGB==rs.getCustomDfactorRGB()
               && sfactorAlpha==rs.getCustomSfactorAlpha()
               && dfactorAlpha==rs.getCustomDfactorAlpha();
           
        }

        return true;
    }

    @Override
    @Deprecated
    public void setPointSprite(boolean pointSprite) {
    }

    @Override
    @Deprecated
    public void setAlphaFallOff(float alphaFallOff) {
    }

    @Override
    @Deprecated
    public void setAlphaTest(boolean alphaTest) {
    }

    @Override
    public void setColorWrite(boolean colorWrite) {
        applyColorWrite = true;
        this.colorWrite = colorWrite;
        cachedHashCode = -1;
    }

    @Override
    public void setFaceCullMode(FaceCullMode cullMode) {
        applyCullMode = true;
        this.cullMode = cullMode;
        cachedHashCode = -1;
    }

    @Override
    public void setBlendMode(BlendMode blendMode) {
        applyBlendMode = true;
        this.blendMode = blendMode;
        cachedHashCode = -1;
    }

    @Override
    public void setBlendEquation(BlendEquation blendEquation) {
        applyBlendEquation = true;
        this.blendEquation = blendEquation;
        cachedHashCode = -1;
    }
    
    @Override
    public void setBlendEquationAlpha(BlendEquationAlpha blendEquationAlpha) {
        applyBlendEquationAlpha = true;
        this.blendEquationAlpha = blendEquationAlpha;
        cachedHashCode = -1;
    }

    
    @Override
    public void setCustomBlendFactors(BlendFunc sfactorRGB, BlendFunc dfactorRGB, BlendFunc sfactorAlpha, BlendFunc dfactorAlpha)
    {
       this.sfactorRGB = sfactorRGB;
       this.dfactorRGB = dfactorRGB;
       this.sfactorAlpha = sfactorAlpha;
       this.dfactorAlpha = dfactorAlpha;
       cachedHashCode = -1;
    }
    
    
    @Override
    public void setDepthTest(boolean depthTest) {
        applyDepthTest = true;
        this.depthTest = depthTest;
        cachedHashCode = -1;
    }

    @Override
    public void setDepthWrite(boolean depthWrite) {
        applyDepthWrite = true;
        this.depthWrite = depthWrite;
        cachedHashCode = -1;
    }

    @Override
    public void setWireframe(boolean wireframe) {
        applyWireFrame = true;
        this.wireframe = wireframe;
        cachedHashCode = -1;
    }

    @Override
    public void setPolyOffset(float factor, float units) {
        applyPolyOffset = true;
        if (factor == 0 && units == 0) {
            offsetEnabled = false;
        } else {
            offsetEnabled = true;
            offsetFactor = factor;
            offsetUnits = units;
        }
        cachedHashCode = -1;
    }    

    @Override
    public void setStencil(boolean enabled,
                           StencilOperation _frontStencilStencilFailOperation,
                           StencilOperation _frontStencilDepthFailOperation,
                           StencilOperation _frontStencilDepthPassOperation,
                           StencilOperation _backStencilStencilFailOperation,
                           StencilOperation _backStencilDepthFailOperation,
                           StencilOperation _backStencilDepthPassOperation,
                           TestFunction _frontStencilFunction,
                           TestFunction _backStencilFunction) {

        stencilTest = enabled;
        applyStencilTest = true;
        this.frontStencilStencilFailOperation = _frontStencilStencilFailOperation;
        this.frontStencilDepthFailOperation = _frontStencilDepthFailOperation;
        this.frontStencilDepthPassOperation = _frontStencilDepthPassOperation;
        this.backStencilStencilFailOperation = _backStencilStencilFailOperation;
        this.backStencilDepthFailOperation = _backStencilDepthFailOperation;
        this.backStencilDepthPassOperation = _backStencilDepthPassOperation;
        this.frontStencilFunction = _frontStencilFunction;
        this.backStencilFunction = _backStencilFunction;
        cachedHashCode = -1;
    }

    @Override
    public void setDepthFunc(TestFunction depthFunc) {
        applyDepthFunc = true;
        this.depthFunc = depthFunc;
        cachedHashCode = -1;
    }

    @Override
    @Deprecated
    public void setAlphaFunc(TestFunction alphaFunc) {
    }

    @Override
    public void setLineWidth(float lineWidth) {
        if (lineWidth < 1f) {
            throw new IllegalArgumentException("lineWidth must be greater than or equal to 1.0");
        }
        this.lineWidth = lineWidth;
        this.applyLineWidth = true;
        cachedHashCode = -1;
    }

    @Override
    public boolean isStencilTest() {
        return stencilTest;
    }

    @Override
    public StencilOperation getFrontStencilStencilFailOperation() {
        return frontStencilStencilFailOperation;
    }

    @Override
    public StencilOperation getFrontStencilDepthFailOperation() {
        return frontStencilDepthFailOperation;
    }

    @Override
    public StencilOperation getFrontStencilDepthPassOperation() {
        return frontStencilDepthPassOperation;
    }

    @Override
    public StencilOperation getBackStencilStencilFailOperation() {
        return backStencilStencilFailOperation;
    }

    @Override
    public StencilOperation getBackStencilDepthFailOperation() {
        return backStencilDepthFailOperation;
    }

    @Override
    public StencilOperation getBackStencilDepthPassOperation() {
        return backStencilDepthPassOperation;
    }

    @Override
    public TestFunction getFrontStencilFunction() {
        return frontStencilFunction;
    }

    @Override
    public TestFunction getBackStencilFunction() {
        return backStencilFunction;
    }

    @Override
    public BlendEquation getBlendEquation() {
        return blendEquation;
    }
    
    @Override
    public BlendEquationAlpha getBlendEquationAlpha() {
        return blendEquationAlpha;
    }

    @Override
    public BlendMode getBlendMode() {
        return blendMode;
    }
    
    @Override
    public BlendFunc getCustomSfactorRGB() {
       return sfactorRGB;
    }
    
    @Override
    public BlendFunc getCustomDfactorRGB() {
       return dfactorRGB;
    }
    
    @Override
    public BlendFunc getCustomSfactorAlpha() {
       return sfactorAlpha;
    }
    
    @Override
    public BlendFunc getCustomDfactorAlpha() {
       return dfactorAlpha;
    }
    
    @Override
    @Deprecated
    public boolean isPointSprite() {
        return true;
    }

    @Override
    public boolean isAlphaTest() {
        return false;
    }

    @Override
    public FaceCullMode getFaceCullMode() {
        return cullMode;
    }

    @Override
    public boolean isDepthTest() {
        return depthTest;
    }

    @Override
    public boolean isDepthWrite() {
        return depthWrite;
    }

    @Override
    public boolean isWireframe() {
        return wireframe;
    }

    @Override
    public boolean isColorWrite() {
        return colorWrite;
    }

    @Override
    public float getPolyOffsetFactor() {
        return offsetFactor;
    }

    @Override
    public float getPolyOffsetUnits() {
        return offsetUnits;
    }

    @Override
    public boolean isPolyOffset() {
        return offsetEnabled;
    }

    @Override
    @Deprecated
    public float getAlphaFallOff() {
        return 0f;
    }

    @Override
    public TestFunction getDepthFunc() {
        return depthFunc;
    }

    @Override
    @Deprecated
    public TestFunction getAlphaFunc() {
        return TestFunction.Greater;
    }

    @Override
    public float getLineWidth() {
        return lineWidth;
    }



    @Override
    public boolean isApplyBlendMode() {
        return applyBlendMode;
    }

    @Override
    public boolean isApplyBlendEquation() {
        return applyBlendEquation;
    }

    @Override
    public boolean isApplyBlendEquationAlpha() {
        return applyBlendEquationAlpha;
    }

    @Override
    public boolean isApplyColorWrite() {
        return applyColorWrite;
    }

    @Override
    public boolean isApplyCullMode() {
        return applyCullMode;
    }

    @Override
    public boolean isApplyDepthTest() {
        return applyDepthTest;
    }

    @Override
    public boolean isApplyDepthWrite() {
        return applyDepthWrite;
    }


    @Override
    public boolean isApplyPolyOffset() {
        return applyPolyOffset;
    }

    @Override
    public boolean isApplyWireFrame() {
        return applyWireFrame;
    }

    @Override
    public boolean isApplyDepthFunc() {
        return applyDepthFunc;
    }


    @Override
    public boolean isApplyLineWidth() {
        return applyLineWidth;
    }

    @Override
    public int contentHashCode() {
        if (cachedHashCode == -1){
            int hash = 7;
            hash = 79 * hash + (this.wireframe ? 1 : 0);
            hash = 79 * hash + (this.cullMode != null ? this.cullMode.hashCode() : 0);
            hash = 79 * hash + (this.depthWrite ? 1 : 0);
            hash = 79 * hash + (this.depthTest ? 1 : 0);
            hash = 79 * hash + (this.depthFunc != null ? this.depthFunc.hashCode() : 0);
            hash = 79 * hash + (this.colorWrite ? 1 : 0);
            hash = 79 * hash + (this.blendMode != null ? this.blendMode.hashCode() : 0);
            hash = 79 * hash + (this.blendEquation != null ? this.blendEquation.hashCode() : 0);
            hash = 79 * hash + (this.blendEquationAlpha != null ? this.blendEquationAlpha.hashCode() : 0);
            hash = 79 * hash + Float.floatToIntBits(this.offsetFactor);
            hash = 79 * hash + Float.floatToIntBits(this.offsetUnits);
            hash = 79 * hash + (this.offsetEnabled ? 1 : 0);
            hash = 79 * hash + (this.stencilTest ? 1 : 0);
            hash = 79 * hash + (this.frontStencilStencilFailOperation != null ? this.frontStencilStencilFailOperation.hashCode() : 0);
            hash = 79 * hash + (this.frontStencilDepthFailOperation != null ? this.frontStencilDepthFailOperation.hashCode() : 0);
            hash = 79 * hash + (this.frontStencilDepthPassOperation != null ? this.frontStencilDepthPassOperation.hashCode() : 0);
            hash = 79 * hash + (this.backStencilStencilFailOperation != null ? this.backStencilStencilFailOperation.hashCode() : 0);
            hash = 79 * hash + (this.backStencilDepthFailOperation != null ? this.backStencilDepthFailOperation.hashCode() : 0);
            hash = 79 * hash + (this.backStencilDepthPassOperation != null ? this.backStencilDepthPassOperation.hashCode() : 0);
            hash = 79 * hash + (this.frontStencilFunction != null ? this.frontStencilFunction.hashCode() : 0);
            hash = 79 * hash + (this.backStencilFunction != null ? this.backStencilFunction.hashCode() : 0);
            hash = 79 * hash + Float.floatToIntBits(this.lineWidth);
            
            hash = 79 * hash + this.sfactorRGB.hashCode();
            hash = 79 * hash + this.dfactorRGB.hashCode();
            hash = 79 * hash + this.sfactorAlpha.hashCode();
            hash = 79 * hash + this.dfactorAlpha.hashCode();
            cachedHashCode = hash;
        }
        return cachedHashCode;
    }

    @Override
    public RenderState copyMergedTo(RenderStateImpl additionalState, RenderStateImpl state) {
        if (additionalState == null) {
            return this;
        }

        if (additionalState.applyWireFrame) {
            state.wireframe = additionalState.wireframe;
        } else {
            state.wireframe = wireframe;
        }

        if (additionalState.applyCullMode) {
            state.cullMode = additionalState.cullMode;
        } else {
            state.cullMode = cullMode;
        }
        if (additionalState.applyDepthWrite) {
            state.depthWrite = additionalState.depthWrite;
        } else {
            state.depthWrite = depthWrite;
        }
        if (additionalState.applyDepthTest) {
            state.depthTest = additionalState.depthTest;
        } else {
            state.depthTest = depthTest;
        }
        if (additionalState.applyDepthFunc) {
            state.depthFunc = additionalState.depthFunc;
        } else {
            state.depthFunc = depthFunc;
        }
        if (additionalState.applyColorWrite) {
            state.colorWrite = additionalState.colorWrite;
        } else {
            state.colorWrite = colorWrite;
        }
        if (additionalState.applyBlendEquation) {
            state.blendEquation = additionalState.blendEquation;
        } else {
            state.blendEquation = blendEquation;
        }
        if (additionalState.applyBlendEquationAlpha) {
            state.blendEquationAlpha = additionalState.blendEquationAlpha;
        } else {
            state.blendEquationAlpha = blendEquationAlpha;
        }        
        if (additionalState.applyBlendMode) {
            state.blendMode = additionalState.blendMode;
            if (additionalState.getBlendMode().equals(BlendMode.Custom)) {
               state.setCustomBlendFactors(
                additionalState.getCustomSfactorRGB(),
                additionalState.getCustomDfactorRGB(),
                additionalState.getCustomSfactorAlpha(),
                additionalState.getCustomDfactorAlpha());
            }
        } else {
            state.blendMode = blendMode;
        }

        if (additionalState.applyPolyOffset) {
            state.offsetEnabled = additionalState.offsetEnabled;
            state.offsetFactor = additionalState.offsetFactor;
            state.offsetUnits = additionalState.offsetUnits;
        } else {
            state.offsetEnabled = offsetEnabled;
            state.offsetFactor = offsetFactor;
            state.offsetUnits = offsetUnits;
        }
        if (additionalState.applyStencilTest) {
            state.stencilTest = additionalState.stencilTest;

            state.frontStencilStencilFailOperation = additionalState.frontStencilStencilFailOperation;
            state.frontStencilDepthFailOperation = additionalState.frontStencilDepthFailOperation;
            state.frontStencilDepthPassOperation = additionalState.frontStencilDepthPassOperation;

            state.backStencilStencilFailOperation = additionalState.backStencilStencilFailOperation;
            state.backStencilDepthFailOperation = additionalState.backStencilDepthFailOperation;
            state.backStencilDepthPassOperation = additionalState.backStencilDepthPassOperation;

            state.frontStencilFunction = additionalState.frontStencilFunction;
            state.backStencilFunction = additionalState.backStencilFunction;
        } else {
            state.stencilTest = stencilTest;

            state.frontStencilStencilFailOperation = frontStencilStencilFailOperation;
            state.frontStencilDepthFailOperation = frontStencilDepthFailOperation;
            state.frontStencilDepthPassOperation = frontStencilDepthPassOperation;

            state.backStencilStencilFailOperation = backStencilStencilFailOperation;
            state.backStencilDepthFailOperation = backStencilDepthFailOperation;
            state.backStencilDepthPassOperation = backStencilDepthPassOperation;

            state.frontStencilFunction = frontStencilFunction;
            state.backStencilFunction = backStencilFunction;
        }
        if (additionalState.applyLineWidth) {
            state.lineWidth = additionalState.lineWidth;
        } else {
            state.lineWidth = lineWidth;
        }
        state.cachedHashCode = -1;
        return state;
    }

    @Override
    public void set(RenderStateImpl state) {
        wireframe = state.wireframe;
        cullMode = state.cullMode;
        depthWrite = state.depthWrite;
        depthTest = state.depthTest;
        colorWrite = state.colorWrite;
        blendMode = state.blendMode;
        offsetEnabled = state.offsetEnabled;
        offsetFactor = state.offsetFactor;
        offsetUnits = state.offsetUnits;
        stencilTest = state.stencilTest;
        frontStencilStencilFailOperation = state.frontStencilStencilFailOperation;
        frontStencilDepthFailOperation = state.frontStencilDepthFailOperation;
        frontStencilDepthPassOperation = state.frontStencilDepthPassOperation;
        backStencilStencilFailOperation = state.backStencilStencilFailOperation;
        backStencilDepthFailOperation = state.backStencilDepthFailOperation;
        backStencilDepthPassOperation = state.backStencilDepthPassOperation;
        frontStencilFunction = state.frontStencilFunction;
        backStencilFunction = state.backStencilFunction;
        blendEquationAlpha = state.blendEquationAlpha;
        blendEquation = state.blendEquation;
        depthFunc = state.depthFunc;
        lineWidth = state.lineWidth;

        applyWireFrame =  true;
        applyCullMode =  true;
        applyDepthWrite =  true;
        applyDepthTest =  true;
        applyColorWrite = true;
        applyBlendEquation =  true;
        applyBlendEquationAlpha =  true;
        applyBlendMode = true;
        applyPolyOffset =  true;
        applyDepthFunc = true;
        applyLineWidth = true;
        
        sfactorRGB = state.sfactorRGB;
        dfactorRGB = state.dfactorRGB;
        sfactorAlpha = state.sfactorAlpha;
        dfactorAlpha = state.dfactorAlpha;
    }

    @Override
    public String toString() {
        return "RenderState[\n"
                + "\nwireframe=" + wireframe
                + "\napplyWireFrame=" + applyWireFrame
                + "\ncullMode=" + cullMode
                + "\napplyCullMode=" + applyCullMode
                + "\ndepthWrite=" + depthWrite
                + "\napplyDepthWrite=" + applyDepthWrite
                + "\ndepthTest=" + depthTest
                + "\ndepthFunc=" + depthFunc
                + "\napplyDepthTest=" + applyDepthTest
                + "\ncolorWrite=" + colorWrite
                + "\napplyColorWrite=" + applyColorWrite
                + "\nblendEquation=" + blendEquation
                + "\napplyBlendEquation=" + applyBlendEquation
                + "\napplyBlendEquationAlpha=" + applyBlendEquationAlpha
                + "\nblendMode=" + blendMode
                + "\napplyBlendMode=" + applyBlendMode
                + "\noffsetEnabled=" + offsetEnabled
                + "\napplyPolyOffset=" + applyPolyOffset
                + "\noffsetFactor=" + offsetFactor
                + "\noffsetUnits=" + offsetUnits
                + "\nlineWidth=" + lineWidth
                + (blendMode.equals(BlendMode.Custom)? "\ncustomBlendFactors=("+sfactorRGB+", "+dfactorRGB+", "+sfactorAlpha+", "+dfactorAlpha+")":"")
                +"\n]";
    }
}
