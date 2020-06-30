package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TheGridSearchSpec extends AnyWordSpec with Matchers {

  "TheGridSearch::gridSearch" should {
    "return yes if 2d pattern exists in grid" in {
      val g1 = Array("1234567890", "0987654321", "1111111111", "1111111111", "2222222222")
      val p1 = Array("876543", "111111", "111111")
      TheGridSearch.gridSearch(g1, p1) must be ("YES")

      val g2 = Array("7283455864","6731158619","8988242643","3830589324","2229505813","5633845374","6473530293","7053106601","0834282956","4607924137")
      val p2 = Array("9505", "3845", "3530")
      TheGridSearch.gridSearch(g2, p2) must be ("YES")

      val g3 = Array("123412","561212","123634","781288")
      val p3 = Array("12", "34")
      TheGridSearch.gridSearch(g3, p3) must be ("YES")
    }

    "return no if 2d pattern does not exist in grid" in {
      val g1 = Array("1234567890", "0987654321", "1111111111", "1111111111", "2222222222")
      val p1 = Array("876543", "111211", "111111")
      TheGridSearch.gridSearch(g1, p1) must be ("NO")
    }
  }
}
