class VideoFile(
    val id: Int,
    override val ownerId: Int,
    override val title: String,
    val description: String? = null,
    val duration: Int,
    val date: Int? = null,
    val addingDate: Int? = null,
    val views: Int? = null,
    val localViews: Int? = null,
    val comments: Int? = null,
    val player: String? = null,
    val platform: String? = null,
    val canAdd: Boolean = false,
    val isPrivate: Boolean = true,
    val accessKey: String? = null,
) : File {
}