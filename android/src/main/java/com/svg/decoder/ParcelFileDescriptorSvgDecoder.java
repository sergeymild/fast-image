/*
 * Copyright 2019 Kirill Rozov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.svg.decoder;

import android.os.ParcelFileDescriptor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import com.bumptech.glide.load.Options;
import com.caverock.androidsvg.SVG;
import com.svg.utils.SizeUtils;

import java.io.IOException;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class ParcelFileDescriptorSvgDecoder extends SvgDecoder<ParcelFileDescriptor> {

    private final FileDescriptorSvgDecoder mDecoder = new FileDescriptorSvgDecoder();

    @Override
    public boolean handles(@NonNull ParcelFileDescriptor source, @NonNull Options options) throws IOException {
        return mDecoder.handles(source.getFileDescriptor(), options);
    }

    @Override
    SVG loadSvg(
            @NonNull ParcelFileDescriptor source,
            int width,
            int height,
            @NonNull Options options
    ) throws SvgParseException {
        return mDecoder.loadSvg(source.getFileDescriptor(), width, height, options);
    }

    @Override
    protected int getSize(@NonNull ParcelFileDescriptor source) throws IOException {
        return SizeUtils.getSize(source);
    }
}
