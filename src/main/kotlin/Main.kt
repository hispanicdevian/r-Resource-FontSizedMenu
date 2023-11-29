import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File
import java.util.prefs.Preferences

@Composable
fun app() {
    var fontSized by remember { mutableStateOf(loadFontSize().sp) }


    val fontSizeMap = mapOf(
        "Font A" to 25.sp,
        "Font B" to 30.sp,
        "Font C" to 35.sp
    )


    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)
    ) {
        TopAppBar(
            backgroundColor = Color.Black,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Monotool Client",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = fontSized.value.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 30.dp).padding(vertical = 100.dp)
                .padding(horizontal = 250.dp)
                .background(
                    Color.Black, shape = AbsoluteRoundedCornerShape(8.dp)
                )
                .padding(5.dp)
                .size(300.dp)
                .background((Color.DarkGray), shape = AbsoluteRoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            val itemsList = listOf("Font A", "Font B", "Font C")
            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                state = rememberLazyListState(),
                verticalArrangement = Arrangement.Center
            ) {
                items(itemsList) { item ->
                    Text(
                        text = item,
                        color = Color.White,
                        modifier = Modifier
                            .clickable {
                                fontSized =
                                    fontSizeMap[item] ?: 20.sp // Default to 20 sp if item is not found in the map
                                saveFontSize(fontSized.value)
                            }
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 30.sp)
                    )




                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}
