package davidrobles.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ColorSelection extends AppCompatActivity implements View.OnClickListener {

    private Button mTextButton;
    private Button mHeadingTextButton;
    private Button mHeadingBgButton;
    private Button mBackgroundButton;
    private Button mDoneButton;

    private String mTextColor;
    private String mHeadingTextColor;
    private String mHeadingBgColor;
    private String mBackgroundColor;


    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selection);

        mText = (TextView) findViewById(R.id.type_text);

        mTextButton = (Button) findViewById(R.id.text_button);
        mHeadingTextButton = (Button) findViewById(R.id.heading_text_button);
        mHeadingBgButton = (Button) findViewById(R.id.heading_bg_button);
        mBackgroundButton = (Button) findViewById(R.id.background_button);
        mDoneButton = (Button) findViewById(R.id.done_button);

        mTextButton.setOnClickListener(this);
        mHeadingTextButton.setOnClickListener(this);
        mHeadingBgButton.setOnClickListener(this);
        mBackgroundButton.setOnClickListener(this);
        mDoneButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.text_button)
        {
            mText.setText("Text Color");
        }
        else if(view.getId() == R.id.heading_text_button)
        {
            mText.setText("Heading Text Color");
        }
        else if(view.getId() == R.id.heading_bg_button)
        {
            mText.setText("Heading Background Color");
        }
        else if(view.getId() == R.id.background_button)
        {
            mText.setText("Background Color");
        }

        if(mText.equals("Text Color"))
        {
            if(view.getId() == R.id.blue_button)
            {
                mTextColor = "blue";
            }
            else if(view.getId() == R.id.red_button)
            {
                mTextColor = "red";
            }
            else if(view.getId() == R.id.purple_button)
            {
                mTextColor = "purple";
            }
            else if(view.getId() == R.id.orange_button)
            {
                mTextColor = "orange";
            }
            else if(view.getId() == R.id.green_button)
            {
                mTextColor = "green";
            }
            else if(view.getId() == R.id.pink_button)
            {
                mTextColor = "pink";
            }
        }
        else if(mText.equals("Heading Text Color"))
        {
            if(view.getId() == R.id.blue_button)
            {
                mHeadingTextColor = "blue";
            }
            else if(view.getId() == R.id.red_button)
            {
                mHeadingTextColor = "red";
            }
            else if(view.getId() == R.id.purple_button)
            {
                mHeadingTextColor = "purple";
            }
            else if(view.getId() == R.id.orange_button)
            {
                mHeadingTextColor = "orange";
            }
            else if(view.getId() == R.id.green_button)
            {
                mHeadingTextColor = "green";
            }
            else if(view.getId() == R.id.pink_button)
            {
                mHeadingTextColor = "pink";
            }
        }
        else if(mText.equals("Heading Background Color"))
        {
            if(view.getId() == R.id.blue_button)
            {
                mHeadingBgColor = "blue";
            }
            else if(view.getId() == R.id.red_button)
            {
                mHeadingBgColor = "red";
            }
            else if(view.getId() == R.id.purple_button)
            {
                mHeadingBgColor = "purple";
            }
            else if(view.getId() == R.id.orange_button)
            {
                mHeadingBgColor = "orange";
            }
            else if(view.getId() == R.id.green_button)
            {
                mHeadingBgColor = "green";
            }
            else if(view.getId() == R.id.pink_button)
            {
                mHeadingBgColor = "pink";
            }
        }
        else if(mText.equals("Background Color"))
        {
            if(view.getId() == R.id.blue_button)
            {
                mBackgroundColor = "blue";
            }
            else if(view.getId() == R.id.red_button)
            {
                mBackgroundColor = "red";
            }
            else if(view.getId() == R.id.purple_button)
            {
                mBackgroundColor = "purple";
            }
            else if(view.getId() == R.id.orange_button)
            {
                mBackgroundColor = "orange";
            }
            else if(view.getId() == R.id.green_button)
            {
                mBackgroundColor = "green";
            }
            else if(view.getId() == R.id.pink_button)
            {
                mBackgroundColor = "pink";
            }
        }



        if(view.getId() == R.id.done_button)
        {

            Intent resultData = new Intent();
            resultData.putExtra("text_color", mTextColor);
            resultData.putExtra("heading_background_color", mHeadingBgColor);
            resultData.putExtra("heading_text_color", mHeadingTextColor);
            resultData.putExtra("background_color", mBackgroundColor);

            setResult(RESULT_OK, resultData);
            finish();
        }
    }

//    public static Intent newIntent(Context ctx)
//    {
//        Intent ret = new Intent(ctx, ColorSelection.class);
//        return ret;
//    }
}
