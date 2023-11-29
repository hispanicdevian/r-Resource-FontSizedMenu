import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}

@Composable
fun app() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Aligns children to the start and end of the row
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display fontSizeV1 on the left
            fontSizeV1(Modifier.weight(1f))

            // Display fontSizeV2 on the right
            fontSizeV2(Modifier.weight(1f))
        }
    }
}
