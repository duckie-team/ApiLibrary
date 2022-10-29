/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.mapper

import land.sungbin.apilibrary.data.model.ApiItem as DataApiItem
import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem

internal fun List<DataApiItem>.toDomain() = mapNotNull { item ->
    with(item) {
        if (api == null || link == null) { // require fields
            null
        } else {
            DomainApiItem(
                name = api,
                description = description,
                category = category,
                link = link,
                neededAuth = auth,
                supportCORS = cors == "yes",
            )
        }
    }
}

internal fun List<DomainApiItem>.toData() = map { item ->
    with(item) {
        DataApiItem(
            description = description,
            category = category,
            https = null,
            auth = neededAuth,
            api = name,
            cors = null,
            link = link,
        )
    }
}
