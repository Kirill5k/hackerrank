package io.kirill.hackerrank.algorithms

object SherlockAndAnagrams {

  def sherlockAndAnagrams(s: String): Int = {
    val chars = s.toList.map(_.toString)
    val allSubstrings = (1 until s.length)
      .flatMap(i => chars.sliding(i))
      .map(_.sorted.mkString)
      .groupBy(identity)

    allSubstrings
      .values
      .map(_.size)
      .filter(_ > 1)
      .map(c => (c*(c-1))/2)
      .sum
  }
}
