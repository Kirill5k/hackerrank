package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MaxMinSpec extends AnyWordSpec with Matchers {

  "MaxMin::maxMin" should {
    "return min unfairness" in {
      MaxMin.maxMin(3, Array(10,100,300,200,1000,20,30)) must be (20)
      MaxMin.maxMin(3, Array(100,200,300,350,400,401,402)) must be (2)
    }
  }
}
