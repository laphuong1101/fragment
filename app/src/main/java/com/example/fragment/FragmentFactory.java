package com.example.fragment;

import androidx.fragment.app.Fragment;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class    FragmentFactory {
    private static final HashMap listFragment = new HashMap();
    private static FragmentFactory instance;

    private FragmentFactory() {

    }

    public static FragmentFactory getInstance() {
        if (instance == null) {
            instance = new FragmentFactory();
        }
        return instance;
    }

    public Fragment getFragment(String fragmentName) {
        try {
            Fragment fragment = (Fragment) listFragment.get(fragmentName);
            if (fragment == null) {
                Class<?> aClass = Class.forName(fragmentName);
                Constructor<?> constructor = aClass.getConstructor();
                fragment = (Fragment) constructor.newInstance();
                listFragment.put(fragmentName, fragment);
            }
            return fragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
