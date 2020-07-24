package io.kirill.hackerrank.algorithms

object GoodlandElectricity {

  def pylons(k: Int, arr: Array[Int]): Int = {
    @scala.annotation.tailrec
    def go(pos: Int, coverage: Int = 0, towers: Int = 0): Int = {
      if (coverage >= arr.length) towers
      else if (pos < coverage - k + 1 || pos < 0) -1
      else {
        if (arr(pos) == 1) {
          val newPos = if (pos + 2*k - 1 >= arr.length) arr.length-1 else pos + 2*k - 1
          go(newPos, pos+k, towers+1)
        } else go(pos-1, coverage, towers)
      }
    }

    go(k-1)
  }
}
