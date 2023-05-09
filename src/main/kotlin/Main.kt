fun main() {
    val cardType = "Maestro"
    val alreadyPayAmmount = 3500
    val payAmmount = 1500
    println(commisionAmount(cardType,alreadyPayAmmount,payAmmount))
}

fun commisionAmount(cardType: String = "VK Pay", alreadyPayAmount: Int = 0 , payAmount : Int) : Double{
    val mirVisaComission = 0.0075 // процент комиссии для карт мир и виза
    val mirVisaMinComision = 35.0 // минимальный размер комиссии для карт мир и виза
    val masterMaestroComision = 0.006 //  процент комиссии ля мастеркард и маестро
    val masterMaestroAdditionalComision = 20.0 // постоянная надавка к комиссии для карт маестро и мастеркард
    return when {
        cardType in arrayOf("Mastercard","Maestro") && alreadyPayAmount > 75_000 -> payAmount * masterMaestroComision + masterMaestroAdditionalComision
        cardType in arrayOf("Visa","Мир") -> if (payAmount * mirVisaComission < mirVisaMinComision) mirVisaMinComision else payAmount * mirVisaComission
        else -> 0.0
    }
}