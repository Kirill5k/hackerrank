package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EmaSupercomputerSpec extends AnyWordSpec with Matchers {

  "EmaSupercomputer::twoPluses" should {
    "return area of a biggest cross" in {
      val g1 = Array("GGGGGG","GBBBGB","GGGGGG","GGBBGB","GGGGGG")
      EmaSupercomputer.twoPluses(g1) must be (5)

      val g2 = Array("BGBBGB","GGGGGG","BGBBGB","GGGGGG","BGBBGB","BGBBGB")
      EmaSupercomputer.twoPluses(g2) must be (25)

      val g3 = Array("GGGGGGG","BGBBBBG","BGBBBBG","GGGGGGG","GGGGGGG","BGBBBBG")
      EmaSupercomputer.twoPluses(g3) must be (5)

      val g4 = Array("GGGGGGGG","GBGBGGBG","GBGBGGBG","GGGGGGGG","GBGBGGBG","GGGGGGGG","GBGBGGBG","GGGGGGGG")
      EmaSupercomputer.twoPluses(g4) must be (81)

      val g5 = Array("GGGGGGGGG","GBBBGGBGG","GBBBGGBGG","GBBBGGBGG","GBBBGGBGG","GBBBGGBGG","GBBBGGBGG","GGGGGGGGG")
      EmaSupercomputer.twoPluses(g5) must be (1)
    }
  }
}
