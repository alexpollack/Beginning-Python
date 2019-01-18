package scala.math

object set1 extends App {

  //Short-circuit Evaluation
  
  // this will implement 'e1 && e2'
  def and(e1: => Boolean, e2: => Boolean): Boolean = {
    if(e1) {
      if(e2) {
        return true;
      }
      else {
        return false;
      }
      }
    else {
      return false;
    }
  }
  
  // this will implement 'e1 || e2'
  def or(e1: => Boolean, e2: => Boolean): Boolean = {
    if(e1) {
      return true;
    }
    else {
      if(e2) {
        return true;
      }
      else {
        return false;
      }
    }
  }
  
  // Simple Newton's Method
  
  def cubicRoot(c: Double, epsilon: Double): Double = {
    require (c >= 0) // makes sure that we don't call cubicRoot with negative values
    require (epsilon >= 0) // the error bound should also be positive
    
    var xn: Double = 1.0; // insert appropriate value to initialize xn

    while( math.abs(xn*xn*xn - c) > epsilon) {
      xn = ( c/(xn*xn) + 2.0*xn)/3.0
    }

    return xn
  }

  // Simple Binary Search

  def isStrictlySorted(a: Array[Int]): Boolean = {
    require (a != null) // make sure that 'a' isn't null
    var i: Int = 1
    while( i < a.length) {
      if (a(i - 1) >= a(i)) {
        return false
      }
      i = i + 1
    }
    return true

  }

  def binarySearch(x: Int, a: Array[Int]): Int = {
    require (a != null && isStrictlySorted(a)) // make sure that 'a' isn't null and sorted
    var m: Int = 0
    var range = Array(0, a.length - 1)
    var big: Boolean = false
    var eq: Boolean = false

    if( a.length % 2 == 0) {
      m = a.length/2
    }
    else {
      m = (a.length - 1)/2
    }
    if(a.length !=0) {
      while (big != true && eq != true) {

        if (x > a(m)) {
          if( m == a.length - 1 | m > a.length ) {
            big = true
          }
          else if (m == 0) {
            eq = true
          }
          else {
            if(m % 2 == 0) {
              m = (range(1) + m )/ 2
              range(0) = m
            }
            else {
              m = (range(1) + 1 + m) / 2
              range(0) = m
            }
          }
          if ( range(0) == range(1) ) {
            m = m+1
            eq = true
          }
        }
        else if (x < a(m)) {
          if (m == 0) {
            eq = true
          }
          else if (m % 2 == 0) {
            m = m / 2
          }
          else {
            m = (m - 1) / 2
          }
          range(1) = m
        }
        else if ( a(m) == x) {
          eq = true
        }
      }
    }
    if( eq ) {
      return m
    }
    else if( big ) {
      return a.length
    }
    else {
      return a.length
    }

  }
}
