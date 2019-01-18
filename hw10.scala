package hw10

import scala.collection.immutable.AbstractMap
import scala.language.implicitConversions

object hw10 {
  
  sealed abstract class TreeMap[+A] extends AbstractMap[Int, A] {
    def add[B >: A](kv: (Int, B)): TreeMap[B] = {
      val (key, value) = kv
      this match {
        case Leaf() => Node(key, value, Leaf(), Leaf())
        case Node(key1, value1, left, right) =>
          if (key < key1) Node(key1, value1, left.add((key, value)), right)
          else if (key > key1) Node(key1, value1, left, right.add((key, value)))
          else if (key == key1) Node(key1, value, left, right)
          else this
       }
    }

    def deleteMin: ((Int, A), TreeMap[A]) = {
      require(!this.isEmpty, "Empty map")

      def blank[A]: TreeMap[A] = Leaf()
      val kvlist: List[(Int, A)] = this.toList
      val key = kvlist(0)._1
      val value: A = kvlist(0)._2
      def min[A](l: List[(Int, A)], k: Int, v: A): (Int, A) = l match {
        case Nil => (k, v)
        case x :: xs => x match {
          case (key1, value1) => {if (k > key1) min[A](xs, key1, value1) else min[A](xs, k, v)}
          case  _ => (k, v)

        }
      }
      val minimum = min[A](kvlist, key, value)
      val newList = kvlist.filter( _ != minimum)
      def makeTree[A](k: List[(Int, A)]): TreeMap[A] = k.foldLeft(blank[A])(_ add _)
      val tree = makeTree[A](newList)
      (minimum, tree)

    }
    
    def delete(key: Int): TreeMap[A] =  {
      val kvlist: List[(Int, A)] = this.toList
      def blank[A]: TreeMap[A] = Leaf()
      val newList = kvlist.filter(x=>x._1 != key)
      def makeTree[A](k: List[(Int, A)]): TreeMap[A] = k.foldLeft(blank[A])(_ add _)
      val tree = makeTree[A](newList)
      tree

    }

    def get(key: Int): Option[A] = this match {
      case Leaf() => None
      case Node(key1, value, left, right) =>
        if (key == key1) Some(value)
        else if (key < key1) left.get(key)
        else right.get(key)
    }
    
    def +[A1 >: A](kv: (Int, A1)): TreeMap[A1] = this.add(kv)

    def -(k: Int): TreeMap[A] = this.delete(k)
    
    override def toList: List[(Int, A)] = this match {
      case Leaf() => Nil
      case Node(key, value, left, right) => 
        left.toList ::: (key, value) :: right.toList
    }

    def iterator: Iterator[(Int, A)] = toList.iterator
  }
  
  case class Leaf() extends TreeMap[Nothing]
  case class Node[+A](key: Int, value: A, 
                      left: TreeMap[A], right: TreeMap[A]) extends TreeMap[A]

  object TreeMap {
    def empty[A]: TreeMap[A] = Leaf()
    
    def apply[A](kvs: (Int, A)*): TreeMap[A] = 
      kvs.toSeq.foldLeft(empty[A])(_ + _)
  }
    
  
}
