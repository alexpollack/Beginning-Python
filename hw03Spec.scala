package pl.hw03

import org.scalactic.Tolerance._
import org.scalatest.FlatSpec

import hw03._

class hw03Spec extends FlatSpec {
   
   // Tests for Problem 1
   
   "and" should "implement 'e1 && e2'" in {
     // check truth table for && 
     assert (and(true, true) === true)
     assert (and(true, false) === false)
     assert (and(false, true) === false)
     assert (and(false, false) === false)
     
     // check short-circuiting
     assert (and(false, {1 / 0; false}) === false)
     intercept[ArithmeticException] (and(true, {1 / 0; false}))
   }

  "or" should "implement 'e1 || e2'" in {
    // check truth table for || 
    assert (or(true, true) === true)
    assert (or(true, false) === true)
    assert (or(false, true) === true)
    assert (or(false, false) === false)

    // check short-circuiting
    assert (or(true, {1 / 0; false}) === true)
    intercept[ArithmeticException] (or(false, {1 / 0; false}))
  }

  // Tests for Problem 2
  
  "cubicRoot" should "compute the cubic root of 'c' up to error 'epsilon'" in {
      //val epsilon = 0.0001
    val epsilon = 0.0001

    val cs = List(0.0, 8.0, 27.0, 64.0)

    for (c <- cs) {
      val croot = cubicRoot(c, epsilon)
      assert (math.abs(croot * croot * croot - c) < epsilon)
    }
      /*assert(cubicRoot(0, epsilon) === 0)
      assert(cubicRoot(8, epsilon) === 2.0 +- epsilon)
      assert(cubicRoot(27, epsilon) === 3.0 +- epsilon)
      assert(cubicRoot(64, epsilon) === 4.0 +- epsilon)*/
   }


   // Tests for Problem 3
   
   "isSorted" should "check whether the array 'a' is strictly sorted in increasing order" in {
      assert(isStrictlySorted(Array()))
      assert(isStrictlySorted(Array(Int.MinValue, Int.MaxValue)))
      assert(isStrictlySorted(Array(-1, 1, 2, 3)))
      assert(!isStrictlySorted(Array(-1, 1, 1, 2, 3)))
      assert(!isStrictlySorted(Array(3, 2, 1)))
      assert(!isStrictlySorted(Array(1, 2, -1, 3)))
   }
   
   "binarySearch" should "return the smallest index of 'a' whose value is greater or equal to 'x'" in {
      assert(binarySearch(1, Array()) === 0)
      assert(binarySearch(2, Array(1, 2, 3)) === 1)
      assert(binarySearch(0, Array(1, 2, 3)) === 0)
      assert(binarySearch(2, Array(1, 3, 4)) === 1)
      assert(binarySearch(4, Array(1, 2, 3)) === 3)
   }
}