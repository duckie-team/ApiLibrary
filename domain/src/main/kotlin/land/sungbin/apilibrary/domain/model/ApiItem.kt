/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.domain.model

/**
 * Api 아이템 정보 객체
 *
 * @param name API 이름
 * @param description API 설명
 * @param category API 카테고리
 * @param link API 홈페이지
 * @param neededAuth 필요한 인증키
 * @param supportCORS CORS 지원 여부
 */
data class ApiItem(
    val name: String,
    val description: String?,
    val category: String?,
    val link: String,
    val neededAuth: String?,
    val supportCORS: Boolean,
) {
    companion object
}
