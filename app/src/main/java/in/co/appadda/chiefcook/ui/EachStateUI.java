package in.co.appadda.chiefcook.ui;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import in.co.appadda.chiefcook.R;

/**
 * Created by dewangankisslove on 05-02-2016.
 */
public class EachStateUI extends LinearLayout {
    public ListView recipeView;

    private void inflateLayout(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.each_state_activity, this);
        this.recipeView = (ListView) view.findViewById(R.id.listView);
    }

    public EachStateUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(context);
    }

    public EachStateUI(Context context) {
        super(context);
        inflateLayout(context);
    }
}
