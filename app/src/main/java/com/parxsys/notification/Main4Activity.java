package com.parxsys.notification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.parxsys.notification.FragmentFolder.FragmentOne;
import com.parxsys.notification.FragmentFolder.FragmentThree;
import com.parxsys.notification.FragmentFolder.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
ViewPager viewPager;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        viewPager=findViewById(R.id.vp);
        tabLayout=findViewById(R.id.tb);

        tabLayout.setupWithViewPager(viewPager);


        ViewpagerAdapterr adapterr =new ViewpagerAdapterr(getSupportFragmentManager(),0);
        adapterr.addFrag(new FragmentOne(),"F ONE");
        adapterr.addFrag(new FragmentTwo(),"F TWO");
        adapterr.addFrag(new FragmentThree(),"F THREE");
        viewPager.setAdapter(adapterr);

        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);


    }

    private class ViewpagerAdapterr extends FragmentPagerAdapter {

        List<Fragment> fragments =new ArrayList<>();
        List<String> title=new ArrayList<>();

        public ViewpagerAdapterr(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }


        public  void addFrag(Fragment fragment,String titlee){
            fragments.add(fragment);
            title.add(titlee);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }
    }
}
