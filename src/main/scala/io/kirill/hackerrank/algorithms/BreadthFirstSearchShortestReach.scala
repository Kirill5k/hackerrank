package io.kirill.hackerrank.algorithms

object BreadthFirstSearchShortestReach {

  import scala.collection.immutable.{List, Set}

  def bfs(nNodes: Int, nEdges: Int, edges: Array[Array[Int]], startingNode: Int, nodeLength: Int = 6): Array[Int] = {
    val visits = Array.fill(nNodes + 1)(false)
    val graph = edges.foldLeft(Map.empty[Int, Set[Int]]) { case (g, el) =>
      val n1 = el(0)
      val n2 = el(1)
      g + (n1 -> (g.getOrElse(n1, Set.empty[Int]) + n2)) + (n2 -> (g.getOrElse(n2, Set.empty[Int]) + n1))
    }
    val distances = Array.fill(nNodes + 1)(-1)
    distances(startingNode) = 0
    val queue     = List(startingNode)
    search(queue, distances, graph, visits)
      .tail
      .filter(_ != 0)
      .map(d => if (d == -1) d else d * nodeLength)
  }

  @scala.annotation.tailrec
  private def search(
      queue: List[Int],
      distances: Array[Int],
      graph: Map[Int, Set[Int]],
      visits: Array[Boolean]
  ): Array[Int] =
    if (queue.isEmpty) distances
    else {
      val node = queue.head
      visits(node) = true
      val nextNodes = graph.getOrElse(node, Set.empty[Int]).filter(n => !visits(n))
      nextNodes.foreach(n => distances(n) = distances(node) + 1)
      search(queue.tail :++ nextNodes, distances, graph, visits)
    }
}
