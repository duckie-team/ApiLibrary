/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.repository

import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.domain.model.ApiItem

class ApiLibraryRepository(
    private val localDatasource: ApiLibraryDatasource,
    private val remoteDatasource: ApiLibraryDatasource,
) {
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
