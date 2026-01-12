package com.example.internship

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Scanner


class Transaction(
    val transactionId: Int,
    val type: String,
    val amount: Double,
    val dateTime: String
)

class Account(
    val accountNumber: Int,
    val name: String,
    val accountType: String
) {
    var balance: Double = 0.0
    val transactions = ArrayList<Transaction>()

    fun deposit(amount: Double, txnId: Int) {
        balance += amount
        addTransaction(txnId, "Deposit", amount)
    }

    fun withdraw(amount: Double, txnId: Int) {
        if (amount > balance) {
            println("Insufficient balance")
            return
        }
        balance -= amount
        addTransaction(txnId, "Withdraw", amount)
    }

    private fun addTransaction(txnId: Int, type: String, amount: Double) {
        val dt = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        transactions.add(Transaction(txnId, type, amount, dt.format(formatter)))
    }

    fun printAccountDetails() {
        println("\nAccount Number: $accountNumber")
        println("Name: $name")
        println("Account Type: $accountType")
        println("Balance: $balance")
        println("Transactions:")
        if (transactions.isEmpty()) {
            println("No transactions")
        } else {
            for (t in transactions) {
                println("${t.transactionId} | ${t.type} | ${t.amount} | ${t.dateTime}")
            }
        }
    }
}

class Bank {
    private val accounts = ArrayList<Account>()
    private var lastAccountNumber = 1000
    private var lastTransactionId = 1

    fun openAccount(name: String, type: String) {
        lastAccountNumber++
        val acc = Account(lastAccountNumber, name, type)
        accounts.add(acc)
        println("Account created successfully. Account No: $lastAccountNumber")
    }

    fun deposit(accNo: Int, amount: Double) {
        val acc = searchByAccountNo(accNo)
        if (acc != null) {
            acc.deposit(amount, lastTransactionId++)
            println("Amount deposited successfully")
        } else {
            println("Account not found")
        }
    }

    fun withdraw(accNo: Int, amount: Double) {
        val acc = searchByAccountNo(accNo)
        if (acc != null) {
            acc.withdraw(amount, lastTransactionId++)
        } else {
            println("Account not found")
        }
    }

    fun searchByAccountNo(accNo: Int): Account? {
        return accounts.find { it.accountNumber == accNo }
    }

    fun searchByName(name: String) {
        val result = accounts.filter { it.name.equals(name, true) }
        if (result.isEmpty()) {
            println("No account found")
        } else {
            for (acc in result) acc.printAccountDetails()
        }
    }

    fun closeAccount(accNo: Int) {
        val acc = searchByAccountNo(accNo)
        if (acc != null) {
            accounts.remove(acc)
            println("Account closed successfully")
        } else {
            println("Account not found")
        }
    }
}

fun main() {
    val bank = Bank()
    val sc = Scanner(System.`in`)

    while (true) {
        println("\n----- Banking Application Menu -----")
        println("1. Open New Account")
        println("2. Deposit Amount")
        println("3. Withdraw Amount")
        println("4. Search Account by Account No")
        println("5. Search Account by Name")
        println("6. Close Account")
        println("0. Exit")
        print("Enter choice: ")

        when (sc.nextInt()) {
            1 -> {
                print("Enter Name: ")
                sc.nextLine()
                val name = sc.nextLine()
                print("Enter Account Type (Saving/Current): ")
                val type = sc.nextLine()
                bank.openAccount(name, type)
            }
            2 -> {
                print("Enter Account No: ")
                val accNo = sc.nextInt()
                print("Enter Amount: ")
                val amt = sc.nextDouble()
                bank.deposit(accNo, amt)
            }
            3 -> {
                print("Enter Account No: ")
                val accNo = sc.nextInt()
                print("Enter Amount: ")
                val amt = sc.nextDouble()
                bank.withdraw(accNo, amt)
            }
            4 -> {
                print("Enter Account No: ")
                val accNo = sc.nextInt()
                val acc = bank.searchByAccountNo(accNo)
                if (acc != null) acc.printAccountDetails() else println("Account not found")
            }
            5 -> {
                print("Enter Name: ")
                sc.nextLine()
                val name = sc.nextLine()
                bank.searchByName(name)
            }
            6 -> {
                print("Enter Account No: ")
                val accNo = sc.nextInt()
                bank.closeAccount(accNo)
            }
            0 -> {
                println("Exiting application...")
                break
            }
            else -> println("Invalid choice")
        }
    }
}
