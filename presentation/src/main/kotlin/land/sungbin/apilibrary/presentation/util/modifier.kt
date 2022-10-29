/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

// LazyListScope.item 에서 Modifier.fillMaxHeight 가 작동하지 않음
// LocalConfiguration.current.screenHeightDp 는 system bars 의 높이를 포함하지 않음
@Stable
internal fun Modifier.ensureFillMaxHeight() = composed {
    val systemBarPaddings = WindowInsets.systemBars.asPaddingValues()

    height(
        height = LocalConfiguration.current.screenHeightDp.dp
            .plus(other = systemBarPaddings.calculateTopPadding())
            .plus(other = systemBarPaddings.calculateBottomPadding()),
    )
}

// LazyListScope.item 에서 Modifier.fillMaxHeight 가 작동하지 않음
// See: Modifier.ensureFillMaxHeight
@Stable
internal fun Modifier.ensureFillMaxSize() = fillMaxWidth().ensureFillMaxHeight()
