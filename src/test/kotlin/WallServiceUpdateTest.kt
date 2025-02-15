import org.junit.Test

import org.junit.Assert.*

class WallServiceUpdateTest {

    @org.junit.Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update() {

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
            comment = arrayOf(Comments(
                text = "коммент3"
            )),
            attachment = null,
        )

        val secondPost = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "второй пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = arrayOf(Comments(
                text = "коммент4"
            )),
            attachment = null,
        )

        val thirdPost = Post(
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "третий пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = arrayOf(Comments(
                text = "коммент5"
            )),
            attachment = null,
        )

        WallService.add(firstPost)
        WallService.add(secondPost)

        val result = WallService.update(thirdPost) // выполняем целевое действие

        assertTrue(result) // проверяем результат
    }

    @Test
    fun negUpdate() {
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
            comment = arrayOf(Comments(
                text = "коммент6"
            )),
            attachment = null,
        )

        val secondPost = Post(
            id = 2,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "второй пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = arrayOf(Comments(
                text = "коммент7"
            )),
            attachment = null,
        )

        WallService.add(firstPost)

        val result = WallService.update(secondPost) // выполняем целевое действие

        assertFalse(result)
    }
}