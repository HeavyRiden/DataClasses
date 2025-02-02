import org.junit.Test

import org.junit.Assert.*

class WallServiceUpdateTest {

    @org.junit.Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update() {

        var firstPost = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "Первый пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = Comments(
                count = 0,
                canPost = true,
                groupsCanPost = true,
                canClose = true,
                canOpen = true
            ),
        )

        var secondPost = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "второй пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = Comments(
                count = 0,
                canPost = true,
                groupsCanPost = true,
                canClose = true,
                canOpen = true
            ),
        )

        var thirdPost = Post(
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            text = "третий пост",
            markedAsAds = false,
            isFavorite = true,
            signerId = 0,
            canPin = true,
            comment = Comments(
                count = 0,
                canPost = true,
                groupsCanPost = true,
                canClose = true,
                canOpen = true
            ),
        )

        WallService.add(firstPost)
        WallService.add(secondPost)

        val result = WallService.update(thirdPost) // выполняем целевое действие

        assertTrue(result) // проверяем результат
    }
}