package zzz.com.myzhoubianyou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zzz.com.myzhoubianyou.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class HomeFragment extends BaseFragment {
    public View layout;
    public static final String TAG=HomeFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home_activity,container,false);
        return layout;
    }
}
