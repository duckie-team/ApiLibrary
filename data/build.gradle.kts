/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress(
    "DSL_SCOPE_VIOLATION",
    "UnstableApiUsage",
)

plugins {
    id(ConventionEnum.AndroidLibrary)
    id(ConventionEnum.AndroidLibraryUiTest)
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

    packagingOptions {
        resources.excludes.addAll(
            listOf(
                "META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",
            )
        )
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementations(
        libs.hilt.core,
        libs.androidx.room.core,
        libs.coroutines,
        libs.bundles.ktor,
        projects.domain,
    )
    testImplementations(
        libs.test.ktor.client,
    )
    androidTestImplementations(
        libs.test.ktor.client,
    )
    ksp(
        libs.androidx.room.compiler,
    )
    kapt(
        libs.hilt.compiler,
    )
}
