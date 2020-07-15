package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ClimbingTheLeaderboardSpec extends AnyWordSpec with Matchers {

  "ClimbingTheLeaderboard::climbingLeaderboard" should {
    "return rank based on score" in {
      val s1 = Array(100,90,90,80,75,60)
      val a1 = Array(50,65,77,90,102)
      ClimbingTheLeaderboard.climbingLeaderboard(s1, a1) must be (Array(6,5,4,2,1))

      val s2 = Array(100, 100, 50, 40, 40, 20, 10)
      val a2 = Array(5,25,50,120)
      ClimbingTheLeaderboard.climbingLeaderboard(s2, a2) must be (Array(6,4,2,1))
    }
  }
}
