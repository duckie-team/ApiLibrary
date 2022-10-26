/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import land.sungbin.apilibrary.convention.configureCompose
import land.sungbin.apilibrary.convention.libs
import land.sungbin.apilibrary.convention.setupComposeBom
import land.sungbin.apilibrary.convention.setupComposeUi
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Android 프레임워크의 Application 환경에서 Jetpack Compose 를 사용할 준비를 합니다.
 */
internal class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val extension = extensions.getByType<BaseAppModuleExtension>()

            configureCompose(
                extension = extension,
            )

            dependencies {
                setupComposeBom(
                    libs = libs,
                )
                setupComposeUi(
                    libs = libs,
                )
            }
        }
    }
}
