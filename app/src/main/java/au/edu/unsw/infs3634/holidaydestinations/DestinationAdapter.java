package au.edu.unsw.infs3634.holidaydestinations;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Adapter class for the Destination class to handle the viewholder and search / sort functions
 * for the recycler view
 */
public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> implements Filterable {
    private static final String TAG = "DestinationAdapter";
    private List<Destination> mDestinations, mDestinationsFiltered;
    private RecyclerViewClickListener mListener;
    public static final int SORT_METHOD_TITLE = 1;
    public static final int SORT_METHOD_NAME = 2;
    public static final int SORT_METHOD_RATING = 3;
    public static final int SORT_METHOD_TIME = 4;


    /**
     * Constructor method for DestinationAdapter class
     */
    public DestinationAdapter(List<Destination> mDestinations, RecyclerViewClickListener mListener) {
        this.mDestinations = mDestinations;
        this.mListener = mListener;
        this.mDestinationsFiltered = mDestinations;
    }

    /**
     * Create the ViewHolder and return it
     */
    @NonNull
    @Override
    public DestinationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view, mListener);
    }

    /**
     * Associate the data with the view holder for a given position within the RecyclerView
     * @param holder - Viewholder parameter
     * @param position - integer value of the record's row in the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull DestinationAdapter.ViewHolder holder, int position) {
        Destination destination = mDestinationsFiltered.get(position);
        holder.mImage.setImageResource(destination.getFlags());
        holder.mTitle.setText(destination.getTitle());
        holder.mLocalCurrentTime.setText(destination.getLocalCurrentTime());
        holder.mRating.setRating((Float.parseFloat(String.valueOf(destination.getRating()))));
        holder.mLocation.setText(destination.getName());
        holder.mTimeZone.setText(destination.getTimezone());
        holder.itemView.setTag(destination.getSymbol());

    }

    /**
     * Utilise the filtered list to set the numebr of records of the recycler view
     * @return
     */
    @Override
    public int getItemCount() {
        return mDestinationsFiltered.size();
    }

    /**
     * Method of the Filterable interface
     * Perform the Filter(search) on either the destination's title, country name or timezone
     * @return
     */
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                Log.d(TAG, "Performing the search action");
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mDestinationsFiltered = mDestinations;
                } else {
                    ArrayList<Destination> filteredList = new ArrayList<>();
                    for (Destination destination : mDestinations) {
                        if (destination.getTitle().toLowerCase().contains(charString.toLowerCase())
                                || destination.getName().toLowerCase().contains(charString.toLowerCase())
                                || destination.getTimezone().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(destination);
                        }
                    }
                    mDestinationsFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDestinationsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                Log.d(TAG, "Submitted search action");
                mDestinationsFiltered = (ArrayList<Destination>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    /**
     * Declare and Instantiate the Viewholder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImage;
        private TextView mTitle, mLocalCurrentTime, mLocation, mTimeZone;
        private RatingBar mRating;
        private RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View view, RecyclerViewClickListener listener) {
            super(view);
            mListener = listener;
            view.setOnClickListener(this);
            mImage = view.findViewById(R.id.iv_Icon);
            mTitle = view.findViewById(R.id.txt_Name);
            mRating = view.findViewById(R.id.rb_Rating);
            mLocalCurrentTime = view.findViewById(R.id.txt_Local_Current_Time);
            mLocation = view.findViewById(R.id.txt_Location);
            mTimeZone = view.findViewById(R.id.txt_TimeZone);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, (String) view.getTag());
            Log.d(TAG, (String) view.getTag());
        }
    }

    /**
     * Implement the sort method which can sort the records based alphabetically based on their
     * Title, Country Name, Rating (Ascending) and Local Time (Ascending)
     * @param sortMethod
     */
    public void sort(final int sortMethod) {
        Log.d(TAG,"Sorting Items");
        if (mDestinationsFiltered.size() > 0) {
            Log.d(TAG, "Filtered List has more than 0");
            Collections.sort(mDestinationsFiltered, new Comparator<Destination>() {
                @Override
                public int compare(Destination d1, Destination d2) {
                    if (sortMethod == SORT_METHOD_NAME) {
                        Log.d(TAG,"Sort Method Name true");
                        //Sort list by product name
                        Log.d(TAG, d1.getName());
                        return d1.getName().compareToIgnoreCase(d2.getName());
                    } else if (sortMethod == SORT_METHOD_TITLE) {
                        return d1.getTitle().compareToIgnoreCase(d2.getTitle());
                    } else if (sortMethod == SORT_METHOD_RATING) {
                        return d1.getRating().compareTo(d2.getRating());
                    } else if (sortMethod == SORT_METHOD_TIME) {
                        return d1.getLocalCurrentTime().compareToIgnoreCase(d2.getLocalCurrentTime());
                    }
                    return d2.getTitle().compareTo(d1.getTitle());
                }
            });
        }
        notifyDataSetChanged();
    }

    //ClickListener interface
    public interface RecyclerViewClickListener {
        void onClick(View view, String destinationSymbol);
    }
}
