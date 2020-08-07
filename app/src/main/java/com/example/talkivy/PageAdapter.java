package com.example.talkivy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int nooftabs;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm);
        this.nooftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new ChatTabFragment();
            case 1:
                return new GroupTabFragment();
            case 2:
                return new NearbyTabFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nooftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
