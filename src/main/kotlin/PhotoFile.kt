class PhotoFile(
    val id: Int,
    override val ownerId: Int,
    override val title: String,
    val photo130: String,
    val photo604: String,
) : File {

}