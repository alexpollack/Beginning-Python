package pl.hw05

import scala.annotation.tailrec

object hw05 extends App {

  // Problem 1: Tail Recursion

  // Naive inefficient implementation of binom used for testing
  def binomNaive(n: Int, k: Int): Int = {
    require(0 <= k && k <= n)
    if (n == k || k == 0) 1
    else binomNaive(n - 1, k - 1) + binomNaive(n - 1, k)
  }

  @tailrec def binomTail(num: Int, denom: Int, n: Int, k: Int): Int = {
    require(0 <= k && k <= n)
    if (k == 0 || k == n) num / denom else binomTail(n * num, k * denom, n - 1, k - 1)
  }

  // Your implementation of Part 1
  def binom(n0: Int, k0: Int): Int = binomTail(1, 1, n0, k0) //{
  //require (0 <= k && k <= n)
  //???
  //}


  // Naive inefficient implementation of trib used for testing
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

  // Your implementation of Part 2
  def trib(n: Int): Int = tribTail(n,n,1,1,0)

  
}
