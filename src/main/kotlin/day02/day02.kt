package day02

import java.lang.Exception

fun takeDirection(direction: String, currentPos: Position): Position {
    val splitDir = direction.split(" ")
    when (splitDir[0]) {
        "forward" -> return Position(currentPos.horizontal + splitDir[1].toInt(), currentPos.depth, currentPos.aim)
        "down" -> return Position(currentPos.horizontal, currentPos.depth + splitDir[1].toInt(), currentPos.aim)
        "up" -> return Position(currentPos.horizontal, currentPos.depth - splitDir[1].toInt(), currentPos.aim)
        else -> throw Exception("Split dir went weird $splitDir")
    }
}

fun takeDirectionWAim(direction: String, currentPos: Position): Position {
    val splitDir = direction.split(" ")
    when (splitDir[0]) {
        "forward" -> return Position(currentPos.horizontal + splitDir[1].toInt(),
                currentPos.depth + (currentPos.aim * splitDir[1].toInt()), currentPos.aim)
        "down" -> return Position(currentPos.horizontal, currentPos.depth, currentPos.aim + splitDir[1].toInt())
        "up" -> return Position(currentPos.horizontal, currentPos.depth, currentPos.aim - splitDir[1].toInt())
        else -> throw Exception("Split dir went weird $splitDir")
    }
}

class Position(val horizontal: Int, val depth: Int, val aim: Int)

fun computeFinalPosition(startPosition: Position, directionsIterator: Iterator<String>): Int {
    var currentPos = startPosition
    while (directionsIterator.hasNext()) {
        currentPos = takeDirection(directionsIterator.next(), currentPos)
    }
    println("The final position is ${currentPos.horizontal}, ${currentPos.depth}")
    val depthHorMultiply = currentPos.horizontal * currentPos.depth
    println("The the two positions multiplied is $depthHorMultiply")
    return depthHorMultiply
}

fun computeFinalPositionWAim(startPosition: Position, directionsIterator: Iterator<String>): Int {
    var currentPos = startPosition
    while (directionsIterator.hasNext()) {
        currentPos = takeDirectionWAim(directionsIterator.next(), currentPos)
    }
    println("The final position w aim is ${currentPos.horizontal}, ${currentPos.depth}")
    val depthHorMultiply = currentPos.horizontal * currentPos.depth
    println("The the two positions w aim multiplied is $depthHorMultiply")
    return depthHorMultiply
}

fun main() {
    val directions = day01.readFileAsLinesUsingGetResourceAsStream("inputday02.txt")
            .readLines()

    val depthHorMultiply = computeFinalPosition(Position(0,0, 0), directions.iterator())
    val depthHorMultiplyWAim = computeFinalPositionWAim(Position(0,0, 0), directions.iterator())
}