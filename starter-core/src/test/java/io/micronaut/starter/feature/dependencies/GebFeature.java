package io.micronaut.starter.feature.dependencies;

import io.micronaut.context.annotation.Requires;
import io.micronaut.starter.application.ApplicationType;
import io.micronaut.starter.application.generator.GeneratorContext;
import io.micronaut.starter.build.dependencies.DependencyContext;
import io.micronaut.starter.feature.Feature;
import io.micronaut.starter.options.TestFramework;
import org.jetbrains.annotations.NotNull;
import javax.inject.Singleton;

@Requires(property = "spec.name", value = "DependenciesFeatureSpec")
@Singleton
public class GebFeature implements Feature {

    public GebFeature() {
    }

    @NotNull
    @Override
    public String getName() {
        return "geb";
    }

    @Override
    public boolean supports(ApplicationType applicationType) {
        return true;
    }

    @Override
    public void apply(GeneratorContext context) {
        if (context.getTestFramework() == TestFramework.JUNIT) {
            context.addTestDependency("geb-junit5");
        } else if (context.getTestFramework() == TestFramework.SPOCK) {
            context.addTestDependency("geb-spock");
        }
        context.addTestRuntimeDependency("selenium-firefox-driver");
        context.addTestRuntimeDependency("selenium-support");
    }
}
