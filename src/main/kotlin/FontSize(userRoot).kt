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
import java.util.prefs.Preferences

@Composable
fun fontSizeV2() {
    var fontSized by remember { mutableStateOf(loadFontSizeV2().sp) }

    val fontSizeMap = mapOf(
        "Font A" to 25.sp,
        "Font B" to 30.sp,
        "Font C" to 35.sp
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .weight(1f)
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
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
                                    saveFontSizeV2(fontSized.value)
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
}

fun saveFontSizeV2(fontSize: Float) {
    val prefs = Preferences.userRoot().node("FotSelected")
    prefs.putFloat("fontSize", fontSize)
}


fun loadFontSizeV2(): Float {
    val prefs = Preferences.userRoot().node("FotSelected")
    return prefs.getFloat("fontSize", 20.0f) // Default to 20.0f if no font size is found
}
