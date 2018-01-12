package org.institutoserpis.juanminm.fragmentoejemplos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EjemploFragment extends Fragment {
    int mNum;

    static EjemploFragment newInstance(int number) {
        EjemploFragment f = new EjemploFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        View tv;

        if (mNum % 2 == 0) {
            v = inflater.inflate(R.layout.fragment_ejemplo, container, false);
            tv = v.findViewById(R.id.text);
        } else {
            v = inflater.inflate(R.layout.fragment_ejemplo2, container, false);
            tv = v.findViewById(R.id.text2);
        }

        ((TextView) tv).setText("Fragmento número #" + mNum);

        return v;
    }
}
