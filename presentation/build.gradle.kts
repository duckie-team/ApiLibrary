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
    id(libs.plugins.hilt.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "land.sungbin.apilibrary.presentation"
}

dependencies {
    implementations(
        libs.hilt.core,
        libs.androidx.browser,
        libs.util.systemui.controller,
        libs.androidx.room.core,
        libs.bundles.ktor,
        projects.data,
        projects.domain,
    )
    kapt(
        libs.hilt.compiler,
    )
}
