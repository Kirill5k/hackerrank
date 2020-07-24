package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CandiesSpec extends AnyWordSpec with Matchers {

  "Candies::candies" should {
    "return minimal amount of candies needed" in {
      Candies.candies(10, Array(2,4,2,6,1,7,8,9,2,1)) must be (19)
      Candies.candies(8, Array(2,4,3,5,2,6,4,5)) must be (12)
    }
  }
}
