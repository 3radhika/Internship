package com.example.internship

class Matrix(private val rows: Int, private val cols: Int) {

    private val data = Array(rows) { IntArray(cols) }

    fun setElement(row: Int, col: Int, value: Int) {
        data[row][col] = value
    }

    fun printMatrix() {
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                print("${data[i][j]} ")
            }
            println()
        }
    }

    fun add(other: Matrix): Matrix {
        val result = Matrix(rows, cols)
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                result.data[i][j] = this.data[i][j] + other.data[i][j]
            }
        }
        return result
    }


    fun multiply(other: Matrix): Matrix {
        val result = Matrix(rows, other.cols)
        for (i in 0 until rows) {
            for (j in 0 until other.cols) {
                for (k in 0 until cols) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j]
                }
            }
        }
        return result
    }

    fun transpose(): Matrix {
        val result = Matrix(cols, rows)
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                result.data[j][i] = data[i][j]
            }
        }
        return result
    }
}

fun main() {
    val m1 = Matrix(2, 2)
    val m2 = Matrix(2, 2)

    m1.setElement(0, 0, 1)
    m1.setElement(0, 1, 2)
    m1.setElement(1, 0, 3)
    m1.setElement(1, 1, 4)

    m2.setElement(0, 0, 5)
    m2.setElement(0, 1, 6)
    m2.setElement(1, 0, 7)
    m2.setElement(1, 1, 8)

    println("Matrix 1:")
    m1.printMatrix()

    println("\nMatrix 2:")
    m2.printMatrix()

    println("\nAddition:")
    m1.add(m2).printMatrix()

    println("\nMultiplication:")
    m1.multiply(m2).printMatrix()

    println("\nTranspose of Matrix 1:")
    m1.transpose().printMatrix()
}
