package cpsu.pmppalm.nakhonpathom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cpsu.pmppalm.nakhonpathom.PlaceDetailsActivity;
import cpsu.pmppalm.nakhonpathom.R;
import cpsu.pmppalm.nakhonpathom.model.Place;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHoder> {
    private Context mContext;
    private int mResource;
    private List<Place> mPlaceList;

    public RecyclerViewAdapter(Context mContext, int mResource, List<Place> mPlaceList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mPlaceList = mPlaceList;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        Place place = mPlaceList.get(position);
    holder.place = place;
        holder.nameTextView.setText(place.name);
        holder.districtTextView.setText(place.district);
        holder.placeImageView.setImageResource(place.imageRes);

    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        private ImageView placeImageView;
        private TextView nameTextView;
        private TextView districtTextView;

        private Place place;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);

            this.placeImageView = itemView.findViewById(R.id.logo_image_view);
            this.nameTextView = itemView.findViewById(R.id.place_name_textView);
            this.districtTextView = itemView.findViewById(R.id.district_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PlaceDetailsActivity.class);
                    intent.putExtra("name", place.name);
                    //intent.putExtra("district", place.district);
                    intent.putExtra("image", place.imageRes);
                    mContext.startActivity(intent);
                }
            });
        }
    }

}
