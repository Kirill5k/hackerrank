package io.kirill.hackerrank.algorithms

object LilysHomework {

  def lilysHomework(arr: Array[Int]): Int = {
    val valToKey = arr.zipWithIndex.toMap
    val sorted = arr.sorted
    val s1 = findMinAmountOfSwaps(arr.clone(), sorted, valToKey)
    val s2 = findMinAmountOfSwaps(arr.clone(), sorted.reverse, valToKey)
    math.min(s1, s2)
  }

  @scala.annotation.tailrec
  def findMinAmountOfSwaps(input: Array[Int], ref: Array[Int], valToInd: Map[Int, Int], i: Int = 0, swaps: Int = 0): Int = {
    if (i >= input.length) swaps
    else {
      val iv = input(i)
      val rv = ref(i)
      if (iv == rv) findMinAmountOfSwaps(input, ref, valToInd, i+1, swaps)
      else {
        val irv = valToInd(rv)
        input(i) = rv
        input(irv) = iv
        findMinAmountOfSwaps(input, ref, valToInd + (iv -> irv), i+1, swaps+1)
      }
    }
  }
}
