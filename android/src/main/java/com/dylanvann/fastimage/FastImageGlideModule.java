package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import com.svg.StringLoader;
import com.svg.SvgBitmapDrawableTranscoder;
import com.svg.decoder.ByteBufferSvgDecoder;
import com.svg.decoder.FileDescriptorSvgDecoder;
import com.svg.decoder.FileSvgDecoder;
import com.svg.decoder.InputStreamSvgDecoder;
import com.svg.decoder.ParcelFileDescriptorSvgDecoder;
import com.svg.decoder.RawResourceSvgDecoder;
import com.svg.decoder.StringSvgDecoder;
import com.svg.decoder.UnitSVGDecoder;

import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.ByteBuffer;

// We need an AppGlideModule to be present for progress events to work.
@GlideModule
public final class FastImageGlideModule extends AppGlideModule {

    private static final String REGISTRY = "com.kirich1409.svgloader.glide";

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.register(SVG.class, BitmapDrawable.class, new SvgBitmapDrawableTranscoder(context, glide))
                .append(SVG.class, SVG.class, UnitModelLoader.Factory.getInstance())
                .append(String.class, String.class, StringLoader.Factory.getInstance());
        registerDecoders(context, registry);
    }

    private void registerDecoders(@NonNull Context context, @NonNull Registry registry) {
        registry.append(REGISTRY, InputStream.class, SVG.class, new InputStreamSvgDecoder())
                .append(REGISTRY, File.class, SVG.class, new FileSvgDecoder())
                .append(REGISTRY, FileDescriptor.class, SVG.class, new FileDescriptorSvgDecoder())
                .append(REGISTRY, ParcelFileDescriptor.class, SVG.class, new ParcelFileDescriptorSvgDecoder())
                .append(REGISTRY, SVG.class, SVG.class, new UnitSVGDecoder())
                .append(REGISTRY, ByteBuffer.class, SVG.class, new ByteBufferSvgDecoder())
                .append(REGISTRY, String.class, SVG.class, new StringSvgDecoder())
                .append(REGISTRY, Uri.class, SVG.class, new RawResourceSvgDecoder(context));
    }
}
