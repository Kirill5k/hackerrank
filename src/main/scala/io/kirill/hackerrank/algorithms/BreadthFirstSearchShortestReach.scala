package io.kirill.hackerrank.algorithms

object BreadthFirstSearchShortestReach {

  import scala.collection.immutable.{List, Set}

  def bfs(nNodes: Int, nEdges: Int, edges: Array[Array[Int]], s: Int): Array[Int] = {
    val visited   = Array.fill(nNodes + 1)(false)
    visited(s) = true
    val distances = Array.fill(nNodes + 1)(-1)
    distances(s) = 0
    val graph = Array.fill(nNodes + 1)(Set[Int]())
    edges.foreach {
      case Array(a, b) =>
        graph(a) = graph(a) + b
        graph(b) = graph(b) + a
    }

    val travelledDist = search(List(s), visited, distances, graph)

    travelledDist
      .drop(1)
      .filter(_ != 0)
      .map(d => if (d == - 1) d else d * 6)
  }

  @scala.annotation.tailrec
  def search(queue: List[Int], vis: Array[Boolean], dist: Array[Int], graph: Array[Set[Int]]): Array[Int] =
    if (queue.isEmpty) dist
    else {
      val n = queue.head
      val adjacentNodes = graph(n).filter(x => !vis(x) && dist(x) == -1)
      adjacentNodes.foreach { an =>
          dist(an) = dist(n) + 1
          vis(an) = true
        }
      search(queue.tail :++ adjacentNodes, vis, dist, graph)
    }
}
