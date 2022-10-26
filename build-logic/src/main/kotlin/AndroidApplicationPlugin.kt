@file:Suppress(
    "UnstableApiUsage",
)

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.androidprojecttemplate.convention.ApplicationConstants
import land.sungbin.androidprojecttemplate.convention.PluginEnum
import land.sungbin.androidprojecttemplate.convention.applyPlugins
import land.sungbin.androidprojecttemplate.convention.configureApplication
import land.sungbin.androidprojecttemplate.convention.implementations
import land.sungbin.androidprojecttemplate.convention.libs
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
            val (versionName, versionCode) = "1.0.0" to 1

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
                    this.versionName = versionName
                    this.versionCode = versionCode
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

