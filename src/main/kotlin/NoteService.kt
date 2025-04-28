interface NoteService {
    fun add(title: String, text: String): Int
    fun createComment(noteId: Int, message: String): Int
    fun delete(noteId: Int): Int
    fun deleteComment(commentId: Int): Int //Positive
    fun edit(noteId: Int, title: String, text: String): Int
    fun editComment(commentId: Int, message: String): Int //Positive
    fun get(): List<Note>
    fun getById(noteId: Int): Note?//Positive
    fun getComments(noteId: Int): List<Comment>//Positive
    fun restoreComment(commentId: Int): Int//Positive
}