/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:Suppress("PrivatePropertyName")

package land.sungbin.apilibrary.data.test

import io.ktor.http.HttpStatusCode
import land.sungbin.apilibrary.data.datasource.remote.RemoteDatasource

class HttpStatusTest {
    private val OkRemote = RemoteDatasource(
        status = HttpStatusCode.OK,
    )
    private val ForbiddenRemote = RemoteDatasource(
        status = HttpStatusCode.Forbidden,
    )
}
