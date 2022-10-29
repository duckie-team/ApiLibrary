/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation

import land.sungbin.apilibrary.domain.model.ApiItem

internal sealed class ApiLibraryState {
    object Initial : ApiLibraryState() {
        override fun toString() = "Initial"
    }

    object Loading : ApiLibraryState() {
        override fun toString() = "Loading"
    }

    class Loaded(val apis: List<ApiItem>) : ApiLibraryState() {
        override fun toString() = "[Loaded]\n\n\n${apis.joinToString("\n\n")}"
    }

    class Error(val exception: Throwable) : ApiLibraryState() {
        override fun toString() = "[Error] $exception"
    }
}
