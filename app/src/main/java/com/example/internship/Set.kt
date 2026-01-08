package com.example.internship

class MySet {
    private val elements = ArrayList<Int>()

    fun addElement(value: Int) {
        if (!elements.contains(value)) {
            elements.add(value)
        }
    }

    fun concatenate(other: MySet): MySet {
        val result = MySet()
        result.elements.addAll(this.elements)
        result.elements.addAll(other.elements)
        return result
    }

    fun merge(other: MySet): MySet {
        val result = MySet()
        for (e in this.elements) result.addElement(e)
        for (e in other.elements) result.addElement(e)
        return result
    }

    fun union(other: MySet): MySet {
        return merge(other)
    }

    fun intersection(other: MySet): MySet {
        val result = MySet()
        for (e in elements) {
            if (other.elements.contains(e)) {
                result.addElement(e)
            }
        }
        return result
    }

    fun search(value: Int): Boolean {
        return elements.contains(value)
    }

    fun sortSet() {
        elements.sort()
    }

    fun printSet() {
        print("{ ")
        for (e in elements) {
            print("$e ")
        }
        println("}")
    }
}

fun main() {
    val set1 = MySet()
    set1.addElement(5)
    set1.addElement(3)
    set1.addElement(1)

    val set2 = MySet()
    set2.addElement(3)
    set2.addElement(4)
    set2.addElement(6)

    println("Set 1:")
    set1.printSet()

    println("Set 2:")
    set2.printSet()

    println("Concatenation:")
    set1.concatenate(set2).printSet()

    println("Merge:")
    set1.merge(set2).printSet()

    println("Union:")
    set1.union(set2).printSet()

    println("Intersection:")
    set1.intersection(set2).printSet()

    println("Search 3 in Set1: ${set1.search(3)}")

    println("Sorted Set1:")
    set1.sortSet()
    set1.printSet()
}
