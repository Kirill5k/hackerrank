package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FraudulentActivityNotificationsSpec extends AnyWordSpec with Matchers {

  "FraudulentActivityNotifications::activityNotifications" should {
    "return amount of notification that will be sent" in {
//      FraudulentActivityNotifications.activityNotifications(Array(10,20,30,40,50), 3) must be (1)
      FraudulentActivityNotifications.activityNotifications(Array(2,3,4,2,3,6,8,4,5), 5) must be (2)
//      FraudulentActivityNotifications.activityNotifications(Array(1,2,3,4,4), 4) must be (0)
    }
  }
}
