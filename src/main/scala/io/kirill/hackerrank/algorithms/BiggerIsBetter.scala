package io.kirill.hackerrank.algorithms

object BiggerIsBetter {

  def biggerIsGreater(w: String): String = {
    val suffix = longestNonIncreasingSuffix(w)
    if (suffix == w) "no answer"
    else {
      val pivot = w.length - suffix.length - 1
      val successor = findPivotSuccessor(w, pivot)
      val swapped = swap(w, pivot, successor)
      swapped.substring(0, pivot+1) + swapped.substring(pivot+1).reverse
    }
  }

  private def findPivotSuccessor(s: String, pivot: Int): Int = {
    val pivotC = s.charAt(pivot)
    def go(i: Int): Int = {
      val successorC = s.charAt(i)
      if (pivotC < successorC) i else go(i-1)
    }
    go(s.length-1)
  }

  private def longestNonIncreasingSuffix(s: String): String = {
    @scala.annotation.tailrec
    def go(res: String, i: Int): String = {
      if (i <= 0) res
      else {
        val p1 = s.charAt(i)
        val p2 = s.charAt(i-1)
        if (p2 >= p1) go(p2 +: res, i-1) else res
      }
    }
    go("" :+ s.charAt(s.length-1), s.length-1)
  }

  private def swap(s: String, p1: Int, p2: Int): String = {
    val c1 = s.charAt(p1)
    val c2 = s.charAt(p2)
    s.updated(p2, c1).updated(p1, c2)
  }
}
