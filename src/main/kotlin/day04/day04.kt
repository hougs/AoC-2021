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
    var hasBingoed = false

    fun markValue(value: Int) {
        // iterate through rows
        for (i in 0..4) {
            if (board[i].indexOf(value) != -1) {
                foundRowSum[i] += 1
                foundColSum[board[i].indexOf(value)] += 1
                if (!hasBingoed) {numbersMatched.add(value)}
            }
        }
    }


    fun checkBingo(): Boolean {
        val bingoBool = (foundColSum.indexOf(5) != -1) or (foundRowSum.indexOf(5) != -1)
        hasBingoed = bingoBool
        return bingoBool
    }

    fun sumRemainingElements(): Int {
        board[0]
        val sumOfLists = board.fold(0) {sum, list -> sum + list.sum()}
        return sumOfLists
    }
}

fun findFirstWinningBoard(bingoBoards: ArrayList<BingoBoard>, numbersCalled: List<Int>): ArrayList<Pair<BingoBoard, Int>> {
    val winningBoards: ArrayList<Pair<BingoBoard, Int>> = arrayListOf()
    val numberIter = numbersCalled.iterator()
    while (numberIter.hasNext()) {
        val valueToCheck = numberIter.next()
        for (bingoBoard in bingoBoards) {
            bingoBoard.markValue(valueToCheck)
            if (bingoBoard.checkBingo()) {
                winningBoards.add(Pair(bingoBoard, valueToCheck))
            }
        }
    }
    return winningBoards
}

fun findLastWinningBoard(bingoBoardsIn: List<BingoBoard>, numbersCalled: List<Int>){
    var bingoBoards = bingoBoardsIn
    numbersCalled.forEach{ n ->
        bingoBoards.forEach {it.markValue(n)}
        val (bingosDone, bingosToDo) = bingoBoards.partition { it.checkBingo() }
        if (bingosToDo.isEmpty()) {
            if (bingosDone.isNotEmpty()){
                println("Final ans: " + n*(bingosDone[0].sumRemainingElements() - bingosDone[0].numbersMatched.sum()))
            }
            return
        }
        bingoBoards = bingosToDo
    }
}


fun solveP1(bingoBoards: ArrayList<BingoBoard>, numbersCalled: List<Int>){
    val winners: List<Pair<BingoBoard, Int>> = findFirstWinningBoard(bingoBoards, numbersCalled)
    val pairs = winners.first()
    val sumElems = pairs.first.sumRemainingElements() - pairs.first.numbersMatched.sum()
    val valueWonOn = pairs.second
    val finalScore = sumElems * valueWonOn
    println("P1 Final score is $finalScore")
}

fun solveP2(bingoBoards: ArrayList<BingoBoard>, numbersCalled: List<Int>){
    val winningBingo = findLastWinningBoard(bingoBoards, numbersCalled)
}

fun setupInput(): Pair<ArrayList<BingoBoard>, List<Int>> {
    val input = day01.readFileAsLinesUsingGetResourceAsStream("inputday04.txt").readLines()
    val numbersCalled: List<Int> = input[0].split(",").map { x -> x.toInt() }
    var bingoBoards: ArrayList<BingoBoard> = ArrayList()
    for (i in 2..596 step 6) {
        bingoBoards.add(BingoBoardManager.makeBingoBoard(input.subList(i, i + 5)))
    }
    return Pair(bingoBoards, numbersCalled)
}

fun main() {
    val input1 = setupInput()
    solveP1(input1.first, input1.second)
    val input2 = setupInput() // I should figure out how to do this immutably
    solveP2(input2.first, input2.second)
}