import AppExceptions.NoteNotFoundException

//add Создает новую заметку у текущего пользователя.
//createComment Добавляет новый комментарий к заметке.
//delete Удаляет заметку текущего пользователя.
//deleteComment Удаляет комментарий к заметке.
//edit Редактирует заметку текущего пользователя.
//editComment Редактирует указанный комментарий у заметки.
//get Возвращает список заметок, созданных пользователем.
//getById Возвращает заметку по её id.
//getComments Возвращает список комментариев к заметке.
//restoreComment Восстанавливает удалённый комментарий.

object NoteServiceImpl : NoteService {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()

    private var nId = 0L
    private var cId = 0

    fun clear() {
        notes.clear()
        comments.clear()

        nId = 0L
        cId = 0
    }


        override fun add(title: String, text: String): Int {
        val note = Note(id = nId++, title = title, text = text)
        notes.add(note)
        return notes.lastIndex
    }

    override fun createComment(noteId: Int, message: String): Int {
        if (notes[noteId] in notes) {
            val comment = Comment(id = cId++, text = message, noteId = noteId)
            comments.add(comment)
            return comments.lastIndex
        }
        throw NoteNotFoundException("create comment error, not found note with id")
    }

    override fun delete(noteId: Int): Int {
        if (notes[noteId] in notes) {
            notes.removeAt(noteId)
            return 1
        }
        throw NoteNotFoundException("delete error, note not exist")
    }

    override fun deleteComment(commentId: Int): Int {
        if (comments[commentId] in comments) {
            comments[commentId].deleted = true
            return 1
        }
        throw NoteNotFoundException("comment with id not found")
    }

    override fun edit(noteId: Int, title: String, text: String): Int {
        if (notes[noteId] in notes) {
            notes.removeAt(noteId)
            notes[noteId] = notes[noteId].copy(title = title, text = text)
            notes.add(notes[noteId])
            return 1
        }
        throw NoteNotFoundException("edit error, note with id not found")
    }

    override fun editComment(commentId: Int, message: String): Int {
        if (comments[commentId] in comments) {
            comments.removeAt(commentId)
            comments[commentId] = comments[commentId].copy(text = message)
            comments.add(comments[commentId])
            return 1
        }
        throw NoteNotFoundException("edit comment error, comment with id not found")
    }

    override fun get(): List<Note> {
        return notes
    }

    override fun getById(noteId: Int): Note {
        if (notes[noteId] in notes) {
            return notes[noteId]
        }
        throw NoteNotFoundException("error, note with id not found")
    }

    override fun getComments(noteId: Int): List<Comment> {
        if (notes[noteId] in notes) {
            return comments.filter { it.noteId == noteId && !it.deleted }
        }
        throw NoteNotFoundException("error, note with id not found")
    }

    override fun restoreComment(commentId: Int): Int {
        if (comments[commentId] in comments) {
            comments[commentId].deleted = false
            return 1
        }
        throw NoteNotFoundException("error, comment with id not found")
    }

    fun printNote() {
        for (note in notes) {
            println(note)
        }
    }

    fun printComments() {
        for (comment in comments) {
            if (!comment.deleted) {println(comment)}

        }
    }


}