package in.co.appadda.chiefcook.ui;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.co.appadda.chiefcook.R;

/**
 * Created by dewangankisslove on 10-01-2016.
 */
public class EachRecipeUI extends LinearLayout {
    public TabLayout tabLayout;
    public ViewPager viewPager;
    public RelativeLayout recipeImage;
    public TextView rname;

    private void inflateLayout(Context context) {
        LayoutInflater layoutInflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_recipe, this);

        this.recipeImage = (RelativeLayout) view.findViewById(R.id.rl_recipeImage);
        this.tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        this.viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        this.rname = (TextView) view.findViewById(R.id.tv_rname);
    }
    public EachRecipeUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(context);
    }

    public EachRecipeUI(Context context) {
        super(context);
        inflateLayout(context);
    }
}
