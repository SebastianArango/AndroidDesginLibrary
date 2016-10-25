package examplelibrarydesign.com.examplelibrarydesing.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import examplelibrarydesign.com.examplelibrarydesing.R;
import examplelibrarydesign.com.examplelibrarydesing.view.adapter.SampleFragmentPagerAdapter;


public class FragmentTabs extends Fragment {

    private TabLayout tabLayout;

    public FragmentTabs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tabs, container, false);

        castComponents(view);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager(), getActivity()));

        // Give the TabLayout the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void castComponents(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    }

}
