/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.repository

import land.sungbin.apilibrary.data.datasource.remote.RemoteMockDatasource
import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem

class ApiLibraryMockRepository {
    private val remoteDatasource = RemoteMockDatasource()

    suspend fun fetchAllApis(): List<DomainApiItem> {
        return remoteDatasource.fetchAllApis()
    }
}
