package in.co.appadda.chiefcook;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import in.co.appadda.chiefcook.adapters.Recipes;

public class Favourite extends AppCompatActivity {
    private ListView favouriteListView;
    public static FavouritesListAdapter favouritsListAdapter;
    private ArrayList<Recipes> favouritesBeanSampleList;
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.each_state_activity);

        appBar();

        sharedPreference=new SharedPreference();
        try {
            favouritesBeanSampleList = sharedPreference.loadFavorites(getApplicationContext());
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        favouriteListView = (ListView) findViewById(R.id.listView);
    }

    public void appBar(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("onResume", "onResume Called");
        if(favouritesBeanSampleList != null ) {
            try {
                favouritsListAdapter = new FavouritesListAdapter(getApplicationContext(), favouritesBeanSampleList);
                favouriteListView.setAdapter(favouritsListAdapter);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            favouritsListAdapter.notifyDataSetChanged();
        }
    }

    public class FavouritesListAdapter extends BaseAdapter {

        Context context;
        ArrayList<Recipes> favouritesBeanSampleList;

        public FavouritesListAdapter(Context context, ArrayList<Recipes> favouritesBeanSampleList) {
            this.context = context;
            this.favouritesBeanSampleList = favouritesBeanSampleList;
        }

        public int getCount() {
            return favouritesBeanSampleList.size();
        }

        public Object getItem(int position) {
            return favouritesBeanSampleList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        class ViewHolder {
            TextView myRecipe, time, serve;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_recipe_rowlayout, parent, false);
                holder = new ViewHolder();
                holder.myRecipe = (TextView) convertView.findViewById(R.id.tv_recipe_names);
                holder.time = (TextView) convertView.findViewById(R.id.tv_recipe_time);
                holder.serve = (TextView) convertView.findViewById(R.id.tv_recipe_serves);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.myRecipe.setText(favouritesBeanSampleList.get(position).getName());
            holder.time.setText(favouritesBeanSampleList.get(position).getTime());
            holder.serve.setText(favouritesBeanSampleList.get(position).getServe());
            return convertView;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
