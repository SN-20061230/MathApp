
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Select Mode",
            fontSize = 27.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "easy")
            )
        }) {
            Text(text = "Easy")
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "medium")
            )
        }) {
            Text(text = "Medium")
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp), onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "hard")
            )
        }) {
            Text(text = "Hard")
        }
    }
}