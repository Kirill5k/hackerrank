package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ConnectedCellsInGridSpec extends AnyWordSpec with Matchers {

  "ConnectedCellsInGrid::connectedCell" should {

    "return area of largest region" in {
      val grid = Array(Array(1,1,0,0), Array(0,1,1,0), Array(0,0,1,0), Array(1,0,0,0))
      ConnectedCellsInGrid.connectedCell(grid) must be (5)

      val grid2 = Array(Array(0,0,1,1), Array(0,0,1,0), Array(0,1,1,0), Array(0,1,0,0), Array(1,1,0,0))
      ConnectedCellsInGrid.connectedCell(grid2) must be (8)

      val grid3 = Array(Array(1,1,1,0,1), Array(0,0,1,0,0), Array(1,1,0,1,0), Array(0,1,1,0,0), Array(0,0,0,0,0), Array(0,1,0,0,0), Array(0,0,1,1,0))
      ConnectedCellsInGrid.connectedCell(grid3) must be (9)

      val grid4 = Array(Array(0,1,0,0,0,0,1,1,0),Array(1,1,0,0,1,0,0,0,1),Array(0,0,0,0,1,0,1,0,0),Array(0,1,1,1,0,1,0,1,1),Array(0,1,1,1,0,0,1,1,0),Array(0,1,0,1,1,0,1,1,0),Array(0,1,0,0,1,1,0,1,1),Array(1,0,1,1,1,1,0,0,0))
      ConnectedCellsInGrid.connectedCell(grid4) must be (29)
    }
  }
}
