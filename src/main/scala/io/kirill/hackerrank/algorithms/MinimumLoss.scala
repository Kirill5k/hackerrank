package io.kirill.hackerrank.algorithms

object MinimumLoss {

  def minimumLoss(price: Array[Long]): Int = {
    val sorted = price.sorted.reverse
    var loss = Long.MaxValue
    for (i <- 0 until price.length - 1) {
      val (p1, p2) = (sorted(i), sorted(i+1))
      if (p1 - p2 < loss && price.indexOf(p1) < price.indexOf(p2)) {
        loss = p1 - p2
      }
    }

    loss.toInt
  }
}
