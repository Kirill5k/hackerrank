package io.kirill.hackerrank.algorithms

object TheFullCountingSort {

  def sort(arr: Array[Array[String]]): String = {
    val half = arr.length / 2
    val counts = arr.zipWithIndex.toList.map {
      case (Array(n, w), i) => (n.toInt , (w, i))
    }
      .groupBy(_._1)
      .view.mapValues(_.map(_._2))
      .toMap

    counts
      .keys
      .toList
      .sorted
      .map(counts(_).map(c => if (c._2 < half) "-" else c._1))
      .map(_.mkString(" "))
      .mkString(" ")
  }
}
