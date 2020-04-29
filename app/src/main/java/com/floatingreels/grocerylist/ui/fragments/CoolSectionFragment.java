package com.floatingreels.grocerylist.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.floatingreels.grocerylist.R;

public class CoolSectionFragment extends Fragment {

    public CoolSectionFragment() {
    }

    //factory
    public static CoolSectionFragment newInstance(){
        return new CoolSectionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_cool, container, false);
        return rootView;
    }
}
