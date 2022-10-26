/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.apilibrary.convention.ApplicationConstants
import land.sungbin.apilibrary.convention.PluginEnum
import land.sungbin.apilibrary.convention.applyPlugins
import land.sungbin.apilibrary.convention.configureApplication
import land.sungbin.apilibrary.convention.implementations
import land.sungbin.apilibrary.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Android 프레임워크의 Application 환경을 구성합니다.
 */
internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            applyPlugins(
                PluginEnum.AndroidApplication,
                PluginEnum.AndroidKotlin,
                libs.findPlugin("oss-license").get().get().pluginId,
            )

            extensions.configure<BaseAppModuleExtension> {
                configureApplication(
                    extension = this,
                )

                defaultConfig {
                    targetSdk = ApplicationConstants.targetSdk
                    this.versionName = ApplicationConstants.versionName
                    this.versionCode = ApplicationConstants.versionCode
                }
            }

            dependencies {
                implementations(
                    libs.findLibrary("util-oss-license").get(),
                )
            }
        }
    }
}

