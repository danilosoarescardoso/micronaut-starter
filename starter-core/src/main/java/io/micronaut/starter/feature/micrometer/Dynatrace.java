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
package io.micronaut.starter.feature.micrometer;

import io.micronaut.starter.application.generator.GeneratorContext;
import io.micronaut.starter.build.dependencies.Dependency;
import io.micronaut.starter.feature.other.Management;

import javax.inject.Singleton;

@Singleton
public class Dynatrace extends MicrometerFeature {

    public Dynatrace(Core core, Management management) {
        super(core, management);
    }

    @Override
    public String getName() {
        return "micrometer-dynatrace";
    }

    @Override
    public String getDescription() {
        return "Adds support for Micrometer metrics (w/ Dynatrace reporter)";
    }

    @Override
    public void apply(GeneratorContext generatorContext) {
        generatorContext.getConfiguration().put(EXPORT_PREFIX + ".dynatrace.enabled", true);
        generatorContext.getConfiguration().put(EXPORT_PREFIX + ".dynatrace.apiToken", "${DYNATRACE_DEVICE_API_TOKEN}");
        generatorContext.getConfiguration().put(EXPORT_PREFIX + ".dynatrace.uri", "${DYNATRACE_DEVICE_URI}");
        generatorContext.getConfiguration().put(EXPORT_PREFIX + ".dynatrace.deviceId", "${DYNATRACE_DEVICE_ID}");
        generatorContext.getConfiguration().put(EXPORT_PREFIX + ".dynatrace.step", "PT1M");
        generatorContext.addDependency(Dependency.builder()
                .groupId("io.micronaut.micrometer")
                .artifactId("micronaut-micrometer-registry-dynatrace")
                .compile());
    }
}
