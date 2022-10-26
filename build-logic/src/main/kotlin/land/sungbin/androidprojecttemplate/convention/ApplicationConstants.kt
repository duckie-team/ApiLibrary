package land.sungbin.androidprojecttemplate.convention

import org.gradle.api.JavaVersion

/**
 * 그레이들 설정에 사용될 기본 상수 값들 모음
 */
internal object ApplicationConstants {
    const val minSdk = 23
    const val targetSdk = 33
    const val compileSdk = 33
    const val jvmTarget = "11"
    val javaVersion = JavaVersion.VERSION_11
}
