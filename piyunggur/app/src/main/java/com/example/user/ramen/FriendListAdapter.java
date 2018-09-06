package com.example.user.ramen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FriendListAdapter extends BaseAdapter implements Filterable {


    private FriendListActivity activity;
    private FriendFilter friendFilter;
    private Typeface typeface;
    private ArrayList<User> friendList;
    private ArrayList<User> filteredList;


    public FriendListAdapter(FriendListActivity activity, ArrayList<User> filteredList){
        this.activity = activity;
        this.friendList = friendList;
        this.filteredList = friendList;
        typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/vegur_2.otf");

        getFilter();
    }


    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int i) {
        return filteredList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //A ViewHolder keeps refernces to children views to avoid unnecessary calls
        //to findViewById() on each row.
        final ViewHolder holder;
        final User suer = (User) getItem(position);


        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.friend_list_row_layout, parent, false);
            holder = new ViewHolder();
            holder.iconText = (TextView) view.findViewById(R.id.icon_text);
            holder.name = (TextView) view.findViewById(R.id.friend_list_row_layout_name);
            holder.iconText.setTypeface(typeface, Typeface.BOLD);
            holder.iconText.setTextColor(activity.getResources().getColor(R.color.while));
            holder.name.setTypeface(typeface, Typeface.NORMAL);

            view.setTag(holder);
        }else{
            //get view holder back
            holder = (ViewHolder) view.getTag();
        }

        //bind text with view holder content view for efficient use
        holder.iconText.setText("#");
        holder.name.setText(user.getEmail());
        view.setBackgroundResource(R.drawable.friend_list_selector);

        return view;
    }


    @Override
    public Filter getFilter() {
        if(friendFilter == null){
            friendFilter = new FriendFilter();
        }
        return friendFilter;
    }


    static class ViewHolder{
        TextView iconText;
        TextView name;
    }


    private class FriendFilter extends Filter{


        @Override
        protected FilterResults performFiltering(CharSequence constraint){
            FilterResults filterResults = new FilterResults();
            if(constraint != null && constraint.length() > 0){
                ArrayList<User> tempList = new ArrayList<User>();

                //search content in friend list
                for (User user : friendList){
                    if(user.getEmail().toLowerCase().contains(constraint.toString().toLowerCase())){
                        tempList.add(user);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;

            }else{
                filterResults.count = friendList.size();
                filterResults.values = friendList;
            }

            return filterResults;

        }


        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results){
            filteredList = (ArrayList<User>) results.values;
            notifyDataSetChanged();
        }
    }


}
