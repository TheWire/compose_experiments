package com.thewire.compose_experiments.presentation.ui.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.thewire.compose_experiments.R
import kotlin.math.tan

@Composable
fun Screen11() {
    drawArea()
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
@Composable
fun drawPlantPot() {

}


@Composable
fun PlantPotFillable(
    height: Float = 300f,
    width: Float = 200f,
    yOffset: Float = 0f,
    xOffset: Float = 0f,
    angle: Double = 102.0,
    percent: Int = 100,
) {
    val adj1 =  (height / tan(Math.toRadians(180.0 - angle))).toFloat()
    val startX = xOffset
    val startY = yOffset
    val outLinePath = Path().apply {
        moveTo(xOffset, yOffset)
        lineTo(startX + adj1, startY + height)
        lineTo(startX + adj1 + width, startY + height)
        lineTo(startX + width + (adj1 * 2), startY)
    }
    val fillHeight = height * percent / 100f
    val adj2 =  (fillHeight / tan(Math.toRadians(180.0 - angle))).toFloat()
    val startFillX = xOffset + (adj1 - adj2)
    val startFillY = xOffset + (height - fillHeight)
    val fillPath = Path().apply {
        moveTo(startFillX, startFillY)
        lineTo(startFillX + adj2, startFillY + fillHeight)
        lineTo(startFillX + adj2 + width, startFillY + fillHeight)
        lineTo(startFillX + width + (adj2 * 2), startFillY)
        close()
    }
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawPath(path = fillPath, color = Color(0xffd4f1f9))
        drawPath(
            path = outLinePath,
            color = Color(0xff6b3430),
            style = Stroke(width = 20f, cap = StrokeCap.Round)
        )
    }
}

//class TestShape : Shape {
//    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
//        val path = Path().apply {
//            moveTo(0f, 0f)
//            lineTo(0f, size.height)
//            lineTo(size.width, size.height)
//            lineTo(size.width, size.height)
//            close()
//        }
//        return Outline.Generic(path)
//    }
//
//    override fun draw(p0: Canvas?, p1: Paint?) {
//        TODO("Not yet implemented")
//    }
//}

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
//class Sh : Shape() {
//
//    override fun draw(canvas: Canvas?, paint: Paint?) {
//        if(canvas == null || paint == null) return
//        val path = Path().apply {
//            val width: Float = canvas.width
//            moveTo(0f, 0f)
//            lineTo(0f, size.height)
//            lineTo(canvas., size.height)
//            lineTo(size.width, size.height)
//            close()
//        }
//        p0?.let {
//            it.drawPath(this.createOutline(Size(100f, 100f), LayoutDirection.Ltr, Density.Default), p1)
//        }
//    }
//
//}

@Preview
@Composable
fun previewScreen11() {
//    drawPlantPot()
Box(
    modifier = Modifier.fillMaxSize()
        .background(Color.White),
) {
    Image(
        modifier = Modifier
            .clip(MyGenericShape())
            .size(200.dp)
            .background(Color.Cyan),
        painter = painterResource(R.drawable.soil),
        contentDescription = "Soil",
        alpha = 0.5f,
    )
}

//    drawArea()
}