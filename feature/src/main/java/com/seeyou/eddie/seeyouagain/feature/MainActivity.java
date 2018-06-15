package com.seeyou.eddie.seeyouagain.feature;

import android.annotation.TargetApi;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL, recipientArray);
        System.out.println("JZMTEST onCreate");
    }

    class neibulei implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "click button", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = (Button) findViewById(R.id.mybutton);
        btn.setOnClickListener(
        new neibulei()
        );
        System.out.println("JZMTEST onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("JZMTEST onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("JZMTEST onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("JZMTEST onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Button btn = (Button)findViewById(R.id.mybutton);
        System.out.println("JZMTEST onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("JZMTEST onDestroy");
    }

    @Override
    @TargetApi(21)
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outPersistentState.putString("TESTVALUE", "data01");
        System.out.println("JZMTEST onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String str = savedInstanceState.getString("TESTVALUE", "NOTHING");
        System.out.println("JZMTEST onRestoreInstanceState,and the value is " + str);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
