package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMainActCallback {
    private ImageView ivContact, ivInfo;
    private ListContactFrg listContactFrg;
    private DetailContactFrg detailContactFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        ivContact = findViewById(R.id.iv_contact);
        ivInfo = findViewById(R.id.iv_info);
        changeTab(ivContact, ivInfo);


        ivInfo.setOnClickListener(this);
        ivContact.setOnClickListener(this);
        listContactFrg = new ListContactFrg();
        detailContactFrg = new DetailContactFrg();
        listContactFrg.setCallback(this);

        showListContactFrg();
    }

    private void showListContactFrg() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, listContactFrg, listContactFrg.getClass().getName())
                .commit();
    }

    private void showDetailContactFrg() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, detailContactFrg, detailContactFrg.getClass().getName())
                .commit();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_contact) {
            changeTab(ivContact, ivInfo);
            showListContactFrg();
        } else if (view.getId() == R.id.iv_info) {
            changeTab(ivInfo, ivContact);
            showDetailContactFrg();
        }
    }

    private void changeTab(ImageView selectTab, ImageView unselectTab) {
        selectTab.setBackgroundResource(R.color.white);
        selectTab.setColorFilter(ContextCompat.getColor(this, R.color.design_default_color_primary),
                android.graphics.PorterDuff.Mode.SRC_IN);
        unselectTab.setBackgroundResource(R.color.design_default_color_primary);
        unselectTab.setColorFilter(ContextCompat.getColor(this, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void showDetailContact(ContactEntity contactEntity) {
        detailContactFrg.setContactEntity(contactEntity);
        showDetailContactFrg();
    }
}