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

package land.sungbin.apilibrary.data.repository

import land.sungbin.apilibrary.data.datasource.local.LocalMockDatasource
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.data.datasource.remote.RemoteMockDatasource
import land.sungbin.apilibrary.domain.model.ApiItem

class ApiLibraryMockRepository(dao: ApiLibraryDao) {
    private val localDatasource = LocalMockDatasource(dao = dao)
    private val remoteDatasource = RemoteMockDatasource()

    suspend fun fetchAllApis(
        isOfflineMode: Boolean,
    ): List<ApiItem> {
        return if (isOfflineMode) {
            localDatasource.fetchAllApis()
        } else {
            remoteDatasource.fetchAllApis().also { apis ->
                localDatasource.saveAllApis(apis = apis)
            }
        }
    }
}
