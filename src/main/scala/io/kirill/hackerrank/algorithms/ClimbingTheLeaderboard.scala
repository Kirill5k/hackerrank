package io.kirill.hackerrank.algorithms

object ClimbingTheLeaderboard {

  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {
    val remainingScores = scores.distinct
    var i = remainingScores.length - 1

    alice.map { a =>
      while (i >= 0 && remainingScores(i) <= a) {
        i -= 1
      }
      i + 2
    }
  }
}
