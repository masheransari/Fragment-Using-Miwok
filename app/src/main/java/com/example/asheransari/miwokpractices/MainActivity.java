package com.example.asheransari.miwokpractices;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        t1 = (TextView)findViewById(R.id.number);
        t2 = (TextView)findViewById(R.id.family);
        t3 = (TextView)findViewById(R.id.color);
        t4 = (TextView)findViewById(R.id.phrase);
//        FragmentManager fm = getSupportFragmentManager();
//        final FragmentTransaction ft = fm.beginTransaction();
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.fragment_Container);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,number_activity.class);
//                startActivity(i);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                layout.removeAllViewsInLayout();
                number_activity na =new number_activity();
                ft.replace(R.id.fragment_Container,na);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,family_activity.class);
//                startActivity(i);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                layout.removeAllViewsInLayout();
                family_activity fa = new family_activity();
                ft.replace(R.id.fragment_Container,fa);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,color_activity.class);
//                startActivity(i);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                layout.removeAllViewsInLayout();
                color_activity ca = new color_activity();
                ft.add(R.id.fragment_Container, ca);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,phrase_activity.class);
//                startActivity(i);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                layout.removeAllViewsInLayout();
                phrase_activity pa = new phrase_activity();
                ft.add(R.id.fragment_Container,pa);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });


    }
//    public void replaceFragment(Fragment fragment, String TAG) {
//
//        try {
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(mContainerId, fragment, tag);
//            fragmentTransaction.addToBackStack(tag);
//            fragmentTransaction.commitAllowingStateLoss();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//    }

}
