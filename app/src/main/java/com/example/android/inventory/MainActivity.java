package com.example.android.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.inventory.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener{

    private static int COLUMN_COUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_main, ListFragment.newInstance(COLUMN_COUNT), "rageComicList")
                    .commit();
        }
    }

    public void onListFragmentInteraction(String type) { //todo: add the correct parameters to hand over to DetailsFragment instead of dummy item
        int imageResId = 1;
        String name = "test Name";
        String description = "huch, description";
        String  url = "https://google.com";
        final DetailsFragment detailsFragment = DetailsFragment.newInstance(type);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, detailsFragment, "rageComicDetails")
                .addToBackStack(null)
                .commit();
        Toast.makeText(this, "ListFragmentInteraction", Toast.LENGTH_SHORT).show();
    }
}
