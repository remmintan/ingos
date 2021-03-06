package ru.ingos.digitalmedicine.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import ru.ingos.digitalmedicine.ui.fragments.fragmentmain.FavoriteFragment;
import ru.ingos.digitalmedicine.ui.fragments.fragmentmain.InsuranceInfoFragment;
import ru.ingos.digitalmedicine.ui.fragments.fragmentmain.RegistryFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentMainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public FragmentMainAdapter(FragmentManager fm) {
        super(fm);

        fragments.add(new RegistryFragment());
        fragments.add(new InsuranceInfoFragment());
        fragments.add(new FavoriteFragment());

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return object instanceof Fragment && ((Fragment) object).getView() == view;
    }
}
