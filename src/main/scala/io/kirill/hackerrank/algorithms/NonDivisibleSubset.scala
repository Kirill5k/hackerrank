package io.kirill.hackerrank.algorithms

object NonDivisibleSubset {

  def nonDivisibleSubset(k: Int, s: Array[Int]): Int = {
    val remainders = s.map(i => (i, i % k))
      .groupBy(_._2)
      .view.mapValues(_.toList.map(_._1))
      .map {
        case (r, nums) => if (r == 0 || (k % 2 == 0 && r == k /2)) (r, List(nums.head)) else (r, nums)
      }
      .toList
      .sortBy(_._2.size)
      .reverse

    val numbers = scala.collection.mutable.Map[Int, List[Int]]()

    remainders.foreach {
      case (r, nums) =>
        if (!numbers.contains(k-r)) {
          numbers(r) = nums
        }
    }

    numbers.values.flatten.size
  }
}
