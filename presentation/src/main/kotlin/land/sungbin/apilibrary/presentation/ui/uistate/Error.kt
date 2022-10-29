/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalFoundationApi::class)

package land.sungbin.apilibrary.presentation.ui.uistate

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import land.sungbin.apilibrary.presentation.R
import land.sungbin.apilibrary.presentation.theme.defaultTween
import land.sungbin.apilibrary.presentation.ui.LottieAsset
import land.sungbin.apilibrary.presentation.ui.LottieItem
import land.sungbin.apilibrary.presentation.ui.LottieSize
import land.sungbin.apilibrary.presentation.util.ensureFillMaxSize

@Suppress("FunctionName")
internal fun LazyListScope.ApiLibraryErrorState(
    exceptionMessage: String?,
) {
    item(
        key = LottieAsset.Error,
    ) {
        Column(
            modifier = Modifier
                .ensureFillMaxSize()
                .padding(
                    all = 30.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically,
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LottieItem(
                modifier = Modifier
                    .animateItemPlacement(
                        animationSpec = defaultTween(),
                    )
                    .size(
                        size = LottieSize,
                    ),
                asset = LottieAsset.Error,
            )
            Text(
                text = stringResource(
                    id = R.string.composable_apilibrary_error,
                    exceptionMessage?.let { message ->
                        "\n\n$message"
                    }.orEmpty(),
                ),
            )
        }
    }
}
