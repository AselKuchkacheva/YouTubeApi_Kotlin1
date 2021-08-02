import com.google.gson.annotations.SerializedName
import java.sql.Time
import java.util.*


data class ContentDetails (

	@SerializedName("itemCount") val itemCount : Int,
	@SerializedName("videoPublishedAt") val videoPublishedAt : String
)