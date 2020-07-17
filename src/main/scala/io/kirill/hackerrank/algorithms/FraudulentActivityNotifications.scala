package io.kirill.hackerrank.algorithms

object FraudulentActivityNotifications {

  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    val (i1, i2) = (math.floor((d - 1) / 2.0).toInt, math.ceil((d - 1) / 2.0).toInt)
    val counts   = Array.fill(201)(0)
    (0 until d).foreach(i => counts(expenditure(i)) = counts(expenditure(i)) + 1)
    (for (i <- d until expenditure.length) yield {
      val m1 = getMedianPoint(counts, i1)
      val m2 = getMedianPoint(counts, i2)
      val m  = (m1 + m2) / 2.0
      counts(expenditure(i - d)) = counts(expenditure(i - d)) - 1
      counts(expenditure(i)) = counts(expenditure(i)) + 1
      if (expenditure(i) >= m * 2) 1 else 0
    }).sum
  }

  @scala.annotation.tailrec
  def getMedianPoint(counts: Array[Int], i: Int, k: Int = 0, j: Int = 0): Int =
    if (k > i) j - 1
    else getMedianPoint(counts, i, k + counts(j), j + 1)
}
