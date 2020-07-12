package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class HackerlandRadioTransmittersSpec extends AnyWordSpec with Matchers {

  "HackerlandRadioTransmitters::hackerlandRadioTransmitters" should {
    "return minimal amount of transmitters needs to cover the whole area" in {
      HackerlandRadioTransmitters.hackerlandRadioTransmitters(Array(1,2,3,4,5), 1) must be (2)
      HackerlandRadioTransmitters.hackerlandRadioTransmitters(Array(7,2,4,6,5,9,12,11), 2) must be (3)
    }
  }
}
