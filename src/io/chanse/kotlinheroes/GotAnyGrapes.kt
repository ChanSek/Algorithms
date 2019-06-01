package io.chanse.kotlinheroes

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val andrewWants = reader.nextInt()
    val dmitryWants = reader.nextInt()
    val michalWants = reader.nextInt()

    val greenGrapes = reader.nextInt()
    val purpleGrapes = reader.nextInt()
    val blackGrapes = reader.nextInt()

    val remainingGreenGrapes = greenGrapes - andrewWants
    val remainingPurpleGrapes = (remainingGreenGrapes + purpleGrapes) - dmitryWants
    when {
        greenGrapes < andrewWants -> println("NO")
        (remainingGreenGrapes + purpleGrapes) < dmitryWants -> println("NO")
        (remainingPurpleGrapes + blackGrapes) < michalWants -> println("NO")
        else -> println("YES")
    }
}
