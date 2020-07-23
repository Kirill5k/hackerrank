package io.kirill.hackerrank.algorithms

object OrganizingContainersOfBalls {

  def organizingContainers(container: Array[Array[Int]]): String = {
    val boxes = Array.fill[Long](container.length)(0)
    container.zipWithIndex.foreach {
      case (b, i) => boxes(i) = b.map(_.toLong).sum
    }
    val balls = Array.fill[Long](container.length)(0)
    container.foreach { c =>
      c.zipWithIndex.foreach {
        case (n, i) => balls(i) = balls(i) + n
      }
    }

    if (boxes.sorted.sameElements(balls.sorted)) "Possible" else "Impossible"
  }
}
