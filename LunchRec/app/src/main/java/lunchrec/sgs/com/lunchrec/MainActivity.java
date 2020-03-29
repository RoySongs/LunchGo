package lunchrec.sgs.com.lunchrec;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import lunchrec.sgs.com.lunchrec.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static final float BIG_SCALE = 1.0f;
    public static final float SMALL_SCALE = 0.9f;
    public static final float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    public static final int NUMOFTABS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),NUMOFTABS);


        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }
}