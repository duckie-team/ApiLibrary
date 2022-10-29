/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.theme

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween

private const val DefaultAnimationDurationMillis = 200
private val DefaultAnimationEasing = LinearEasing

internal fun <T> defaultTween() = tween<T>(
    durationMillis = DefaultAnimationDurationMillis,
    easing = DefaultAnimationEasing,
)
