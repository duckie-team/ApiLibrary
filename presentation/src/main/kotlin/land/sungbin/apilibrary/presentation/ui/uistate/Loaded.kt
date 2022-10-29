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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.presentation.theme.defaultTween
import land.sungbin.apilibrary.presentation.ui.LottieAsset
import land.sungbin.apilibrary.presentation.ui.ResultLottieScreen

@Suppress("FunctionName")
internal fun LazyListScope.ApiLibraryLoadedState(
    apiItems: ImmutableList<ApiItem>,
) {
    when (apiItems.isEmpty()) {
        true -> {
            ResultLottieScreen(
                lottieAsset = LottieAsset.Empty,
            )
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
                        .fillMaxWidth()
                        .wrapContentHeight()
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
