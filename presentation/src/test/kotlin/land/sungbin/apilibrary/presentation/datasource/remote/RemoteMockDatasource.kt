/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.datasource.remote

import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.jackson.jackson
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource

class RemoteMockDatasource(
    status: HttpStatusCode,
    private val isSorted: Boolean,
) : ApiLibraryDatasource {
    private val client = HttpClient(engine = MockEngine(status = status)) {
        expectSuccess = true
        install(plugin = ContentNegotiation) {
            jackson()
        }
    }

    override suspend fun fetchAllApis(): List<DomainApiItem> {
        client.get(urlString = "")
        return when (isSorted) {
            true -> FakeResponse.DomainSortedApiItems
            else -> FakeResponse.DomainApiItems
        }
    }

    override suspend fun saveAllApis(apis: List<DomainApiItem>): Nothing {
        throw UnsupportedOperationException(
            "RemoteDatasource does not support saveAllApis(). " +
                    "Please use LocalDatasource instead.",
        )
    }
}
