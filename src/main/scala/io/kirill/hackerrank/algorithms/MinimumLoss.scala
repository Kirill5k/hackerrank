package io.kirill.hackerrank.algorithms

object MinimumLoss {

  def minimumLoss(price: Array[Long]): Int = {
    price
      .sorted
      .reverse
      .sliding(2)
      .filter {
        case Array(p1, p2) => price.indexOf(p1) < price.indexOf(p2)
      }
      .map {
        case Array(p1, p2) => (p1 - p2).toInt
      }
      .min
  }
}
