
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mathkids.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg6),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Choose Mode",
            fontSize = 27.sp,
            color = Color.White
        )
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),

            onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "*")
            )
        }) {
            Text(text = "*", fontSize = 30.sp,
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),

            onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "÷")
            )
        }) {
            Text(text = "÷", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(18.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),

            onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "+")
            )
        }) {
            Text(text = "+", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(18.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 125.dp),

            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),

            onClick = {
            navController.navigate(
                route = Screens.Name.getFullRoute(mode = "-")
            )
        }) {
            Text(text = "-", fontSize = 30.sp)
        }
    }
}