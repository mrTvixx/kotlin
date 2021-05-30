class Manager: Employee() {
    var numberOfOptions: Int = 0 // Количество опционов на акции
    /**
     * Переопределенный метод для начисления бонусов
     */
    override fun giveBonus(amount: Float){
        // Использование кода функции родительского класса
        super.giveBonus(amount)
        // Опционы на акции: увеличиваем их количество
        numberOfOptions += amount.toInt() * 10
    }
    /**
     * Переопределенный метод вывода информации
     */
    override fun displayStatus(){
        super.displayStatus()
        println("Количество опционов: $numberOfOptions")
    }
}