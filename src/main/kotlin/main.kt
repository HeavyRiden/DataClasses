
data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, // Идентификатор владельца стены, на которой размещена запись
    val fromId: Int, // Идентификатор автора записи
    val createdBy: Int, // Идентификатор администратора, который опубликовал запись
    val text: String, // Текст записи
    val markedAsAds: Boolean, // Информация о том, содержит ли запись отметку «реклама»
    val isFavorite: Boolean, // true, если объект добавлен в закладки у текущего пользователя
    val postponedId: Int, // Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере
    val signerId: Int, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean, // Информация о том, может ли текущий пользователь закрепить запись
    val comment: Comments // Информация о комментариях к записи, объект с полями

)

class Comments (
    private var count: Int, // количество комментариев
    private var canPost: Boolean, // информация о том, может ли текущий пользователь комментировать запись
    private var groupsCanPost: Boolean, // информация о том, могут ли сообщества комментировать запись;
    private var canClose: Boolean, // может ли текущий пользователь закрыть комментарии к записи;
    private var canOpen: Boolean, // может ли текущий пользователь открыть комментарии к записи.
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }
}

fun main() {
}
