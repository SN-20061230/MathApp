
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathkids.R
import kotlin.math.roundToInt

@Composable
fun ResultScreen(score: Int, tasks: Int) {

    val context = LocalContext.current
    val top =
        SharedPreference(context).getRecords().sortedWith(compareBy({ it.second }, { it.first }))
            .asReversed()[0]

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
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text =  "Time Is UP",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text =  "$score/" + (tasks.toInt()-1),
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (score == 0){
                    Text(
                        text = "0%",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                else {
                    Text(
                        text = "${(score.toDouble() / (tasks.toDouble() - 1) * 100).roundToInt()}%",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 13.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Top 1: ${top.first}",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 11.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Score: ${top.second}",
                    color = Color.White,

                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )
            }
        }
    }
}