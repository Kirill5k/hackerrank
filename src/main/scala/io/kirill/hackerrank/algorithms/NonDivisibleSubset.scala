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

    remainders.foldLeft(Map[Int, List[Int]]()) {
      case (res, (r, nums)) => if (!res.contains(k-r)) res + (r -> nums) else res
    }.values.flatten.size
  }
}
