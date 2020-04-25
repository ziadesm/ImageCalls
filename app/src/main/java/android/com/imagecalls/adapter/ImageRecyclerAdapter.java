package android.com.imagecalls.adapter;
import android.com.imagecalls.R;
import android.com.imagecalls.pojo.ModelImage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ItemViewHolder> {
    private List<ModelImage> mList = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.albumTv.setText(String.valueOf(mList.get(position).getAlbumId()));
        holder.titleTv.setText(mList.get(position).getTitle());
        holder.urlTv.setText(mList.get(position).getUrl());
        Picasso.get()
                .load(mList.get(position).getThumbnailUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<ModelImage> ModelImages) {
        this.mList = ModelImages;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView albumTv, titleTv, urlTv;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            albumTv = itemView.findViewById(R.id.album_tv);
            titleTv = itemView.findViewById(R.id.title_tv);
            urlTv = itemView.findViewById(R.id.url_tv);

        }
    }
}
