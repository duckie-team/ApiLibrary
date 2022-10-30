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
import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository

class ApiLibraryMockRepository(
    dao: ApiLibraryDao,
    private val isOfflineMode: Boolean,
) : ApiLibraryRepository {
    private val localDatasource = LocalMockDatasource(dao = dao)
    private val remoteDatasource = RemoteMockDatasource()

    override suspend fun fetchAllApis(): List<ApiItem> {
        return if (isOfflineMode) {
            localDatasource.fetchAllApis()
        } else {
            remoteDatasource.fetchAllApis().also { apis ->
                localDatasource.saveAllApis(apis = apis)
            }
        }
    }
}
