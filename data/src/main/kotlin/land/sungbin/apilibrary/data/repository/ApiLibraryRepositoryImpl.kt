/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.repository

import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository

class ApiLibraryRepositoryImpl(
    private val calcIsOfflineMode: () -> Boolean,
    private val localDatasource: ApiLibraryDatasource,
    private val remoteDatasource: ApiLibraryDatasource,
) : ApiLibraryRepository {
    override suspend fun fetchAllApis(): List<ApiItem> {
        return if (calcIsOfflineMode()) {
            localDatasource.fetchAllApis()
        } else {
            remoteDatasource.fetchAllApis().also { apis ->
                localDatasource.saveAllApis(apis = apis)
            }
        }
    }
}
