@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kover)
}

koverMerged {
    enable()
    xmlReport {
        reportFile.set(file("$rootDir/report/test-coverage/report.xml"))
    }
    htmlReport {
        reportDir.set(file("$rootDir/report/test-coverage/html"))
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.build.kotlin)
        classpath(libs.build.oss.license)
        classpath(libs.build.gradle.agp)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    afterEvaluate {
        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=kotlin.OptIn",
                    "-opt-in=kotlin.RequiresOptIn",
                )
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=$rootDir/report/compose-metrics",
                )
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=$rootDir/report/compose-reports",
                )
            }
        }
    }

    apply {
        plugin(rootProject.libs.plugins.kover.get().pluginId)
    }
}

tasks.register(
    name = "cleanAll",
    type = Delete::class,
) {
    allprojects.map { project ->
        project.buildDir
    }.forEach(::delete)
}
