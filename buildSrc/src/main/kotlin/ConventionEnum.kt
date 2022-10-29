/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

object ConventionEnum {
    private const val prefix = "apilibrary"

    const val AndroidApplication = "$prefix.android.application"

    const val AndroidLibrary = "$prefix.android.library"
    const val AndroidLibraryUiTest = "$prefix.android.library.uitest"
    const val AndroidLibraryCompose = "$prefix.android.library.compose"
    const val AndroidLibraryComposeUiTest = "$prefix.android.library.compose.uitest"

    const val JvmJUnit4 = "$prefix.jvm.junit4"
}
