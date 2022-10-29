/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.remote

import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.jackson.jackson
import land.sungbin.apilibrary.data.Constants
import land.sungbin.apilibrary.data.mapper.toDomain
import land.sungbin.apilibrary.data.model.ApiLibraryResponse
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource

class RemoteMockDatasource(
    status: HttpStatusCode = HttpStatusCode.OK,
) : ApiLibraryDatasource {
    private val client = HttpClient(engine = MockEngine(status = status)) {
        expectSuccess = true
        install(plugin = ContentNegotiation) {
            jackson()
        }
    }

    override suspend fun fetchAllApis(): List<DomainApiItem> {
        val request = client.get(urlString = Constants.ApiUrl)
        val body: ApiLibraryResponse = request.body()
        return body.entries.orEmpty().toDomain()
    }

    override suspend fun saveAllApis(apis: List<DomainApiItem>): Nothing {
        throw UnsupportedOperationException(
            "RemoteDatasource does not support saveAllApis(). " +
                    "Please use LocalDatasource instead.",
        )
    }
}
