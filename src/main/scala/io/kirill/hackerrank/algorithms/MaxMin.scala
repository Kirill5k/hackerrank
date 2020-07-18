package io.kirill.hackerrank.algorithms

object MaxMin {

  def maxMin(k: Int, arr: Array[Int]): Int = {
    val sorted = arr.sorted
    var min = Int.MaxValue
    (0 until arr.length - k  + 1).foreach { i =>
      val a = sorted.slice(i, i+k)
      val fairness = a(k-1) - a(0)
      if (fairness < min) {
        min = fairness
      }
    }
    min
  }
}
