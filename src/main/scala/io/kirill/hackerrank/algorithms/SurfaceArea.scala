package io.kirill.hackerrank.algorithms

object SurfaceArea {

  def surfaceArea(figure: Array[Array[Int]]): Int = {
    val h = figure.length
    val w = figure.head.length

    val coords = for {
      x <- 0 until h
      y <- 0 until w
    } yield (x, y)

    coords.map {
      case (x, y) =>
        val current = figure(x)(y)
        scala.collection.immutable.List(
          math.max(0, current - getHeight(figure, x - 1, y)),
          math.max(0, current - getHeight(figure, x + 1, y)),
          math.max(0, current - getHeight(figure, x, y - 1)),
          math.max(0, current - getHeight(figure, x, y + 1))
        ).sum
    }.sum + (h * w) * 2
  }

  private def getHeight(figure: Array[Array[Int]], x: Int, y: Int): Int =
    if (x < 0 || y < 0 || x >= figure.length || y >= figure.head.length) 0 else figure(x)(y)
}
