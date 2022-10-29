/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.ui.uistate

import androidx.compose.foundation.lazy.LazyListScope
import land.sungbin.apilibrary.presentation.ui.LottieAsset
import land.sungbin.apilibrary.presentation.ui.ResultLottieScreen

@Suppress("NOTHING_TO_INLINE", "FunctionName")
internal inline fun LazyListScope.ApiLibraryLoadingState() {
    ResultLottieScreen(
        lottieAsset = LottieAsset.Loading,
    )
}
