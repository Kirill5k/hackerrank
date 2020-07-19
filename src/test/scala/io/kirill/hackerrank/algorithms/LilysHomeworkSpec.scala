package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LilysHomeworkSpec extends AnyWordSpec with Matchers {

  "LilysHomework::lilysHomework" should {

    "return min amount of swaps need to make array beautiful" in {
      LilysHomework.lilysHomework(Array(2,5,3,1)) must be (2)
      LilysHomework.lilysHomework(Array(7,5,12,3)) must be (2)
    }
  }
}
