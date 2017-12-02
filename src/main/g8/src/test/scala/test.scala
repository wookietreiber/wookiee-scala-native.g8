package $name$

import utest._

object Tests extends TestSuite {
  val tests = Tests {
    'a - {
      val xs = 1 :: 2 :: 3 :: Nil
      assert(xs.sum == 6)
    }
  }
}
