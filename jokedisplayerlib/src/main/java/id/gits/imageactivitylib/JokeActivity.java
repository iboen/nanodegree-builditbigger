package id.gits.imageactivitylib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private static final String EXTRA_JOKE = "extrajoke";

    private TextView mTvJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        mTvJoke = (TextView) findViewById(R.id.tv_joke);

        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        if (joke != null){
            mTvJoke.setText(joke);
        }
    }

    public static void startThisActivity(Context context, String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        context.startActivity(intent);
    }
}
