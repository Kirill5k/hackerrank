package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ExtraLongFactorialsSpec extends AnyWordSpec with Matchers {

  "ExtraLongFactorials" should {
    "calculate factorial" in {
      ExtraLongFactorials.factorial(5) must be (120)
    }
  }
}
