/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toImmutableList
import land.sungbin.apilibrary.presentation.ApiLibraryState
import land.sungbin.apilibrary.presentation.ui.uistate.ApiLibraryErrorState
import land.sungbin.apilibrary.presentation.ui.uistate.ApiLibraryLoadedState
import land.sungbin.apilibrary.presentation.ui.uistate.ApiLibraryLoadingState
import land.sungbin.apilibrary.presentation.util.systemBarPaddings

@Composable
internal fun ApiList(
    modifier: Modifier, // require
    uiState: ApiLibraryState,
) {
    val spacedBy = remember(
        key1 = LocalDensity.current.density,
    ) {
        16.dp
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            top = systemBarPaddings.calculateTopPadding() + spacedBy,
            bottom = systemBarPaddings.calculateBottomPadding() + spacedBy,
        ),
        verticalArrangement = Arrangement.spacedBy(
            space = spacedBy,
        ),
    ) {
        when (uiState) {
            ApiLibraryState.Initial, is ApiLibraryState.Loading -> {
                ApiLibraryLoadingState()
            }
            is ApiLibraryState.Loaded -> {
                val apiItems = uiState.apis
                ApiLibraryLoadedState(
                    apiItems = apiItems.toImmutableList(),
                )
            }
            is ApiLibraryState.Error -> {
                ApiLibraryErrorState(
                    exceptionMessage = uiState.exception.message,
                )
            }
        }
    }
}
