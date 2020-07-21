package io.kirill.hackerrank.algorithms

object AlmostSorted {

  import scala.collection.immutable.List

  def canBeSorted(arr: Array[Int]): Array[String] = {
    val peaks = (1 until arr.length - 1).map { i =>
      val (p, c, n) = (arr(i-1), arr(i), arr(i+1))
      val inv = if (c > p && c > n) 1 else if (c < p && c < n) -1 else 0
      (i+1, inv)
    }.toList

    val groupedPeaks = peaks.groupBy(_._2)

    (groupedPeaks.get(1).map(_.size).getOrElse(0), groupedPeaks.get(-1).map(_.size).getOrElse(0)) match {
      case (0, 0) =>
        if (arr.length == 2 && arr(0) > arr(1)) Array("yes", "swap 1 2")
        else Array("yes")
      case (1, 1) =>
        val (p1, p2) = (groupedPeaks(1).head._1, groupedPeaks(-1).head._1)
        if (p1 + 1 != p2) Array("yes", s"reverse $p1 $p2")
        else if (canBeSwapped(p1-1, p2-1, arr)) Array("yes", s"swap $p1 $p2")
        else Array("no")
      case (2, 2) =>
        val (p1, p2) = (groupedPeaks(1).head._1, groupedPeaks(-1).last._1)
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
