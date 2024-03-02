
/**
 * This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
 *
 * Do not edit this file as changes may cause incorrect behavior and will be lost
 * once the code is regenerated.
 *
 * @generated by codegen project: GenerateModuleJavaSpec.js
 *
 * @nolint
 */

package com.rnmapbox.rnmbx;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

public abstract class NativeRNMBXChangeLineOffsetsShapeAnimatorModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
  public static final String NAME = "RNMBXChangeLineOffsetsShapeAnimatorModule";

  public NativeRNMBXChangeLineOffsetsShapeAnimatorModuleSpec(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public @Nonnull String getName() {
    return NAME;
  }

  @ReactMethod
  @DoNotStrip
  public abstract void create(double tag, ReadableArray coordinates, double startOffset, double endOffset, Promise promise);

  @ReactMethod
  @DoNotStrip
  public abstract void setLineString(double tag, ReadableArray coordinates, double startOffset, double endOffset, Promise promise);

  @ReactMethod
  @DoNotStrip
  public abstract void setStartOffset(double tag, double offset, double duration, Promise promise);

  @ReactMethod
  @DoNotStrip
  public abstract void setEndOffset(double tag, double offset, double duration, Promise promise);
}