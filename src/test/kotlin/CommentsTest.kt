import org.junit.Assert.*
import org.junit.Test

class CommentsTest {


    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.createComment(100, Comments(text = "Привет"))
    }

    @Test
    fun createComment() {
        val firstPost = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "Первый пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = arrayOf(
                Comments(
                    text = "коммент"
                )
            ),
            attachment = null,
        )

        WallService.add(firstPost)

        val comm = Comments(text = "текст")
        val comm2: Comments = WallService.createComment(1, comm)

        assertEquals(comm, comm2)
    }
}