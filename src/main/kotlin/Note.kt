import java.sql.Date

data class Note(
    var id: Long = 0,//integer Идентификатор заметки.
    val ownerId: Int = 0,//integer Идентификатор владельца заметки.
    val title: String = "",//string Заголовок заметки.
    val text: String = "",//string Текст заметки.
    val date: Int = 0,// integer Дата создания заметки в формате Unixtime.
    val comments: Int = 0,//integer Количество комментариев.
    val readComments: Int = 0,//integer Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
    val viewUrl: String = "",//string URL страницы для отображения заметки.
    val privacyView: String = "",//string Настройки приватности комментирования заметки
    val canComment: Int = 0,//integer Есть ли возможность оставлять комментарии
    val textWiki: String = ""//string Тэги ссылок на wiki
)
