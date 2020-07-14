package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AbsolutePermutationSpec extends AnyWordSpec with Matchers {

  "AbsolutePermutation::absolutePermutation" should {

    "return lexicographically smallest absolute permutation" in {
      AbsolutePermutation.absolutePermutation(3, 0) must be (Array(1,2,3))
      AbsolutePermutation.absolutePermutation(3, 2) must be (Array(-1))
    }
  }
}
