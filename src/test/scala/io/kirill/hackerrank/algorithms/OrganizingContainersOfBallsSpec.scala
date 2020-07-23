package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OrganizingContainersOfBallsSpec extends AnyWordSpec with Matchers {

  "OrganizingContainersOfBalls::organizingContainers" should {
    "tell whether it is possible to sort containers" in {
      OrganizingContainersOfBalls.organizingContainers(Array(Array(997612619,934920795,998879231,999926463),Array(960369681,997828120,999792735,979622676),Array(999013654,998634077,997988323,958769423),Array(997409523,999301350,940952923,993020546))) must be ("Possible")
      OrganizingContainersOfBalls.organizingContainers(Array(Array(1,3,1),Array(2,1,2),Array(3,3,3))) must be ("Impossible")
      OrganizingContainersOfBalls.organizingContainers(Array(Array(0,2,1),Array(1,1,1),Array(2,0,0))) must be ("Possible")
    }
  }
}
