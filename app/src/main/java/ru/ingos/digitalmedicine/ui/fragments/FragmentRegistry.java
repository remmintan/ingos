package ru.ingos.digitalmedicine.ui.fragments;

import ru.ingos.digitalmedicine.R;

/**
 * Created by Александр Шиян on 11.04.2017.
 *
 * Экран текущих записей на прием
 */
public class FragmentRegistry extends FragmentBase {

    public FragmentRegistry(){
        super();
        super.setLayout(R.layout.fragment_layout_registry);
        super.setTitle(R.string.frag_title_notes);
    }

}