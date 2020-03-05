package com.hyif.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        System.out.println(666666666666666666666666666)
        AppExtension appExtension = project.extensions.getByType(AppExtension.class);
        appExtension.registerTransform(new CustomTransform(project))
    }
}
