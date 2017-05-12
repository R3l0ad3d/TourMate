package com.example.r3l0ad3d.tourmate.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.r3l0ad3d.tourmate.R;
import com.example.r3l0ad3d.tourmate.databinding.FragmentEventListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    private FragmentEventListBinding binding;

    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_event_list, container, false);
        binding = DataBindingUtil.bind(view);

        return view;
    }

}
