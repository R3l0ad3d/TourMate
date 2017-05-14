package com.example.r3l0ad3d.tourmate.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.r3l0ad3d.tourmate.Adapter.AdapterEventList;
import com.example.r3l0ad3d.tourmate.ModelClass.Event;
import com.example.r3l0ad3d.tourmate.R;
import com.example.r3l0ad3d.tourmate.databinding.FragmentEventListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    private FragmentEventListBinding binding;
    private AdapterEventList adapter;
    private List<Event> eventList;

    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_event_list, container, false);
        binding = DataBindingUtil.bind(view);
        eventList = new ArrayList<>();

        populateListFromDatabse();

        adapter = new AdapterEventList(getContext(),eventList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvEventList.setHasFixedSize(true);
        binding.rvEventList.setLayoutManager(layoutManager);
        binding.rvEventList.setAdapter(adapter);

        binding.fabCreateEventEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.replaceLayout,new CreateEventFragment()).commit();
                ft.addToBackStack(null);
            }
        });

        return view;
    }

    private void populateListFromDatabse() {
        for(int i =0;i<10;i++){
            Event event = new Event("today","India","tomorrow","tomorrow next","10000");
            eventList.add(event);
        }
    }

}
