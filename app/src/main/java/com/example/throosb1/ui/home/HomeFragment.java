package com.example.throosb1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.throosb1.R;
import com.example.throosb1.databinding.FragmentHomeBinding;
import com.example.throosb1.ui.gallery.GalleryFragment;
import com.example.throosb1.ui.slideshow.SlideshowFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TabLayout tabLayout = root.findViewById(R.id.tabLayout);
        ViewPager viewPager = root.findViewById(R.id.viewPager);

        // Set up ViewPager with the sections adapter
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getParentFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        // Connect ViewPager with TabLayout
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < sectionsPagerAdapter.getCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                // Set the custom view for the tab
                tab.setCustomView(sectionsPagerAdapter.getTabView(i));
            }
        }
        return root;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Return the fragment for the selected tab
            switch (position) {
                case 0:
                    return new GalleryFragment();
                case 1:
                    return new SlideshowFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total tabs
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Set tab titles
            switch (position) {
                case 0:
                    return "Route";
                case 1:
                    return "Calendar";
                default:
                    return null;
            }
        }

        public View getTabView(int position) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_tab_item, null);
            TextView tabTitle = view.findViewById(R.id.text1);
            tabTitle.setText(getPageTitle(position));
            return view;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}