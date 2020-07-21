package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TheFullCountingSortSpec extends AnyWordSpec with Matchers {

  "TheFullCountingSort::sort" should {
    "return sorted array" in {
      val s0 = Array(Array("1", "e"),Array("2", "a"),Array("1", "b"),Array("3", "a"),Array("4", "f"),Array("1", "f"),Array("2", "a"),Array("1", "e"),Array("1", "b"),Array("1", "c"))
      TheFullCountingSort.sort(s0) must be ("- - f e b c - a - -")
      val s1 = Array(Array("0","a"), Array("1","b"), Array("0","c"), Array("1","d"))
      TheFullCountingSort.sort(s1) must be ("- c - d")
      val s2 = Array(Array("0", "ab"),Array("6", "cd"),Array("0", "ef"),Array("6", "gh"),Array("4", "ij"),Array("0", "ab"),Array("6", "cd"),Array("0", "ef"),Array("6", "gh"),Array("0", "ij"),Array("4", "that"),Array("3", "be"),Array("0", "to"),Array("1", "be"),Array("5", "question"),Array("1", "or"),Array("2", "not"),Array("4", "is"),Array("2", "to"),Array("4", "the"))
      TheFullCountingSort.sort(s2) must be ("- - - - - to be or not to be - that is the question - - - -")
    }
  }
}
