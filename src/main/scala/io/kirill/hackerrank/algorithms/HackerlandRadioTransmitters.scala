package io.kirill.hackerrank.algorithms

object HackerlandRadioTransmitters {

  def hackerlandRadioTransmitters(x: Array[Int], k: Int): Int = {
    val sorted = x.sorted
    var transmittersCount = 0
    val n = x.length
    var i = 0
    while (i < n) {
      transmittersCount += 1
      var loc = sorted(i) + k
      while (i < n && sorted(i) <= loc) i += 1
      i -= 1
      loc = sorted(i) + k
      while (i < n && sorted(i) <= loc) i += 1
    }

    transmittersCount
  }
}
