import scala.collection.immutable.{Queue}
import scala.collection.mutable.Set

val q = Queue(1, 2, 3)
q.dequeue
q.enqueue(100, 1)

def neighbors[A](node: A) = {
  List(node)
}

val s = Set("A")
s += "B"

def bfs[A](node: A) = {
  val q = Queue(node)
  def bfs_(q: Queue[A], visited: scala.collection.mutable.Set[A]): Int = {
    if (q.isEmpty) 0
    val (h, t) = q.dequeue
    val neigh = neighbors(h)
    visited += h
    bfs_(t.enqueue(neigh.filterNot(visited.contains)), visited)

  }

  bfs_(q, Set[A]())
}