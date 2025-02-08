sealed class Attachments(
    val type: String // Тип вложения(аудио, видео..)

)


data class Audio(
    val id: Int, // Идентификатор аудиозаписи
    val ownerId: Int, // Идентификатор владельца аудиозаписи
    val artist: String, //Исполнитель
    val title: String, // Название композиции
    val duration: Int, // Длительность аудиозаписи в секундах
)

data class AudioAttachment(val audio: Audio) : Attachments("audio")


data class Video(
    val id: Int, // Идентификатор видеозаписи
    val ownerId: Int, // Идентификатор владельца видеозаписи
    val title: String, // Название видеозаписи
    val duration: Int, // Длительность ролика в секундах
    val description: String // Текст описания видеозаписи
)

data class VideoAttachment(val video: Video) : Attachments("video")


data class Photo(
    val id: Int, // Идентификатор фотографии
    val ownerId: Int, // Идентификатор владельца фотографии
    val albumId: Int, // Идентификатор альбома, в котором находится фотография
    val text: String, // Текст описания фотографии
    val date: Long, // Дата добавления в формате Unixtime
)

data class PhotoAttachment(val photo: Photo) : Attachments("photo")


data class File(
    val id: Int, // Идентификатор файла
    val ownerId: Int, // Идентификатор пользователя, загрузившего файл
    val title: String, // Название файла
    val size: Int, // Размер файла в байтах
    val ext: String, // Расширение файла
)

data class FileAttachment(val file: File) : Attachments("file")

data class Geotag(
    val type: Int, // Тип места
    val latitude: Int, // Географическая широта
)

data class GeoTagAttachment(val geotag: Geotag) : Attachments("geotag")