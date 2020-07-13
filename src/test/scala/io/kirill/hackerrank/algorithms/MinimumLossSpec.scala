package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MinimumLossSpec extends AnyWordSpec with Matchers {

  "MinimumLoss::minimumLoss" should {
    "calculate minimum loss when buying and selling a house" in {
      MinimumLoss.minimumLoss(Array(5, 10, 3)) must be (2)
      MinimumLoss.minimumLoss(Array(20, 7, 8, 2, 5)) must be (2)
    }
  }
}
