/*
 * Copyright 2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.starter.feature.function;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Introspected;

/**
 * Encapsulates a link to Website.
 * @author Sergio del Amo
 */
@Introspected
public class DocumentationLink {
    @NonNull
    private String title;

    @NonNull
    private String url;

    public DocumentationLink() {
    }

    public DocumentationLink(@NonNull String title, @NonNull String url) {
        this.title = title;
        this.url = url;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }
}
