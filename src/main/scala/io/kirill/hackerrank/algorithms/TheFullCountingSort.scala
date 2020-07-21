package io.kirill.hackerrank.algorithms

object TheFullCountingSort {

  def sort(arr: Array[Array[String]]): String = {
    val half = arr.length / 2
    val counts = arr.zipWithIndex.toList.map {
      case (Array(n, w), i) => (n.toInt , if (i < half) "-" else  w)
    }
      .groupBy(_._1)
      .view.mapValues(_.map(_._2).mkString(" "))
      .toMap

    counts
      .toList
      .sortBy(_._1)
      .map(_._2)
      .mkString(" ")
  }
}
