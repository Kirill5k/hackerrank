package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AlmostSortedSpec extends AnyWordSpec with Matchers {

  "AlmostSorted::canBeSorted" should {
    "tell whether an array can be sorted with 1 operation" in {
      AlmostSorted.canBeSorted(Array(43,65,1,98,99,101)) must be (Array("no"))
//      AlmostSorted.canBeSorted(Array(4,2)) must be (Array("yes", "swap 1 2"))
//      AlmostSorted.canBeSorted(Array(3,1,2)) must be (Array("no"))
//      AlmostSorted.canBeSorted(Array(1,5,4,3,2,6)) must be (Array("yes", "reverse 2 5"))
//      AlmostSorted.canBeSorted(Array(1,2,6,5,4,3,7,8)) must be (Array("yes", "reverse 3 6"))
//      AlmostSorted.canBeSorted(Array(1,2,6,4,5,3,7,8)) must be (Array("yes", "swap 3 6"))
    }
  }
}
