package br.com.digitalhouse.pageview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class PhotoPageStateAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    //Contrutor que recebe um getSupportFragmentManager, e uma lista de fragmentos
    PhotoPageStateAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}