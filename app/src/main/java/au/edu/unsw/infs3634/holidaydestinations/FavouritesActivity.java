package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Responsible for creating the class of favourited destinations
 */
public class FavouritesActivity extends AppCompatActivity {
    private static final String TAG = "FavouritesActivity";
    private RecyclerView mRecyclerView;
    private DestinationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        //Handler for the recycler view
        mRecyclerView = findViewById(R.id.rv_FavouritesList);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Utilise the same adapter to make the recycler view the exact same as the top 10
        //Making it much easier / simpler for the user
        DestinationAdapter.RecyclerViewClickListener listener = new DestinationAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String destinationSymbol) {
                Log.d(TAG, destinationSymbol);
                launchDetailActivity(destinationSymbol);
            }
        };

        //Parse through the favourite destinations into the adapter by calling upon the getFavourites() method
        mAdapter = new DestinationAdapter(Destination.getFavourites(Destination.getDestinations()), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    protected void launchDetailActivity (String symbol) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, symbol);
        Log.d(TAG,symbol);
        startActivity(intent);
    }

}