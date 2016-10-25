package examplelibrarydesign.com.examplelibrarydesing.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import examplelibrarydesign.com.examplelibrarydesing.view.fragment.Fragment1;
import examplelibrarydesign.com.examplelibrarydesing.view.fragment.Fragment2;
import examplelibrarydesign.com.examplelibrarydesing.view.fragment.Fragment3;

/**
 * Created by sarango on 25/10/2016.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"MENU DEL DIA", "VEGETARIANA", "BEBIDAS"};
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new Fragment1();
                break;
            case 1:
                frag = new Fragment2();
                break;
            case 2:
                frag = new Fragment3();
                break;
        }
        return frag;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
