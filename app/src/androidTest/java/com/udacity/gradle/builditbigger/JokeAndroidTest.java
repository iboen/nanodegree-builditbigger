package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeAndroidTest extends AndroidTestCase {
    public void testGceHasResponse() {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(getContext(), new EndpointsAsyncTask.OnGceCallback() {
            @Override
            public void onCallFinished(String result) {
                assertNotNull(result);
                signal.countDown();
            }
        });
        asyncTask.execute();

        try {
            signal.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}