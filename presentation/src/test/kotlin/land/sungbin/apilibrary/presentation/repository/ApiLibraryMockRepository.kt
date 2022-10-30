/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.repository

import io.ktor.http.HttpStatusCode
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository
import land.sungbin.apilibrary.presentation.datasource.remote.RemoteMockDatasource

class ApiLibraryMockRepository(
    status: HttpStatusCode,
    isSorted: Boolean,
) : ApiLibraryRepository {
    private val remoteDatasource = RemoteMockDatasource(
        status = status,
        isSorted = isSorted,
    )

    override suspend fun fetchAllApis(): List<ApiItem> {
        return remoteDatasource.fetchAllApis()
    }
}
