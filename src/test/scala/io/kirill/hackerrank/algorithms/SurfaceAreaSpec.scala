package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SurfaceAreaSpec extends AnyWordSpec with Matchers {

  "SurfaceArea::surfaceArea" should {
    "calculate surface area of a 3d figure" in {

      SurfaceArea.surfaceArea(Array(Array(1))) must be (6)
      SurfaceArea.surfaceArea(Array(Array(1, 3, 4), Array(2, 2, 3), Array(1, 2, 4))) must be (60)
    }
  }
}
