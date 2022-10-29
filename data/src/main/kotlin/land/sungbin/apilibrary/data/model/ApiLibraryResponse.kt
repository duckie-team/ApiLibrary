/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiLibraryResponse(
    @field:JsonProperty("entries")
    val entries: List<ApiItem>? = null,

    @field:JsonProperty("count")
    val count: Int? = null,
)
