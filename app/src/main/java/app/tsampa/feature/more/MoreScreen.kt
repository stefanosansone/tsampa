package app.tsampa.feature.more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DonutSmall
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.PieChartOutline
import androidx.compose.material.icons.rounded.DonutSmall
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.tsampa.ui.TsampaApp
import app.tsampa.ui.theme.TsampaTheme

@Composable
internal fun MoreScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        content = {
            item { Column(modifier = Modifier.fillMaxWidth().height(150.dp)){} }
            item { Divider() }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().clickable {  },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.PieChartOutline,
                        contentDescription = "Goals",
                        modifier = Modifier.padding(15.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Goals"
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
    MoreScreen()
}