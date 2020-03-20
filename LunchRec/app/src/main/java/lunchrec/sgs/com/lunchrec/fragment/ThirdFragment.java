package lunchrec.sgs.com.lunchrec.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import lunchrec.sgs.com.lunchrec.R;

public class ThirdFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.two_fragment_main, container, false);
    }
}
