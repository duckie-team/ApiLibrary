/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.apilibrary.presentation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier

@NonRestartableComposable
@Composable
internal fun Badge(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
) {
    SuggestionChip(
        modifier = modifier,
        onClick = onClick,
        label = {
            Text(text = text)
        },
    )
}
