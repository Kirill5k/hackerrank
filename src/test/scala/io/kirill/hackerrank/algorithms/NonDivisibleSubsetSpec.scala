package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NonDivisibleSubsetSpec extends AnyWordSpec with Matchers {

  "NonDivisibleSubset::nonDivisibleSubset" should {

    "print the max size of subset where sum of all permutations is non divisible by k" in {
      NonDivisibleSubset.nonDivisibleSubset(3, Array(1,7,2,4)) must be (3)
      NonDivisibleSubset.nonDivisibleSubset(4, Array(19,10,12,10,24,25,22)) must be (3)
      NonDivisibleSubset.nonDivisibleSubset(13, Array(2375782,21836421,2139842193,2138723,23816,21836219,2948784,43864923,283648327,23874673)) must be (7)
    }
  }
}
