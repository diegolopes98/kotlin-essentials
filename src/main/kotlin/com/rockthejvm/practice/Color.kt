package com.rockthejvm.practice

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class Color(red: Int, green: Int, blue: Int) {
    val r = initSingleColor(red)
    val g = initSingleColor(green)
    val b = initSingleColor(blue)

    fun initSingleColor(color: Int) =
        when {
            color < 0 -> 0
            color > 255 -> 255
            else -> color
        }

    fun toInt() = (r shl 16) or (g shl 8) or b

    fun draw(w: Int, h: Int, path: String) {
        val image = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
        val pixels = IntArray(w * h) { toInt() }
        image.setRGB(0, 0, w, h, pixels, 0, w)
        ImageIO.write(image, "JPG", File(path))
    }
}

fun main() {
    Color(0,0,0).draw(100, 100, "src/main/resources/color.jpg")
}