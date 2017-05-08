package ru.ingos.digitalmedicine.ui.adapters;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.activities.RegistryInfoActivity;
import ru.ingos.digitalmedicine.ui.listeners.OnClickListener;
import ru.ingos.digitalmedicine.ui.models.RegistryModel;

public class RegistryListAdapter extends RecyclerView.Adapter<RegistryListAdapter.RegistryHolder> {

    List<RegistryModel> registry;
    private final OnClickListener listener;


    public RegistryListAdapter(List<RegistryModel> registry, Activity activity) {
        this.registry = registry;
        this.listener = new OnClickListener(activity, RegistryInfoActivity.class);
    }

    @Override
    public RegistryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.block_registry_info, parent, false);


        return new RegistryHolder(view);
    }

    @Override
    public void onBindViewHolder(RegistryHolder holder, int position) {
        RegistryModel current = registry.get(position);
        holder.setData(current, position);
        holder.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return registry.size();
    }

    public class RegistryHolder extends RecyclerView.ViewHolder {

        private TextView tvTimeRegistry;
        private TextView tvNameService;
        private TextView tvAddressClinic;
        private int position;
        private View view;


        public RegistryHolder(View itemView) {
            super(itemView);

            tvTimeRegistry = (TextView) itemView.findViewById(R.id.tvTimeRegistry);
            tvNameService = (TextView) itemView.findViewById(R.id.tvNameService);
            tvAddressClinic = (TextView) itemView.findViewById(R.id.tvAdClinic);

        }

        public void setData(RegistryModel currentObject, int position) {
            this.tvTimeRegistry.setText(currentObject.getTimeRegistry());
            this.tvNameService.setText(currentObject.getNameService());
            this.tvAddressClinic.setText(currentObject.getAddressClinic());
            this.position = position;
            this.view = itemView;
        }

        public void setOnClickListener(View.OnClickListener listener){
            view.setOnClickListener(listener);
        }

    }
}