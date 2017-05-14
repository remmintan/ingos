package ru.ingos.digitalmedicine.ui.fragments.insuranceinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;
import ru.ingos.digitalmedicine.mvp.presenters.InsuranceServicesPresenter;
import ru.ingos.digitalmedicine.mvp.views.InsuranceServicesView;
import ru.ingos.digitalmedicine.ui.adapters.InsuranceServiceAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class FragmentAvailableService extends MVP4Fragment implements InsuranceServicesView{

    @BindView(R.id.fragment_available_service_recycler_view)
    RecyclerView rvAvailableServices;

    private InsuranceServiceAdapter mAdapter;

    @InjectPresenter
    InsuranceServicesPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_available_service, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        mAdapter = new InsuranceServiceAdapter(getActivity());

        rvAvailableServices.setLayoutManager(new LinearLayoutManager(null));
        rvAvailableServices.setAdapter(mAdapter);
    }

    @Override
    public void setInsuranceServices(List<InsuranceServiceModel> insuranceServices) {
        mAdapter.setmInsuranceServices(insuranceServices);
    }
}