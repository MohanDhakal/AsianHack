package com.asianapp.mohankumardhakal.athithi.random;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asianapp.mohankumardhakal.athithi.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ModelClass> itemList;
    public static List<ModelClass> savedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Saved;
        Saved = findViewById(R.id.viewSaved);
        Saved.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewSaved.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        savedItem = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<>();
        mAdapter = new ModelAdaptor(this, itemList);
        recyclerView.setAdapter(mAdapter);
        Context context = this;
        new ItemTouchHelper(touchHelper).attachToRecyclerView(recyclerView);
        itemList.add(new ModelClass("Hotel Kathmandu Echo", "Kathmandu Eco Hotel is a Tibetan themed boutique hotel in Kathmandu offering the best in modern amenities with traditional Nepalese hospitality. Located along the prestigious “embassy road”  Kathmandu Eco Hotel is just 10 minutes drive from the city centre, in close proximity to major embassies, businesses and within easy access to major tourist attractions.\n",
                R.mipmap.allied_hotel));
        itemList.add(new ModelClass("Hotel DhurbaTara",
                "Dhurbatara is a Tibetan themed boutique hotel in Kathmandu offering the best in modern amenities with traditional Nepalese hospitality. Located along the prestigious “embassy road”  Kathmandu Eco Hotel is just 10 minutes drive from the city centre, in close proximity to major embassies, businesses and within easy access to major tourist attractions.\n",
                R.mipmap.hotel_namaste));
        itemList.add(new ModelClass("Hotel Royal Kathmandu", "Hotel Royal Kathmandu, located in the heart of Nepal's thriving capital, places you close to corporate offices and popular attractions like the entertainment district of Thamel. Once you arrive at Tribhuvan International Airport (KTM), we can transport you in our airport shuttle to the hotel, where you can unwind with a treatment at our Tranquility Spa. Business travellers can also enjoy our Business Class Lounge, perfect for small meet-and-greets accompanied by a two-hour offering of free drinks and assorted snacks.\n", R.mipmap.hotel_rosmery));
        itemList.add(new ModelClass("Kaligandaki Guest House",
                "Kaligandaki Guest House is a luxury 5-star deluxe hotel in the heart of Kathmandu, Nepal. Modern day sophistication meets cultural heritage in the ample grounds of this over 100-year-old palace.\n",
                R.mipmap.hotel_royal_kathmandu));
        itemList.add(new ModelClass("Hotel Yeti and Resturant",
                "Hotel Yeti and Resturant is a 5 star luxury hotel and resort in Kathmandu and is set on 37 acres of landscaped grounds, created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet, and a UNESCO World Heritage Site which is 5 minutes walk from the hotel.  The hotel is just 4 km (2.4 miles) from the Tribhuvan International Airport and 6 km (3.7 miles) from the city center of Kathmandu.\n" +
                        "\n", R.mipmap.kathmandu_eco_hotel));
        itemList.add(new ModelClass("Hotel Rose Garden", "Hotel Namaste is a 5 star luxury hotel and resort in Kathmandu and is set on 37 acres of landscaped grounds, created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet, and a UNESCO World Heritage Site which is 5 minutes walk from the hotel.  The hotel is just 4 km (2.4 miles) from the Tribhuvan International Airport and 6 km (3.7 miles) from the city center of Kathmandu.\n" +
                "\n", R.mipmap.manamaiju_homestay));
        itemList.add(new ModelClass("Hotel Syatyawati", "Hotel Namaste is a 5 star luxury hotel and resort in Kathmandu and is set on 37 acres of landscaped grounds, created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet, and a UNESCO World Heritage Site which is 5 minutes walk from the hotel.  The hotel is just 4 km (2.4 miles) from the Tribhuvan International Airport and 6 km (3.7 miles) from the city center of Kathmandu.\n" +
                "\n", R.mipmap.hotel_rosmery));
        itemList.add(new ModelClass("Hotel Allied ", "Hotel Namaste is a 5 star luxury hotel and resort in Kathmandu and is set on 37 acres of landscaped grounds, created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet, and a UNESCO World Heritage Site which is 5 minutes walk from the hotel.  The hotel is just 4 km (2.4 miles) from the Tribhuvan International Airport and 6 km (3.7 miles) from the city center of Kathmandu.\n" +
                "\n", R.mipmap.allied_hotel));
        itemList.add(new ModelClass("Hotel DhurbaTara", "Hotel Namaste is a 5 star luxury hotel and resort in Kathmandu and is set on 37 acres of landscaped grounds, created in the traditional Newari style of Nepalese architecture. This beautiful hotel and resort is located on the road to the Boudhanath Stupa: the most holy of all Tibetan Buddhist shrines outside of Tibet, and a UNESCO World Heritage Site which is 5 minutes walk from the hotel.  The hotel is just 4 km (2.4 miles) from the Tribhuvan International Airport and 6 km (3.7 miles) from the city center of Kathmandu.\n" +
                "\n", R.mipmap.hotel_namaste));

        Log.d("apple", String.valueOf(R.drawable.background));

    }

    public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }

    ItemTouchHelper.SimpleCallback touchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {


        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            final ModelClass deleted = itemList.get(viewHolder.getAdapterPosition());
            final int position = viewHolder.getAdapterPosition();
            savedItem.add(deleted);
            itemList.remove(viewHolder.getAdapterPosition());
            mAdapter.notifyDataSetChanged();
            View v = findViewById(R.id.mainLayout);

            Snackbar.make(v, "Saved", Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    savedItem.remove(savedItem.size() - 1);
                    itemList.add(position, deleted);
                    mAdapter.notifyDataSetChanged();
                }
            }).show();
        }
    };
}
