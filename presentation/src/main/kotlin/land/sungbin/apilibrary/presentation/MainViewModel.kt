/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import land.sungbin.apilibrary.domain.usecase.ApiLibraryFetchUseCase

@Singleton
class MainViewModel @Inject constructor(
    private val fetchAllApi: ApiLibraryFetchUseCase,
) {
    private val _state = MutableStateFlow<ApiLibraryState>(ApiLibraryState.Initial)
    val state = _state.asStateFlow()

    suspend fun loadApis() {
        _state.value = ApiLibraryState.Loading
        fetchAllApi()
            .onSuccess { apis ->
                _state.value = ApiLibraryState.Loaded(
                    apis = apis,
                )
            }
            .onFailure { exception ->
                _state.value = ApiLibraryState.Error(
                    exception = exception,
                )
            }
    }
}
