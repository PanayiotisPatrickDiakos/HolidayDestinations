package au.edu.unsw.infs3634.holidaydestinations;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Destination class that provides data for the destination records
 * Declare record variables
 */
public class Destination {
    private static final String TAG = "Destination";
    private String name;
    private String title;
    private String symbol;
    private Double rating;
    private String timezone;
    private String localCurrentTime;
    private String description;
    private int maps;
    private int icons;
    private int flags;
    private String coordinates;
    private int favStatus;

    /**
     * Construct record variables
     * @param name - Name of the country the holiday destination is located in
     * @param title - Name of the holiday destination
     * @param symbol - String identifier for the record
     * @param rating - Numeric rating for the record
     * @param timezone - Local timezone the destination is located in
     * @param localCurrentTime - Calculated local time of the destination based off the timezone
     * @param description - Short description which has been sourced from "lonelyplanet.com
     * @param maps - Image of the destination's location on a map, clickable which opens google maps
     * @param icons - Image of the actual destination
     * @param flags - Flag of the coutry the destination is located in
     * @param coordinates - Coordinates of the destination to be parsed through google maps
     * @param favStatus - Favourite status of the record
     */
    public Destination(String name, String title, String symbol, Double rating,
                       String timezone, String localCurrentTime, String description, int maps, int icons, int flags, String coordinates, int favStatus) {
        this.symbol = symbol;
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.timezone = timezone;
        this.localCurrentTime = localCurrentTime;
        this.description = description;
        this.maps = maps;
        this.icons = icons;
        this.flags = flags;
        this.coordinates = coordinates;
        this.favStatus = favStatus;
    }

    /**
     *
     * Getters and Setters
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocalCurrentTime() {
        return localCurrentTime;
    }

    public void setLocalCurrentTime(String localCurrentTime) {
        this.localCurrentTime = localCurrentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public int getMaps() {
        return maps;
    }

    public void setMaps(int maps) {
        this.maps = maps;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(int favStatus) {
        this.favStatus = favStatus;
    }

    /**
     * Responsible for generating all destination data into an arraylist which can then be called
     * upon within another class (therefore the public status of the method)
     * @returndestinations - Returns the ArrayList of destinations to the class calling this method
     */
    public static ArrayList<Destination> getDestinations() {
        ArrayList<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination("Greece", "Acropolis", "GR", 5.0, "EEST", null,
                "Hedonists rejoice! Greece is ancient sun-bleached ruins piercing blue" +
                        " skies, the balmy Aegean lapping an endless coastline and a culture alive " +
                        "with passionate music, wonderful cuisine and thrill-seeking activities.",
                R.drawable.acropolis_map01, R.drawable.acropolis_map02, R.drawable.gr, "37.97165068769283, 23.72577065576142", 1));
        destinations.add(new Destination("Spain","Basilica La Sagrada Familia", "SP", 4.0, "CEST", null,
                "Passionate, sophisticated and devoted to living the good life, Spain is " +
                        "both a stereotype come to life and a country more diverse than you ever " +
                        "imagined.",
                R.drawable.basilicalasagradafamilia_map01, R.drawable.basilicalasagradafamilia_map02, R.drawable.es, "41.40367011609531, 2.1743772558577783", 0));
        destinations.add(new Destination("France", "Eiffel Tower","FR", 3.5, "CEST", null,
                "France seduces travellers with its unfalteringly familiar culture, woven " +
                        "around cafe terraces, village-square markets and lace-curtained bistros " +
                        "with their plat du jour (dish of the day) chalked on the board.",
                R.drawable.eiffeltower_map01, R.drawable.eiffeltower_map02, R.drawable.fr, "48.85842778364132, 2.2944950286588313", 1));
        destinations.add(new Destination("India", "Taj Mahal","ID", 2.8, "IST", null,
                "With its sumptuous mix of traditions, spiritual beliefs, festivals, " +
                        "architecture and landscapes, your memories of India will blaze bright long " +
                        "after you've left its shores.",
                R.drawable.tajmahal_map01, R.drawable.tajmahal_map02, R.drawable.in, "27.175149145846518, 78.04214313073578", 0));
        destinations.add(new Destination("Australia","Harbour Bridge", "AU", 5.0, "AEST", null,
                "Australia is the unexpected: a place where the world’s oldest cultures " +
                        "share vast ochre plains, stylish laneways and unimaginably blue waters with " +
                        "successive waves of new arrivals from across the globe.",
                R.drawable.harbourbridge_map01, R.drawable.harbourbridge_map02, R.drawable.au, "-33.85224420633101, 151.21082585042635", 0));
        destinations.add(new Destination("Great Britain", "Big Ben", "GB", 4.3, "GMT", null,
                "Australia is the unexpected: a place where the world’s oldest cultures " +
                        "share vast ochre plains, stylish laneways and unimaginably blue waters with " +
                        "successive waves of new arrivals from across the globe.",
                R.drawable.bigben_map01, R.drawable.bigben_map02, R.drawable.gb, "51.50073251900912, -0.12460863768675848", 0));
        destinations.add(new Destination("Portugal","Torre de Belem", "PT", 4.0, "WEST", null,
                "Medieval castles, cobblestone villages, captivating cities and golden " +
                        "beaches: the Portugal experience can be many things. History, great food " +
                        "and idyllic scenery are just the beginning…",
                R.drawable.belemtower_map01, R.drawable.belemtower_map02, R.drawable.pt, "38.691589960172806, -9.215959196996371", 0));
        destinations.add(new Destination("Italy","Leaning Tower of Pisa", "IT", 3.0, "CEST", null,
                "Home to many of the world's greatest works of art, architecture and " +
                        "gastronomy, Italy elates, inspires and moves like no other.",
                R.drawable.leaningtowerofpisa_map01, R.drawable.leaningtowerofpisa_map02, R.drawable.it, "43.722958278939196, 10.396616444274331", 0));
        destinations.add(new Destination("New Zealand","Hobbiton", "NZ", 3.9, "NZDT", null,
                "Get ready for mammoth national parks, dynamic Māori culture, and " +
                        "world-class surfing and skiing. New Zealand can be mellow or action-packed, " +
                        "but it's always epic.",
                R.drawable.hobbiton_map01, R.drawable.hobbiton_map02, R.drawable.nz, "-37.8720839588607, 175.68294147682465", 0));
        destinations.add(new Destination("Japan","Tokyo Disney Resort", "JP", 4.2, "JST", null,
                "Japan is truly timeless, a place where ancient traditions are fused with " +
                        "modern life as if it were the most natural thing in the world.",
                R.drawable.tokyodisneyresort_map01, R.drawable.tokyodisneyresort_map02, R.drawable.jp, "35.63066714550535, 139.88286949802725", 0));
        getCurrentTime(destinations);

        return destinations;
    }

    /**
     * Responsible for calculating the local current time in the destination's timezone
     * by utilising the setTimeZone plug-in
     * @param destinations - Retrieves the destinations array list created in getDestinations()
     */
    public static void getCurrentTime(ArrayList<Destination> destinations) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
        String[] currentTimeArray = new String[10];

        for(int i = 0; i <destinations.size(); i++) {
            if(destinations.get(i).getName().equals("Greece")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Athens"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Spain")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("France")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("India")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Australia")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Canberra"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Great Britain")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Portugal")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Portugal"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Italy")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("New Zealand")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));

            } else if(destinations.get(i).getName().equals("Japan")) {
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
                currentTimeArray[i] = dateFormat.format(date);
                destinations.get(i).setLocalCurrentTime(String.valueOf(currentTimeArray[i]));
            }
        }
        //Print the currentTimeArray list with the country's name to ensure correct local times are
        //being generated
        for(int i = 0; i < currentTimeArray.length; i++) {
            Log.d(TAG, String.valueOf(destinations.get(i).getName()));
            Log.d(TAG, String.valueOf(currentTimeArray[i]));
        }
    }

    /**
     * Responsible for retrieving the singular destination's data for an onclicklistener
     * @param symbol - Retrieve string value of destination's Tag value from recyclerview handler
     * @return - return the destination data
     */
    public static Destination getDestination(String symbol) {
        Log.d(TAG, "getDestination Running" + symbol);
        ArrayList<Destination> destinations = Destination.getDestinations();
        for(final Destination destination : destinations) {
            if(destination.getSymbol().equals(symbol)) {
                return destination;
            }
        }
        return null;
    }

    /**
     * Responsible for retrieving the list of favourited destinations by the user
     * @param destinations - retrieves the list of destinations generated in getDestinations()
     * @return - returns the favourite list
     */
    public static ArrayList<Destination> getFavourites(ArrayList<Destination> destinations) {
        ArrayList<Destination> favourites = new ArrayList<>();
        for(int i = 0; i <destinations.size(); i++) {
            if(destinations.get(i).getFavStatus() == 1) {
                favourites.add(destinations.get(i));
            }
        }
        return favourites;
    }

}
