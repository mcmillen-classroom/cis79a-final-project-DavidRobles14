package davidrobles.finalproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LaunchScreen extends AppCompatActivity implements View.OnClickListener {

    private Button mEnterButton;
    private Button mSkipButton;
    private EditText mUserName;
    private TextView mWelcome;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);
        setTitle("Activity Tracker");

        mWelcome = (TextView) findViewById(R.id.welcome_text);

//        mWelcome.setTextColor(getColor(R.color.blue));

        mEnterButton = (Button) findViewById(R.id.enter_button);
        mSkipButton = (Button) findViewById(R.id.skip_button);
        mUserName = (EditText) findViewById(R.id.user_name);

        mEnterButton.setOnClickListener(this);
        mSkipButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        if(view.getId() == R.id.skip_button)
        {
            Intent start = MainActivity.newIntent(this);
            startActivity(start);
        }


        if(view.getId() == R.id.enter_button)
        {
            String userName = mUserName.getText().toString();

            Intent start = MainActivity.newIntent(this);
            start.putExtra("activity_user_name", userName);
            startActivity(start);
        }
    }
}
