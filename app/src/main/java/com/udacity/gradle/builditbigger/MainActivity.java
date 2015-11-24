package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.OnGceCallback {
    private MainActivityFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this, this);
        asyncTask.execute();

        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        findViewById(R.id.btnJoke).setEnabled(false);
    }

    @Override
    public void onCallFinished(String result) {
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        findViewById(R.id.btnJoke).setEnabled(true);

        mFragment.goToJoke(result);

    }

}
