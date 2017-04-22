package ru.ingos.digitalmedicine.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.daimajia.swipe.SwipeLayout;
import ru.ingos.digitalmedicine.mvp.presenters.HomePresenter;
import ru.ingos.digitalmedicine.mvp.views.HomeView;
import ru.ingos.digitalmedicine.ui.activities.SpecialtyActivity;
import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Фрагмент, представляющий собой главный экран приложения. На нем располагаются ключевые кнопки, информация о
 * состоянии страховки и последняя активная запись к врачу.
 */
public class FragmentMain extends FragmentBase implements HomeView, AdapterView.OnClickListener{

    @BindView(R.id.last_clinic_name)
    TextView clinicName;
    @BindView(R.id.last_clinic_tel)
    TextView clinicPhone;
    @BindView(R.id.last_clinic_adress)
    TextView clinicAdress;
    @BindView(R.id.last_clinic_work_hours)
    TextView clinicWorkHours;

    @BindView(R.id.insuranse_username)
    TextView insuranceFullname;
    @BindView(R.id.insuranse_expire)
    TextView insuranceExpire;

    @BindView(R.id.btn_building_list)
    RelativeLayout swipe_right_btn;
    @BindView(R.id.block_insuranse)
    LinearLayout block_insurance;
    @BindView(R.id.btn_register)
    RelativeLayout add_registry;

    private Unbinder unbinder;

    @InjectPresenter(tag = "HOME")
    HomePresenter homePresenter;

    public FragmentMain(){
        super();
        super.setLayout(R.layout.fragment_layout_main);
        super.setTitle(R.string.frag_title_main);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance){
        unbinder = ButterKnife.bind(this, view);
        swipe_right_btn.setOnClickListener(this);
        block_insurance.setOnClickListener(this);
        add_registry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.block_insuranse:
                homePresenter.onInsuranceInfoClick();
                break;
            case R.id.btn_register:
                homePresenter.onNewRegistryBtnClick();
                break;
            case R.id.block_statistics:
                homePresenter.onStatisticsClick();
                break;
            case R.id.btn_building_list:
                homePresenter.onBuildingListClick();
                break;
            default:
                break;
        }
    }

    @Override
    public void setLastClinicInfo(String name, String adress, String phone, String workHours) {
        clinicName.setText(name);
        clinicAdress.setText(adress);
        clinicPhone.setText(phone);
        clinicWorkHours.setText(workHours);
    }

    @Override
    public void setInsuranceInfo(String userName, String expire, Boolean isRed) {
        insuranceFullname.setText(userName);
        insuranceExpire.setText(expire);

        int red = ContextCompat.getColor(getActivity(), R.color.colorAccent);
        int white = ContextCompat.getColor(getActivity(), R.color.White);

        insuranceExpire.setTextColor(isRed?red:white);
    }

    @Override
    public void showPrivateRoom() {
        super.changeView(FragmentPrivateRoom.class);
    }

    @Override
    public void showStatistics() {
        //TODO: добавить переход на экран статистики
    }

    @Override
    public void createNewRegistry() {
        startActivity(new Intent(getActivity(), SpecialtyActivity.class));
    }

    @Override
    public void showClinicsList() {
        super.changeView(FragmentClinicList.class);
    }

    @Override
    public void onDestroyView(){
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
