package io.kirill.hackerrank.algorithms

object BreadthFirstSearchShortestReach {

  def bfs(nNodes: Int, nEdges: Int, edges: Array[Array[Int]], s: Int): Array[Int] = {
    val visited   = Array.fill(nNodes + 1)(false)
    val distances = Array.fill(nNodes + 1)(0)
    distances(s) = s
    val graph = Array.fill(nNodes + 1)(scala.collection.immutable.Set[Int]())
    edges.foreach {
      case Array(a, b) =>
        graph(a) = graph(a) + b
        graph(b) = graph(b) + a
    }

    val travelledDist = search(scala.collection.immutable.List(s), visited, distances, graph)

    (1 to nNodes)
      .map(n => (n, getDistance(n, travelledDist, 0)))
      .filter(_._1 != s)
      .map(_._2)
      .map(d => if (d == 0) -1 else d * 6)
      .toArray
  }

  @scala.annotation.tailrec
  def search(
      queue: scala.collection.immutable.List[Int],
      visited: Array[Boolean],
      distances: Array[Int],
      graph: Array[scala.collection.immutable.Set[Int]]
  ): Array[Int] =
    if (queue.isEmpty) distances
    else {
      val n = queue.head
      if (!visited(n)) {
        visited(n) = true
        val an = graph(n).filter(x => !visited(x))
        an.foreach(x => distances(x) = n)
        search(an ++: queue.tail, visited, distances, graph)
      } else {
        search(queue.tail, visited, distances, graph)
      }
    }

  @scala.annotation.tailrec
  def getDistance(n: Int, travelledDist: Array[Int], journey: Int): Int = {
    val prev = travelledDist(n)
    if (prev == n || prev == 0) journey
    else getDistance(prev, travelledDist, journey + 1)
  }
}
