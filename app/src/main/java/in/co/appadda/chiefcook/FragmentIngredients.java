package in.co.appadda.chiefcook;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;

import in.co.appadda.chiefcook.R;
import in.co.appadda.chiefcook.databases.RecipeOpenHelper;

/**
 * Created by HP on 20-12-2015.
 */
public class FragmentIngredients extends Fragment {
    RecipeOpenHelper recipeOpenHelper;
    String table_name;

    public FragmentIngredients(String table_name) {
        // Required empty public constructor
        this.table_name = table_name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredients, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recipeOpenHelper = new RecipeOpenHelper(getActivity().getApplicationContext());
        try {

            recipeOpenHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        try {

            recipeOpenHelper.openDataBase();
            getListViewIngredients();

        } catch (SQLException sqle) {

            throw sqle;

        }

    }

    private void getListViewIngredients() {


        Cursor cursor = recipeOpenHelper.getAllRow(table_name,"ingredients");


        // Allow activity to manage lifetime of the cursor.
        // DEPRECATED! Runs on the UI thread, OK for small/short queries.
        getActivity().startManagingCursor(cursor);

        // Setup mapping from cursor to view fields:
        String[] fromFieldNames = new String[]
                {RecipeOpenHelper.UID,recipeOpenHelper.Ingredients};
        int[] toViewIDs = new int[]
                {R.id.tv_recipe_id, R.id.tv_recipe_info};


        // Create adapter to may columns of the DB onto elemesnt in the UI.
        SimpleCursorAdapter myCursorAdapter =
                new SimpleCursorAdapter(
                        getActivity().getApplicationContext(),        // Context
                        R.layout.fragment_listview_layout,    // Row layout template
                        cursor,                    // cursor (set of DB records to map)
                        fromFieldNames,            // DB Column names
                        toViewIDs                // View IDs to put information in
                );


        // Set the adapter for the list view
        ListView myList = (ListView) getActivity().findViewById(R.id.list_data_ingredients);
        myList.setAdapter(myCursorAdapter);
    }
}
