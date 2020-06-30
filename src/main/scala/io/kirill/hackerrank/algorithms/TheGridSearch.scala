package io.kirill.hackerrank.algorithms

object TheGridSearch {

  def gridSearch(g: Array[String], p: Array[String]): String = {
    val patternTopRow = p.head
    val patternLength = patternTopRow.length
    val positions = g.zipWithIndex
      .map {
        case (row, i) => (i, getPositions(row, p.head))
      }
      .filter(rowPos => rowPos._2.nonEmpty)
      .flatMap {
        case (r, is) => is.map(i => (r, i))
      }

    val patternExists = positions.exists(ri => containsPattern(g, p, ri._1, ri._2, patternLength))
    if (patternExists) "YES" else "NO"
  }

  private def getPositions(row: String, pattern: String, prevPos: Int = 0, positions: List[Int] = Nil): List[Int] =
    if (!row.substring(prevPos).contains(pattern)) positions
    else {
      val pos = row.indexOf(pattern, prevPos)
      getPositions(row, pattern, pos+1, positions :+ pos)
    }

  private def containsPattern(grid: Array[String], pattern: Array[String], row: Int, pos: Int, length: Int): Boolean = {
    val rows = grid.slice(row, row + pattern.length).map(_.substring(pos, pos + length))
    rows.mkString("") == pattern.mkString("")
  }
}
