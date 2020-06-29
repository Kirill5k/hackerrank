package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TheTimeInWordsSpec extends AnyWordSpec with Matchers {

  "TheTimeInWords::timeInWords" should {

    "convert time into words" in {
      TheTimeInWords.timeInWords(5, 0) must be ("five o' clock")
      TheTimeInWords.timeInWords(5, 15) must be ("quarter past five")
      TheTimeInWords.timeInWords(5, 30) must be ("half past five")
      TheTimeInWords.timeInWords(5, 45) must be ("quarter to six")
      TheTimeInWords.timeInWords(12, 45) must be ("quarter to one")
      TheTimeInWords.timeInWords(5, 10) must be ("ten minutes past five")
      TheTimeInWords.timeInWords(5, 39) must be ("twenty one minutes to six")
      TheTimeInWords.timeInWords(5, 47) must be ("thirteen minutes to six")
      TheTimeInWords.timeInWords(1, 1) must be ("one minute past one")
    }
  }
}
