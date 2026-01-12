package com.example.internship

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class MyDate(val day: Int, val month: Int, val year: Int) {

    private val date: LocalDate = LocalDate.of(year, month, day)

    fun daysBetween(other: MyDate): Long {
        return ChronoUnit.DAYS.between(this.date, other.date)
    }

    fun addDays(days: Long): MyDate {
        val newDate = date.plusDays(days)
        return MyDate(newDate.dayOfMonth, newDate.monthValue, newDate.year)
    }

    fun subtractDays(days: Long): MyDate {
        val newDate = date.minusDays(days)
        return MyDate(newDate.dayOfMonth, newDate.monthValue, newDate.year)
    }

    fun compare(other: MyDate): Int {
        return this.date.compareTo(other.date)
    }

    fun printDate() {
        println("$day-$month-$year")
    }

    fun getLocalDate(): LocalDate {
        return date
    }
}

fun main() {

    val d1 = MyDate(10, 1, 2024)
    val d2 = MyDate(25, 1, 2024)

    println("Date 1:")
    d1.printDate()

    println("Date 2:")
    d2.printDate()

    println("Days between dates: ${d1.daysBetween(d2)}")

    println("Add 10 days to Date 1:")
    d1.addDays(10).printDate()

    println("Subtract 5 days from Date 2:")
    d2.subtractDays(5).printDate()

    val cmp = d1.compare(d2)
    when {
        cmp == 0 -> println("Both dates are equal")
        cmp < 0 -> println("Date 1 is before Date 2")
        else -> println("Date 1 is after Date 2")
    }

    val dateList = arrayListOf(d1, d2, MyDate(5, 1, 2024), MyDate(20, 2, 2024))

    println("\nDates in Ascending Order:")
    dateList.sortedBy { it.getLocalDate() }.forEach { it.printDate() }

    println("\nDates in Descending Order:")
    dateList.sortedByDescending { it.getLocalDate() }.forEach { it.printDate() }
}
