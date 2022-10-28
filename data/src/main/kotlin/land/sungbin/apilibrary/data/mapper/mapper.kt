/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.mapper

import land.sungbin.apilibrary.data.model.ApiItem as DataApiItem
import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem

internal fun List<DataApiItem>.toDomain() = map { item ->
    with(item) {
        DomainApiItem(
            description = description,
            category = category,
            https = https,
            auth = auth,
            api = api,
            cors = cors,
            link = link,
        )
    }
}

internal fun List<DomainApiItem>.toData() = map { item ->
    with(item) {
        DataApiItem(
            description = description,
            category = category,
            https = https,
            auth = auth,
            api = api,
            cors = cors,
            link = link,
        )
    }
}
