/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id(ConventionEnum.AndroidLibrary)
    id(ConventionEnum.JvmJUnit4)
    alias(libs.plugins.ksp)
    id(libs.plugins.hilt.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "land.sungbin.apilibrary.data"

    buildTypes {
        sourceSets.getByName("debug") {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        sourceSets.getByName("release") {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

dependencies {
    implementations(
        libs.hilt.core,
        libs.androidx.room.core,
        libs.coroutines,
        libs.ktor.client,
    )
    testImplementations(
        libs.test.room,
        libs.test.ktor.client,
    )
    ksp(
        libs.androidx.room.compiler,
    )
    kapt(
        libs.hilt.compiler,
    )
}
