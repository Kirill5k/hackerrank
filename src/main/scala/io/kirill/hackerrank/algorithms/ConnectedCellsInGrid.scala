package io.kirill.hackerrank.algorithms

object ConnectedCellsInGrid {

  def connectedCell(matrix: Array[Array[Int]]): Int = {
    var id = 0
    val ids = scala.collection.mutable.Map[(Int, Int), Int]()
    val sizes = scala.collection.mutable.Map[(Int, Int), Int]()

    matrix.zipWithIndex.foreach {
      case (row, x) => row.zipWithIndex.foreach {
        case (_, y) =>
          id += 1
          ids((x, y)) = id
          sizes((x, y)) = 1
      }
    }

    def connect(p1: (Int, Int), p2: (Int, Int)): Unit = {
      if (sizes(p1) > sizes(p2)) {
        sizes(p1) = sizes(p1) + sizes(p2)
        ids(p2) = ids(p1)
      } else {
        sizes(p2) = sizes(p1) + sizes(p2)
        ids(p1) = ids(p2)
      }
    }

    matrix.zipWithIndex.foreach {
      case (row, x) => row.zipWithIndex
        .filter(_._1 == 1)
        .map(_._2)
        .foreach { y =>
          val allAdjacentPoints = for {
            x1 <- (x-1) to (x + 1)
            y1 <- (y-1) to (y + 1)
          } yield (x1, y1)
          allAdjacentPoints
            .filter(_ != (x, y))
            .filter(p => ids.contains(p))
            .filter(p => matrix(p._1)(p._2) == 1)
            .foreach(p => connect((x, y), p))
        }
    }

    ids.values.groupBy(identity).values.map(_.size).max
  }
}
