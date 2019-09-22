package cpsu.pmppalm.nakhonpathom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        Intent intent = getIntent();
        String placeName = intent.getStringExtra("name");
        int placeImgRes = intent.getIntExtra("image", 0);

        ImageView cover = findViewById(R.id.cover_image_view);
        TextView textView = findViewById(R.id.place_name_text_vuew);

        cover.setImageResource(placeImgRes);
        textView.setText(placeName);


    }
}
