/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class ApiItem(
    @field:JsonProperty("Description")
    val description: String,

    @field:JsonProperty("Category")
    val category: String,

    @field:JsonProperty("HTTPS")
    val https: Boolean,

    @field:JsonProperty("Auth")
    val auth: String,

    @PrimaryKey
    @field:JsonProperty("API")
    val api: String,

    @field:JsonProperty("Cors")
    val cors: String,

    @field:JsonProperty("Link")
    val link: String,
)
