package examplelibrarydesign.com.examplelibrarydesing.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import examplelibrarydesign.com.examplelibrarydesing.R;


public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        TextView textView = (TextView) view.findViewById(R.id.test);
        textView.setText("Fragment 1");
        return view;
    }

}
