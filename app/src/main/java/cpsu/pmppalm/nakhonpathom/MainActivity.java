package cpsu.pmppalm.nakhonpathom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cpsu.pmppalm.nakhonpathom.Adapter.RecyclerViewAdapter;
import cpsu.pmppalm.nakhonpathom.model.Place;

public class MainActivity extends AppCompatActivity {
    //    private String[] mPlaceList = new String[]{
//            "องค์พระปฐมเจดีย์", "วัดไร่ขิง", "ตลาดดอนหวาย",
//            "ฟาร์มจระเข้สามพราน", "พระราชวังสนามจันทร์", "พิพิธภัณฑ์หุ่นขี้ผึ้ง"
//    };
    //private Place[] mPlaceList = new Place[10];
    private List<Place> mPlaceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                MainActivity.this,
                R.layout.item_place,
                mPlaceList
        );


        LinearLayoutManager m = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        //แนวตั้ง
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //แนวนอน
        // recyclerView.setLayoutManager(m);

        recyclerView.setAdapter(adapter);


//        ListView placeListView = findViewById(R.id.place_list_view);

//        //สร้าง Adapter
//        final PlaceListAdapter adapter = new PlaceListAdapter(
//                MainActivity.this, R.layout.item_place,
//                mPlaceList
//        );
//
//        placeListView.setAdapter(adapter);
//
//        //เมื่อ Item ถูกกด
//        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Place place = mPlaceList.get(position);
//                String placeName = place.name;
//                Toast.makeText(MainActivity.this, placeName, Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(MainActivity.this, PlaceDetailsActivity.class);
//                intent.putExtra("name", place.name);
//                intent.putExtra("image", place.imageRes);
//                startActivity(intent);
//
//            }
//        });
    }

    private void populateData() {
        Place place = new Place("องค์พระปฐมเจดีย์", "เมือง", R.drawable.nkpt);
        mPlaceList.add(place);
        place = new Place("วัดไร่ขิง", "สามพราน", R.drawable.watraiking);
        mPlaceList.add(place);
        place = new Place("ฟาร์มจระเข้", "สามพราน", R.drawable.framsampan);
        mPlaceList.add(place);
        place = new Place("ตลาดดอนหวาย", "ดอนหวาย", R.drawable.taratdonwai);
        mPlaceList.add(place);
        place = new Place("พระราชวังสนามจันทร์", "เมือง", R.drawable.sanamchan);
        mPlaceList.add(place);
        place = new Place("พิพิธภัณฑ์หุ่นขี้ผึ้ง", "นครชัยศรี", R.drawable.hun);
        mPlaceList.add(place);


    }
}
