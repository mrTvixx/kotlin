class Student(var fullName: String, var group: String) {
    override fun toString(): String {
        return "$fullName группа $group"
    }
}