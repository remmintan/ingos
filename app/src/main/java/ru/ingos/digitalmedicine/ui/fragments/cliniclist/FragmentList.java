package ru.ingos.digitalmedicine.ui.fragments.cliniclist;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ClinicListModel;
import ru.ingos.digitalmedicine.mvp.presenters.ClinicListPresenter;
import ru.ingos.digitalmedicine.mvp.views.ClinicListView;
import ru.ingos.digitalmedicine.ui.adapters.ClinicListAdapter;
import ru.ingos.digitalmedicine.ui.fragments.Mvp4Fragment;

import java.util.List;

public class FragmentList extends Mvp4Fragment implements ClinicListView {

    private ClinicListAdapter mClinicListAdapter;

    @InjectPresenter(type=PresenterType.GLOBAL, tag="ClinicListPresenter") ClinicListPresenter presenter;

    @BindView(R.id.child_fragment_clinic_list_recyclerview) RecyclerView rvHolder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.child_fragment_clinic_list, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstance){
        ButterKnife.bind(this, view);

        Log.d(IngosApplication.DEBUG_TAG, view.getClass().getCanonicalName());

        mClinicListAdapter = new ClinicListAdapter(getActivity());
        presenter.setClinics();
        rvHolder.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHolder.setAdapter(mClinicListAdapter);

        ViewPager.LayoutParams params = (ViewPager.LayoutParams) view.getLayoutParams();
        params.height = 1024;
        view.setLayoutParams(params);
    }

    @Override
    public void setClinics(List<ClinicListModel> clinics)
    {
        if(mClinicListAdapter != null) mClinicListAdapter.setClinics(clinics);
        else Log.w(IngosApplication.DEBUG_TAG, "ListAdapter in clinic list is null!");
    }

    @Override
    public void moveMap(LatLng ll) {    }

    @Override
    public void zoom(float zoom) {    }

    @Override
    public void addMarker(MarkerOptions mo) {    }
}
