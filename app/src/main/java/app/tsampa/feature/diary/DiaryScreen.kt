package app.tsampa.feature.diary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DonutLarge
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.tsampa.navigation.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DiaryScreen(
    navController: NavController
) {
    Scaffold(topBar = {
        DiaryScreenTopBar(navController)
    }) { paddingValues ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
        ) {
            Column() {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DiaryScreenTopBar(
    navController: NavController
) {
    TopAppBar(title = { Text(Route.DIARY) }, actions = {
        IconButton(
            onClick = { navController.navigate(Route.NUTRITION) }
        ){
            Icon(
                imageVector = Icons.Default.DonutLarge,
                contentDescription = "Nutrition"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Nutrition"
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DiaryScreenPreview() {
    DiaryScreen(rememberNavController())
}