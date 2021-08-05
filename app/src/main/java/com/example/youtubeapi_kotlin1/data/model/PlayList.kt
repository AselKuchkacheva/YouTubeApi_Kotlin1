import com.google.gson.annotations.SerializedName

data class PlayList (

	@SerializedName("kind") val kind : String? = null,
	 val message : String? = null,
	@SerializedName("etag") val etag : String? = null,
	@SerializedName("nextPageToken") val nextPageToken : String? = null,
	@SerializedName("pageInfo") val pageInfo : PageInfo? = null,
	@SerializedName("items") val items : List<Items>? = null
)