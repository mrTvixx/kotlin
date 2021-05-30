class TelephoneСall(
    val date: String,
    val code: Int,
    val city: String,
    val time: Int,
    val tariff: String,
    val number: Number,
) {
    fun displayStatus(){
        println("")
        println("Дата и время звонка: $date - $time")
        println("Место звонка: $city $code")
        println("Номер и тариф: $number $tariff")
    }

    fun getTotalPrice(): Int {
        // Classic 2/min
        return time * 2
    }

    override fun toString(): String {
        return "Город: $city Номер: $number"
    }
}