package com.example.internship

class Stack(private val size: Int) {

    private val stack = IntArray(size)
    private var top = -1


    fun push(value: Int) {
        if (top == size - 1) {
            println("Stack Overflow")
        } else {
            stack[++top] = value
            println("$value pushed into stack")
        }
    }


    fun pop() {
        if (top == -1) {
            println("Stack Underflow")
        } else {
            println("${stack[top--]} popped from stack")
        }
    }


    fun peek() {
        if (top == -1) {
            println("Stack is empty")
        } else {
            println("Top element is ${stack[top]}")
        }
    }


    fun display() {
        if (top == -1) {
            println("Stack is empty")
        } else {
            println("Stack elements:")
            for (i in top downTo 0) {
                println(stack[i])
            }
        }
    }
}

fun main() {
    val stack = Stack(5)

    stack.push(10)
    stack.push(20)
    stack.push(30)

    stack.display()

    stack.pop()
    stack.peek()

    stack.display()
}