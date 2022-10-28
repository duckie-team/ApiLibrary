/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.domain.datasource

import land.sungbin.apilibrary.domain.model.ApiItem

interface ApiLibraryDatasource {
    suspend fun fetchAllApis(): List<ApiItem>
    suspend fun saveAllApis(apis: List<ApiItem>)
}
