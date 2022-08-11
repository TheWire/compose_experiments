package com.thewire.compose_experiments.presentation.ui.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thewire.compose_experiments.R
import kotlin.math.atan
import kotlin.math.tan

@Composable
fun Screen11() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        PlantPotFillable(
            modifier = Modifier
                .size(400.dp)
                .background(color = Color.Gray)
                .align(Alignment.Center),
            fillPainter = painterResource(R.drawable.soil),
            percent = 50,
            text = {
                Text(
                    text = "50%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            },
        )
    }
}

@Composable
fun drawArea() {
    Canvas(
        modifier = Modifier
            .size(250.dp)
            .background(Color.White)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, 100f)
            lineTo(100f, 100f)
            lineTo(100f, 0f)
            lineTo(0f, 0f)
            close()
        }
//        drawLine(
//            start = Offset(0f, 0f),
//            end = Offset(0f, 0f),
//            brush = Brush.horizontalGradient(listOf(Color.Red, Color.Red)
//        )

//        drawCircle(
//            brush = Brush.verticalGradient(
//                colors = listOf(
//                    Color(0xFF00FF00),
//                    Color(0xFF0000FF)
//                ),
//            ),
//            radius = width.times(.17f),
//            center = Offset(width.times(.35f), height.times(.35f))
//        )
    }
}




fun MySquare(): GenericShape {
    val g = GenericShape { size, _ ->
            moveTo(0f, 0f)
            lineTo(0f, size.height)
            lineTo(size.width, size.height)
            lineTo(size.width, size.height)
        }
    return g
}

fun MyGenericShape(): GenericShape {
    val g = GenericShape { size, _ ->
            moveTo(0f, 0f)
            lineTo(0f, size.height)
            lineTo(size.width + 50f, size.height + 50f)
            lineTo(size.width + 50f, size.height + 200f)
    }
    return g
}

@Composable
fun PlantPotFillable(
    modifier: Modifier = Modifier,
    bottomRatio: Float = 0.85f,
    percent: Int = 100,
    outlineColor: Color = Color(0xff6b3430),
    outlineThickness: Float = 20f,
    fillColor: Color = Color(0xff1ca3ec),
    fillPainter: Painter? = null,
    text: @Composable() (BoxScope.()-> Unit)? = null
) {
//    val adj1 =  (height / tan(Math.toRadians(180.0 - angle))).toFloat()
    Box(modifier = modifier) {
        fillPainter?.let { painter ->
            Image(
                modifier = Modifier
                    .clip(Pot(bottomRatio = bottomRatio))
                    .background(Color.Magenta),
                painter = painter,
                contentScale = ContentScale.FillBounds,
                contentDescription = "Pot",
            )
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeOffset = outlineThickness / 2f
            val fillHeight = size.height - strokeOffset
            val adj = (fillHeight - (fillHeight * bottomRatio)) / 2f
            val angle = atan((fillHeight / adj).toDouble())
            val heightDiff = fillHeight - (fillHeight * (percent / 100f))
            val widthDiff = (heightDiff / tan(angle)).toFloat()
            val fillYOffset = size.height * ((100 - percent) / 100f)
            val fillXOffset = 0f
            val fillShape = getPotPath(
                height = fillHeight * (percent / 100f),
                topWidth = size.width - (widthDiff * 2),
                bottomWidth = size.width * bottomRatio,
                xOffset = fillXOffset + widthDiff,
                yOffset = fillYOffset
            )
            drawPath(
                path = fillShape,
                color = fillColor,
                alpha = 0.5f,
            )
            val outLinePath = getPotPath(
                height = size.height - strokeOffset,
                topWidth = size.width - outlineThickness,
                bottomWidth = (size.width * bottomRatio) - outlineThickness,
                yOffset = 0f,
                xOffset = strokeOffset,
                closed = false
            )
            drawPath(
                path = outLinePath,
                color = outlineColor,
                style = Stroke(width = outlineThickness, cap = StrokeCap.Butt)
            )
        }
        text?.let { it() }
    }
}

class Pot(
    val yOffset: Float = 0f,
    val xOffset: Float = 0f,
    val bottomRatio: Float = 0.85f,
): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        size.height
//        val adj1 =  (size.height / tan(Math.toRadians(180.0 - angle))).toFloat()
        val startX = xOffset
        val startY = yOffset
        val path = getPotPath(
            height = size.height,
            topWidth = size.width,
            bottomWidth = size.width * bottomRatio,
            yOffset = yOffset,
            xOffset = xOffset,
        )
        return Outline.Generic(path)
    }
}

fun getPotPath(
    height: Float = 300f,
    topWidth: Float = 200f,
    bottomWidth: Float = 150f,
    yOffset: Float = 0f,
    xOffset: Float = 0f,
    closed: Boolean = true
): Path {
    val adj = (topWidth - bottomWidth) / 2f
    val startX = xOffset
    val startY = yOffset
    val path = Path().apply {
        moveTo(xOffset, yOffset)
        lineTo(startX + adj, startY + height)
        lineTo(startX + adj + bottomWidth, startY + height)
        lineTo(startX + topWidth, startY)
        if (closed) {
            close()
        }
    }
    return path
}

@Preview
@Composable
fun previewScreen11() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        PlantPotFillable(
            modifier = Modifier
                .size(400.dp)
                .background(color = Color.Gray)
                .align(Alignment.Center),
            fillPainter = painterResource(R.drawable.soil),
            percent = 50,
            text = {
                Text(
                    text = "50%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            },
        )
//        Row( modifier = Modifier
//            .align(Alignment.Center)
//        ) {
//            PlantPotFillable(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(color = Color.Gray),
//                fillPainter = painterResource(R.drawable.soil),
//                percent = 100,
//                text = {
//                    Text(
//                        text = "100%",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                    )
//                },
//            )
//            PlantPotFillable(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(color = Color.Gray),
//                fillPainter = painterResource(R.drawable.soil),
//                percent = 80,
//                text = {
//                    Text(
//                        text = "80%",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                    )
//                },
//            )
//            PlantPotFillable(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(color = Color.Gray),
//                fillPainter = painterResource(R.drawable.soil),
//                percent = 80,
//                text = {
//                    Text(
//                        text = "80%",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                    )
//                },
//            )
//        }
    }

}