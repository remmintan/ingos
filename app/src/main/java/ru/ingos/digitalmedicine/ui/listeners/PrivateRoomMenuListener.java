package ru.ingos.digitalmedicine.ui.listeners;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import ru.ingos.digitalmedicine.common.Utils;
import ru.ingos.digitalmedicine.ui.activities.InsuranceServicesInfoActivity;
import ru.ingos.digitalmedicine.ui.activities.PersonalDataActivity;
import ru.ingos.digitalmedicine.ui.activities.StatsActivity;
import ru.ingos.digitalmedicine.ui.fragments.FragmentSettings;

public class PrivateRoomMenuListener implements View.OnClickListener {

    private final RecyclerView mView;

    private final Activity head;

    public PrivateRoomMenuListener(RecyclerView mView, Activity head) {
        this.mView = mView;
        this.head = head;
    }

    @Override
    public void onClick(View v) {
        int pos = this.mView.getChildAdapterPosition(v);

        switch (pos){
            case 0: //Персональыне данные
                Intent i0 = new Intent(head, PersonalDataActivity.class);
                head.startActivity(i0);
                break;
            case 1: //Информация о страховке
                Intent i1 = new Intent(head, InsuranceServicesInfoActivity.class);
                head.startActivity(i1);
                break;
            case 2: //Сервисы
                Utils.showFragmentInActivity(FragmentSettings.class, head);
                break;
            case 3: //Статистика
                Intent i3 = new Intent(head, StatsActivity.class);
                head.startActivity(i3);
                break;
        }
    }
}
