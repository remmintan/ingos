package ru.ingos.digitalmedicine.ui.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;
import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.ingos.digitalmedicine.IngosApplication;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.fragments.MVP4Fragment;

public class FragmentHolderActivity extends MvpAppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fragment_holder);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        setupFragment();
    }

    private void setupFragment(){
        String className = getIntent().getStringExtra(IngosApplication.EXTRA_FRAGMENT_CLASSNAME);
        Class fragmentClass = null;
        Object fragmentInstance = null;

        try {
            fragmentClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            if(fragmentClass!=null) fragmentInstance = fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if(fragmentInstance != null) bindFragment(fragmentInstance);
    }

    private void bindFragment(Object fragment){
        if(Fragment.class.isAssignableFrom(fragment.getClass())){
            Fragment frag = (Fragment) fragment;
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.fragment_holder, frag);
            trans.commit();
        }else if(MVP4Fragment.class.isAssignableFrom(fragment.getClass())){
            MVP4Fragment frag = (MVP4Fragment) fragment;
            android.support.v4.app.FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.fragment_holder, frag);
            trans.commit();
        }else{
            Log.e("MOJAR", "Fragment has wrong class! Class: "+fragment.getClass());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        return true;
    }
}
