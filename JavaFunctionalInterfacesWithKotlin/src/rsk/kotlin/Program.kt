package rsk.kotlin

import rsk.java.Created
import rsk.java.User

fun main() {
    var user = User("Marciano")
    var count = 0

    var eventListener = Created { println("User $it has been created: ${++count} times") }

    user.create {
        println(eventListener);
        user.create { println("User $it has been created: ${++count} times") };
    }
}