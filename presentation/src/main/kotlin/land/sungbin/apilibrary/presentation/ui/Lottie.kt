/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalFoundationApi::class)

package land.sungbin.apilibrary.presentation.ui

import androidx.annotation.RawRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import land.sungbin.apilibrary.presentation.R
import land.sungbin.apilibrary.presentation.theme.defaultTween
import land.sungbin.apilibrary.presentation.util.ensureFillMaxSize

internal val LottieSize = 200.dp

@Immutable
internal enum class LottieAsset(
    @RawRes val raw: Int,
) {
    Loading(raw = R.raw.reading),
    Empty(raw = R.raw.empty_box),
    Error(raw = R.raw.fire);

    companion object
}

@Suppress("FunctionName", "NOTHING_TO_INLINE")
internal inline fun LazyListScope.ResultLottieScreen(
    lottieAsset: LottieAsset,
) {
    item(
        key = lottieAsset,
        contentType = LottieAsset,
    ) {
        Box(
            modifier = Modifier.ensureFillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            LottieItem(
                modifier = Modifier
                    .animateItemPlacement(
                        animationSpec = defaultTween(),
                    )
                    .size(
                        size = LottieSize,
                    ),
                asset = lottieAsset,
            )
        }
    }
}

@NonRestartableComposable
@Composable
internal fun LottieItem(
    modifier: Modifier, // require
    asset: LottieAsset,
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            resId = asset.raw,
        ),
    )
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}
