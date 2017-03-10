package com.oos_team.xuxin.rxreader.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oos_team.xuxin.rxreader.R;

/**
 * Created by xuxin on 17-2-20.
 */

public class LeftMenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_menu_fragment, container, false);

        return view;
    }
}
