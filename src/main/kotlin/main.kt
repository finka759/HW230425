fun main() {
    val noteService = NoteServiceImpl

    println("Создение заметки")
    val note1 = noteService.add("Заголовок1", "Текст заметки1")
    val note2 = noteService.add("Заголовок2", "Текст заметки12")
    val note3 = noteService.add("Заголовок3", "Текст заметки13")
    noteService.printNote()

    println("\nДобавление комментария к заметке")
    val comment1 = noteService.createComment(0, "Текст комментария1")
    val comment2 = noteService.createComment(1, "Текст комментария2")
    val comment3 = noteService.createComment(2, "Текст комментария3")
    val comment4 = noteService.createComment(2, "Текст комментария4")
    noteService.printComments()

    println("\nУдаление заметки")
    noteService.delete(0)
    noteService.printNote()

    println("\nУдаление комментария к заметке")
    noteService.printComments()
    println(noteService.deleteComment(1))
    noteService.printComments()

    println("\nВозвращение списка заметок")
    println(noteService.get())

    println("\nВозвращение заметки по её id")
    println(noteService.getById(0))
    println(noteService.getById(1))

    println("\nВозвращение списка комментариев к заметке") //!!!
    println(noteService.getComments(0))

    println("\nВосстанавление удалённого комментария")
    noteService.printComments()
    println(noteService.restoreComment(1))
    noteService.printComments()

}