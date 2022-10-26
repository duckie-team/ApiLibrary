import com.android.build.gradle.LibraryExtension
import land.sungbin.androidprojecttemplate.convention.androidTestImplementations
import land.sungbin.androidprojecttemplate.convention.configureCompose
import land.sungbin.androidprojecttemplate.convention.debugImplementations
import land.sungbin.androidprojecttemplate.convention.libs
import land.sungbin.androidprojecttemplate.convention.setupComposeBom
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Android 프레임워크의 Library 환경에서 Jetpack Compose 의 UI 테스트를 진행할 준비를 합니다.
 */
internal class AndroidLibraryComposeUiTestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val extension = extensions.getByType<LibraryExtension>()

            configureCompose(
                extension = extension,
            )

            extension.apply {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies {
                setupComposeBom(
                    libs = libs,
                )
                debugImplementations(
                    libs.findLibrary("test-compose-manifest").get(),
                )
                androidTestImplementations(
                    libs.findLibrary("test-compose-junit").get(),
                )
            }
        }
    }
}

