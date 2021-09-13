package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailContactFrg extends Fragment {
    private Context mContext;
    private ContactEntity contactEntity;
    private TextView tvName;
    private TextView tvPhone;


    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemRoot = inflater.inflate(R.layout.frg_detail_contact, container, false);
        initViews(itemRoot);
        return itemRoot;
    }

    private void initViews(View itemRoot) {
        tvName = itemRoot.findViewById(R.id.tv_name);
        tvPhone = itemRoot.findViewById(R.id.tv_phone);

        if (contactEntity != null) {
            tvName.setText(contactEntity.getName());
            tvPhone.setText(contactEntity.getPhone());
        }
    }
}
