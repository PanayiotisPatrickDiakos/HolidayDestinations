package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Responsible for creating the home view the user is greeted to right after the splash screen
 */
public class HomeActivity extends AppCompatActivity {
    private CardView mTopTen, mFavourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Handler for the card views
        mTopTen = findViewById(R.id.cv_topTen);
        mFavourites = findViewById(R.id.cv_favourites);

        /**
         * Set an onclick listener to the top ten card view that will launch the TopTen Activity
         */
        mTopTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TopTenActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Set an onclick listener to the favourites card view that will launch the Favourites Activity
         */
        mFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });


    }



}