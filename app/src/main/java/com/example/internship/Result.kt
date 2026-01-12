package com.example.internship


class Subject(
    val name: String,
    val maxMarks: Int,
    val minPassingMarks: Int,
    val marksObtained: Int
) {
    fun isPassed(): Boolean {
        return marksObtained >= minPassingMarks
    }
}

class Course(
    val courseName: String,
    val subjects: List<Subject>
)

class Student(
    val name: String,
    val mobile: String,
    val dob: String,
    val address: String,
    val course: Course
) {
    var totalMarks: Int = 0
    var percentage: Double = 0.0
    var result: String = "FAIL"

    fun calculateResult() {
        var totalMaxMarks = 0
        totalMarks = 0

        for (subject in course.subjects) {
            totalMarks += subject.marksObtained
            totalMaxMarks += subject.maxMarks
            if (!subject.isPassed()) {
                result = "FAIL"
                return
            }
        }

        percentage = (totalMarks.toDouble() / totalMaxMarks) * 100
        result = "PASS"
    }

    fun printResult() {
        println("Name: $name")
        println("Course: ${course.courseName}")
        println("Total Marks: $totalMarks")
        println("Percentage: %.2f".format(percentage))
        println("Result: $result")
        println("--------------------------")
    }
}

fun main() {

    val students = ArrayList<Student>()


    val subjects1 = listOf(
        Subject("Maths", 100, 35, 80),
        Subject("Science", 100, 35, 75),
        Subject("English", 100, 35, 70)
    )
    val course1 = Course("BSc", subjects1)
    val s1 = Student("Radhika", "9876543210", "23-06-2003", "Nashik", course1)
    s1.calculateResult()
    students.add(s1)


    val subjects2 = listOf(
        Subject("Maths", 100, 35, 60),
        Subject("Science", 100, 35, 55),
        Subject("English", 100, 35, 65)
    )
    val course2 = Course("BSc", subjects2)
    val s2 = Student("Anjali", "9876543222", "12-04-2002", "Pune", course2)
    s2.calculateResult()
    students.add(s2)


    val subjects3 = listOf(
        Subject("Maths", 100, 35, 90),
        Subject("Science", 100, 35, 85),
        Subject("English", 100, 35, 88)
    )
    val course3 = Course("BSc", subjects3)
    val s3 = Student("Meera", "9876543333", "10-01-2001", "Mumbai", course3)
    s3.calculateResult()
    students.add(s3)

    println("RESULT IN DESCENDING ORDER OF PERCENTAGE")
    students.sortedByDescending { it.percentage }.forEach { it.printResult() }

    println("RESULT IN ASCENDING ORDER OF PERCENTAGE")
    students.sortedBy { it.percentage }.forEach { it.printResult() }

    println("RESULT SORTED ALPHABETICALLY BY NAME")
    students.sortedBy { it.name }.forEach { it.printResult() }
}