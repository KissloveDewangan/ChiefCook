package in.co.appadda.chiefcook.states;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import in.co.appadda.chiefcook.EachRecipeActivity;
import in.co.appadda.chiefcook.Favourite;
import in.co.appadda.chiefcook.R;
import in.co.appadda.chiefcook.adapters.RecipeListAdapter;
import in.co.appadda.chiefcook.adapters.Recipes;
import in.co.appadda.chiefcook.SharedPreference;
import in.co.appadda.chiefcook.ui.EachStateUI;


/**
 * Created by HP on 19-12-2015.
 */
public class EachStateActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] foodName, foodTime, foodServe;
    private ArrayList<Recipes> recipesArrayList = new ArrayList<Recipes>();
    SharedPreference sharedPreference;
    private RecipeListAdapter adapter;

    EachStateUI ui;
    Bundle basket;
    int strt, end;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = new EachStateUI(this);
        basket = getIntent().getExtras();
        strt = basket.getInt("strtpos");
        end = basket.getInt("endpos");
        title = basket.getString("statename");
        setContentView(ui);

        getSupportActionBar().setTitle(title);

        foodName = getResources().getStringArray(R.array.all_cuisine);
        foodTime = getResources().getStringArray(R.array.all_cuisine_time);
        foodServe = getResources().getStringArray(R.array.all_cuisine_serve);

        sharedPreference = new SharedPreference();

        for (int i = strt; i < end + 1; i++) {
            recipesArrayList.add(new Recipes(i + 1, foodName[i], foodTime[i], foodServe[i]));
        }

        adapter = new RecipeListAdapter(this, recipesArrayList);
        ui.recipeView.setAdapter(adapter);
        ui.recipeView.setClickable(true);
        ui.recipeView.setOnItemClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String str = recipesArrayList.get(position).getName();
        Bundle basket = new Bundle();
        Intent newRecipes;
        basket.putString("rname", str);
        newRecipes = new Intent(EachStateActivity.this, EachRecipeActivity.class);
        newRecipes.putExtras(basket);
        startActivity(newRecipes);
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
                Intent fav = new Intent(EachStateActivity.this, Favourite.class);
                startActivity(fav);
                break;
        }
        return false;
    }
}

