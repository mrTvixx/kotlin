class TelephoneСall(
    private val date: String,
    private val code: Number,
    private val city: String,
    private val time: String,
    private  val tariff: String,
    private val number: Number,
) {
    fun displayStatus(){
        println("")
        println("Дата и время звонка: $date - $time")
        println("Место звонка: $city $code")
        println("Номер и тариф: $number $tariff")
    }
}