/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress("NonAsciiCharacters")
@file:OptIn(ExperimentalCoroutinesApi::class)

package land.sungbin.apilibrary.presentation.test

import app.cash.turbine.test
import io.ktor.client.plugins.ClientRequestException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import land.sungbin.apilibrary.domain.usecase.ApiLibraryFetchUseCase
import land.sungbin.apilibrary.presentation.ApiLibraryState
import land.sungbin.apilibrary.presentation.MainViewModel
import land.sungbin.apilibrary.presentation.datasource.remote.FakeResponse
import land.sungbin.apilibrary.presentation.repository.ApiLibraryMockRepository
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ViewModelTest {
    @Test
    fun `뷰모델 state 가 Init - Loading - Loaded 로 변함`() = runTest {
        val repository = ApiLibraryMockRepository(
            isSorted = true,
            status = HttpStatusCode.OK,
        )
        val usecase = ApiLibraryFetchUseCase(repository = repository)
        val viewmodel = MainViewModel(fetchAllApi = usecase)

        launch {
            viewmodel.state.test {
                expectThat(awaitItem()).isEqualTo(ApiLibraryState.Initial)
                expectThat(awaitItem()).isEqualTo(ApiLibraryState.Loading)
                expectThat(awaitItem()) {
                    isA<ApiLibraryState.Loaded>()
                    get {
                        (this as ApiLibraryState.Loaded).apis
                    }.isEqualTo(FakeResponse.DomainSortedApiItems)
                }
            }
        }

        launch {
            viewmodel.loadApis()
        }
    }

    @Test
    fun `뷰모델 state 가 Init - Loading - Error 로 변함`() = runTest {
        val repository = ApiLibraryMockRepository(
            isSorted = true,
            status = HttpStatusCode.TooManyRequests,
        )
        val usecase = ApiLibraryFetchUseCase(repository = repository)
        val viewmodel = MainViewModel(fetchAllApi = usecase)

        launch {
            viewmodel.state.test {
                expectThat(awaitItem()).isEqualTo(ApiLibraryState.Initial)
                expectThat(awaitItem()).isEqualTo(ApiLibraryState.Loading)
                expectThat(awaitItem()) {
                    isA<ApiLibraryState.Error>()
                    get {
                        (this as ApiLibraryState.Error).exception
                    }.isA<ClientRequestException>()
                }
            }
        }

        launch {
            viewmodel.loadApis()
        }
    }

    @Test
    fun `usecase 를 통한 결과는 항상 이름 순서로 정렬됨`() = runTest {
        val repository = ApiLibraryMockRepository(
            isSorted = false,
            status = HttpStatusCode.OK,
        )
        val usecase = ApiLibraryFetchUseCase(repository = repository)
        val viewmodel = MainViewModel(fetchAllApi = usecase)

        launch {
            viewmodel.state.test {
                skipItems(2)
                expectThat(awaitItem()) {
                    get {
                        (this as ApiLibraryState.Loaded).apis
                    }.isEqualTo(FakeResponse.DomainSortedApiItems)
                }
            }
        }

        launch {
            viewmodel.loadApis()
        }
    }
}
