package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BreadthFirstSearchShortestReachSpec extends AnyWordSpec with Matchers {

  "BreadthFirstSearchShortestReach::bfs" should {
    "return shortest distances to all nodes" in {
      val nNodes = 5
      val edges = Array(Array(1, 2), Array(1, 3), Array(3, 4))
      val startingNode = 1

      val result = BreadthFirstSearchShortestReach.bfs(nNodes, edges.length, edges, startingNode)

      result mustBe Array(6, 6, 12, -1)
    }
  }
}
