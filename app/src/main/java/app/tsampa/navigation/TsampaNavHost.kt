package app.tsampa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.tsampa.feature.diary.DiaryScreen
import app.tsampa.feature.more.MoreScreen
import app.tsampa.feature.nutrition.NutritionScreen
import app.tsampa.feature.recipes.RecipesScreen

@Composable
fun TsampaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Route.DIARY,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(Route.DIARY) {
            DiaryScreen(navController)
        }
        composable(Route.RECIPES) {
            RecipesScreen()
        }
        composable(Route.MORE) {
            MoreScreen()
        }
        composable(Route.NUTRITION) {
            NutritionScreen()
        }
    }
}