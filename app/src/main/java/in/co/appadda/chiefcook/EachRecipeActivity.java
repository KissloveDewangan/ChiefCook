package in.co.appadda.chiefcook;

import android.app.ActionBar;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.co.appadda.chiefcook.databases.RecipeOpenHelper;
import in.co.appadda.chiefcook.ui.EachRecipeUI;

public class EachRecipeActivity extends AppCompatActivity {
    private int[] tabIcons = {
            R.drawable.ic_tab_ingredient,
            R.drawable.ic_tab_steps
    };
    String small,rname;
    Bundle basket;

    EachRecipeUI ui;
    RecipeOpenHelper recipeOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = new EachRecipeUI(this);

        basket = getIntent().getExtras();
        rname = basket.getString("rname");
        ui.rname.setText(rname);
        small = rname.toLowerCase().replaceAll("\\s", "");
        getSupportActionBar().hide();

      //  String[] recName = {"Mizo Vawksa", "Misa Mach Poora", "Paanch Phoran", "Foli Fish Kofta", "Phaanu", "Keema Dum", "Naat Yakkhn", "Haak", "Pomfret Moilee", "Aamti", "Tan", "Buta Dali", "Khira Gaintha", "Bhangui", "Muya Awandru", "Sobai Gudok", "Kothalor Chakoi"};

            recipeOpenHelper = new RecipeOpenHelper(getApplicationContext());
            try {

                recipeOpenHelper.createDataBase();

            } catch (IOException ioe) {

                throw new Error("Unable to create database");

            }
            try {

                recipeOpenHelper.openDataBase();

            } catch (SQLException sqle) {

                throw sqle;

            }

            byte[] ourImage = recipeOpenHelper.getImages(rname);
            Bitmap b1 = BitmapFactory.decodeByteArray(ourImage, 0, ourImage.length);
            Drawable d = new BitmapDrawable(getResources(), b1);
            ui.recipeImage.setBackground(d);

            setContentView(ui);


            setupViewPager(ui.viewPager);

            ui.tabLayout.setupWithViewPager(ui.viewPager);
            setupTabIcons();

        }


    private void setupTabIcons() {
        ui.tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        ui.tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentIngredients(small), "Ingredients");
        adapter.addFragment(new FragmentSteps(small), "Steps");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

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
                break;
            case R.id.favourite:
                Intent fav = new Intent(EachRecipeActivity.this,Favourite.class);
                startActivity(fav);
                break;

        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
