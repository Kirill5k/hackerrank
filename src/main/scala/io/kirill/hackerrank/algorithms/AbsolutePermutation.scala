package io.kirill.hackerrank.algorithms

object AbsolutePermutation {

  def absolutePermutation(n: Int, k: Int): Array[Int] = {
    if (k == 0) (1 to n).toArray
    else if ((n.toDouble/k) % 2 != 0) Array(-1)
    else {
      var j = k + 1
      val result = scala.collection.mutable.ListBuffer[Int]()
      while (result.size < n) {
        (0 until k).foreach(_ => result.append(result.size + j))
        j = if (j == 1 + k) 1 - k else 1 + k
      }
      result.toArray
    }
  }
}
