/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    `kotlin-dsl`
}

group = "land.sungbin.apilibrary.convention"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.build.kotlin)
    implementation(libs.build.kover)
    implementation(libs.build.gradle.agp)
}

gradlePlugin {
    val prefix = "apilibrary"
    plugins {
        register("androidApplicationPlugin") {
            id = "$prefix.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibraryPlugin") {
            id = "$prefix.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidLibraryComposePlugin") {
            id = "$prefix.android.library.compose"
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("androidLibraryComposeUiTestPlugin") {
            id = "$prefix.android.library.compose.uitest"
            implementationClass = "AndroidLibraryComposeUiTestPlugin"
        }
        register("jvmJunit4Plugin") {
            id = "$prefix.jvm.junit4"
            implementationClass = "JvmJUnit4Plugin"
        }
    }
}
