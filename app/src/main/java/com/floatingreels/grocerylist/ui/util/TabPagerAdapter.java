package com.floatingreels.grocerylist.ui.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.floatingreels.grocerylist.ui.fragments.ASectionFragment;
import com.floatingreels.grocerylist.ui.fragments.BSectionFragment;
import com.floatingreels.grocerylist.ui.fragments.CoolSectionFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    //referentie naar lijst met alle fragments, aangemaakt via factory method
    private Fragment[] fragments = {ASectionFragment.newInstance(), CoolSectionFragment.newInstance(), BSectionFragment.newInstance()};

    public TabPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //positie fragment moet overeenkomen met index in array van fragmenten
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title = "";
        if (position == 0) {
            title = "Section A";
        } else if (position == 1) {
            title = "Section Cool";
        } else if (position == 2){
            title = "Section B";
        }
        return title;
    }

}
