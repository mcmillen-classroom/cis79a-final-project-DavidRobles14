package davidrobles.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityPage extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ACTIVITY_EDIT = 2;
    private TextView mName;
    private TextView mStartAndEnd;
    private TextView mEndGoal;
    private TextView mProgress;

    private String mStart;
    private String mEnd;

    private Button mEditButton;
    private Button mDoneButton;

    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        setTitle(R.string.activity_page_title);



        mName = (TextView) findViewById(R.id.activity_name);
        mStartAndEnd = (TextView) findViewById(R.id.start_end);
        mEndGoal = (TextView) findViewById(R.id.goal);
        mProgress = (TextView) findViewById(R.id.activity_progress);


        mDoneButton = (Button) findViewById(R.id.done_button);


        mDoneButton.setOnClickListener(this);

        Intent data = getIntent();
        mStart = data.getStringExtra("activity_start");
        mEnd = data.getStringExtra("activity_end_date");
        mName.setText(data.getStringExtra("activity_name"));
        mStartAndEnd.setText("Start Date: " + mStart + "  End Date: " + mEnd );
        mEndGoal.setText("End Goal: " + data.getStringExtra("activity_end_goal"));
        mProgress.setText("Current Progress: " + data.getStringExtra("activity_progress"));
        mPosition = data.getIntExtra("activity_position", -1);


        if(mPosition == -1)
        {
            //TODO; throw exception
        }
    }

    public static Intent newIntent(Context ctx)
    {
        Intent ret = new Intent(ctx, ActivityPage.class);
        return ret;
    }


    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.done_button)
        {
            String name = mName.getText().toString();
            String start = mStart;
            String endDate = mEnd;
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
