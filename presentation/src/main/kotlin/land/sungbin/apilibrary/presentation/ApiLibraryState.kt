/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation

import land.sungbin.apilibrary.domain.model.ApiItem

sealed class ApiLibraryState {
    object Initial : ApiLibraryState()
    object Loading : ApiLibraryState()
    class Loaded(val apis: List<ApiItem>) : ApiLibraryState()
    class Error(val exception: Throwable) : ApiLibraryState()
}
