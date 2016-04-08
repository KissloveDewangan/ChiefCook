package in.co.appadda.chiefcook;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.co.appadda.chiefcook.adapters.Recipes;

/**
 * Created by dewangankisslove on 09-01-2016.
 */
public class SharedPreference {

    public static final String PREFS_NAME = "favourite_recipe";
    public static final String FAVORITES = "favourite";

    public SharedPreference() {
        super();
    }


    public void storeFavorites(Context context, List<Recipes> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public ArrayList<Recipes> loadFavorites(Context context) {
        SharedPreferences settings;
        List<Recipes> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Recipes[] favoriteItems = gson.fromJson(jsonFavorites,Recipes[].class);
            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Recipes>(favorites);
        } else
            return null;

        return (ArrayList<Recipes>) favorites;
    }


    public void addFavorite(Context context, Recipes beanSampleList) {
        List<Recipes> favorites = loadFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Recipes>();
        favorites.add(beanSampleList);
        storeFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Recipes beanSampleList) {
        ArrayList<Recipes> favorites = loadFavorites(context);
        if (favorites != null) {
            favorites.remove(beanSampleList);
            storeFavorites(context, favorites);
        }
    }




}
