/*
 * Copyright (c) 2008-2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bson.codecs.configuration.mapper.entities;

import org.bson.codecs.configuration.mapper.conventions.Converter;

class Rot13Converter implements Converter {

    @Override
    public String apply(final Object value) {
        return rot13(value);
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public Object unapply(final Object value) {
        return rot13(value);
    }

    private String rot13(final Object value) {
        if (value == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : value.toString().toCharArray()) {
            if (c >= 'a' && c <= 'm') {
                c += 13;
            } else if (c >= 'n' && c <= 'z') {
                c -= 13;
            } else if (c >= 'A' && c <= 'M') {
                c += 13;
            } else if (c >= 'N' && c <= 'Z') {
                c -= 13;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}