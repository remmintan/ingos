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
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.InsuranceServiceModel;
import ru.ingos.digitalmedicine.mvp.presenters.InsuranceServicesPresenter;
import ru.ingos.digitalmedicine.mvp.views.InsuranceServicesView;
import ru.ingos.digitalmedicine.ui.activities.FragmentHolderActivity;
import ru.ingos.digitalmedicine.ui.adapters.InsuranceServiceAdapter;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;
import ru.ingos.digitalmedicine.ui.listeners.ServicesListener;

public class FragmentUnavailableService extends MVP4Fragment implements InsuranceServicesView{

    @BindView(R.id.fragment_unavailable_service_recycler_view)
    RecyclerView rvUnavailableService;

    @InjectPresenter
    InsuranceServicesPresenter presenter;

    private InsuranceServiceAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_fragment_unavailable_service, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if(getActivity() instanceof FragmentHolderActivity)Utils.setActivityTitle(R.string.frag_title_unavailable_services, getActivity());
        ButterKnife.bind(this, view);

        mAdapter = new InsuranceServiceAdapter(getActivity(), new ServicesListener(getActivity(), this));

        rvUnavailableService.setLayoutManager(new LinearLayoutManager(null));
        rvUnavailableService.setAdapter(mAdapter);
    }

    @Override
    public void setInsuranceServices(List<InsuranceServiceModel> insuranceServices) {
        return;
    }

    @Override
    public void setClosedInsuranceServices(List<InsuranceServiceModel> closedInsuranceServices) {
        mAdapter.setmInsuranceServices(closedInsuranceServices);
    }
}
