package io.kirill.hackerrank.algorithms

object TheFullCountingSort {

  def sort(arr: Array[Array[String]]): String = {
    val charsToReplace = arr.slice(0, arr.length / 2).map(_(1)).toSet
    val counts = arr.toList.map {
      case Array(i, w) => (i.toInt ,w)
    }
      .groupBy(_._1)
      .view.mapValues(_.map(_._2))
      .toMap

    counts
      .keys
      .toList
      .sorted
      .map { i =>
        val chars = counts(i)
        if (chars.size == 1) chars
        else chars.map(c => if (charsToReplace.contains(c)) "-" else c)
      }
      .map(_.mkString(" "))
      .mkString(" ")
  }
}
