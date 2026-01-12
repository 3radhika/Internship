package com.example.internship

class Queue(private val size: Int) {

    private val queue = IntArray(size)
    private var front = 0
    private var rear = -1
    private var count = 0


    fun enqueue(value: Int) {
        if (count == size) {
            println("Queue Overflow")
        } else {
            rear = (rear + 1) % size
            queue[rear] = value
            count++
            println("$value inserted into queue")
        }
    }


    fun dequeue() {
        if (count == 0) {
            println("Queue Underflow")
        } else {
            println("${queue[front]} removed from queue")
            front = (front + 1) % size
            count--
        }
    }


    fun peek() {
        if (count == 0) {
            println("Queue is empty")
        } else {
            println("Front element is ${queue[front]}")
        }
    }


    fun display() {
        if (count == 0) {
            println("Queue is empty")
        } else {
            println("Queue elements:")
            for (i in 0 until count) {
                println(queue[(front + i) % size])
            }
        }
    }
}

fun main() {
    val queue = Queue(5)

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    queue.display()

    queue.dequeue()
    queue.peek()

    queue.display()
}