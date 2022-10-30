/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress(
    "UnstableApiUsage",
    "DSL_SCOPE_VIOLATION",
)

plugins {
    id(ConventionEnum.AndroidLibrary)
    id(ConventionEnum.AndroidLibraryCompose)
    id(ConventionEnum.AndroidLibraryComposeUiTest)
    id(ConventionEnum.JvmJUnit4)
    id(libs.plugins.hilt.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "land.sungbin.apilibrary.presentation"
}

dependencies {
    implementations(
        libs.kotlin.immutable.collection,
        libs.hilt.core,
        libs.util.systemui.controller,
        libs.compose.lottie,
        libs.androidx.splash,
        libs.androidx.browser,
        libs.androidx.room.core,
        libs.bundles.ktor,
        projects.data,
        projects.domain,
    )
    testImplementations(
        libs.test.ktor.client,
        libs.test.turbine,
    )
    kapt(
        libs.hilt.compiler,
    )
}
