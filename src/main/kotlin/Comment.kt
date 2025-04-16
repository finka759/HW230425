import java.awt.Button
import javax.print.attribute.standard.QueuedJobCount

class Comment(
    val id: Int = 0,//integer Идентификатор комментария.
    val fromId: Int,//integer Идентификатор автора комментария.
    val date: Int,//integer Дата создания комментария в формате Unixtime.
    val text: String,//string Текст комментария.
    val donut: Donut = Donut(),//object Информация о VK Donut.
    val replyToUser: Int = 0, //integer Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment: Int = 0, //integer Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attacment: Array<Attacment> = emptyArray(), //object Медиавложения комментария (фотографии, ссылки и т.п.).
    val parentsStack: Array<Int> = emptyArray(),//array Массив идентификаторов родительских комментариев.
    val thread: Thread = Thread(),//object Информация о вложенной ветке комментариев, объект с полями
)

class Donut(
    val isDonut: Boolean = false,//is_don (boolean) — является ли комментатор подписчиком VK Donut.
    val placeholder: String = "not subscribet",//placeholder (string) — заглушка для пользователей, которые не оформили подписку VK Donut.
)

class Thread(
    val count: Int = 0,//— количество комментариев в ветке.
    val items: Array<Comments> = emptyArray(),//— массив объектов комментариев к записи (только для метода wall.getComments).
    val canPost: Boolean = false,//– может ли текущий пользователь оставлять комментарии в этой ветке.
    val showReplyButton: Boolean = false,// – нужно ли отображать кнопку «ответить» в ветке.
    val groupsCanPost: Boolean = false,//– могут ли сообщества оставлять комментарии в ветке.
)