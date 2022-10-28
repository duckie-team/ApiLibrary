/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.local

import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.data.mapper.toData
import land.sungbin.apilibrary.data.mapper.toDomain
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.domain.model.ApiItem

class LocalDatasource(
    private val dao: ApiLibraryDao,
) : ApiLibraryDatasource {
    override suspend fun fetchAllApis(): List<ApiItem> = dao.getAll().toDomain()
    override suspend fun saveAllApis(apis: List<ApiItem>) {
        dao.insertAll(apis.toData())
    }
}
