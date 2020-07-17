package io.kirill.hackerrank.algorithms

object FraudulentActivityNotifications {

  /*

  function activityNotifications (expenditure, d) {

    // Number of notifications
    let n = 0

    // Set midpoints for median calculation
    let [ i1, i2 ] = [ Math.floor((d-1)/2), Math.ceil((d-1)/2) ]
    let m1, m2, m

    // Initialize count sorted subarray
    let cs = new Array(201).fill(0)
    for (let i = d-1; i >= 0; i--) cs[expenditure[i]]++

    // Iterate through expenditures
    for (let i = d, l = expenditure.length; i < l; i++) {

        // Find median
        for (let j = 0, k = 0; k <= i1; k += cs[j], j++) m1 = j
        for (let j = 0, k = 0; k <= i2; k += cs[j], j++) m2 = j
        let m = (m1 + m2) / 2

        // Check if notification is given
        if (expenditure[i] >= m * 2) n++

        // Replace subarray elements
        cs[expenditure[i-d]]--
        cs[expenditure[i]]++
    }

    return n
}

   */


  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    var notifications = 0
    val (i1, i2) = (math.floor((d-1)/2.0).toInt, math.ceil((d-1)/2.0).toInt)
    val counts = Array.fill(201)(0)
    (0 until d).foreach(i => counts(expenditure(i)) = counts(expenditure(i)) + 1)
    for (i <- d until expenditure.length) {
      val m1 = getMedianPoint(counts, i1)
      val m2 = getMedianPoint(counts, i2)
      val m = (m1+m2)/2.0
      if (expenditure(i) >= m * 2) {
        notifications += 1
      }
      counts(expenditure(i-d)) = counts(expenditure(i-d)) - 1
      counts(expenditure(i)) = counts(expenditure(i-d)) + 1
    }
    notifications
  }

  @scala.annotation.tailrec
  def getMedianPoint(counts: Array[Int], i: Int, k: Int = 0, j: Int = 0): Int = {
    if (k > i) j
    else {
      getMedianPoint(counts, i, k + counts(j), j+1)
    }
  }
}
