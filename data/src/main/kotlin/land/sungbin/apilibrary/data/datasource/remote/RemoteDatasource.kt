/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.jackson.jackson
import land.sungbin.apilibrary.data.Constants
import land.sungbin.apilibrary.data.mapper.toDomain
import land.sungbin.apilibrary.data.model.ApiLibraryResponse
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.domain.model.ApiItem

private val DefaultCIOClient = HttpClient(engineFactory = CIO) {
    expectSuccess = true
    engine {
        endpoint {
            connectTimeout = Constants.MaxTimeoutMs
            connectAttempts = Constants.MaxRetryCount
        }
    }
    install(plugin = ContentNegotiation) {
        jackson()
    }
    install(plugin = Logging) {
        logger = Logger.ANDROID
        level = LogLevel.ALL
    }
}

class RemoteDatasource(
    private val client: HttpClient = DefaultCIOClient,
) : ApiLibraryDatasource {
    override suspend fun fetchAllApis(): List<ApiItem> {
        val request = client.get(urlString = Constants.ApiUrl)
        val body: ApiLibraryResponse = request.body()
        return body.entries.orEmpty().toDomain()
    }

    override suspend fun saveAllApis(apis: List<ApiItem>): Nothing {
        throw UnsupportedOperationException(
            "RemoteDatasource does not support saveAllApis(). " +
                    "Please use LocalDatasource instead.",
        )
    }
}
