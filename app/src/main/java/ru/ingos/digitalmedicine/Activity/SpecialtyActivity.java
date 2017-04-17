package ru.ingos.digitalmedicine.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.adapters.SpecialityListAdapter;
import ru.ingos.digitalmedicine.models.SpecialityModel;

/**
 * Created by Alexandr on 17.04.2017.
 */



public class SpecialtyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speciality);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new SpecialityListAdapter(this, createData()));
    }

    private List<SpecialityModel> createData(){
        List<SpecialityModel> specialties = new ArrayList<>();

        specialties.add(new SpecialityModel("Терапевт"));
        specialties.add(new SpecialityModel("Ортопед"));
        specialties.add(new SpecialityModel("Гематолог"));
        specialties.add(new SpecialityModel("Логопед"));
        specialties.add(new SpecialityModel("ЛОР"));
        specialties.add(new SpecialityModel("Онколог"));
        specialties.add(new SpecialityModel("Хирург"));

        return specialties;

    }
}
