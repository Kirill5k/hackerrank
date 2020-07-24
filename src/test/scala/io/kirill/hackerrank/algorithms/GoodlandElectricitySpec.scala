package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GoodlandElectricitySpec extends AnyWordSpec with Matchers {

  "GoodlandElectricity::pylons" should {
    "return amount of stations needs to supply electricity" in {
      GoodlandElectricity.pylons(2, Array(0,1,1,1,1,0)) must be (2)
    }
  }
}
