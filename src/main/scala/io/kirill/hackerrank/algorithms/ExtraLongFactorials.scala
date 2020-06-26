package io.kirill.hackerrank.algorithms

import scala.annotation.tailrec

object ExtraLongFactorials {

  def factorial(n: Int): BigInt = {
    @tailrec
    def go(x: Int, result: BigInt): BigInt = {
      if (x == 1) result
      else go(x-1, result * x)
    }
    go(n, 1)
  }
}
