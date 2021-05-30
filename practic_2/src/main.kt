fun deleteByCity(list: MutableList<TelephoneСall>, city: String): List<TelephoneСall> {
    return list.filter { it.city != city }
}

fun sortByCity(list: MutableList<TelephoneСall>): List<TelephoneСall> {
    return list.sortedBy { it.city }
}

fun listAll(list: MutableList<TelephoneСall>) {
    list.forEach{ println(it)}
}

fun getTotalTimeAndSumByCity(list: MutableList<TelephoneСall>, city: String) {
    var totalTime = 0
    var totalSum = 0

    list.filter { it.city == city }.forEach { item: TelephoneСall ->
        totalSum += item.getTotalPrice()
        totalTime += item.time
    }

    println("Total time: $totalTime on $totalSum ue")
}

fun main() {
    val students: MutableList<Student> = mutableListOf<Student>()
    students.add(Student("Акинина Ольга", "331"))
    students.add(Student("Викулов Михаил", "331"))
    students.add(Student("Анисимова Наталья", "321"))
    students.add(Student("Квасов Виктор", "321"))
    students.add(Student("Илларионов Евнений", "334"))
    students.add(Student("Кузнецова Татьяна", "334"))
    students.forEach{ println(it)}

    println("Filtered list:")
    students.filter{ it.group == "321" }.forEach { println(it) }

    println("Sorted list:")
    students.sortBy{ it.fullName }
    students.forEach { println(it) }

    // Calls
    var calls: MutableList<TelephoneСall> = mutableListOf<TelephoneСall>()
    calls.add(TelephoneСall("30.05.20201", 321123, "Taganrog", 10, "Classic", 111111111))
    calls.add(TelephoneСall("12.05.20201", 3213, "Rostov", 23, "Classic", 3333333333))
    calls.add(TelephoneСall("23.05.20201", 321123, "Taganrog", 12, "Classic", 222222222))
    calls.add(TelephoneСall("30.05.20201", 321123, "Rostov", 50, "Classic", 4444444444))

    listAll(calls)
    sortByCity(calls)
    calls = deleteByCity(calls, "Taganrog") as MutableList<TelephoneСall>
    println("After delete")
    listAll(calls)
    getTotalTimeAndSumByCity(calls, "Rostov")
}