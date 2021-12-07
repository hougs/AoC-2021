package day07

import kotlin.math.abs

fun solve(initPos: List<Int>, distanceType: DistanceFunction): Pair<Int, Int> {
    val gridRange = initPos.minOrNull()!!..initPos.maxOrNull()!!
    val fuelCosts = gridRange.map { gridPt ->
        initPos.map{ pos -> distanceFunc(pos, gridPt, distanceType) }.sum()
    }
    return gridRange.zip(fuelCosts).minByOrNull { it.second}!!
}

fun solveP1(initPos: List<Int>): Pair<Int, Int>  {
    return solve(initPos, DistanceFunction.Euclidean)
}

fun solveP2(initPos: List<Int>): Pair<Int, Int>  {
    return solve(initPos, DistanceFunction.Sum)
}

enum class DistanceFunction { Euclidean, Sum}

fun distanceFunc(x: Int, y: Int, distanceType: DistanceFunction): Int {
    val dist = when (distanceType) {
        DistanceFunction.Euclidean -> abs(x - y)
        DistanceFunction.Sum -> abs(x - y)*(abs(x - y) + 1)/2
    }
    return dist
}

fun setupInput(): List<Int> {
    val input = day01.readFileAsLinesUsingGetResourceAsStream("inputday07.txt").readLines()
    return input[0].split(",").map { x: String -> x.toInt() }
}

fun main() {
    val inputPos = setupInput()
    val (position, fuelCost) = solveP1(inputPos)
    println("P1 position is : " + position)
    println("P1 fuel cost is : " + fuelCost)

    val (position2, fuelCost2) = solveP2(inputPos)
    println("P2 position is : " + position2)
    println("P2 fuel cost is : " + fuelCost2)
}
