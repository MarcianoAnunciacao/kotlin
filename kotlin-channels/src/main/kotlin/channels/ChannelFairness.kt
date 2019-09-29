package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

data class Comment(var hits: Int)

fun main() = runBlocking {
    val discussion = Channel<Comment>()

    GlobalScope.launch (coroutineContext){ child("he did it", discussion)  }
    GlobalScope.launch (coroutineContext){ child("she did it", discussion)  }

    discussion.send(Comment(0))
    delay(1000)
    coroutineContext.cancel()
}

suspend fun child(text: String, discussion: Channel<Comment>){
    for (comment in discussion){
        comment.hits ++
        println("$text $comment")
        delay(300)
        discussion.send(comment)
    }
}