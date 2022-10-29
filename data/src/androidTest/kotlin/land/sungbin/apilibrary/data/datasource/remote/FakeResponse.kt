/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.remote

import land.sungbin.apilibrary.data.mapper.toDomain
import land.sungbin.apilibrary.data.model.ApiLibraryResponse
import land.sungbin.apilibrary.data.datasource.mapper

object FakeResponse {
    val ApiEntries = """
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
    val ApiItems = mapper.readValue(
        ApiEntries,
        ApiLibraryResponse::class.java
    ).entries.orEmpty().toDomain()
}
