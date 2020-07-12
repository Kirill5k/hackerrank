package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PairsSpec extends AnyWordSpec with Matchers {

  "Pairs::pairs" should {

    "return amount of pairs with a given remainder" in {

      Pairs.pairs(2, Array(1,5,3,4,2)) must be (3)
    }
  }
}
