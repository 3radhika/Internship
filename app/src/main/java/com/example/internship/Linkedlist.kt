package com.example.internship

class Node(var data: Int) {
    var next: Node? = null
}

class LinkedList {

    private var head: Node? = null

    fun addAtStart(value: Int) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
    }

    fun addAtEnd(value: Int) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            return
        }
        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.next = newNode
    }

    fun addAtPosition(value: Int, position: Int) {
        if (position == 0) {
            addAtStart(value)
            return
        }

        val newNode = Node(value)
        var temp = head
        var index = 0

        while (temp != null && index < position - 1) {
            temp = temp.next
            index++
        }

        if (temp == null) {
            println("Invalid position")
            return
        }

        newNode.next = temp.next
        temp.next = newNode
    }


    fun removeFirst() {
        if (head == null) {
            println("List is empty")
            return
        }
        head = head?.next
    }

    fun removeLast() {
        if (head == null) {
            println("List is empty")
            return
        }

        if (head?.next == null) {
            head = null
            return
        }

        var temp = head
        while (temp?.next?.next != null) {
            temp = temp.next
        }
        temp?.next = null
    }

    fun removeAtPosition(position: Int) {
        if (head == null) {
            println("List is empty")
            return
        }

        if (position == 0) {
            removeFirst()
            return
        }

        var temp = head
        var index = 0

        while (temp?.next != null && index < position - 1) {
            temp = temp.next
            index++
        }

        if (temp?.next == null) {
            println("Invalid position")
            return
        }

        temp.next = temp.next?.next
    }
    fun display() {
        if (head == null) {
            println("List is empty")
            return
        }

        var temp = head
        while (temp != null) {
            print("${temp.data} -> ")
            temp = temp.next
        }
        println("null")
    }
}

fun main() {
    val list = LinkedList()

    list.addAtStart(10)
    list.addAtStart(5)
    list.addAtEnd(20)
    list.addAtEnd(30)
    list.addAtPosition(15, 2)

    println("Linked List:")
    list.display()

    list.removeFirst()
    println("After removing first:")
    list.display()

    list.removeLast()
    println("After removing last:")
    list.display()

    list.removeAtPosition(1)
    println("After removing at position 1:")
    list.display()
}
