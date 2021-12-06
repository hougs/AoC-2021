package day06

import day05.Line

class LanternFishPopulation(val populationTracker: HashMap<Int, Long> = HashMap<Int, Long>()) {

     fun addFish(timer: Int) {
         populationTracker.put(timer, populationTracker.getOrDefault(timer, 0) + 1)
     }
}

fun advanceOneDay(populationTracker: HashMap<Int, Long>): LanternFishPopulation {
    val nextPop = HashMap<Int, Long>()
    for ((timer, count) in populationTracker.toSortedMap()) {
        if (timer == 0) {
            nextPop.put(8, count)
            nextPop.put(6, nextPop.getOrDefault(6, 0) + count)
        } else {
            if (timer == 7) {
                nextPop.put(6, nextPop.getOrDefault(6, 0) + count)
            } else {
                nextPop.put(timer -1, count)
            }

        }
    }

    return LanternFishPopulation(nextPop)
}

fun countFish(populationTracker: HashMap<Int, Long>): Long {
    return populationTracker.values.sum()
}

fun setupInput(): List<Int> {
    val input = day01.readFileAsLinesUsingGetResourceAsStream("inputday06.txt").readLines()
    return input[0].split(",").map { x: String -> x.toInt() }
}

fun solveP1(initialFishPop: List<Int>, nDays: Int): Long {
    // initialize fish population
    var fishPop = LanternFishPopulation()
    for (fish in initialFishPop) {
        fishPop.addFish(fish)
    }
    repeat (nDays) {
        fishPop = advanceOneDay(fishPop.populationTracker)
    }
    return countFish(fishPop.populationTracker)
}

fun main() {
    val initialFishPop  = setupInput()
    println("Final fish pop after 80 days is " + solveP1(initialFishPop, 80))
    println("Final fish pop after 256 days is " + solveP1(initialFishPop, 256))
}