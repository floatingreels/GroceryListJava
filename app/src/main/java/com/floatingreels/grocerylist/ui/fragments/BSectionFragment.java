package com.floatingreels.grocerylist.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.floatingreels.grocerylist.R;

public class BSectionFragment extends Fragment {

    public BSectionFragment() {
    }

    //factory
    public static BSectionFragment newInstance(){
        return new BSectionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_b, container, false);
        return rootView;
    }
}
