package ru.ingos.digitalmedicine.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.RegistryInfoPresenter;
import ru.ingos.digitalmedicine.mvp.views.RegistryInfoView;

public class RegistryInfoActivity extends MvpAppCompatActivity implements View.OnClickListener, RegistryInfoView {

    @InjectPresenter RegistryInfoPresenter presenter;

    @BindView(R.id.activity_registry_info_clinic_info) LinearLayout llClinicInfo;
    @BindView(R.id.activity_registry_info_specialty_info) LinearLayout llSpecInfo;
    @BindView(R.id.activity_registry_info_btn_cancle) RelativeLayout rlCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_info);
        ButterKnife.bind(this);

        llClinicInfo.setOnClickListener(this);
        llSpecInfo.setOnClickListener(this);
        rlCancelButton.setOnClickListener(this);

        ActionBar supportActionBar = this.getSupportActionBar();
        if(supportActionBar != null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setTitle(R.string.full_information_from_registry);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.activity_registry_info_clinic_info:
                presenter.onClinicInfoClick();
                break;
            case R.id.activity_registry_info_specialty_info:
                presenter.onSpecialistClick();
                break;
            case R.id.activity_registry_info_btn_cancle:
                presenter.onCancleRegistry();
                break;
            default:
                break;
        }
    }

    @Override
    public void registryCanceled() {
        onBackPressed();
    }

    @Override
    public void startChildActivity(Class<? extends MvpAppCompatActivity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
