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

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import com.bumptech.glide.load.Options;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.svg.utils.SvgUtils;

import java.io.File;
import java.io.IOException;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class FileSvgDecoder extends SvgDecoder<File> {

    @Override
    SVG loadSvg(@NonNull File source, int width, int height, @NonNull Options options) throws SvgParseException {
        try {
            return SvgUtils.getSvg(source);
        } catch (IOException | SVGParseException e) {
            throw new SvgParseException(e);
        }
    }

    @Override
    protected int getSize(@NonNull File source) {
        return (int) source.length();
    }
}
