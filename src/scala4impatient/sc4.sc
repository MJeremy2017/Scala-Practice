val scores = Map("Alice" -> 10, "Bob" -> 3)

val scores_mutable = collection.mutable.Map(("Alice", 10), ("Bob", 3))

val bob_score = if (scores.contains("Bob")) scores("Bob") else 0

val bob_score2 = scores.getOrElse("Bob", 0)

val bob_score3 = scores.get("Bob")  // Some(3)

scores.withDefaultValue(0)

val s = Map(("A", 1), ("A", 2))  // A is 2
s("A")

// scores_mutable("Fred") = 33

scores_mutable += ("Bob" -> 2, "Jay" -> 5)

scores.keySet
for (v <- scores.values) yield v

collection.mutable.SortedMap("A" -> 10, "C" -> 3, "B" -> 6)  // sort keys

val t = (3, "as")

val sy = Array("<", "_", ">")
val counts = Array(1, 2, 3)

sy.zip(counts).toMap

val myMap = Map(("p1", 10), ("p2", 20))

val myMap2 = for ((k, v) <- myMap) yield (k, v*.9)

