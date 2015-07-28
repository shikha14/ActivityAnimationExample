package com.android.shikha.animationexample;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button mFadeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponent();
    }

    private void initializeComponent() {

        mFadeButton= (Button) findViewById(R.id.button1);
        mFadeButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                performActivityAnimation();
                //performFade(v);
                //performAltFade(v);
               // performScaleXWithDuration(v);
                break;
            default:
                break;
        }

    }

    private void performActivityAnimation() {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    private void performFade(View v) {
        ObjectAnimator fadeAnimation=ObjectAnimator.ofFloat(v, "rotation", 0.2f);
        fadeAnimation.start();

    }
    private void performAltFade(View v) {
        ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(v, View.ALPHA, 0, 1);
        fadeAltAnim.start();
    }

    private void performScaleXWithDuration(View v)
    {
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(v, "scaleX", 1.0f, 2.0f);
        scaleAnim.setDuration(3000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim.start();
    }
}
