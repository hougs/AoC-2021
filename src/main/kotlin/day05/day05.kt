package day05

class Line(val start: Pair<Int, Int>, val end: Pair<Int, Int>) {
}

class Grid(){
    val gridSum = HashMap<Pair<Int, Int>, Int>()
    fun addLine(line: Line) {
        // vertical lines
        if(line.start.first == line.end.first) {
            var yStart = line.start.second
            var yEnd = line.end.second
            if (yStart > yEnd) {
                yStart = yEnd.also { yEnd = yStart }
            }
            for (i in yStart..yEnd) {
                val nextInsert = Pair(line.start.first, i)
                gridSum.put(nextInsert, gridSum.getOrDefault(nextInsert, 0) + 1)
            }
        }
        // horizontal lines
        if(line.start.second == line.end.second) {
            var xStart = line.start.first
            var xEnd = line.end.first
            if (xStart > xEnd) {
                xStart = xEnd.also { xEnd = xStart }
            }
            for (i in xStart..xEnd) {
                val nextInsert = Pair(i, line.start.second)
                gridSum.put(nextInsert, gridSum.getOrDefault(nextInsert, 0) + 1)
            }
        }
    }

    fun pointsWAtLeastTwoLines(): Int {
        return gridSum.count {it.value > 1}
    }
}

fun setupInput(): List<Line> {
    val input = day01.readFileAsLinesUsingGetResourceAsStream("inputday05.txt").readLines()
    val lines: MutableList<Line> = mutableListOf()
    for (line in input) {
        val intArr = line.split(" -> ", ",").map { x: String -> x.toInt() }
        lines.add(Line(Pair(intArr[0], intArr[1]), Pair(intArr[2], intArr[3])))
    }
    return lines
}

fun solveP1(lines: List<Line>): Int {
    val grid = Grid()
    for (line in lines) {
        grid.addLine(line)
    }
    println("size of hashmap: " + grid.gridSum.size)
    return grid.pointsWAtLeastTwoLines()
}

fun main() {
    val lines = setupInput()
    println("size of input is ${lines[0].start} ${lines[0].end}")
    val soln1 = solveP1(lines)
    println("the number of points where at least two lines overlap is " + soln1)

}
