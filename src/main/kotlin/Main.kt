fun main() {
    println(equalDigitFrequency(1122, 1122))
    println(equalDigitFrequency(2211, 1221))
}

private fun equalDigitFrequency(first: Int, second: Int): Boolean {
    val frequencyCount1 = first.toString().groupingBy { it }.eachCount()
    val frequencyCount2 = second.toString().groupingBy { it }.eachCount()
    return frequencyCount1 == frequencyCount2
}
