import scalanative.native._
import scalanative._

object Main extends App{

  val c = libc.malloc(20)

  hello.greet(c, 20)

  stdio.puts(c)

  libc.free(c)

}

@extern
@link("hello")
object hello {
  def greet(str: CString, n: CInt): CString = extern
}
@extern
object libc {
  def malloc(size: native.CSize): native.Ptr[Byte] = native.extern
  def free(ptr: Ptr[Byte]): Unit = native.extern
}