// Класс "Сотрудник"
open class Employee {
    // Поля класса
    var empId = 0 // Идентификатор
    var fullName = "" // Имя Фамилия
    var currPay = 0f // Зар. плата
    // Методы класса
    /**
     * Переопределяемый метод для начисления бонусов
     */
    open fun giveBonus(amount: Float){
        currPay += amount
    }
    /**
     * Переопределяемый метод вывода информации
     */
    open fun displayStatus(){
        println("Код: $empId")
        println("ФИО: $fullName")
        println("Зарплата: $currPay")
    }
}