import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi_kotlin1.R
import com.example.youtubeapi_kotlin1.databinding.ItemPlayListBinding
import com.example.youtubeapi_kotlin1.extensions.loadImage
import com.example.youtubeapi_kotlin1.model.Items
import com.example.youtubeapi_kotlin1.ui.playlist.OnPlaylistClick

class PlaylistAdapter(
        private var listener: OnPlaylistClick
) :
        RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {


    private var context: Context? = null

    private var list: List<Items> = listOf()

    fun setList(list: List<Items>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
                ItemPlayListBinding.inflate(LayoutInflater.from(context), parent, false),
                context as Context
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPhoto(list[position])
        holder.itemView.setOnClickListener {
            listener.onPlaylist(list[position])
        }
    }

    class ViewHolder(private val view: ItemPlayListBinding, private val context: Context) : RecyclerView.ViewHolder(view.root) {

        @SuppressLint("SetTextI18n")
        fun bindPhoto(item: Items) {

            view.tvPlaylistTitle.text = item.snippet.title
            view.ivVideoPreview.loadImage(context, item.snippet.thumbnails.default.url)
            view.tvVideoSeries.text = "${item.contentDetails.itemCount}  ${context.getString(R.string.video_series)}"
        }
    }
}