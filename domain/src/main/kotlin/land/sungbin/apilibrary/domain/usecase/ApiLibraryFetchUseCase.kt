/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.domain.usecase

import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository

class ApiLibraryFetchUseCase(
    private val repository: ApiLibraryRepository,
) {
    suspend operator fun invoke() = runCatching {
        repository.fetchAllApis()
    }
}
