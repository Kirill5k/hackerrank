package io.kirill.hackerrank.algorithms

object TheTimeInWords {

  val digitsToWords = Map(
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen",
    20 -> "twenty",
  )

  def timeInWords(h: Int, m: Int): String = m match {
    case 0 => s"${digitsToWords(h)} o' clock"
    case 15 => s"quarter past ${digitsToWords(h)}"
    case 30 => s"half past ${digitsToWords(h)}"
    case 45 => s"quarter to ${if (h == 12) digitsToWords(1) else digitsToWords(h+1)}"
    case x if x <= 20 => s"${digitsToWords(m)} ${if (m == 1) "minute" else "minutes"} past ${digitsToWords(h)}"
    case x if x > 21 && x < 30 =>
      s"${digitsToWords(20)} ${digitsToWords(m-20)} minutes past ${digitsToWords(h)}"
    case x if x > 30 && x < 40 =>
      s"${digitsToWords(20)} ${digitsToWords(60-m-20)} minutes to ${if (h == 12) digitsToWords(1) else digitsToWords(h+1)}"
    case x if x >= 40 =>
      s"${digitsToWords(60-m)} ${if (60-m == 1) "minute" else "minutes"} to ${if (h == 12) digitsToWords(1) else digitsToWords(h+1)}"
  }
}
