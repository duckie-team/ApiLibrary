/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.build.kotlin)
    implementation(libs.build.gradle.agp)
    implementation("com.squareup:javapoet:1.13.0") {
        because("https://github.com/google/dagger/issues/3068#issuecomment-999118496")
    }
}
