package day03


fun computePowerConsumption(diagnostics: List<String>): Int {
    var epsBits = ""
    var gammaBits = ""
    val listLen = diagnostics.size
    for (i in diagnostics[0].indices) {
        val nZeros = diagnostics.count{it[i] == '0'}
        val nOnes = listLen - nZeros
        if (nZeros < nOnes) {
            gammaBits += '1'
            epsBits += '0'
        } else {
            gammaBits += '0'
            epsBits += '1'
        }
    }
    val gamma = gammaBits.toInt(2)
    val epsilon = epsBits.toInt(2)
    return gamma * epsilon
}


fun main() {
    val diagnostics = day01.readFileAsLinesUsingGetResourceAsStream("inputday03.txt")
    val ans1 = computePowerConsumption(diagnostics.readLines())
    println("Power consumption $ans1")
}