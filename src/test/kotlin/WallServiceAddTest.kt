import org.junit.Assert.*

class WallServiceAddTest {

    @org.junit.Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @org.junit.Test
    fun add() {

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

        val result = WallService.add(firstPost).id

        assertEquals(1, result)
    }
}