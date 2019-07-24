package davidrobles.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ActivityEditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mActivityName;
    private EditText mStartDate;
    private EditText mEndDateGoal;
    private EditText mEndGoal;
    private EditText mProgress;

    private Button mAddPicButton;
    private Button mDoneButton;
    private ImageButton mSettingsButton;

    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amcreate);
        setTitle(R.string.activity_edit_title);

        mActivityName = (EditText) findViewById(R.id.activity_name);
        mStartDate = (EditText) findViewById(R.id.start_date);
        mEndDateGoal = (EditText) findViewById(R.id.end_date_goal);
        mEndGoal = (EditText) findViewById(R.id.end_goal);
        mProgress = (EditText) findViewById(R.id.progress);

//        mAddPicButton = (Button) findViewById(R.id.add_pic_button);
        mDoneButton = (Button) findViewById(R.id.done_button);
        mSettingsButton = (ImageButton) findViewById(R.id.settings_button);

//        mAddPicButton.setOnClickListener(this);
        mDoneButton.setOnClickListener(this);
        mSettingsButton.setOnClickListener(this);

        Intent data = getIntent();
        mActivityName.setText(data.getStringExtra("activity_name"));
        mStartDate.setText(data.getStringExtra("activity_start"));
        mEndDateGoal.setText(data.getStringExtra("activity_end_date"));
        mEndGoal.setText(data.getStringExtra("activity_end_goal"));
        mProgress.setText(data.getStringExtra("activity_progress"));
        mPosition = data.getIntExtra("activity_position", -1);

        if(mPosition == -1)
        {
            //TODO; throw exception
        }
    }


    @Override
    public void onClick(View view)
    {

        if(view.getId() == R.id.done_button)
        {
            String name = mActivityName.getText().toString();
            String start = mStartDate.getText().toString();
            String endDate = mEndDateGoal.getText().toString();
            String endGoal = mEndGoal.getText().toString();
            String progress = mProgress.getText().toString();

            Intent resultData = new Intent();
            resultData.putExtra("activity_position", mPosition);
            resultData.putExtra("activity_name", name);
            resultData.putExtra("activity_start", start);
            resultData.putExtra("activity_end_date", endDate);
            resultData.putExtra("activity_end_goal", endGoal);
            resultData.putExtra("activity_progress", progress);

            setResult(RESULT_OK, resultData);
            finish();
        }
    }
}