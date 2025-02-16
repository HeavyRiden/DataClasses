data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, // Идентификатор владельца стены, на которой размещена запись
    val fromId: Int, // Идентификатор автора записи
    val createdBy: Int, // Идентификатор администратора, который опубликовал запись
    val text: String, // Текст записи
    val markedAsAds: Boolean, // Информация о том, содержит ли запись отметку «реклама»
    val isFavorite: Boolean, // true, если объект добавлен в закладки у текущего пользователя
    val signerId: Int, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean, // Информация о том, может ли текущий пользователь закрепить запись
    var comment: Array<Comments>?, // Информация о комментариях к записи, объект с полями
    val attachment: Array<Attachments>? //

)

class Comments(
    var id: Int = 0, // id комментария
    private var canPost: Boolean = true, // информация о том, может ли текущий пользователь комментировать запись
    private var groupsCanPost: Boolean = true, // информация о том, могут ли сообщества комментировать запись;
    private var canClose: Boolean = true, // может ли текущий пользователь закрыть комментарии к записи;
    private var canOpen: Boolean = true, // может ли текущий пользователь открыть комментарии к записи.
    private var text: String, // текст комментария
)

object WallService {
    private var posts = emptyArray<Post>()
    private var idWall = 1

    fun add(post: Post): Post {
        posts += post.copy(id = idWall)
        idWall += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, current) in posts.withIndex()) {
            if (post.id == current.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        idWall = 1
    }

    fun get(): Array<Post> {
        return posts
    }

    fun createComment(postId: Int, comment: Comments): Comments {
        var found: Boolean = false
        for ((index, current) in posts.withIndex()) {
            if (postId == current.id) {
                if (current.comment == null) {
                    current.comment = emptyArray<Comments>()
                }
                current.comment = current.comment!! + comment
                comment.id += current.comment!!.size
                found = true
            }
        }
        if (!found) throw PostNotFoundException("no post with id $postId")
        return comment
    }
}


fun main() {

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
        comment = null,
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
        comment = arrayOf(
            Comments(
                text = "Второй коммент"
            )
        ),
        attachment = arrayOf(
            AudioAttachment(
                audio = Audio(
                    id = 0,
                    ownerId = 0,
                    artist = "Artist",
                    title = "Title",
                    duration = 100,
                )
            ),
            VideoAttachment(
                video = Video(
                    id = 0,
                    ownerId = 0,
                    title = "VideoTitle",
                    duration = 60,
                    description = "Cats"
                )
            )
        )
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
        comment = arrayOf(
            Comments(
                text = "Третий коммент"
            )
        ),
        attachment = arrayOf(
            PhotoAttachment(
                photo = Photo(
                    id = 0,
                    ownerId = 0,
                    albumId = 1,
                    text = "text",
                    date = 1738899357,
                )
            )

        )
    )

    WallService.add(firstPost)
    val comm = WallService.createComment(1, Comments(text = "Привет"))
    println(comm)
}

