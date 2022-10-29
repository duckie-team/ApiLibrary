/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress("PrivatePropertyName")
@file:OptIn(ExperimentalCoroutinesApi::class)

package land.sungbin.apilibrary.data.test

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import land.sungbin.apilibrary.data.datasource.remote.RemoteMockDatasource
import org.junit.Test
import strikt.api.expectCatching
import strikt.assertions.isA
import strikt.assertions.isFailure
import strikt.assertions.isSuccess

class HttpStatusTest {
    private val OkRemote = RemoteMockDatasource(
        status = HttpStatusCode.OK,
    )
    private val TooManyRequestsRemote = RemoteMockDatasource(
        status = HttpStatusCode.TooManyRequests,
    )
    private val ServiceUnavailableRemote = RemoteMockDatasource(
        status = HttpStatusCode.ServiceUnavailable,
    )

    @Test
    fun `OK status is success`() = runTest {
        expectCatching { OkRemote.fetchAllApis() }
            .isSuccess()
    }

    @Test
    fun `TooManyRequests status is failure`() = runTest {
        expectCatching { TooManyRequestsRemote.fetchAllApis() }
            .isFailure()
            .isA<ClientRequestException>()
    }

    @Test
    fun `ServiceUnavailable status is failure`() = runTest {
        expectCatching { ServiceUnavailableRemote.fetchAllApis() }
            .isFailure()
            .isA<ServerResponseException>()
    }
}
