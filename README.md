# Shimmer Modifier for Jetpack Compose

The **Shimmer Modifier** provides a just-in-time composition of a `Modifier` that adds a shimmer effect to any composable it is applied to. The shimmer effect is commonly used as a placeholder to indicate loading content. It animates a gradient that moves across the composable, creating a visual effect suggesting the content is still loading.

## Features

- **Customizable Transparency**: Adjust the shimmer colors' opacity with the `transparentMode` parameter.
- **Color Customization**: Choose your desired colors for the shimmer effect using the `shimmerColor` and `fallbackColor` parameters.
- **Adjustable Duration**: Control the shimmer animation's duration with the `durationMillis` parameter.

## Usage

Here is an example of how to use the shimmer modifier in your Jetpack Compose project:

```kotlin
@Composable
fun ItemPlaceholder() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .shimmer(
            transparentMode = true,
            shimmerColor = R.color.placeholderBgColor,
            fallbackColor = R.color.cardBgColor,
            durationMillis = 1200
        )
    ) {
        // Content goes here
    }
}
```

## Parameters

- **transparentMode** (`Boolean`): When set to `true`, the shimmer colors will have reduced opacity. Defaults to `false`.
- **shimmerColor** (`Color`): The color to be used for the shimmer effect. Defaults to `R.color.placeholderBgColor`.
- **fallbackColor** (`Color`): The fallback color used as the middle color in the gradient. Defaults to `R.color.cardBgColor`.
- **durationMillis** (`Int`): The duration of the shimmer animation in milliseconds. Defaults to `1200` milliseconds.

## Example Usage

```kotlin
@sample com.syfuzzaman.shimmer_jetpackcompose.ItemPlaceholder
```

By using this modifier, you can enhance the user experience by visually indicating loading states in your application, making it clear that content is being fetched or processed.
