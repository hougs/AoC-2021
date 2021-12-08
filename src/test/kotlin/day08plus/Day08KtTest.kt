package day08plus

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day08KtTest : StringSpec({
    "small, simple input part 1" {
        val textInputLine = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | " +
                "fdgacbe cefdb cefbgd gcbe\n" +
                "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | " +
                "fcgedb cgb dgebacf gc\n" +
                "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | " +
                "cg cg fdcagb cbg\n" +
                "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | " +
                "efabcd cedba gadfec cb\n" +
                "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | " +
                "gecf egdcabf bgf bfgea\n" +
                "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | " +
                "gebdcfa ecba ca fadegcb\n" +
                "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | " +
                "cefg dcbef fcge gbcadfe\n" +
                "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | " +
                "ed bcgafe cdgba cbgef\n" +
                "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | " +
                "gbdfcae bgc cg cgb\n" +
                "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | " +
                "fgae cfgab fg bagce"
        solveP1(textInputLine.split("\n")) shouldBe 26
    }

    "small input part 2" {
        val textInputLine = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | " +
                "cdfeb fcadb cdfeb cdbaf"
        solveP2(listOf(textInputLine)) shouldBe 5353
    }

    "small input2 part 2" {
        val textInputLine = "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | " +
                "fcgedb cgb dgebacf gc"
        solveP2(listOf(textInputLine)) shouldBe 9781
    }

    "big input part 2" {
        val textInputLine = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | " +
                "fdgacbe cefdb cefbgd gcbe\n" +
                "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | " +
                "fcgedb cgb dgebacf gc\n" +
                "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | " +
                "cg cg fdcagb cbg\n" +
                "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | " +
                "efabcd cedba gadfec cb\n" +
                "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | " +
                "gecf egdcabf bgf bfgea\n" +
                "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | " +
                "gebdcfa ecba ca fadegcb\n" +
                "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | " +
                "cefg dcbef fcge gbcadfe\n" +
                "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | " +
                "ed bcgafe cdgba cbgef\n" +
                "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | " +
                "gbdfcae bgc cg cgb\n" +
                "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | " +
                "fgae cfgab fg bagce"
        solveP2(textInputLine.split("\n")) shouldBe 61229
    }

})
