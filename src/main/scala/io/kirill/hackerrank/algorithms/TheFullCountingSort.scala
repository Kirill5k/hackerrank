package io.kirill.hackerrank.algorithms

object TheFullCountingSort {

  def sort(arr: Array[Array[String]]): String = {
    val half = arr.length / 2

    var counts = Map[Int, List[String]]()
    for (i <- arr.indices) {
      val Array(n, w) = arr(i)
      counts = counts + (n.toInt -> (counts.getOrElse(n.toInt, Nil) :+ (if (i < half) "-" else w)))
    }

    counts
      .keys
      .toList
      .sorted
      .map(counts(_).mkString(" "))
      .mkString(" ")
  }
}
