package com.example.internship

import kotlin.math.sqrt
import kotlin.math.pow

class Point2D(var x: Double, var y: Double) {

    fun distance(other: Point2D): Double {
        return sqrt(
            (other.x - x).pow(2.0) +
                    (other.y - y).pow(2.0)
        )
    }
}

fun main() {
    val p1 = Point2D(3.0, 4.0)
    val p2 = Point2D(6.0, 8.0)

    val dist = p1.distance(p2)

    println("Distance between points = $dist")
}
