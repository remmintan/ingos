package ru.ingos.digitalmedicine.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpFragment;
import ru.ingos.digitalmedicine.R;

public class FragmentRegistry extends MvpFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        super.onCreateView(inflater,container,savedInstance);
        getActivity().setTitle(R.string.frag_title_registry);
        return inflater.inflate(R.layout.fragment_layout_registry,container,false);
    }

}
