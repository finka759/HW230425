import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val service = WallService
        val post: Post = Post(
            1,
            1,
            1,
            1,
            1,
            "text_lorem_ipsum",
            1,
            0,
            false,
            Comments(123, true, false, false),
        )
        val postNew = service.add(post)

        WallService.add(post)

        assertTrue(postNew.id > 0)
    }

    @Test
    fun update() {
        val service = WallService
        val post1: Post = Post(
            1,
            1,
            1,
            1,
            1,
            "text_lorem_ipsum",
            1,
            0,
            false,
            Comments(1, true, false, false),
        )
        val post2: Post = Post(
            2,
            2,
            2,
            2,
            2,
            "text_lorem_ipsum",
            2,
            2,
            false,
            Comments(2, true, false, false),
        )
        val postUpdateTrue: Post = Post(
            2,
            22,
            22,
            22,
            22,
            "text_lorem_ipsum",
            22,
            22,
            false,
            Comments(22, true, false, false),
        )
        val postUpdateFalse: Post = Post(
            3,
            22,
            22,
            22,
            22,
            "text_lorem_ipsum",
            22,
            22,
            false,
            Comments(22, true, false, false),
        )
        service.add(post1)
        service.add(post2)

        assertTrue(service.update(postUpdateTrue))
        assertTrue(!service.update(postUpdateFalse))

    }
}