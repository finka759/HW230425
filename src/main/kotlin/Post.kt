data class Post(
    val id: Long = 0,//Идентификатор записи
    val ownerId: Int,//Идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id
    val fromId: Int,//Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int?,//Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад
    val date: Int,//Время публикации записи в формате unixtime
    val text: String,//Текст записи
    val replyOwnerId: Int,//Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int,//Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean,//1, если запись была создана с опцией «Только для друзей»
    val comments: Comments, //object Информация о комментариях к записи, объект с полями: ...
)

class Comments(
    val count: Int,//число пользователей, которым понравилась запись
    val userLikes: Boolean,//наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val canLike: Boolean,//информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может)
    val canPublish: Boolean,//информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может)
)