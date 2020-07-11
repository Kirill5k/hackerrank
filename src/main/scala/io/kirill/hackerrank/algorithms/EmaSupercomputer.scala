package io.kirill.hackerrank.algorithms


object EmaSupercomputer {

  type Cross = (Int, Int, Int)

  def twoPluses(grid: Array[String]): Int = {
    var crosses = scala.collection.immutable.List[Cross]()
    for (x <- 1 until grid.length - 1; y <- 1 until grid.head.length - 1) {
      val (l1, l2, l3, c) = (grid(x-1), grid(x), grid(x+1), grid(x).charAt(y))
      if (c == 'G' && l2.charAt(y-1) == c && l2.charAt(y+1) == c && l1.charAt(y) == c && l3.charAt(y) == c) {
        val (width, height) = (findMaxWidth(grid, c, x, y, 0), findMaxHeight(grid, c, x, y, 0))
        val crossLength = if (height == width) height else math.min(height, width)
        for (l <- 1 to crossLength) {
          crosses = crosses :+ (x, y, l)
        }
      }
    }

    val pairs = crosses
      .combinations(2)
      .filter {
        case scala.collection.immutable.List(c1, c2) => c1._1 != c2._1 && c1._2 != c2._2
      }
      .filter {
        case scala.collection.immutable.List(c1, c2) => areNotOverlapping(c1, c2)
      }
      .map {
        case scala.collection.immutable.List(c1, c2) => (c1._3 * 4 + 1) * (c2._3 * 4 + 1)
      }

    if (pairs.isEmpty && crosses.isEmpty) 1
    else if (pairs.isEmpty) crosses.head._3 * 4 + 1
    else pairs.max
  }

  private def areNotOverlapping(c1: Cross, c2: Cross): Boolean = {
    val c1xs = (c1._1 - c1._3 to c1._1 + c1._3).map(x => (x, c1._2)).toSet
    val c1ys = (c1._2 - c1._3 to c1._2 + c1._3).map(y => (c1._1, y)).toSet

    val c2xs = (c2._1 - c2._3 to c2._1 + c2._3).map(x => (x, c2._2)).toSet
    val c2ys = (c2._2 - c2._3 to c2._2 + c2._3).map(y => (c2._1, y)).toSet

    c1xs.forall(coords => !c2xs.contains(coords) && !c2ys.contains(coords)) && c1ys.forall(coords => !c2xs.contains(coords) && !c2ys.contains(coords))
  }

  @scala.annotation.tailrec
  private def findMaxWidth(grid: Array[String], c: Char, x: Int, y: Int, current: Int): Int = {
    val next = current + 1
    if (y - next < 0 || y + next >= grid.head.length) current
    else {
      if (grid(x).charAt(y-next) == c && grid(x).charAt(y+next) == c) findMaxWidth(grid, c, x, y, next)
      else current
    }
  }

  @scala.annotation.tailrec
  private def findMaxHeight(grid: Array[String], c: Char, x: Int, y: Int, current: Int): Int = {
    val next = current + 1
    if (x - next < 0 || x + next >= grid.length) current
    else {
      if (grid(x-next).charAt(y) == c && grid(x+next).charAt(y) == c) findMaxHeight(grid, c, x, y, next)
      else current
    }
  }
}
