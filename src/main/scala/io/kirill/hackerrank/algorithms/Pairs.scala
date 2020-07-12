package io.kirill.hackerrank.algorithms

object Pairs {

  def pairs(k: Int, arr: Array[Int]): Int = {
    val nums = arr.toSet
    arr.foldLeft(0) { (res, el) => if (nums.contains(el+k)) res + 1 else res }
  }
}
