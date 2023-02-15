package app.tsampa.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import app.tsampa.R
import app.tsampa.designsystem.icon.TsampaIcons

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

object Route {
    const val DIARY = "Diary"
    const val GOALS = "Goals"
    const val NUTRITION = "Nutrition"
    const val RECIPES = "Recipes"
    const val MORE = "More"
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = Route.DIARY,
        selectedIcon = TsampaIcons.DiarySelected,
        unselectedIcon = TsampaIcons.DiaryUnselected,
        iconTextId = R.string.diary
    ),
    TopLevelDestination(
        route = Route.RECIPES,
        selectedIcon = TsampaIcons.RecipesSelected,
        unselectedIcon = TsampaIcons.RecipesUnselected,
        iconTextId = R.string.recipes
    ),
    TopLevelDestination(
        route = Route.MORE,
        selectedIcon = TsampaIcons.MoreSelected,
        unselectedIcon = TsampaIcons.MoreUnselected,
        iconTextId = R.string.more
    )
)
