package day05

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestDay05: StringSpec({
    "should compute correct answer" {
        val input = listOf<Line>(
            Line(Pair(0,9),Pair(5,9)),
            Line(Pair(8,0),Pair(0,8)),
            Line(Pair(9,4),Pair(3,4)),
            Line(Pair(2,2),Pair(2,1)),
            Line(Pair(7,0),Pair(7,4)),
            Line(Pair(6,4),Pair(2,0)),
            Line(Pair(0,9),Pair(2,9)),
            Line(Pair(3,4),Pair(1,4)),
            Line(Pair(0,0),Pair(8,8)),
            Line(Pair(5,5),Pair(8,2))
        )
        val soln1 = day05.solveP1(input)
        soln1 shouldBe 5
    }

    "MINE should compute correct answer" {
        val input = listOf<Line>(
            Line(Pair(0,1),Pair(0,2)),
            Line(Pair(0,1),Pair(0,4)),
            Line(Pair(0,1),Pair(3,1))
        )
        val soln1 = day05.solveP1(input)
        soln1 shouldBe 2
    }
})

