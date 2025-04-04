class AudioFile(
        val aid: Int,
        override val ownerId: Int,
        override val title: String,
        val date: Int? = null,
        val artist: String? = null,
        val duration: Int,
        val url: Int? = null,
        val lyricsId: Int? = null,
        val albumId: Int? = null,
        val genreId: Int? = null,
        val noSearsh: Boolean = false,
        val isHd: Boolean = false,
        ) : File {
}
