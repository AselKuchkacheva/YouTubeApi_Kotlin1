import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi_kotlin1.R
import com.example.youtubeapi_kotlin1.databinding.ItemPlayListBinding
import com.example.youtubeapi_kotlin1.extensions.loadImage
import com.example.youtubeapi_kotlin1.ui.main.OnPlaylistClick

class PlaylistAdapter(
//    private val listener: OnPlaylistClick,
    private val playList: PlayList
) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {


    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemPlayListBinding.inflate(LayoutInflater.from(context), parent, false),
            context as Context
        )
    }

    override fun getItemCount() = playList.items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPhoto(playList.items[position])
        holder.itemView.setOnClickListener {
//            listener.onPlaylist(playList.items[position])
        }
    }

    class ViewHolder(private val view: ItemPlayListBinding, private val context: Context): RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")

        fun bindPhoto(item: Items) {

            view.tvPlaylistTitle.text = item.snippet.title
            view.ivVideoPreview.loadImage(context, item.snippet.thumbnails.default.url)
            view.tvVideoSeries.text = "${item.contentDetails.itemCount}  ${context.getString(R.string.video_series)}"
        }
    }
}