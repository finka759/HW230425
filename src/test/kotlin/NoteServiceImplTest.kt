import AppExceptions.NoteNotFoundException
import AppExceptions.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NoteServiceImplTest {


    @Before
    fun clearBeforeTest() {
        NoteServiceImpl.clear()
    }

    @Test
    fun add1() {
        val result = NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        assertEquals(result, 0)
    }

    @Test
    fun add2() {
        NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        val result = NoteServiceImpl.add("Заголовок2", "Текст заметки2")
        assertEquals(result, 1)
    }

    @Test
    fun createComment1() {
        NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        NoteServiceImpl.add("Заголовок2", "Текст заметки2")
        val result = NoteServiceImpl.createComment(0, "Текст комментария1")
        assertEquals(result, 0)
    }

    @Test
    fun createComment2() {
        NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        NoteServiceImpl.add("Заголовок2", "Текст заметки12")

        NoteServiceImpl.createComment(0, "Текст комментария1")
        NoteServiceImpl.createComment(1, "Текст комментария2")
        val result = NoteServiceImpl.createComment(1, "Текст комментария3")
        assertEquals(result, 2)
    }


    @Test
    fun delete1() {
        NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        NoteServiceImpl.add("Заголовок2", "Текст заметки12")

        val result = NoteServiceImpl.delete(0)
        assertEquals(result, 1)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun delete() {
        NoteServiceImpl.add("Заголовок1", "Текст заметки1")
        NoteServiceImpl.add("Заголовок2", "Текст заметки12")

        val result = NoteServiceImpl.delete(3)
    }

}