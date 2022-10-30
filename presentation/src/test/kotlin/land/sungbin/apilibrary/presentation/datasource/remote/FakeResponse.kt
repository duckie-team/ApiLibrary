/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.datasource.remote

import land.sungbin.apilibrary.data.model.ApiItem as DataApiItem
import land.sungbin.apilibrary.domain.model.ApiItem as DomainApiItem

object FakeResponse {
    val DomainApiItems = listOf(
        DomainApiItem(
            name = "Dog Facts",
            description = "Random dog facts",
            category = "Animals",
            link = "https://dukengn.github.io/Dog-facts-API/",
            neededAuth = null,
            supportCORS = true,
        ),
        DomainApiItem(
            name = "Cat Facts",
            description = "Daily cat facts",
            category = "Animals",
            link = "https://alexwohlbruck.github.io/cat-facts/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Axolotl",
            description = "Collection of axolotl pictures and facts",
            category = "Animals",
            link = "https://theaxolotlapi.netlify.app/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Cataas",
            description = "Cat as a service (cats pictures and gifs)",
            category = "Animals",
            link = "https://cataas.com/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Cats",
            description = "Pictures of cats from Tumblr",
            category = "Animals",
            link = "https://docs.thecatapi.com/",
            neededAuth = "apiKey",
            supportCORS = true,
        ),
    )

    val DomainSortedApiItems = listOf(
        DomainApiItem(
            name = "Axolotl",
            description = "Collection of axolotl pictures and facts",
            category = "Animals",
            link = "https://theaxolotlapi.netlify.app/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Cat Facts",
            description = "Daily cat facts",
            category = "Animals",
            link = "https://alexwohlbruck.github.io/cat-facts/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Cataas",
            description = "Cat as a service (cats pictures and gifs)",
            category = "Animals",
            link = "https://cataas.com/",
            neededAuth = null,
            supportCORS = false,
        ),
        DomainApiItem(
            name = "Cats",
            description = "Pictures of cats from Tumblr",
            category = "Animals",
            link = "https://docs.thecatapi.com/",
            neededAuth = "apiKey",
            supportCORS = true,
        ),
        DomainApiItem(
            name = "Dog Facts",
            description = "Random dog facts",
            category = "Animals",
            link = "https://dukengn.github.io/Dog-facts-API/",
            neededAuth = null,
            supportCORS = true,
        ),
    )

    val DataApiItems = listOf(
        DataApiItem(
            api = "Axolotl",
            description = "Collection of axolotl pictures and facts",
            auth = "",
            https = true,
            cors = "no",
            link = "https://theaxolotlapi.netlify.app/",
            category = "Animals",
        ),
        DataApiItem(
            api = "Cat Facts",
            description = "Daily cat facts",
            auth = "",
            https = true,
            cors = "no",
            link = "https://alexwohlbruck.github.io/cat-facts/",
            category = "Animals",
        ),
        DataApiItem(
            api = "Cataas",
            description = "Cat as a service (cats pictures and gifs)",
            auth = "",
            https = true,
            cors = "no",
            link = "https://cataas.com/",
            category = "Animals",
        ),
        DataApiItem(
            api = "Cats",
            description = "Pictures of cats from Tumblr",
            auth = "apiKey",
            https = true,
            cors = "yes",
            link = "https://docs.thecatapi.com/",
            category = "Animals",
        ),
        DataApiItem(
            api = "Dog Facts",
            description = "Random dog facts",
            auth = "",
            https = true,
            cors = "yes",
            link = "https://dukengn.github.io/Dog-facts-API/",
            category = "Animals",
        ),
    )
}
