package com.example.internship

class Polynomial(private val coeff: IntArray) {

    fun add(other: Polynomial): Polynomial {
        val maxDegree = maxOf(coeff.size, other.coeff.size)
        val result = IntArray(maxDegree)

        for (i in 0 until maxDegree) {
            val a = if (i < coeff.size) coeff[i] else 0
            val b = if (i < other.coeff.size) other.coeff[i] else 0
            result[i] = a + b
        }
        return Polynomial(result)
    }

    fun multiply(other: Polynomial): Polynomial {
        val result = IntArray(coeff.size + other.coeff.size - 1)

        for (i in coeff.indices) {
            for (j in other.coeff.indices) {
                result[i + j] += coeff[i] * other.coeff[j]
            }
        }
        return Polynomial(result)
    }

    fun printPoly() {
        var first = true
        for (i in coeff.indices.reversed()) {
            if (coeff[i] != 0) {
                if (!first) print(" + ")
                print("${coeff[i]}x^$i")
                first = false
            }
        }
        if (first) print("0")
        println()
    }
}

fun main() {

    val p1 = Polynomial(intArrayOf(1, 2, 3))

    val p2 = Polynomial(intArrayOf(4, 2))

    println("Polynomial 1:")
    p1.printPoly()

    println("Polynomial 2:")
    p2.printPoly()

    println("Addition:")
    p1.add(p2).printPoly()

    println("Multiplication:")
    p1.multiply(p2).printPoly()
}
