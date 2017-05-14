package com.example.r3l0ad3d.tourmate.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Toast;

import com.example.r3l0ad3d.tourmate.R;
import com.example.r3l0ad3d.tourmate.Weather.ModelClass.ForeCastReport;
import com.example.r3l0ad3d.tourmate.databinding.ExpandabelListChildItemBinding;
import com.example.r3l0ad3d.tourmate.databinding.ExpandableListParentItemBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by r3l0ad3d on 5/15/17.
 */

public class AdapterExpandableList extends BaseExpandableListAdapter {

    private Context context;
    private List<String> parentList = new ArrayList<>();
    private Map<String,List<ForeCastReport>> childWeather = new HashMap<>();
    private Map<String,List<List<String> > > childNearBy = new HashMap<>();

    public AdapterExpandableList(Context context, List<String> parentList, Map<String, List<List<String>>> childNearBy) {
        this.context = context;
        this.parentList = parentList;
        this.childNearBy = childNearBy;
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childNearBy.get(parentList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childNearBy.get(parentList.get(groupPosition)).get(childPosition);
        /*if(groupPosition>0){
            return childNearBy.get(parentList.get(groupPosition));
        }else {
            return childWeather.get(parentList.get(groupPosition));
        }*/

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.expandable_list_parent_item,parent,false);
        ExpandableListParentItemBinding binding = DataBindingUtil.bind(convertView);
        binding.tvParentTextExL.setText(parentList.get(groupPosition));
        binding.btnParentBtnMoreExL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"goto another fragment",Toast.LENGTH_LONG).show();
            }
        });
        binding.tvParentTextExL.setTypeface(null, Typeface.BOLD_ITALIC);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.expandabel_list_child_item,parent,false);
        ExpandabelListChildItemBinding binding = DataBindingUtil.bind(convertView);

        List<String> list = (List<String>) getChild(groupPosition,childPosition);

        AdapterNearByItem adapter = new AdapterNearByItem(context,list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        binding.rvChildItemExL.setHasFixedSize(true);
        binding.rvChildItemExL.setLayoutManager(layoutManager);

        binding.rvChildItemExL.setAdapter(adapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
