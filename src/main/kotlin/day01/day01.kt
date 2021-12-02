package day01

fun readFileAsLinesUsingGetResourceAsStream(fileName: String)
        = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName).bufferedReader()
fun isGreaterThan(x: Int): Int =  when {
    x > 0 -> 1
    x < 0 -> 0
    else -> 0
}
fun countIncreases(readings: List<Int>): Int {
    return readings.zipWithNext { left: Int, right: Int ->
    isGreaterThan(right - left) }.sum()
}

fun slidingWindowSum(readings: List<Int>, windowSize: Int): List<Int> {
    return readings.windowed(windowSize).map { x -> x.sum() }
}

fun main() {
    val numbers = readFileAsLinesUsingGetResourceAsStream("inputday01.txt")
            .readLines()
            .map(String::toInt)
    val nIncreases = countIncreases(numbers)
    val nThreeSumIncreases = countIncreases(slidingWindowSum(numbers, 3))
    println("The number of pairwise increases is $nIncreases")
    println("The number of triple sum increases is $nThreeSumIncreases")
}