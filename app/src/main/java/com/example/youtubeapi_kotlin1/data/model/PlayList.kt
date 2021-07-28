import com.google.gson.annotations.SerializedName

data class PlayList (

	@SerializedName("kind") val kind : String,
	@SerializedName("etag") val etag : String,
	@SerializedName("nextPageToken") val nextPageToken : String,
	@SerializedName("pageInfo") val pageInfo : PageInfo,
	@SerializedName("items") val items : List<Items>
)