/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

import com.android.build.gradle.LibraryExtension
import land.sungbin.apilibrary.convention.androidTestImplementations
import land.sungbin.apilibrary.convention.libs
import land.sungbin.apilibrary.convention.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Android 프레임워크의 Library 환경에서 UI 테스트를 진행할 준비를 합니다.
 */
class AndroidLibraryUiTestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                dependencies {
                    androidTestImplementations(
                        libs.findLibrary("test-androidx-junit").get(),
                        libs.findLibrary("test-androidx-runner").get(),
                    )
                }
            }
        }
    }
}
