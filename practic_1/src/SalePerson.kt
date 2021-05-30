class SalePerson: Employee() {
    var numberOfSales = 0 // Объем продаж
    /**
     * Переопределенный метод для начисления бонусов
     */
    override fun giveBonus(amount: Float){
        val salesBonus = when(numberOfSales){
            in 0..100 -> 10F
            in 101..200 -> 15F
            else -> 20F
        }
        // Использование кода функции родительского класса
        super.giveBonus(amount * salesBonus)
    }
    /**
     * Переопределенный метод вывода информации
     */
    override fun displayStatus(){
        super.displayStatus()
        println("Объем продаж: $numberOfSales")
    }
}