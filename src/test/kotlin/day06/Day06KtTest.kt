package day06

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestDay06: StringSpec({
    "should compute correct answer for P1" {
        val input = listOf<Int>(3,4,3,1,2)
        val soln1 = day06.solveP1(input, 18)
        soln1 shouldBe 26
    }

    "should compute correct answer for P2" {
        val input = listOf<Int>(3,4,3,1,2)
        val soln1 = day06.solveP1(input, 256)
        soln1 shouldBe 26984457539
    }

})