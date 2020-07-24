package io.kirill.hackerrank.algorithms

object GoodlandElectricity {

  def pylons(k: Int, arr: Array[Int]): Int = {
    @scala.annotation.tailrec
    def go(pos: Int, coverage: Int, towers: Int): Int = {
      if (coverage >= arr.length) towers
      else if (pos < coverage - k + 1 || pos < 0) -1
      else {
        if (arr(pos) == 1) {
          val newCoverage = pos + k
          val newPos = newCoverage + k - 1
          if (newPos >= arr.length) go(arr.length-1, newCoverage, towers+1) else go(newPos, newCoverage, towers+1)
        } else go(pos-1, coverage, towers)
      }
    }

    go(k-1, 0, 0)
  }
}
