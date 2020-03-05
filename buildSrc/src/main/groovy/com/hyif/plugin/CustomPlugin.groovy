package com.hyif.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        AppExtension appExtension = project.extensions.getByType(AppExtension.class);
        appExtension.registerTransform(new CustomTransform(project))
    }
}
