package cpsu.pmppalm.nakhonpathom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cpsu.pmppalm.nakhonpathom.R;
import cpsu.pmppalm.nakhonpathom.model.Place;

public class PlaceListAdapter extends ArrayAdapter<Place> {

    private Context mContext;
    private int mResorce;
    private List<Place> mPlaceList;

    public PlaceListAdapter(@NonNull Context context, int resource, @NonNull List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext = context;
        this.mResorce = resource;
        this.mPlaceList = placeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = convertView;
        if (v == null) {
            v = inflater.inflate(mResorce, parent, false);

        }


        //เข้าถึงตาม position ที่ขอมา
        Place place = mPlaceList.get(position);

        TextView placeNameTextView = v.findViewById(R.id.place_name_textView);
        placeNameTextView.setText(place.name);

        TextView districtTextView = v.findViewById(R.id.district_textView);
        districtTextView.setText("อำเภอ".concat(place.district));

        ImageView logoImageView = v.findViewById(R.id.logo_image_view);
        logoImageView.setImageResource(place.imageRes);

        return v;
    }
}
