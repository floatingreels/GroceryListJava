package com.floatingreels.grocerylist.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.floatingreels.grocerylist.R;

public class ASectionFragment extends Fragment {

    public ASectionFragment() {
    }

    //factory
    public static ASectionFragment newInstance(){
        return new ASectionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_a, container, false);
        return rootView;
    }
}
