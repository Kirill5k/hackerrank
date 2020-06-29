package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BiggerIsBetterSpec extends AnyWordSpec with Matchers {

  "BiggerIsBetter::biggerIsGreater" should {

    "find the next word in lexicographical order" in {
      BiggerIsBetter.biggerIsGreater("abcd") must be ("abdc")
      BiggerIsBetter.biggerIsGreater("ab") must be ("ba")
      BiggerIsBetter.biggerIsGreater("bb") must be ("no answer")
      BiggerIsBetter.biggerIsGreater("hefg") must be ("hegf")
      BiggerIsBetter.biggerIsGreater("dhck") must be ("dhkc")
      BiggerIsBetter.biggerIsGreater("dkhc") must be ("hcdk")
      BiggerIsBetter.biggerIsGreater("fedcbabcd") must be ("fedcbabdc")
    }
  }
}
