package examplelibrarydesign.com.examplelibrarydesing.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import examplelibrarydesign.com.examplelibrarydesing.R;

public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);

        TextView textView = (TextView) view.findViewById(R.id.test3);
        textView.setText("Fragment 3");
        return view;
    }

}
