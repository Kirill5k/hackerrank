package io.kirill.hackerrank.algorithms

object ConnectedCellsInGrid {

  def connectedCell(matrix: Array[Array[Int]]): Int = {
    var id = 0
    val ids = scala.collection.mutable.Map[(Int, Int), Int]()
    val sizes = scala.collection.mutable.Map[Int, Int]()

    matrix.zipWithIndex.foreach {
      case (row, x) => row.zipWithIndex.foreach {
        case (_, y) =>
          id += 1
          ids((x, y)) = id
          sizes(id) = 1
      }
    }

    def connect(p1: (Int, Int), p2: (Int, Int)): Unit = {
      val p1Id = ids(p1)
      val p2Id = ids(p2)

      if (p1Id != p2Id) {
        if (sizes(p1Id) > sizes(p2Id)) {
          sizes(p1Id) = sizes(p1Id) + sizes(p2Id)
          ids(p2) = p1Id
        } else {
          sizes(p2Id) = sizes(p1Id) + sizes(p2Id)
          ids(p1) = p2Id
        }
      }
    }

    def unionFind(point: (Int, Int)): Unit = {
      val (x, y) = point
      val allAdjacentPoints = for(x1 <- (x-1) to (x + 1); y1 <- (y-1) to (y + 1)) yield (x1, y1)
      allAdjacentPoints
        .filter(_ != (x, y))
        .filter(p => ids.contains(p))
        .filter(p => matrix(p._1)(p._2) == 1)
        .filter(p => ids(point) != ids(p))
        .foreach(p => {connect(point, p); unionFind(p)})
    }

    matrix.zipWithIndex.foreach {
      case (row, x) => row
        .zipWithIndex
        .filter(_._1 == 1)
        .map(_._2)
        .foreach { y => unionFind((x, y))}
    }

    sizes.maxBy(_._2)._2
  }
}
