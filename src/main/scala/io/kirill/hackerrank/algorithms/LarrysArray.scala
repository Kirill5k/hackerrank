package io.kirill.hackerrank.algorithms

object LarrysArray {

  def larrysArray(a: Array[Int]): String = {
    if((countInversions(a) % 2) == 0) "YES" else "NO"
  }

  private def countInversions(a: Array[Int]): Int = {
    val counts = for {
      x <- 0 until (a.length - 1)
      y <- (x + 1) until a.length
    } yield if (a(x) > a(y)) 1 else 0
    counts.sum
  }
}
