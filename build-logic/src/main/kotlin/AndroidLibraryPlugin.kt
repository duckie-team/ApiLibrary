/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.gradle.LibraryExtension
import land.sungbin.apilibrary.convention.ApplicationConstants
import land.sungbin.apilibrary.convention.PluginEnum
import land.sungbin.apilibrary.convention.applyPlugins
import land.sungbin.apilibrary.convention.configureApplication
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Android 프레임워크의 Library 환경을 구성합니다.
 */
internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            applyPlugins(
                PluginEnum.AndroidLibrary,
                PluginEnum.AndroidKotlin,
            )

            extensions.configure<LibraryExtension> {
                configureApplication(
                    extension = this,
                )

                buildFeatures {
                    buildConfig = false
                }

                defaultConfig.targetSdk = ApplicationConstants.targetSdk
            }
        }
    }
}
