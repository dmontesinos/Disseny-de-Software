package com.example.joans.provatab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;


public class MainActivity extends AppCompatActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabhost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab Un");
        spec.setContent(R.id.tab1);
        spec.setIndicator(getString(R.string.titol_tab1));
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Dos");
        spec.setContent(R.id.tab2);
        spec.setIndicator(getString(R.string.titol_tab2));
        host.addTab(spec);
    }
}
