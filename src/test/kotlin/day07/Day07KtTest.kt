package day07

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day07KtTest : FunSpec({

    test("solveP1") {
        val (position, fuelCost) = solveP1(listOf(16,1,2,0,4,2,7,1,2,14))
        position shouldBe 2
        fuelCost shouldBe 37
    }

    test("solveP2") {
        val (position, fuelCost) = solveP2(listOf(16,1,2,0,4,2,7,1,2,14))
        position shouldBe 5
        fuelCost shouldBe 168
    }
})
