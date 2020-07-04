package io.kirill.hackerrank.algorithms

object SherlockAndTheValidString {

  import scala.collection.immutable.Map

  def isValid(s: String): String = {
    val charCounts = s.foldLeft(Map[Char, Int]())((res, c) => res + (c -> res.get(c).fold(1)(_+1)))

    val counts = charCounts.values.foldLeft(Map[Int, Int]())((res, i) => res + (i -> res.get(i).fold(1)(_+1)))

    if (counts.size == 1 || canRemoveChar(counts)) "YES" else "NO"
  }

  private def canRemoveChar(counts: Map[Int, Int]): Boolean = {
    val c1 = counts.keys.min
    val c2 = counts.keys.max
    counts.size == 2 && counts.values.toList.contains(1) && (math.abs(c1-c2) == 1 || counts(c1) == 1)
  }
}
