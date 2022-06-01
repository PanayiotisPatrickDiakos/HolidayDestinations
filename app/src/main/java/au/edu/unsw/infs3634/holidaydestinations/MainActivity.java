package au.edu.unsw.infs3634.holidaydestinations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Responsible for creating the main Activity that launches as soon as the user opens the app
 */
public class MainActivity extends AppCompatActivity {

  //Instantiate handles for view elements
  Animation topAnimation, botAnimation;
  ImageView mLogo;
  TextView mAppName, mSlogan;
  Handler handler = new Handler();
  public static final int SPLASH_DELAY = 4000;
  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getSupportActionBar().hide();

    //Bind animation handles to the animation resource files utilising the AnimationUtils plug-in
    topAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_animation);
    botAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_animation);

    //Bind handles to view elements
    mLogo = findViewById(R.id.iv_logo);
    mAppName = findViewById(R.id.txt_app_name);
    mSlogan = findViewById(R.id.txt_slogan);

    //Setting the animation to the view elements
    mLogo.setAnimation(topAnimation);
    mAppName.setAnimation(botAnimation);
    mSlogan.setAnimation(botAnimation);

    /**
     * Implement a splash screen that will force a delay to display the app's splash screen
     */
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        Log.d(TAG,"Finished Splash, loading Home Activity");
        startActivity(intent);
        finish(); //So that the user cannot back button to the "loading screen"
      }
    }, SPLASH_DELAY); //Delay for splash background loading screen before running HomeActivity class
  }
}