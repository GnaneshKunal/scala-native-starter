package MainTests

import utest._
import scalanative.native._

object MainTests extends TestSuite {

  val c = libc.malloc(20)

  hello.greet(c, 20)

  stdio.puts(c)

  val tests = Tests {
    'HelloWorldTest - {
      c == c"Hello, World"
    }
  }
  libc.free(c)
}

@extern
@link("hello")
object hello {
  def greet(str: CString, n: CInt): CString = extern
}

@extern
object libc {
  def malloc(size: CSize): Ptr[Byte] = extern
  def free(ptr: Ptr[Byte]): Unit = extern
}