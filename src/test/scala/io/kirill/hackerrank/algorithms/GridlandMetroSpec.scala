package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GridlandMetroSpec extends AnyWordSpec with Matchers {

  "GridlandMetro::gridlandMetro" should {

    "return amount of lampposts that can be placed" in {
      val t1 = Array(Array(2,2,3),Array(3,1,4),Array(4,4,4))
      GridlandMetro.gridlandMetro(4, 4, 3, t1) must be (9)

      val t2 = Array(Array(1, 1, 2), Array(1, 4, 4), Array(2, 1, 2), Array(2, 2, 3), Array(2, 4, 5), Array(4, 1, 2), Array(4, 4, 5))
      GridlandMetro.gridlandMetro(4, 5, 7, t2) must be (8)

      val t3 = Array(Array(1,3,6),Array(1,2,4),Array(1,1,1),Array(1,7,7),Array(1,4,5),Array(1,1,8))
      GridlandMetro.gridlandMetro(1, 9, 6, t3) must be (1)
    }
  }
}
