package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class SherlockAndAnagramsSpec extends AnyWordSpec with Matchers {

  "SherlockAndAnagrams::sherlockAndAnagrams" should {

    "estimate the number of anagrams in string" in {
      SherlockAndAnagrams.sherlockAndAnagrams("pvmupwjjjf") must be (6)
      SherlockAndAnagrams.sherlockAndAnagrams("abba") must be (4)
      SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq") must be (3)
      SherlockAndAnagrams.sherlockAndAnagrams("cdcd") must be (5)
      SherlockAndAnagrams.sherlockAndAnagrams("kkkk") must be (10)
    }
  }

}
