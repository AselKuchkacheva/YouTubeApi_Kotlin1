import com.google.gson.annotations.SerializedName

data class Items (

	@SerializedName("kind") val kind : String,
	@SerializedName("etag") val etag : String,
	@SerializedName("id") val id : String,
	@SerializedName("snippet") val snippet : Snippet,
	@SerializedName("contentDetails") val contentDetails : ContentDetails
)