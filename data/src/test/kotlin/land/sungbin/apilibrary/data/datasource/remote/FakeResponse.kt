/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.remote

import land.sungbin.apilibrary.domain.model.ApiItem

object FakeResponse {
    val ApiEntriesJson = """
        {
          "count": 5,
          "entries": [
            {
              "API": "Axolotl",
              "Description": "Collection of axolotl pictures and facts",
              "Auth": "",
              "HTTPS": true,
              "Cors": "no",
              "Link": "https://theaxolotlapi.netlify.app/",
              "Category": "Animals"
            },
            {
              "API": "Cat Facts",
              "Description": "Daily cat facts",
              "Auth": "",
              "HTTPS": true,
              "Cors": "no",
              "Link": "https://alexwohlbruck.github.io/cat-facts/",
              "Category": "Animals"
            },
            {
              "API": "Cataas",
              "Description": "Cat as a service (cats pictures and gifs)",
              "Auth": "",
              "HTTPS": true,
              "Cors": "no",
              "Link": "https://cataas.com/",
              "Category": "Animals"
            },
            {
              "API": "Cats",
              "Description": "Pictures of cats from Tumblr",
              "Auth": "apiKey",
              "HTTPS": true,
              "Cors": "yes",
              "Link": "https://docs.thecatapi.com/",
              "Category": "Animals"
            },
            {
              "API": "Dog Facts",
              "Description": "Random dog facts",
              "Auth": "",
              "HTTPS": true,
              "Cors": "yes",
              "Link": "https://dukengn.github.io/Dog-facts-API/",
              "Category": "Animals"
            }
          ]
        }
    """.trimIndent()

    val DomainApiItems = listOf(
        ApiItem(
            name = "Axolotl",
            description = "Collection of axolotl pictures and facts",
            category = "Animals",
            link = "https://theaxolotlapi.netlify.app/",
            neededAuth = null,
            supportCORS = false,
        ),
        ApiItem(
            name = "Cat Facts",
            description = "Daily cat facts",
            category = "Animals",
            link = "https://alexwohlbruck.github.io/cat-facts/",
            neededAuth = null,
            supportCORS = false,
        ),
        ApiItem(
            name = "Cataas",
            description = "Cat as a service (cats pictures and gifs)",
            category = "Animals",
            link = "https://cataas.com/",
            neededAuth = null,
            supportCORS = false,
        ),
        ApiItem(
            name = "Cats",
            description = "Pictures of cats from Tumblr",
            category = "Animals",
            link = "https://docs.thecatapi.com/",
            neededAuth = "apiKey",
            supportCORS = true,
        ),
        ApiItem(
            name = "Dog Facts",
            description = "Random dog facts",
            category = "Animals",
            link = "https://dukengn.github.io/Dog-facts-API/",
            neededAuth = null,
            supportCORS = true,
        ),
    )

    val DataApiItems = listOf(
        land.sungbin.apilibrary.data.model.ApiItem(
            api = "Axolotl",
            description = "Collection of axolotl pictures and facts",
            auth = "",
            https = true,
            cors = "no",
            link = "https://theaxolotlapi.netlify.app/",
            category = "Animals",
        ),
        land.sungbin.apilibrary.data.model.ApiItem(
            api = "Cat Facts",
            description = "Daily cat facts",
            auth = "",
            https = true,
            cors = "no",
            link = "https://alexwohlbruck.github.io/cat-facts/",
            category = "Animals",
        ),
        land.sungbin.apilibrary.data.model.ApiItem(
            api = "Cataas",
            description = "Cat as a service (cats pictures and gifs)",
            auth = "",
            https = true,
            cors = "no",
            link = "https://cataas.com/",
            category = "Animals",
        ),
        land.sungbin.apilibrary.data.model.ApiItem(
            api = "Cats",
            description = "Pictures of cats from Tumblr",
            auth = "apiKey",
            https = true,
            cors = "yes",
            link = "https://docs.thecatapi.com/",
            category = "Animals",
        ),
        land.sungbin.apilibrary.data.model.ApiItem(
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
