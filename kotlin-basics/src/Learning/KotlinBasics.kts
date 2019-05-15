//val cards = mutableListOf("Jack", "Queen", "King", "Ace")
val suits = mutableListOf("Spades", "Clubs", "Hearts", "Diamonds")

val cards = mapOf("Jack" to 11, "Queen" to 12, "King" to 13)

val cardsWithSuits = hashMapOf("Jack" to "Clubs", "Queen" to "Diamonds", "King" to "Hearts", "Ace" to "Spades")

for ((name, value) in cards) {
    println("$name, $value")
}
