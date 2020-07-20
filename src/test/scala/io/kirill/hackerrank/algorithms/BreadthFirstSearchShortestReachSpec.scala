package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BreadthFirstSearchShortestReachSpec extends AnyWordSpec with Matchers {

  "BreadthFirstSearchShortestReach::bfs" should {
    "return shortest distances to all nodes" in {
      BreadthFirstSearchShortestReach.bfs(4, 2, Array(Array(1, 2), Array(1, 3)), 1) must be (Array(6, 6, -1))
    }
  }
}
