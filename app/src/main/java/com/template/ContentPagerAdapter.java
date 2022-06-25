package com.template;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private final List<CharSequence> pageTextList;

    public ContentPagerAdapter(FragmentManager fragmentManager, List<CharSequence> pageTextList) {
        super(fragmentManager);
        this.pageTextList = pageTextList;
    }

    @Override
    public Fragment getItem(int i) {
        return SheetFragment.newInstance(pageTextList.get(i));
    }

    @Override
    public int getCount() {
        return pageTextList.size();
    }
}