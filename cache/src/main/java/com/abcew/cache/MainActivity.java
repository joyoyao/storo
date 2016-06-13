package com.abcew.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import st.lowlevel.storo.Storo;
import st.lowlevel.storo.StoroBuilder;
import st.lowlevel.storo.model.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StoroBuilder.configure(8192)  // maximum size to allocate in bytes
                .setDefaultCacheDirectory(this)
                .initialize();

        Storo.put("key", "d").execute();
//        MyObject object = Storo.get("key", MyObject.class).execute();
        Observable<String > observable=Storo.get("key",String.class).async();
//        Storo.get("key", String.class).async(new Callback<String>(){
//
//            @Override
//            public void onResult(String result) {
//
//            }
//        });
    }
}
