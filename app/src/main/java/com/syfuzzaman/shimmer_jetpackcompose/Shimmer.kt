package com.syfuzzaman.shimmer_jetpackcompose

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.IntSize

/**
 * Declare a just-in-time composition of a [Modifier] that adds a shimmer effect to any composable
 * it is applied to. The shimmer effect is commonly used as a placeholder to indicate loading content.
 *
 * The shimmer effect animates a gradient that moves across the composable, creating a visual effect
 * that suggests the content is still loading.
 *
 * The [shimmer] modifier allows customization through several parameters, enabling the user to adjust
 * the appearance and behavior of the shimmer effect.
 *
 * Example usage:
 * @sample com.syfuzzaman.shimmer_jetpackcompose.ItemPlaceholder
 *
 * @param transparentMode When set to `true`, the shimmer colors will have reduced opacity.
 *                        Defaults to `false`.
 * @param shimmerColor The color to be used for the shimmer effect. Defaults to `R.color.placeholderBgColor`.
 * @param fallbackColor The fallback color used as the middle color in the gradient. Defaults to `R.color.cardBgColor`.
 * @param durationMillis The duration of the shimmer animation in milliseconds. Defaults to `1200` milliseconds.
 *
 * @return A [Modifier] that applies the shimmer effect to the composable it modifies.
 */
fun Modifier.shimmer(
    transparentMode: Boolean = false,
    shimmerColor: Int = R.color.placeholderBgColor,
    fallbackColor: Int = R.color.cardBgColor,
    durationMillis: Int = 1200,
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "Transition")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis)
        ), label = "Animation"
    )

    val colors = if (transparentMode) {
        listOf(
            colorResource(shimmerColor).copy(alpha = 0.5f),
            colorResource(fallbackColor),
            colorResource(shimmerColor).copy(alpha = 0.5f),
        )
    } else {
        listOf(
            colorResource(shimmerColor),
            colorResource(fallbackColor),
            colorResource(shimmerColor),
        )
    }
    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ).onGloballyPositioned { size = it.size }
}