package io.kirill.hackerrank.algorithms

object GoodlandElectricity {

  def pylons(k: Int, arr: Array[Int]): Int = {
    @scala.annotation.tailrec
    def go(pos: Int, range: Int, towers: Int): Int = {
      if (range >= arr.length) towers
      else {
        if (arr(pos) == 1) {
          val newRange = pos + k
          val newPos = newRange + k - 1
          if (newPos >= arr.length) go(arr.length-1, newRange, towers+1) else go(newPos, newRange, towers+1)
        } else {
          val newPos = pos-1
          if (newPos < range - k + 1 || newPos < 0) -1
          else go(newPos, range, towers)
        }
      }
    }

    go(k-1, 0, 0)
  }
}
