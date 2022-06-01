package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for creating the Detail Activity class
 */
public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "intent_message";
    private static final String TAG = "DetailActivity";
    private TextView mTitle, mTimeZone, mDescription, mLocalTime;
    private ImageView mImage, mFlag, mMap, mFavourite;
    private RatingBar mRating;
    public List<Destination> mFavourites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get a Handler for all the view elements
        mTitle = findViewById(R.id.txt_Detail_Title);
        mTimeZone = findViewById(R.id.txt_Detail_TimeZone);
        mDescription = findViewById(R.id.txt_Detail_Description);
        mLocalTime = findViewById(R.id.txt_Detail_Local_Current_Time);
        mFlag = findViewById(R.id.iv_Flag);
        mImage = findViewById(R.id.iv_Image);
        mMap = findViewById(R.id.iv_Map);
        mRating = findViewById(R.id.rb_Detail_Rating);
        mFavourite = findViewById(R.id.iv_Favourite);

        //Retrieve the intent that initiated this activity
        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            String destinationSymbol = getIntent().getStringExtra(INTENT_MESSAGE);
            Log.d(TAG, "INTENT_MESSAGE = " + destinationSymbol);
            Destination destination = Destination.getDestination(destinationSymbol);
            if (destination != null) {
                mTitle.setText(destination.getTitle());
                mTimeZone.setText(destination.getTimezone());
                mDescription.setText(destination.getDescription());
                mLocalTime.setText(destination.getLocalCurrentTime());
                mFlag.setImageResource(destination.getFlags());
                mImage.setImageResource(destination.getIcons());
                mMap.setImageResource(destination.getMaps());
                mRating.setRating(Float.valueOf(String.valueOf(destination.getRating())));
                if(destination.getFavStatus() == 0) {
                    mFavourite.setImageResource(R.drawable.favourite_empty);
                } else {
                    mFavourite.setImageResource(R.drawable.favourite_red);
                }

                /**
                 * Set an onclick listener on the title, which then runs the searchTitle() method
                 */
                mTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        searchTitle(destination.getTitle());
                    }
                });

                /**
                 * Set an onclick listener on the map image, which then runs the searchDestination() method
                 */
                mMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        searchDestination(destination.getCoordinates());
                    }
                });

                /**
                 * Set an onclick listener on the favourite heart button, which then runs either the set/removeFavourite() method
                 */
                mFavourite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (destination.getFavStatus() == 0) {
                            setFavourite(destination);
                        } else if(destination.getFavStatus() == 1) {
                            removeFavourite(destination);
                        }

                    }
                });
            }
        }
    }

    /**
     * Retrieves the destination's data and will set the favourite status to 0 (remove from favourites)
     * @param destination
     */
    private void removeFavourite(Destination destination) {
        mFavourite.setImageResource(R.drawable.favourite_empty);
        Toast.makeText(DetailActivity.this, destination.getTitle() + " removed from favourites", Toast.LENGTH_SHORT).show();
        destination.setFavStatus(0);
    }

    /**
     * Retrieves the destination's data and will set the favourite status to 1 (add to favourites)
     * @param destination
     */
    private void setFavourite(Destination destination) {
        mFavourite.setImageResource(R.drawable.favourite_red);
        Toast.makeText(DetailActivity.this, destination.getTitle() + " added to favourites", Toast.LENGTH_SHORT).show();
        destination.setFavStatus(1);
        Log.d(TAG, String.valueOf(destination.getFavStatus()));
    }

    /**
     * GOOGLE MAPS INTEGRATION
     * Method will accept the coordinate string from the destination's data
     * and implicitly search for an app that can utilise this geo data (google maps).
     * Then it will launch google maps and display these coordinates
     * @param coordinates - retrieves the coordinate string from the destinations array object
     */
    private void searchDestination(String coordinates) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:" + coordinates));
        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);
    }

    /**
     * BROWSER INTEGRATION
     * Method will accept destination's title and implicity parse the URl to an app (chrome) to
     * perform a google search of the string
     * @param name - retrieves the title string from the destination's array object
     */
    private void searchTitle(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }
}