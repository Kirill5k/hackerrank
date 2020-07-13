package io.kirill.hackerrank.algorithms

object GridlandMetro {

  def gridlandMetro(n: Long, m: Long, k: Long, tracks: Array[Array[Long]]): Long = {
    val tracksByRows = tracks
      .toList
      .groupBy(_.head)
      .values
      .map(_.map(track => (track(1), track(2))).sortBy(_._1))

    val tracksTotal = tracksByRows.map { ts =>
      ts.foldLeft(scala.collection.immutable.List[(Long, Long)]()){
        case (res, (x1, x2)) =>
          res match {
            case Nil => (x1, x2) :: Nil
            case h :: t if x2 <= h._2 => h :: t
            case h :: t if x1 <= h._2 && x2 >= h._2 => (h._1, x2) :: t
            case h :: t => (x1, x2) :: h :: t
          }
      }.map {
        case (x1, x2) => x2 - x1 + 1
      }
      .sum
    }.sum

    n * m - tracksTotal
  }
}
