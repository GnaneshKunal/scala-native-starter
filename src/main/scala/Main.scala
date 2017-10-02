import scalanative.native._

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
  def malloc(size: CSize): Ptr[Byte] = extern
  def free(ptr: Ptr[Byte]): Unit = extern
}