package app.tsampa.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.tsampa.navigation.Route
import app.tsampa.navigation.TOP_LEVEL_DESTINATIONS
import app.tsampa.navigation.TopLevelDestination
import app.tsampa.navigation.TsampaNavHost
import app.tsampa.ui.theme.TsampaTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TsampaApp() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route ?: Route.DIARY
    val scaffoldInsets = WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal)

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val navbarScrimColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setStatusBarColor(color = Color.Transparent,
            darkIcons = useDarkIcons,
            transformColorForLightContent = { Color.Black })
        systemUiController.setNavigationBarColor(
            color = if (currentDestination in TOP_LEVEL_DESTINATIONS.map { it.route }) {
                navbarScrimColor
            } else {
                Color.Transparent
            },
            darkIcons = useDarkIcons,
            navigationBarContrastEnforced = false,
            transformColorForLightContent = { Color.Black },
        )
        onDispose {}
    }

    Scaffold(
        contentWindowInsets = scaffoldInsets,
        bottomBar = {
            TsampaBottomBar(
                destinations = TOP_LEVEL_DESTINATIONS,
                navController = navController,
                currentDestination = currentDestination,
                modifier = Modifier.testTag("TsampaBottomBar"),
            )
        },
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .consumedWindowInsets(contentPadding)
        ) {
            TsampaNavHost(navController = navController)
        }
    }
}

@Composable
private fun TsampaBottomBar(
    destinations: List<TopLevelDestination>,
    navController: NavController,
    currentDestination: String,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination == destination.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(destination.route) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                    )

                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TsampaAppPreview() {
    TsampaTheme {
        TsampaApp()
    }
}