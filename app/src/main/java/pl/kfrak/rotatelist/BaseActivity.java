package pl.kfrak.rotatelist;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by RENT on 2017-06-14.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getClass().getSimpleName(), "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getClass().getSimpleName(), "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getClass().getSimpleName(), "onSaveInstanceState");
    }
}