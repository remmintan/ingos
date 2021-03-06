package ru.ingos.digitalmedicine.mvp.presenters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.mvp.models.InsuranceInfoModel;
import ru.ingos.digitalmedicine.mvp.views.InsuranceInfoView;

@InjectViewState
public class InsuranceInfoPresenter extends MvpPresenter<InsuranceInfoView> {

    private InsuranceInfoModel insuranceInfo;

    private void loadInsuranceInfo(Context context){
        insuranceInfo = new InsuranceInfoModel("Леонид Каприов",
                "0000 0000 0000",
                "365 дней",
                ContextCompat.getDrawable(context, R.drawable.ic_dicaprio));

    }

    @Override
    protected void onFirstViewAttach() {
        Utils.logPresenterCreated(InsuranceInfoPresenter.class);
        getViewState().laodMethodsWithContext();
    }

    public void setInsuranceInfo(Context context) {
        loadInsuranceInfo(context);
        getViewState().setInsuranceInfo(
                insuranceInfo.getName(),
                insuranceInfo.getInsuranceNumber(),
                insuranceInfo.getInsuranceDate(),
                insuranceInfo.getAvatar()
        );
    }
}
