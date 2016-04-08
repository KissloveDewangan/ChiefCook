package in.co.appadda.chiefcook;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;

import in.co.appadda.chiefcook.adapters.StateCardAdapter;
import in.co.appadda.chiefcook.states.EachStateActivity;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String[] stateRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String adUnitId = getResources().getString(R.string.interstitial_ad_unit_id);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(adUnitId);

        // Create an ad request.
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        // Optionally populate the ad request builder.
        adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        adRequestBuilder.addTestDevice("3676315707EF0B20");
        adRequestBuilder.addTestDevice("62F3394F2CFAB534");

        // Start loading the ad now so that it is ready
        mInterstitialAd.loadAd(adRequestBuilder.build());

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setClickable(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new StateCardAdapter();
        mRecyclerView.setAdapter(mAdapter);

        stateRecipe = getResources().getStringArray(R.array.state_name);

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    int i = recyclerView.getChildAdapterPosition(child);
                    Intent OpenState = null;
                    OpenState = new Intent(MainActivity.this, EachStateActivity.class);
                    OpenState.putExtra("statename", stateRecipe[i]);
                    switch (i) {
                        case 0:
                            OpenState.putExtra("strtpos", 0);
                            OpenState.putExtra("endpos", 9);
                            break;
                        case 1:
                            OpenState.putExtra("strtpos", 10);
                            OpenState.putExtra("endpos", 17);
                            break;
                        case 2:
                            OpenState.putExtra("strtpos", 18);
                            OpenState.putExtra("endpos", 25);
                            break;
                        case 3:
                            OpenState.putExtra("strtpos", 26);
                            OpenState.putExtra("endpos", 35);
                            break;
                        case 4:
                            OpenState.putExtra("strtpos", 36);
                            OpenState.putExtra("endpos", 45);
                            break;
                        case 5:
                            OpenState.putExtra("strtpos", 46);
                            OpenState.putExtra("endpos", 55);
                            break;
                        case 6:
                            OpenState.putExtra("strtpos", 56);
                            OpenState.putExtra("endpos", 65);
                            break;
                        case 7:
                            OpenState.putExtra("strtpos", 66);
                            OpenState.putExtra("endpos", 75);
                            break;
                        case 8:
                            OpenState.putExtra("strtpos", 76);
                            OpenState.putExtra("endpos", 85);
                            break;
                        case 9:
                            OpenState.putExtra("strtpos", 86);
                            OpenState.putExtra("endpos", 95);
                            break;
                        case 10:
                            OpenState.putExtra("strtpos", 96);
                            OpenState.putExtra("endpos", 105);
                            break;
                        case 11:
                            OpenState.putExtra("strtpos", 106);
                            OpenState.putExtra("endpos", 115);
                            break;
                        case 12:
                            OpenState.putExtra("strtpos", 116);
                            OpenState.putExtra("endpos", 125);
                            break;
                        case 13:
                            OpenState.putExtra("strtpos", 126);
                            OpenState.putExtra("endpos", 135);
                            break;
                        case 14:
                            OpenState.putExtra("strtpos", 136);
                            OpenState.putExtra("endpos", 143);
                            break;
                        case 15:
                            OpenState.putExtra("strtpos", 144);
                            OpenState.putExtra("endpos", 151);
                            break;
                        case 16:
                            OpenState.putExtra("strtpos", 152);
                            OpenState.putExtra("endpos", 159);
                            break;
                        case 17:
                            OpenState.putExtra("strtpos", 160);
                            OpenState.putExtra("endpos", 169);
                            break;
                        case 18:
                            OpenState.putExtra("strtpos", 170);
                            OpenState.putExtra("endpos", 176);
                            break;
                        case 19:
                            OpenState.putExtra("strtpos", 177);
                            OpenState.putExtra("endpos", 186);
                            break;
                        case 20:
                            OpenState.putExtra("strtpos", 187);
                            OpenState.putExtra("endpos", 196);
                            break;
                        case 21:
                            OpenState.putExtra("strtpos", 197);
                            OpenState.putExtra("endpos", 206);
                            break;
                        case 22:
                            OpenState.putExtra("strtpos", 207);
                            OpenState.putExtra("endpos", 216);
                            break;
                        case 23:
                            OpenState.putExtra("strtpos", 217);
                            OpenState.putExtra("endpos", 226);
                            break;
                        case 24:
                            OpenState.putExtra("strtpos", 227);
                            OpenState.putExtra("endpos", 236);
                            break;
                        case 25:
                            OpenState.putExtra("strtpos", 237);
                            OpenState.putExtra("endpos", 246);
                            break;
                        case 26:
                            OpenState.putExtra("strtpos", 247);
                            OpenState.putExtra("endpos", 256);
                            break;
                        case 27:
                            OpenState.putExtra("strtpos", 257);
                            OpenState.putExtra("endpos", 266);
                            break;
                        case 28:
                            OpenState.putExtra("strtpos", 267);
                            OpenState.putExtra("endpos", 276);
                            break;
                    }
                    startActivity(OpenState);

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_icon, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i) {
            case R.id.share:
                shareapp();
                break;
            case R.id.favourite:
                Intent fav = new Intent(MainActivity.this, Favourite.class);
                startActivity(fav);
                break;
            case R.id.about_us:
                break;
            case R.id.rate:
                rate();
                break;
            case R.id.feedback:
                sendEmail();
                break;
        }
        return false;
    }

    public void sendEmail() {

        Intent email = new Intent(Intent.ACTION_SEND);
        // prompts email clients only

        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"foodequate@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Chief Cook");
        email.putExtra(Intent.EXTRA_TEXT, "");
        email.setType("message/rfc822");

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client"));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void shareapp() {
        try {

            PackageManager pm = getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), 0);
            File srcFile = new File(ai.publicSourceDir);
            Intent share = new Intent();
            share.setAction(Intent.ACTION_SEND);
            share.setType("application/vnd.android.package-archive");
            share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(srcFile));
            startActivity(Intent.createChooser(share, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void rate(){
        Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
        }
    }
}
