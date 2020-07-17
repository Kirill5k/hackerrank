package io.kirill.hackerrank.algorithms

object FraudulentActivityNotifications {

  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    val e = d % 2 == 0
    val mid = d/2
    var notifications = 0
    for (i <- 0 until expenditure.length - 1 - d) {
      val past = expenditure.slice(i, i+d).sorted
      val today = expenditure(i+d)
      val med = median(past, mid, e)
      if (med * 2 <= today) {
        notifications += 1
      }
    }

    notifications
  }

  def median(expenses: Array[Int], mid: Int, e: Boolean): Double = {
    if (e) (expenses(mid) + expenses(mid+1)) / 2.0
    else expenses(mid)
  }
}
