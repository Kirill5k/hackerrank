package io.kirill.hackerrank.algorithms

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EncryptionSpec extends AnyWordSpec with Matchers {

  "EncryptionSpec" should {
    "encrypt string" in {
      Encryption.encrypt("haveaniceday") must be ("hae and via ecy")
      Encryption.encrypt("feedthedog") must be ("fto ehg ee dd")
      Encryption.encrypt("chillout") must be ("clu hlt io")
    }
  }
}
