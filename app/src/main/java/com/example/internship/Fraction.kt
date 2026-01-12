package com.example.internship

class Fraction(private var numerator: Int, private var denominator: Int) {

    init {
        if (denominator == 0) {
            throw IllegalArgumentException("Denominator cannot be zero")
        }
        simplify()
    }

    fun add(other: Fraction): Fraction {
        val num = numerator * other.denominator + other.numerator * denominator
        val den = denominator * other.denominator
        return Fraction(num, den)
    }

    fun subtract(other: Fraction): Fraction {
        val num = numerator * other.denominator - other.numerator * denominator
        val den = denominator * other.denominator
        return Fraction(num, den)
    }

    fun multiply(other: Fraction): Fraction {
        val num = numerator * other.numerator
        val den = denominator * other.denominator
        return Fraction(num, den)
    }

    fun divide(other: Fraction): Fraction {
        val num = numerator * other.denominator
        val den = denominator * other.numerator
        return Fraction(num, den)
    }

    fun inverse(): Fraction {
        return Fraction(denominator, numerator)
    }

    private fun simplify() {
        val gcd = gcd(Math.abs(numerator), Math.abs(denominator))
        numerator /= gcd
        denominator /= gcd
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun printFraction() {
        println("$numerator/$denominator")
    }
}

fun main() {
    val f1 = Fraction(2, 3)
    val f2 = Fraction(4, 5)

    println("Fraction 1:")
    f1.printFraction()

    println("Fraction 2:")
    f2.printFraction()

    println("Addition:")
    f1.add(f2).printFraction()

    println("Subtraction:")
    f1.subtract(f2).printFraction()

    println("Multiplication:")
    f1.multiply(f2).printFraction()

    println("Division:")
    f1.divide(f2).printFraction()

    println("Inverse of Fraction 1:")
    f1.inverse().printFraction()
}
