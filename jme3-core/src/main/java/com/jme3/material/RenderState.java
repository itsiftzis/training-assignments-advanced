package com.jme3.material;

import com.jme3.export.Savable;
import com.jme3.scene.Mesh;

public interface RenderState extends Cloneable, Savable {
    /**
     * @deprecated Does nothing. Point sprite is already enabled by default for
     * all supported platforms. jME3 does not support rendering conventional
     * point clouds.
     */
    @Deprecated
    void setPointSprite(boolean pointSprite);

    /**
     * @deprecated Does nothing. To use alpha test, set the
     * <code>AlphaDiscardThreshold</code> material parameter.
     * @param alphaFallOff does nothing
     */
    @Deprecated
    void setAlphaFallOff(float alphaFallOff);

    /**
     * @deprecated Does nothing. To use alpha test, set the
     * <code>AlphaDiscardThreshold</code> material parameter.
     * @param alphaTest does nothing
     */
    @Deprecated
    void setAlphaTest(boolean alphaTest);

    /**
     * Enable writing color.
     *
     * <p>When color write is enabled, the result of a fragment shader, the
     * <code>gl_FragColor</code>, will be rendered into the color buffer
     * (including alpha).
     *
     * @param colorWrite Set to true to enable color writing.
     */
    void setColorWrite(boolean colorWrite);

    /**
     * Set the face culling mode.
     *
     * <p>See the {@link FaceCullMode} enum on what each value does.
     * Face culling will project the triangle's points onto the screen
     * and determine if the triangle is in counter-clockwise order or
     * clockwise order. If a triangle is in counter-clockwise order, then
     * it is considered a front-facing triangle, otherwise, it is considered
     * a back-facing triangle.
     *
     * @param cullMode the face culling mode.
     */
    void setFaceCullMode(FaceCullMode cullMode);

    /**
     * Set the blending mode.
     *
     * <p>When blending is enabled, (<code>blendMode</code> is not {@link BlendMode#Off})
     * the input pixel will be blended with the pixel
     * already in the color buffer. The blending operation is determined
     * by the {@link BlendMode}. For example, the {@link BlendMode#Additive}
     * will add the input pixel's color to the color already in the color buffer:
     * <br/>
     * <code>Result = Source Color + Destination Color</code>
     *
     * @param blendMode The blend mode to use. Set to {@link BlendMode#Off}
     * to disable blending.
     */
    void setBlendMode(BlendMode blendMode);

    /**
     * Set the blending equation.
     * <p>
     * When blending is enabled, (<code>blendMode</code> is not
     * {@link BlendMode#Off}) the input pixel will be blended with the pixel
     * already in the color buffer. The blending equation is determined by the
     * {@link BlendEquation}. For example, the mode {@link BlendMode#Additive}
     * and {@link BlendEquation#Add} will add the input pixel's color to the
     * color already in the color buffer:
     * <br/>
     * <code>Result = Source Color + Destination Color</code>
     * <br/>
     * However, the mode {@link BlendMode#Additive}
     * and {@link BlendEquation#Subtract} will subtract the input pixel's color to the
     * color already in the color buffer:
     * <br/>
     * <code>Result = Source Color - Destination Color</code>
     *
     * @param blendEquation The blend equation to use.
     */
    void setBlendEquation(BlendEquation blendEquation);

    /**
     * Set the blending equation for the alpha component.
     * <p>
     * When blending is enabled, (<code>blendMode</code> is not
     * {@link BlendMode#Off}) the input pixel will be blended with the pixel
     * already in the color buffer. The blending equation is determined by the
     * {@link BlendEquation} and can be overrode for the alpha component using
     * the {@link BlendEquationAlpha} . For example, the mode
     * {@link BlendMode#Additive} and {@link BlendEquationAlpha#Add} will add
     * the input pixel's alpha to the alpha component already in the color
     * buffer:
     * <br/>
     * <code>Result = Source Alpha + Destination Alpha</code>
     * <br/>
     * However, the mode {@link BlendMode#Additive} and
     * {@link BlendEquationAlpha#Subtract} will subtract the input pixel's alpha
     * to the alpha component already in the color buffer:
     * <br/>
     * <code>Result = Source Alpha - Destination Alpha</code>
     *
     * @param blendEquationAlpha The blend equation to use for the alpha
     *                           component.
     */
    void setBlendEquationAlpha(BlendEquationAlpha blendEquationAlpha);

    /**
     * Sets the custom blend factors for <code>BlendMode.Custom</code> as
     * defined by the appropriate <code>BlendFunc</code>.
     *
     * @param sfactorRGB   The source blend factor for RGB components.
     * @param dfactorRGB   The destination blend factor for RGB components.
     * @param sfactorAlpha The source blend factor for the alpha component.
     * @param dfactorAlpha The destination blend factor for the alpha component.
     */
    void setCustomBlendFactors(BlendFunc sfactorRGB, BlendFunc dfactorRGB, BlendFunc sfactorAlpha, BlendFunc dfactorAlpha);

    /**
     * Enable depth testing.
     *
     * <p>When depth testing is enabled, a pixel must pass the depth test
     * before it is written to the color buffer.
     * The input pixel's depth value must be less than or equal than
     * the value already in the depth buffer to pass the depth test.
     *
     * @param depthTest Enable or disable depth testing.
     */
    void setDepthTest(boolean depthTest);

    /**
     * Enable depth writing.
     *
     * <p>After passing the {@link RenderStateImpl#setDepthTest(boolean) depth test},
     * a pixel's depth value will be written into the depth buffer if
     * depth writing is enabled.
     *
     * @param depthWrite True to enable writing to the depth buffer.
     */
    void setDepthWrite(boolean depthWrite);

    /**
     * Enables wireframe rendering mode.
     *
     * <p>When in wireframe mode, {@link Mesh meshes} rendered in triangle mode
     * will not be solid, but instead, only the edges of the triangles
     * will be rendered.
     *
     * @param wireframe True to enable wireframe mode.
     */
    void setWireframe(boolean wireframe);

    /**
     * Offsets the on-screen z-order of the material's polygons, to combat visual artefacts like
     * stitching, bleeding and z-fighting for overlapping polygons.
     * Factor and units are summed to produce the depth offset.
     * This offset is applied in screen space,
     * typically with positive Z pointing into the screen.
     * Typical values are (1.0f, 1.0f) or (-1.0f, -1.0f)
     *
     * @see <a href="http://www.opengl.org/resources/faq/technical/polygonoffset.htm" rel="nofollow">http://www.opengl.org/resources/faq/technical/polygonoffset.htm</a>
     * @param factor scales the maximum Z slope, with respect to X or Y of the polygon
     * @param units scales the minimum resolvable depth buffer value
     **/
    void setPolyOffset(float factor, float units);

    /**
     * Enable stencil testing.
     *
     * <p>Stencil testing can be used to filter pixels according to the stencil
     * buffer. Objects can be rendered with some stencil operation to manipulate
     * the values in the stencil buffer, then, other objects can be rendered
     * to test against the values written previously.
     *
     * @param enabled Set to true to enable stencil functionality. If false
     * all other parameters are ignored.
     *
     * @param _frontStencilStencilFailOperation Sets the operation to occur when
     * a front-facing triangle fails the front stencil function.
     * @param _frontStencilDepthFailOperation Sets the operation to occur when
     * a front-facing triangle fails the depth test.
     * @param _frontStencilDepthPassOperation Set the operation to occur when
     * a front-facing triangle passes the depth test.
     * @param _backStencilStencilFailOperation Set the operation to occur when
     * a back-facing triangle fails the back stencil function.
     * @param _backStencilDepthFailOperation Set the operation to occur when
     * a back-facing triangle fails the depth test.
     * @param _backStencilDepthPassOperation Set the operation to occur when
     * a back-facing triangle passes the depth test.
     * @param _frontStencilFunction Set the test function for front-facing triangles.
     * @param _backStencilFunction Set the test function for back-facing triangles.
     */
    void setStencil(boolean enabled,
                    StencilOperation _frontStencilStencilFailOperation,
                    StencilOperation _frontStencilDepthFailOperation,
                    StencilOperation _frontStencilDepthPassOperation,
                    StencilOperation _backStencilStencilFailOperation,
                    StencilOperation _backStencilDepthFailOperation,
                    StencilOperation _backStencilDepthPassOperation,
                    TestFunction _frontStencilFunction,
                    TestFunction _backStencilFunction);

    /**
     * Set the depth conparison function to the given TestFunction
     * default is LessOrEqual (GL_LEQUAL)
     * @see TestFunction
     * @see RenderStateImpl#setDepthTest(boolean)
     * @param depthFunc the depth comparison function
     */
    void setDepthFunc(TestFunction depthFunc);

    /**
     * @deprecated
     */
    @Deprecated
    void setAlphaFunc(TestFunction alphaFunc);

    /**
     * Sets the mesh line width.
     * This is to use in conjunction with {@link #setWireframe(boolean)} or with a mesh in {@link Mesh.Mode#Lines} mode.
     * @param lineWidth the line width.
     */
    void setLineWidth(float lineWidth);

    /**
     * Check if stencil test is enabled.
     *
     * @return True if stencil test is enabled.
     */
    boolean isStencilTest();

    /**
     * Retrieve the front stencil fail operation.
     *
     * @return the front stencil fail operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getFrontStencilStencilFailOperation();

    /**
     * Retrieve the front depth test fail operation.
     *
     * @return the front depth test fail operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getFrontStencilDepthFailOperation();

    /**
     * Retrieve the front depth test pass operation.
     *
     * @return the front depth test pass operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getFrontStencilDepthPassOperation();

    /**
     * Retrieve the back stencil fail operation.
     *
     * @return the back stencil fail operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getBackStencilStencilFailOperation();

    /**
     * Retrieve the back depth test fail operation.
     *
     * @return the back depth test fail operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getBackStencilDepthFailOperation();

    /**
     * Retrieve the back depth test pass operation.
     *
     * @return the back depth test pass operation.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    StencilOperation getBackStencilDepthPassOperation();

    /**
     * Retrieve the front stencil function.
     *
     * @return the front stencil function.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    TestFunction getFrontStencilFunction();

    /**
     * Retrieve the back stencil function.
     *
     * @return the back stencil function.
     *
     * @see RenderStateImpl#setStencil(boolean,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * StencilOperation,
     * TestFunction,
     * TestFunction)
     */
    TestFunction getBackStencilFunction();

    /**
     * Retrieve the blend equation.
     *
     * @return the blend equation.
     */
    BlendEquation getBlendEquation();

    /**
     * Retrieve the blend equation used for the alpha component.
     *
     * @return the blend equation for the alpha component.
     */
    BlendEquationAlpha getBlendEquationAlpha();

    /**
     * Retrieve the blend mode.
     *
     * @return the blend mode.
     */
    BlendMode getBlendMode();

    /**
     * Provides the source factor for the RGB components in
     * <code>BlendMode.Custom</code>.
     *
     * @return the custom source factor for RGB components.
     */
    BlendFunc getCustomSfactorRGB();

    /**
     * Provides the destination factor for the RGB components in
     * <code>BlendMode.Custom</code>.
     *
     * @return the custom destination factor for RGB components.
     */
    BlendFunc getCustomDfactorRGB();

    /**
     * Provides the source factor for the alpha component in
     * <code>BlendMode.Custom</code>.
     *
     * @return the custom destination factor for alpha component.
     */
    BlendFunc getCustomSfactorAlpha();

    /**
     * Provides the destination factor for the alpha component in
     * <code>BlendMode.Custom</code>.
     *
     * @return the custom destination factor for alpha component.
     */
    BlendFunc getCustomDfactorAlpha();

    /**
     * @return true
     * @deprecated Always returns true since point sprite is always enabled.
     * @see #setPointSprite(boolean)
     */
    @Deprecated
    boolean isPointSprite();

    /**
     * @deprecated To use alpha test, set the <code>AlphaDiscardThreshold</code>
     * material parameter.
     * @return false
     */
    boolean isAlphaTest();

    /**
     * Retrieve the face cull mode.
     *
     * @return the face cull mode.
     *
     * @see RenderStateImpl#setFaceCullMode(FaceCullMode)
     */
    FaceCullMode getFaceCullMode();

    /**
     * Check if depth test is enabled.
     *
     * @return True if depth test is enabled.
     *
     * @see RenderStateImpl#setDepthTest(boolean)
     */
    boolean isDepthTest();

    /**
     * Check if depth write is enabled.
     *
     * @return True if depth write is enabled.
     *
     * @see RenderStateImpl#setDepthWrite(boolean)
     */
    boolean isDepthWrite();

    /**
     * Check if wireframe mode is enabled.
     *
     * @return True if wireframe mode is enabled.
     *
     * @see RenderStateImpl#setWireframe(boolean)
     */
    boolean isWireframe();

    /**
     * Check if color writing is enabled.
     *
     * @return True if color writing is enabled.
     *
     * @see RenderStateImpl#setColorWrite(boolean)
     */
    boolean isColorWrite();

    /**
     * Retrieve the poly offset factor value.
     *
     * @return the poly offset factor value.
     *
     * @see RenderStateImpl#setPolyOffset(float, float)
     */
    float getPolyOffsetFactor();

    /**
     * Retrieve the poly offset units value.
     *
     * @return the poly offset units value.
     *
     * @see RenderStateImpl#setPolyOffset(float, float)
     */
    float getPolyOffsetUnits();

    /**
     * Check if polygon offset is enabled.
     *
     * @return True if polygon offset is enabled.
     *
     * @see RenderStateImpl#setPolyOffset(float, float)
     */
    boolean isPolyOffset();

    /**
     * @return 0
     * @deprecated
     */
    @Deprecated
    float getAlphaFallOff();

    /**
     * Retrieve the depth comparison function
     *
     * @return the depth comparison function
     *
     * @see RenderStateImpl#setDepthFunc(TestFunction)
     */
    TestFunction getDepthFunc();

    /**
     * @return {@link TestFunction#Greater}.
     * @deprecated
     */
    @Deprecated
    TestFunction getAlphaFunc();

    /**
     * returns the wireframe line width
     *
     * @return the line width
     */
    float getLineWidth();

    boolean isApplyBlendMode();

    boolean isApplyBlendEquation();

    boolean isApplyBlendEquationAlpha();

    boolean isApplyColorWrite();

    boolean isApplyCullMode();

    boolean isApplyDepthTest();

    boolean isApplyDepthWrite();

    boolean isApplyPolyOffset();

    boolean isApplyWireFrame();

    boolean isApplyDepthFunc();

    boolean isApplyLineWidth();

    /**
     *
     */
    int contentHashCode();

    /**
     * Merges <code>this</code> state and <code>additionalState</code> into
     * the parameter <code>state</code> based on a specific criteria.
     *
     * <p>The criteria for this merge is the following:<br/>
     * For every given property, such as alpha test or depth write, check
     * if it was modified from the original in the <code>additionalState</code>
     * if it was modified, then copy the property from the <code>additionalState</code>
     * into the parameter <code>state</code>, otherwise, copy the property from <code>this</code>
     * into the parameter <code>state</code>. If <code>additionalState</code>
     * is <code>null</code>, then no modifications are made and <code>this</code> is returned,
     * otherwise, the parameter <code>state</code> is returned with the result
     * of the merge.
     *
     * @param additionalState The <code>additionalState</code>, from which data is taken only
     * if it was modified by the user.
     * @param state Contains output of the method if <code>additionalState</code>
     * is not null.
     * @return <code>state</code> if <code>additionalState</code> is non-null,
     * otherwise returns <code>this</code>
     */
    RenderState copyMergedTo(RenderStateImpl additionalState, RenderStateImpl state);

    void set(RenderStateImpl state);

    /**
     * <code>TestFunction</code> specifies the testing function for stencil test
     * function.
     *
     * <p>
     * The reference value given in the stencil command is the input value while
     * the reference is the value already in the stencil buffer.
     */
    public enum TestFunction {

        /**
         * The test always fails
         */
        Never,
        /**
         * The test succeeds if the input value is equal to the reference value.
         */
        Equal,
        /**
         * The test succeeds if the input value is less than the reference value.
         */
        Less,
        /**
         * The test succeeds if the input value is less than or equal to
         * the reference value.
         */
        LessOrEqual,
        /**
         * The test succeeds if the input value is greater than the reference value.
         */
        Greater,
        /**
         * The test succeeds if the input value is greater than or equal to
         * the reference value.
         */
        GreaterOrEqual,
        /**
         * The test succeeds if the input value does not equal the
         * reference value.
         */
        NotEqual,
        /**
         * The test always passes
         */
        Always
    }

    /**
     * <code>BlendEquation</code> specifies the blending equation to combine
     * pixels.
     */
    public enum BlendEquation {
        /**
         * Sets the blend equation so that the source and destination data are
         * added. (Default) Clamps to [0,1] Useful for things like antialiasing
         * and transparency.
         */
        Add,
        /**
         * Sets the blend equation so that the source and destination data are
         * subtracted (Src - Dest). Clamps to [0,1] Falls back to Add if
         * supportsSubtract is false.
         */
        Subtract,
        /**
         * Same as Subtract, but the order is reversed (Dst - Src). Clamps to
         * [0,1] Falls back to Add if supportsSubtract is false.
         */
        ReverseSubtract,
        /**
         * Sets the blend equation so that each component of the result color is
         * the minimum of the corresponding components of the source and
         * destination colors. This and Max are useful for applications that
         * analyze image data (image thresholding against a constant color, for
         * example). Falls back to Add if supportsMinMax is false.
         */
        Min,
        /**
         * Sets the blend equation so that each component of the result color is
         * the maximum of the corresponding components of the source and
         * destination colors. This and Min are useful for applications that
         * analyze image data (image thresholding against a constant color, for
         * example). Falls back to Add if supportsMinMax is false.
         */
        Max
    }

    /**
     * <code>BlendEquationAlpha</code> specifies the blending equation to
     * combine pixels for the alpha component.
     */
    public enum BlendEquationAlpha {
        /**
         * Sets the blend equation to be the same as the one defined by
         * {@link #blendEquation}.
         *
         */
        InheritColor,
        /**
         * Sets the blend equation so that the source and destination data are
         * added. (Default) Clamps to [0,1] Useful for things like antialiasing
         * and transparency.
         */
        Add,
        /**
         * Sets the blend equation so that the source and destination data are
         * subtracted (Src - Dest). Clamps to [0,1] Falls back to Add if
         * supportsSubtract is false.
         */
        Subtract,
        /**
         * Same as Subtract, but the order is reversed (Dst - Src). Clamps to
         * [0,1] Falls back to Add if supportsSubtract is false.
         */
        ReverseSubtract,
        /**
         * Sets the blend equation so that the result alpha is the minimum of
         * the source alpha and destination alpha. This and Max are useful for
         * applications that analyze image data (image thresholding against a
         * constant color, for example). Falls back to Add if supportsMinMax is
         * false.
         */
        Min,
        /**
         * sSets the blend equation so that the result alpha is the maximum of
         * the source alpha and destination alpha. This and Min are useful for
         * applications that analyze image data (image thresholding against a
         * constant color, for example). Falls back to Add if supportsMinMax is
         * false.
         */
        Max
    }

    /**
     * <code>BlendFunc</code> defines the blending functions for use with
     * <code>BlendMode.Custom</code>.
     * Source color components are referred to as (R_s0, G_s0, B_s0, A_s0).
     * Destination color components are referred to as (R_d, G_d, B_d, A_d).
     */
    public enum BlendFunc {
        /**
         * RGB Factor (0, 0, 0), Alpha Factor (0)
         */
        Zero,
        /**
         * RGB Factor (1, 1, 1), Alpha Factor (1)
         */
        One,
        /**
         * RGB Factor (R_s0, G_s0, B_s0), Alpha Factor (A_s0)
         */
        Src_Color,
        /**
         * RGB Factor (1-R_s0, 1-G_s0, 1-B_s0), Alpha Factor (1-A_s0)
         */
        One_Minus_Src_Color,
        /**
         * RGB Factor (R_d, G_d, B_d), Alpha Factor (A_d)
         */
        Dst_Color,
        /**
         * RGB Factor (1-R_d, 1-G_d, 1-B_d), Alpha Factor (1-A_d)
         */
        One_Minus_Dst_Color,
        /**
         * RGB Factor (A_s0, A_s0, A_s0), Alpha Factor (A_s0)
         */
        Src_Alpha,
        /**
         * RGB Factor (1-A_s0, 1-A_s0, 1-A_s0), Alpha Factor (1-A_s0)
         */
        One_Minus_Src_Alpha,
        /**
         * RGB Factor (A_d, A_d, A_d), Alpha Factor (A_d)
         */
        Dst_Alpha,
        /**
         * RGB Factor (1-A_d, 1-A_d, 1-A_d), Alpha Factor (1-A_d)
         */
        One_Minus_Dst_Alpha,
        /**
         * RGB Factor (i, i, i), Alpha Factor (1)
         */
        Src_Alpha_Saturate;
    }

    /**
     * <code>BlendMode</code> specifies the blending operation to use.
     *
     * @see RenderStateImpl#setBlendMode(RenderState.BlendMode)
     */
    public enum BlendMode {

        /**
         * No blending mode is used.
         */
        Off,
        /**
         * Additive blending. For use with glows and particle emitters.
         * <p>
         * Result = Source Color + Destination Color -> (GL_ONE, GL_ONE)
         */
        Additive,
        /**
         * Premultiplied alpha blending, for use with premult alpha textures.
         * <p>
         * Result = Source Color + (Dest Color * (1 - Source Alpha) ) -> (GL_ONE, GL_ONE_MINUS_SRC_ALPHA)
         */
        PremultAlpha,
        /**
         * Additive blending that is multiplied with source alpha.
         * For use with glows and particle emitters.
         * <p>
         * Result = (Source Alpha * Source Color) + Dest Color -> (GL_SRC_ALPHA, GL_ONE)
         */
        AlphaAdditive,
        /**
         * Color blending, blends in color from dest color
         * using source color.
         * <p>
         * Result = Source Color + (1 - Source Color) * Dest Color -> (GL_ONE, GL_ONE_MINUS_SRC_COLOR)
         */
        Color,
        /**
         * Alpha blending, interpolates to source color from dest color
         * using source alpha.
         * <p>
         * Result = Source Alpha * Source Color +
         *          (1 - Source Alpha) * Dest Color -> (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
         */
        Alpha,
        /**
         * Multiplies the source and dest colors.
         * <p>
         * Result = Source Color * Dest Color -> (GL_DST_COLOR, GL_ZERO)
         */
        Modulate,
        /**
         * Multiplies the source and dest colors then doubles the result.
         * <p>
         * Result = 2 * Source Color * Dest Color -> (GL_DST_COLOR, GL_SRC_COLOR)
         */
        ModulateX2,
        /**
         * Opposite effect of Modulate/Multiply. Invert both colors, multiply and
         * then invert the result.
         * <p>
         * Result = 1 - (1 - Source Color) * (1 - Dest Color) -> (GL_ONE, GL_ONE_MINUS_SRC_COLOR)
         */
        Screen,
        /**
         * Mixes the destination and source colors similar to a color-based XOR
         * operation.  This is directly equivalent to Photoshop's "Exclusion" blend.
         * <p>
         * Result = (Source Color * (1 - Dest Color)) + (Dest Color * (1 - Source Color))
         *  -> (GL_ONE_MINUS_DST_COLOR, GL_ONE_MINUS_SRC_COLOR)
         */
        Exclusion,
        /**
         * Allows for custom blending by using glBlendFuncSeparate.
         * <p>
         *
         */
        Custom
    }

    /**
     * <code>FaceCullMode</code> specifies the criteria for faces to be culled.
     *
     * @see RenderStateImpl#setFaceCullMode(RenderState.FaceCullMode)
     */
    public enum FaceCullMode {

        /**
         * Face culling is disabled.
         */
        Off,
        /**
         * Cull front faces
         */
        Front,
        /**
         * Cull back faces
         */
        Back,
        /**
         * Cull both front and back faces.
         */
        FrontAndBack
    }

    /**
     * <code>StencilOperation</code> specifies the stencil operation to use
     * in a certain scenario as specified in {@link RenderStateImpl#setStencil(boolean,
     * RenderState.StencilOperation,
     * RenderState.StencilOperation,
     * RenderState.StencilOperation,
     * RenderState.StencilOperation,
     * RenderState.StencilOperation,
     * RenderState.StencilOperation,
     * RenderState.TestFunction,
     * RenderState.TestFunction) }
     */
    public enum StencilOperation {

        /**
         * Keep the current value.
         */
        Keep,
        /**
         * Set the value to 0
         */
        Zero,
        /**
         * Replace the value in the stencil buffer with the reference value.
         */
        Replace,
        /**
         * Increment the value in the stencil buffer, clamp once reaching
         * the maximum value.
         */
        Increment,
        /**
         * Increment the value in the stencil buffer and wrap to 0 when
         * reaching the maximum value.
         */
        IncrementWrap,
        /**
         * Decrement the value in the stencil buffer and clamp once reaching 0.
         */
        Decrement,
        /**
         * Decrement the value in the stencil buffer and wrap to the maximum
         * value when reaching 0.
         */
        DecrementWrap,
        /**
         * Does a bitwise invert of the value in the stencil buffer.
         */
        Invert
    }
}
