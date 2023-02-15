package app.tsampa.feature.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.tsampa.R
import app.tsampa.navigation.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GoalsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            GoalsScreenTopBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            MacroRow(macroName = stringResource(id = R.string.carbohydrates), macroValue = "0g")
            MacroRow(macroName = stringResource(id = R.string.protein), macroValue = "0g")
            MacroRow(macroName = stringResource(id = R.string.fat), macroValue = "0g")
        }
    }
}

@Composable
private fun MacroRow(
    macroName: String,
    macroValue: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = macroName)
        Text(text = macroValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GoalsScreenTopBar(
    navController: NavController
) {
    TopAppBar(
        title = { Text(Route.GOALS) },
        navigationIcon = { Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")}
    )
}

@Preview(showBackground = true)
@Composable
fun GoalsScreenPreview() {
    GoalsScreen(rememberNavController())
}