import scala.annotation.tailrec

object set3 extends App {

  // Using Tail Recursion

  // an inefficient implementation of binomial method
  def binomNaive(n: Int, k: Int): Int = {
    require(0 <= k && k <= n)
    if (n == k || k == 0) 1
    else binomNaive(n - 1, k - 1) + binomNaive(n - 1, k)
  }

  @tailrec def binomTail(num: Int, denom: Int, n: Int, k: Int): Int = {
    require(0 <= k && k <= n)
    if (k == 0 || k == n) num / denom else binomTail(n * num, k * denom, n - 1, k - 1)
  }



  // an inefficient implementation of trib 
  def tribNaive(n: Int): Int = {
    require(0 <= n)
    n match {
      case 0 | 1 => 0
      case 2 => 1
      case _ => tribNaive(n - 1) + tribNaive(n - 2) + tribNaive(n - 3)
    }
  }

  @tailrec def tribTail(n0: Int, n: Int, a: Int, b: Int, c: Int): Int = {
    require(0 <= n)
    if (n0 == 0 | n0 == 1) 0
    else if (n == 0 | n == 1) return a
    else if (n == 2 | n == 3) tribTail(n0,n-1,a,a,a)
    else tribTail(n0,n-1,a+b+c,a,b)
  }

  def trib(n: Int): Int = tribTail(n,n,1,1,0)

  
}
