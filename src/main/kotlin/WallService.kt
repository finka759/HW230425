import AppExceptions.PostNotFoundException

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Long = 1
    private var comments = emptyArray<Comment>()

    fun clear() {
        posts = emptyArray()
        nextId = 1// также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }

    fun add(post: Post): Post {
        var maxId: Int = 0
        posts += post.copy(id = nextId)
        nextId += 1
        return posts.last()
    }

    fun update(postFind: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postFind.id) {
                posts[index] = postFind.copy(
                    ownerId = post.ownerId,
                    date = post.date,
                    text = post.text,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                )
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if (post.id.toInt() == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("No post with ID: $postId")
    }
}