/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalCoroutinesApi::class)
@file:Suppress("NonAsciiCharacters")

package land.sungbin.apilibrary.data.test

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import land.sungbin.apilibrary.data.datasource.remote.FakeResponse
import land.sungbin.apilibrary.data.repository.ApiLibraryMockRepository
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class RemoteTest {
    private val repository = ApiLibraryMockRepository()

    @Test
    fun `조회된 ApiItem 가 정확히 일치함`() = runTest {
        val response = repository.fetchAllApis()

        expectThat(response) {
            isEqualTo(FakeResponse.ApiItems)
        }
    }
}
