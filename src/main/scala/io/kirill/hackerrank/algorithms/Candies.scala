package io.kirill.hackerrank.algorithms

import scala.util.Try

object Candies {

  def candies(n: Int, arr: Array[Int]): Long = {
    val candies = Array.fill[Long](n)(1)
    for (i <- 0 until arr.length - 1) {
      if (arr(i+1) > arr(i)) {
        candies(i+1) = candies(i) + 1
      }
    }
    for (i <- arr.length-1 until 0 by -1) {
      if (arr(i-1) > arr(i) && candies(i-1) <= candies(i)) {
        candies(i-1) = candies(i) + 1
      }
    }

    candies.sum
  }
}
