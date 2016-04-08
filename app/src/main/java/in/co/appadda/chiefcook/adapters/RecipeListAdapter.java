package in.co.appadda.chiefcook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.co.appadda.chiefcook.R;
import in.co.appadda.chiefcook.SharedPreference;

/**
 * Created by dewangankisslove on 12-01-2016.
 */
public class RecipeListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Recipes> recipesList;
    SharedPreference sharedPreference;


    public RecipeListAdapter(Context context, ArrayList<Recipes> recipesList) {
        this.context = context;
        this.recipesList = recipesList;
        sharedPreference = new SharedPreference();
    }
    private class Myholder{
        TextView myRecipe,time,serve;
        ImageView img;
        Myholder(View view){
            myRecipe = (TextView) view.findViewById(R.id.tv_recipe_names);
            time = (TextView) view.findViewById(R.id.tv_recipe_time);
            serve = (TextView) view.findViewById(R.id.tv_recipe_serves);
            img = (ImageView) view.findViewById(R.id.iv_recipe_icon);
        }
    }

    @Override
    public int getCount() {
        return recipesList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Myholder myholder = null;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_recipe_rowlayout, parent, false);
            myholder = new Myholder(row);
            row.setTag(myholder);
        }else {
            myholder = (Myholder) row.getTag();
        }
        Recipes recipeMy = (Recipes) getItem(position);
        myholder.myRecipe.setText(recipeMy.getName());
        myholder.time.setText(recipeMy.getTime());
        myholder.serve.setText(recipeMy.getServe());

        if (checkFavoriteItem(recipeMy)) {
            myholder.img.setImageResource(R.drawable.cook_red);
            myholder.img.setTag("active");
        } else {
            myholder.img.setImageResource(R.drawable.cook);
            myholder.img.setTag("deactive");
        }
        final Myholder finalMyholder = myholder;
        myholder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String tag = finalMyholder.img.getTag().toString();
                if (tag.equalsIgnoreCase("deactive")) {
                    sharedPreference.addFavorite(context, recipesList.get(position));
                    finalMyholder.img.setTag("active");
                    finalMyholder.img.setImageResource(R.drawable.cook_red);
                    Toast.makeText(context,"Added to favourite",Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreference.removeFavorite(context, recipesList.get(position));
                    finalMyholder.img.setTag("deactive");
                    finalMyholder.img.setImageResource(R.drawable.cook);
                    Toast.makeText(context,"Removed from favourite",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return row;
    }

    public boolean checkFavoriteItem(Recipes checkProduct) {
        boolean check = false;
        List<Recipes> favorites = sharedPreference.loadFavorites(context);
        if (favorites != null) {
            for (Recipes product : favorites) {
                if (product.equals(checkProduct)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }
}
