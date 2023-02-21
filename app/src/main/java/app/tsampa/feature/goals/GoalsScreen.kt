package app.tsampa.feature.goals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.tsampa.R
import app.tsampa.navigation.Route
import app.tsampa.utils.capitalize

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
            Divider()
            MacroRow(macroName = stringResource(id = R.string.carbohydrates), macroValue = "0g")
            Divider()
            MacroRow(macroName = stringResource(id = R.string.protein), macroValue = "0g")
            Divider()
            MacroRow(macroName = stringResource(id = R.string.fat), macroValue = "0g")
            Divider()
        }
    }
}

@Composable
private fun MacroRow(
    macroName: String,
    macroValue: String
){
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        MacroDialog(macroName) { openDialog.value = it }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { openDialog.value = true },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.padding(start = 15.dp)) {
            Text(modifier = Modifier, text = macroName.capitalize())
            Text(
                text = macroValue,
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.ExtraLight
            )
        }
        Text(
            text = "0%",
            modifier = Modifier.padding(end = 15.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MacroDialog(
    macro: String,
    setOpenDialog: (Boolean) -> Unit
) {
    var test by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { setOpenDialog(false) },
        title = {
            Text(text = "${macro.capitalize()} Goal" )
        },
        text = {
            OutlinedTextField(
                value = test,
                onValueChange = { test = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        },
        confirmButton = {
            TextButton(onClick = { setOpenDialog(false) }){
                Text(text = "Save")
            }
        },
        dismissButton = {
            TextButton(onClick = { setOpenDialog(false) }){
                Text(text = "Cancel")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GoalsScreenTopBar(
    navController: NavController
) {
    TopAppBar(
        title = { Text(Route.GOALS) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }){
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GoalsScreenPreview() {
    GoalsScreen(rememberNavController())
}