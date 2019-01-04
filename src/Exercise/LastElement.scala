package Exercise

import java.util.NoSuchElementException

object LastElement {

  def main(args: Array[String]): Unit = {
    val x = List(1, 1, 2, 3, 5, 8)

    def last[T](l: List[T]): T = {
      return l(l.length-1)
    }

    def penultimate[T](l: List[T]): T = {
      return l(l.length-2)
    }

    def nth[T](n:Int, l: List[T]): T = {
        return l(n)
    }

    def reverse[T](l: List[T]): List[T] = {
      var res = List[T]()
      for (i <- l) {
        res = i :: res
      }
      res
    }

    def reverse2[T](l: List[T]): List[T] = {
      l match {
        case  h :: tail => reverse(tail) ::: List(h)
        case Nil => Nil
      }
    }

    def isPalindrome[T](l: List[T]): Boolean = {
      val n = l.length
      if (n % 2 == 0) return false
      for (i <- 0 to n/2) {
        if(l(i) != reverse(l)(i)) return false
      }

      return true
    }

    def isPalindrome2[T](l: List[T]): Boolean = {
      if (l.length <= 1) {
        return true
      } else {
        if (l.head == l.last) {
          return isPalindrome2(l.tail.init)
        } else {return false}
      }
    }

    def flatten(l: List[Any]): List[Any] = l flatMap {
      case ls: List[_] => flatten(ls)
      case h => List(h)
    }

    def compress[T](l: List[T]): List[T] = {
      var res  = List[T]()
      var curValue = null.asInstanceOf[T]
      for (e <- l) {
        if (curValue != e) {
          curValue = e
          res = res ::: List(curValue)
        }
      }
      return res
    }

    def pack[A](l: List[A]):List[List[A]] = {
      def _pack(res: List[List[A]], rem: List[A]):List[List[A]] = rem match {
        case Nil => res
        case h::tail if (res.isEmpty || res.last.head != h) => _pack(res:::List(List(h)), tail)
        case h::tail => _pack(res.init:::List(res.last:::List(h)), tail)
      }
      _pack(List(),l)
    }


    def encode[T](l: List[T]): List[Any] = {
      var res = List[Any]()
      var curValue = l(0)
      var count = 0
      for (elem <- l) {
        if (curValue != elem) {
          if (count == 1) {
            res = res ::: List(curValue)
          } else {
            res = res ::: List((count, curValue))
          }
          curValue = elem
          count = 1
        } else {
          count += 1
        }
      }

      if (count == 1) {
        res = res ::: List(curValue)
      } else {
        res = res ::: List((count, curValue))
      }

      return res
    }

    def rep[T](tup:(Int, T)): List[T] = {
      var res = List[T]()
      for (_ <- 1 to tup._1) {
        res = res ::: List(tup._2)
      }

      return res
    }

    def rep2[T](tup:(Int, T)): List[T] = {
      if (tup._1 > 0) {
        return rep2((tup._1-1, tup._2)) ::: List(tup._2)
      } else {
        return List[T]()
      }
    }

    def decode[T](l: List[(Int, T)]): List[T] = {
      var res = List[T]()
      for (i <- 1 to l.length) {
        res = res ::: rep(l(i-1))
      }
      return res
    }

    def duplicate[T](l:List[T]): List[T] = {
      l.flatMap(x => List(x, x))
    }

    def duplicate2(l:List[Any]): List[Any] = {
      l.flatMap(x => List(x, x))
    }

    def duplicateN[T](n:Int, l: List[T]): List[T] = {
      l.flatMap(x => List.fill(n)(x))
    }

    def drop[T](n:Int, l: List[T]): List[T] = {
      l.grouped(n).flatMap(x => x.take(n-1)).toList
    }

    def dropZip[T](n: Int, l: List[T]): List[T] = {
      l.zipWithIndex.filter(x => (x._2+1)%n != 0).flatMap(x => List(x._1))  // flatmap needs to map to traverable
    }

    def rotate[T](n: Int, l: List[T]): List[T] = {
      if (n > 0) {
        return l.drop(n) ::: l.take(n)
      } else {
        return l.drop(l.length+n) ::: l.take(l.length+n)
      }
    }

    def removeAt[T](n: Int, l: List[T]): List[T] = {
      l.take(n) ::: l.drop(n).tail
    }


    def qsort[T](l:List[List[T]]): List[List[T]] = {
      var n = 0
      var maxInd = 0
      if (l.length == 0) return Nil
      for (i <- 0 to l.length-1) {
        if (l(i).length > n) {
          n = l(i).length
          maxInd = i
        }
      }
      val maxElem = l(maxInd)
      return qsort(removeAt(maxInd, l)) ::: List(maxElem)

    }

    def isPrime(x: Int): Boolean = {
      require(x >= 2, "input smaller than 2")
      if (x == 2) return true
      for (i <- 2 to x-1) {
        if (x % i == 0) return false
      }
      return true
    }

    def gcd(x: Int, y: Int): Int = {
      if (x == 0) return y
      else if (y == 0) return x
      else if (x > y) gcd(x-y, y)
      else gcd(y-x, x)
    }

    def isCoprime(x: Int, y: Int): Boolean = {
      if (x == 1 | y == 1) return true
      else if (x == 0 | y == 0) return false
      else if (x > y) isCoprime(x-y, y)
      else isCoprime(y-x, x)
    }

    def totient(x: Int): Int = {
      (1 to x-1).filter(i => isCoprime(i, x)).length
    }

    def listPrime(x: Int, y: Int): List[Int] = {
      (x to y).filter(i => isPrime(i)).toList
    }

    def combinations[T](k: Int, list: List[T]) : List[List[T]] = {
      if (k == 1) return list.map(List(_))
      else {
        var res = List[List[T]]()
        for (i <- 0 to list.length-1) {
          res = res ::: combinations(k-1, list.slice(i+1, list.length)).map(list(i) :: _)
        }
        return res
      }
    }

    def goldBach(x: Int): Option[List[Int]] = {
      val primes = (2 to x-1).filter(isPrime(_)).toList
      val resList = combinations(2, primes)
      for (elem <- resList) {
        if (elem.sum == x) return Some(elem)
      }
      return None
    }

    def goldBachList(lower: Int, upper: Int) = {
      val evens = (lower to upper).filter(x => x%2 == 0).toList
      evens.foreach(x => goldBach(x) match {
        case Some(List(a, b)) => println("%d + %d = %d".format(a, b, x))
        case None =>
      })
    }

    def gray(k: Int): List[String] = {
      if (k == 1) return List("0", "1")
      return List("0", "1").flatMap(x => {
        gray(k-1).map(_++x)
      })
    }



    println(last(x))
    println(penultimate(x))
    println(nth(2, x))
    println(reverse(x))
    println(reverse2(x))
    println(isPalindrome(List(1, 2, 3, 2, 2)))
    println(isPalindrome2(List(1, 2, 3, 2, 1)))
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(rep((3, "a")))
    println(rep2((3, "a")))
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println(duplicate(List("a", "b")))
    println(duplicate2(List("a", "b")))
    println(duplicateN(3, List("a", "b")))
    println(drop(3, List("a", "b", "a", "b", "a", "b")))
    println(qsort(List(
      List('a, 'b, 'c),
      List('d, 'e),
      List('f, 'g, 'h),
      List('d, 'e),
      List('i, 'j, 'k, 'l),
      List('m, 'n),
      List('o))))
    println(isPrime(7))
    println(gcd(12, 28))
    println(isCoprime(13, 27))
    println(isCoprime(12, 28))
    println(totient(10))
    println(listPrime(10, 20))
    println(removeAt(2, List(1, 2, 3, 2, 2)))
    println(combinations(2, List(1, 2, 3, 5)))
    println(goldBach(28))
    println(goldBachList(3, 12))
    println(gray(3))

  }
}
