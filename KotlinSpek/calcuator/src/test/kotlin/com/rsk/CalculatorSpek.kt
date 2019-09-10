package com.rsk

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.gen5.api.Assertions


class CalculatorSpek : Spek({
    var calculator: Calculator? = null
    describe("the calculator") {
        beforeEach {
            calculator = Calculator(NullResult())
        }

        it("should add two numbers") {
            val result = calculator?.add(12, 13)
            Assertions.assertEquals(25, result)
        }

        it("should accumulate one number") {
            calculator?.accumulate(23)
            Assertions.assertEquals(23, calculator?.total)
        }

        it("should accumulate two numbers") {
            calculator?.accumulate(2)
            calculator?.accumulate(3)
            Assertions.assertEquals(5, calculator?.total)
        }
    }

    describe("the output should be written correctly") {
        val result : Result = mock()
        val calculator = Calculator(result)
        it("should write the output amount") {
            calculator.accumulate(23)
            verify(result).write(23)
        }
    }
})