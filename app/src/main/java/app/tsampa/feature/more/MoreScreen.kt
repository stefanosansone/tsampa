package app.tsampa.feature.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PieChartOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.tsampa.R
import app.tsampa.navigation.Route

@Composable
internal fun MoreScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        content = {
            item { Column(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)){} }
            item { Divider() }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(Route.GOALS) },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.PieChartOutline,
                        contentDescription = stringResource(id = R.string.goals),
                        modifier = Modifier.padding(15.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = stringResource(id = R.string.goals)
                    )
                }
            }
            item { Divider() }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    MoreScreen(rememberNavController())
}