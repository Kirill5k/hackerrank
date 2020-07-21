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
        val p2 = peaks.findLast(_._2 == -1).map(_._1).get
        if (p1 + 1 != p2) Array("yes", s"reverse $p1 $p2")
        else if (canBeSwapped(p1-1, p2-1, arr)) Array("yes", s"swap $p1 $p2")
        else Array("no")
      case (2, 2) =>
        val p1 = peaks.find(_._2 == 1).map(_._1).get
        val p2 = peaks.findLast(_._2 == -1).map(_._1).get
        if (canBeSwapped(p1-1, p2-1, arr)) Array("yes", s"swap $p1 $p2") else Array("no")
      case (_, _) =>
        Array("no")
    }
  }

  def canBeSwapped(p1: Int, p2: Int, arr: Array[Int]): Boolean = {
    val copy = arr.clone()
    copy(p1) = arr(p2)
    copy(p2) = arr(p1)
    !copy.zip(copy.tail).exists {case (x,y) => x>y}
  }
}
