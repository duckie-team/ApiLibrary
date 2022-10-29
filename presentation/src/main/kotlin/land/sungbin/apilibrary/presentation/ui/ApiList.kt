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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.presentation.ApiLibraryState
import land.sungbin.apilibrary.presentation.R
import land.sungbin.apilibrary.presentation.theme.defaultTween

@Composable
internal fun ApiList(
    modifier: Modifier = Modifier,
    uiState: ApiLibraryState,
) {
    val spacedBy = remember(
        key1 = LocalDensity.current.density,
    ) {
        16.dp
    }
    val systemBarPaddings = WindowInsets.systemBars.asPaddingValues()

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
                ResultLottieScreen(lottieAsset = LottieAsset.Loading)
            }
            is ApiLibraryState.Loaded -> {
                val apiItems = uiState.apis
                when (apiItems.isEmpty()) {
                    true -> {
                        ResultLottieScreen(lottieAsset = LottieAsset.Empty)
                    }
                    else -> {
                        items(
                            items = apiItems,
                            contentType = { ApiItem },
                            key = { apiItem ->
                                apiItem.name
                            }
                        ) { apiItem ->
                            ApiItemCard(
                                modifier = Modifier
                                    .animateItemPlacement(
                                        animationSpec = defaultTween(),
                                    )
                                    .padding(
                                        all = 12.dp,
                                    ),
                                apiItem = apiItem,
                            )
                        }
                    }
                }
            }
            is ApiLibraryState.Error -> {
                item(
                    key = LottieAsset.Error,
                ) {
                    val exceptionMessage = uiState.exception.message

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.CenterVertically,
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        LottieItem(
                            modifier = Modifier.animateItemPlacement(
                                animationSpec = defaultTween(),
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
        }
    }
}

private enum class LottieAsset(
    @RawRes val raw: Int,
) {
    Loading(raw = R.raw.reading),
    Empty(raw = R.raw.empty_box),
    Error(raw = R.raw.fire);

    companion object
}

@Suppress("FunctionName")
private fun LazyListScope.ResultLottieScreen(
    lottieAsset: LottieAsset,
) {
    item(
        key = lottieAsset,
        contentType = LottieAsset,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            LottieItem(
                modifier = Modifier.animateItemPlacement(
                    animationSpec = defaultTween(),
                ),
                asset = lottieAsset,
            )
        }
    }
}

@Composable
private fun LottieItem(
    modifier: Modifier, // require
    lottieSize: Dp = remember(
        key1 = LocalDensity.current.density,
    ) {
        100.dp
    },
    asset: LottieAsset,
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            resId = asset.raw,
        ),
    )
    LottieAnimation(
        modifier = modifier.size(
            size = lottieSize,
        ),
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

private const val CorsBadgeString = "CORS"

@Composable
private fun ApiItemCard(
    modifier: Modifier, // require
    apiItem: ApiItem,
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = apiItem.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                apiItem.category?.let { category ->
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
            }
            apiItem.description?.let { description ->
                Text(
                    text = description,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                ),
            ) {
                apiItem.neededAuth?.let { _neededAuth ->
                    val neededAuth = _neededAuth.replaceFirstChar { first ->
                        first.titlecase()
                    }
                    Text(
                        text = neededAuth,
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
                if (apiItem.supportCORS) {
                    Text(
                        text = CorsBadgeString,
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}
