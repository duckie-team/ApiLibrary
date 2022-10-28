/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.domain.model

data class ApiItem(
    val description: String,
    val category: String,
    val https: Boolean,
    val auth: String,
    val api: String,
    val cors: String,
    val link: String,
)
