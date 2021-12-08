package day08plus

fun solveP1(inputString: List<String>): Int {
    val inAndOutChars = inputString.map{ x -> x.split(" | ", " ")}
    val outPut = inAndOutChars.map{it.subList(10, 14)}
    val filtered = outPut.map { it.filter { x -> listOf(2, 4, 3, 7).contains(x.length) }}
    return filtered.fold(0){acc, line -> line.size + acc}
}

fun deduceIntRepresentation(input: List<String>, output: List<String>): HashMap<String, Set<Char>> {
    val intMapping = HashMap<String, Set<Char>>()
    // find definites
    val allVals = input + output
    allVals.map {
        when {
            it.length == 2 -> intMapping.set("1", it.toSet())
            it.length == 3 -> intMapping.set("7", it.toSet())
            it.length == 4 -> intMapping.set("4", it.toSet())
            it.length == 7 -> intMapping.set("8", it.toSet())
        }
    }
    allVals.map {
        val setRepr = it.toSet()
        when {
            (it.length == 6 && setRepr.containsAll(intMapping.get("4")!!)) -> intMapping.set("9", it.toSet())
            (it.length == 6 && setRepr.containsAll(intMapping.get("1")!!)) -> intMapping.set("0", it.toSet())
            (it.length == 6) -> intMapping.set("6", it.toSet())
            (it.length == 5 && setRepr.containsAll(intMapping.get("1")!!)) -> intMapping.set("3", it.toSet())
            (it.length == 5 && setRepr.containsAll(intMapping.get("8")!!.subtract(intMapping.get("4")!!))) -> intMapping.set("2", it.toSet())
            (it.length == 5) -> intMapping.set("5", it.toSet())
        }
    }
    return intMapping
}


fun reprSingleLine(inputScrambled: List<String>, outputScrambled: List<String>): Int {
    val intRep = deduceIntRepresentation(inputScrambled, outputScrambled)
    val reversed = intRep.entries.associateBy({ it.value }) { it.key }
    val digit = outputScrambled.fold(""){acc, next ->
        acc + reversed.getOrDefault(next.toSet(), "X")
    }.toInt()
    return digit
}

fun solveP2(inputString: List<String>): Int {
    val inAndOutChars: List<List<String>> = inputString.map{ x -> x.split(" | ", " ")}
    return inAndOutChars.map { reprSingleLine(it.subList(0, it.size - 4), it.subList(it.size - 4, it.size)) }.sum()
}

fun main() {
    val input = ClassLoader.getSystemClassLoader().getResourceAsStream("inputday08.txt").bufferedReader().readLines()
    println("P1 solution is: " + solveP1(input))
    println("P2 solution is: " + solveP2(input))

}
