package io.kirill.hackerrank.algorithms

object AlmostSorted {

  def canBeSorted(arr: Array[Int]): Array[String] = {
    val peaks = (1 until arr.length - 1).map { i =>
      val (p, c, n) = (arr(i-1), arr(i), arr(i+1))
      val inv = if (c > p && c > n) 1 else if (c < p && c < n) -1 else 0
      (i+1, inv)
    }.toList

    (peaks.count(_._2 == 1), peaks.count(_._2 == -1)) match {
      case (0, 0) =>
        if (arr.length == 2 && arr(0) > arr(1)) Array("yes", "swap 1 2")
        else Array("yes")
      case (1, 1) =>
        val p1 = peaks.find(_._2 == 1).map(_._1).get
        val p2 = peaks.find(_._2 == -1).map(_._1).get
        val op = if (p1 + 1 != p2) "reverse" else "swap"
        Array("yes", s"$op $p1 $p2")
      case (2, 2) =>
        val p1 = peaks.find(_._2 == 1).map(_._1).get
        val p2 = peaks.findLast(_._2 == -1).map(_._1).get
        Array("yes", s"swap $p1 $p2")
      case (_, _) =>
        Array("no")
    }
  }
}
