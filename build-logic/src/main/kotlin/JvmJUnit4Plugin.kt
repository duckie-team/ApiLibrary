/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

import land.sungbin.apilibrary.convention.androidTestImplementations
import land.sungbin.apilibrary.convention.libs
import land.sungbin.apilibrary.convention.setupJunit
import land.sungbin.apilibrary.convention.testImplementations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Android 프레임워크에 의존적이지 않은 순수한 Junit4 테스트 환경을 구성합니다.
 */
internal class JvmJUnit4Plugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            dependencies {
                testImplementations(
                    libs.findLibrary("test-strikt").get(),
                    libs.findLibrary("test-coroutines").get(),
                )
                androidTestImplementations(
                    libs.findLibrary("test-strikt").get(),
                    libs.findLibrary("test-coroutines").get(),
                )
                setupJunit(
                    core = libs.findLibrary("test-junit-core").get(),
                    engine = libs.findLibrary("test-junit-engine").get(),
                )
            }
        }
    }
}
