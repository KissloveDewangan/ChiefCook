package in.co.appadda.chiefcook.adapters;

/**
 * Created by HP on 18-12-2015.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.appadda.chiefcook.R;

public class StateCardAdapter extends RecyclerView.Adapter<StateCardAdapter.ViewHolder> {

    List<StateFoodItems> mItems;

    public StateCardAdapter() {
        super();
        mItems = new ArrayList<StateFoodItems>();
        StateFoodItems state = new StateFoodItems();
        state.setName("Andhra Pradesh");
        state.setThumbnail(R.drawable.ap_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Arunachal Pradesh");
        state.setThumbnail(R.drawable.aru_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Assam");
        state.setThumbnail(R.drawable.assam_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Bihar");
        state.setThumbnail(R.drawable.bihar_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Chhattisgarh");
        state.setThumbnail(R.drawable.cg_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Goa");
        state.setThumbnail(R.drawable.goa_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Gujarat");
        state.setThumbnail(R.drawable.guj_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Haryana");
        state.setThumbnail(R.drawable.har_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Himachal Pradesh");
        state.setThumbnail(R.drawable.hp_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Jharkhand");
        state.setThumbnail(R.drawable.jharkhand_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Jammu and Kashmir");
        state.setThumbnail(R.drawable.jk_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Karnataka");
        state.setThumbnail(R.drawable.karnataka_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Kerala");
        state.setThumbnail(R.drawable.kerala_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Maharashtra");
        state.setThumbnail(R.drawable.maharastra_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Manipur");
        state.setThumbnail(R.drawable.manipur_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Meghalaya");
        state.setThumbnail(R.drawable.meghalya_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Mizoram");
        state.setThumbnail(R.drawable.mizoram_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Madhya Pradesh");
        state.setThumbnail(R.drawable.mp_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Nagaland");
        state.setThumbnail(R.drawable.nagaland_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Odisha");
        state.setThumbnail(R.drawable.odisha_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Punjab");
        state.setThumbnail(R.drawable.punjab_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Rajasthan");
        state.setThumbnail(R.drawable.rajasthan_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Sikkim");
        state.setThumbnail(R.drawable.sikkim_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Tamil Nadu");
        state.setThumbnail(R.drawable.tamilnadu_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Telangana");
        state.setThumbnail(R.drawable.telangana_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("Tripura");
        state.setThumbnail(R.drawable.tripura_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("UttarPradesh");
        state.setThumbnail(R.drawable.up_food);
        mItems.add(state);


        state = new StateFoodItems();
        state.setName("Uttarakhand");
        state.setThumbnail(R.drawable.uttarakhand_food);
        mItems.add(state);

        state = new StateFoodItems();
        state.setName("West Bengal");
        state.setThumbnail(R.drawable.westbengal_food);
        mItems.add(state);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        StateFoodItems nature = mItems.get(i);
        viewHolder.stateName.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgThumbnail;
        public TextView stateName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            stateName = (TextView) itemView.findViewById(R.id.tv_state);
        }
    }



}
