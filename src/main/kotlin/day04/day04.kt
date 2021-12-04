package day04

object BingoBoardManager {
    fun makeBingoBoard(stringyBoard: List<String>): BingoBoard {
        if (stringyBoard.size !=5) {
            println("Juliet, you are parsing wrong")
        }
        val board: List<List<Int>> = stringyBoard.map { strLine -> arrayListOf(strLine.substring(0, 2).trim(),
            strLine.substring(3, 5).trim(),
            strLine.substring(6, 8).trim(),
            strLine.substring(9, 11).trim(),
            strLine.substring(12, 14).trim()
        ).map { elem -> elem.toInt() } }
        return BingoBoard(board as ArrayList<ArrayList<Int>>)
    }
}

// board is row major rep of a bingo board
class BingoBoard(val board: ArrayList<ArrayList<Int>>) {
    val foundRowSum: ArrayList<Int> = arrayListOf(0,0,0,0,0)
    val foundColSum: ArrayList<Int> = arrayListOf(0,0,0,0,0)
    val numbersMatched: ArrayList<Int> = arrayListOf()

    fun markValue(value: Int) {
        // iterate through rows
        for (i in 0..4) {
            if (board[i].indexOf(value) != -1) {
                foundRowSum[i] += 1
                foundColSum[board[i].indexOf(value)] += 1
                numbersMatched.add(value)
            }
        }
    }

    // return index of row of column that won
    fun checkBingo(): Boolean {
        return (foundColSum.indexOf(5) != -1) or (foundRowSum.indexOf(5) != -1)
    }

    fun sumRemainingElements(): Int {
        board[0]
        val sumOfLists = board.fold(0) {sum, list -> sum + list.sum()}
        return sumOfLists
    }
}

fun findWinningBoard(bingoBoards: ArrayList<BingoBoard>, numbersCalled: List<Int>): Pair<BingoBoard, Int> {
    var winningBoard = bingoBoards[0]
    val numberIter = numbersCalled.iterator()
    while (numberIter.hasNext()) {
        val valueToCheck = numberIter.next()
        for (bingoBoard in bingoBoards) {
            bingoBoard.markValue(valueToCheck)
            if (bingoBoard.checkBingo()) {
                return Pair(bingoBoard, valueToCheck)
            }
        }
    }
    return Pair(winningBoard, -1)
}

fun main() {
    val input = day01.readFileAsLinesUsingGetResourceAsStream("inputday04.txt").readLines()
    val numbersCalled: List<Int> = input[0].split(",").map { x -> x.toInt() }
    var bingoBoards: ArrayList<BingoBoard> = ArrayList()
    for (i in 2..596 step 6) {
        bingoBoards.add(BingoBoardManager.makeBingoBoard(input.subList(i, i + 5)))
    }
    val pairs = findWinningBoard(bingoBoards, numbersCalled)
    println(pairs.first.numbersMatched.sum())
    val sumElems = pairs.first.sumRemainingElements() - pairs.first.numbersMatched.sum()
    val valueWonOn = pairs.second
    val finalScore = sumElems * valueWonOn
    println("Sum of remaining elements $sumElems")
    println("Values won on $valueWonOn")
    println("Final score is $finalScore")
}