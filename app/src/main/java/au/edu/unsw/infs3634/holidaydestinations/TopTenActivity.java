package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

/**
 * Responsible for creating the TopTen Activity
 */
public class TopTenActivity extends AppCompatActivity {
    private static final String TAG = "TopTenActivity";
    private RecyclerView mRecyclerView;
    private DestinationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starting Launch");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten);

        //Provide handle for the recycler view
        mRecyclerView = findViewById(R.id.rv_ListTopTen);
        mRecyclerView.setHasFixedSize(true);

        //Set the recycler view's layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Set an onclick listener for the recycler view
        DestinationAdapter.RecyclerViewClickListener listener = new DestinationAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String destinationSymbol) {
                Log.d(TAG, destinationSymbol);
                launchDetailActivity(destinationSymbol);
            }
        };

        //Set the recycler view's adapter
        mAdapter = new DestinationAdapter(Destination.getDestinations(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Responsible for launching the detail activity once a record is tapped in the recycler view
     * @param symbol - Retrieve the symbol string from the record's Tag() within the recycler iew
     */
    protected void launchDetailActivity (String symbol) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, symbol);
        Log.d(TAG,symbol);
        startActivity(intent);
    }

    /**
     * Inflate the top menu bar with the menu_topten resource file
     * @param menu - retrieve the menu object
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_topten, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_filter).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.getFilter().filter(query); //Parsed string query to filter method, in which it will do the sorting for us
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.sortName:
                //Sort by Destination's Country Name
                Log.d(TAG, "Sort by Name was selected");
                mAdapter.sort(DestinationAdapter.SORT_METHOD_NAME);
                return true;
            case R.id.sortTitle:
                //Sort by destination's title
                Log.d(TAG, "Sort by Country was selected");
                mAdapter.sort(DestinationAdapter.SORT_METHOD_TITLE);
                return true;
            case R.id.sortRating:
                //Sort by destination's rating
                Log.d(TAG, "Sort by Rating was selected");
                mAdapter.sort(DestinationAdapter.SORT_METHOD_RATING);
                return true;
            case R.id.sortTime:
                //Sort by destination's local time
                Log.d(TAG, "Sort by Time was selected");
                mAdapter.sort(DestinationAdapter.SORT_METHOD_TIME);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}