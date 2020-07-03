package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LarrysArraySpec extends AnyWordSpec with Matchers {

  "LarrysArray::larrysArray" should {

    "determine whether array can be sorted in specific way" in {
      LarrysArray.larrysArray(Array(1,6,5,2,4,3)) must be ("YES")
    }
  }
}
