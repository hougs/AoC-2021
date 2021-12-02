package day02

import java.lang.Exception

fun takeDirection(direction: String, currentPos: Position): Position {
    val splitDir = direction.split(" ")
    when (splitDir[0]) {
        "forward" -> return Position(currentPos.horizontal + splitDir[1].toInt(), currentPos.depth)
        "down" -> return Position(currentPos.horizontal, currentPos.depth + splitDir[1].toInt())
        "up" -> return Position(currentPos.horizontal, currentPos.depth - splitDir[1].toInt())
        else -> throw Exception("Split dir went weird $splitDir")
    }
}

class Position(val horizontal: Int, val depth: Int)

fun main() {
    val startPosition = Position(0,0)
    val directionsIterator = day01.readFileAsLinesUsingGetResourceAsStream("inputday02.txt")
            .readLines().iterator()
    var currentPos = startPosition
    while (directionsIterator.hasNext()) {
        currentPos = takeDirection(directionsIterator.next(), currentPos)
    }
    val depthHorMultiply = currentPos.horizontal * currentPos.depth
    println("The final position is ${currentPos.horizontal}, ${currentPos.depth}")
    println("The the two positions multiplied is $depthHorMultiply")
}