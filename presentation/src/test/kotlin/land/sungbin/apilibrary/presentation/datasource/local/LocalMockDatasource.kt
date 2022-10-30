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

package land.sungbin.apilibrary.presentation.datasource.local

import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.presentation.datasource.remote.FakeResponse

class LocalMockDatasource : ApiLibraryDatasource {
    override suspend fun fetchAllApis(): List<DomainApiItem> = FakeResponse.DomainSortedApiItems
    override suspend fun saveAllApis(apis: List<DomainApiItem>) {
        // nothing here.
    }
}
