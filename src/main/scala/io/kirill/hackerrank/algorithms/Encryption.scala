package io.kirill.hackerrank.algorithms

object Encryption {

  def encrypt(text: String): String = {
    val textWithoutSpaces = text.replaceAll(" ", "")
    val (x, y) = gridDimensions(textWithoutSpaces.length)
    val rows = textWithoutSpaces.grouped(x).toList
    (0 to y).map(i => rows.map(s => if (s.length <= i) "" else s.charAt(i).toString).mkString).mkString(" ").trim
  }

  private def gridDimensions(l: Int): (Int, Int) = {
    val x = math.sqrt(l).ceil.intValue
    val y = math.sqrt(l).floor.intValue
    if (x * y < l) gridDimensions(l+1) else (x, y)
  }
}
