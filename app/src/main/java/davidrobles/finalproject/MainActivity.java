package davidrobles.finalproject;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.ContextMenu;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.graphics.Color;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final int REQUEST_ACTIVITY_CREATE = 1;
    private static final int REQUEST_ACTIVITY_EDIT = 2;
    private static final int REQUEST_ACTIVITY_SETTINGS = 3;
    private ListView mListView;
    private ArrayAdapter<ActivityModel> mArrayAdapter;

    private String mUserName;

    private LinearLayout mBackground;

    private ImageButton mSettingsButton;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent data = getIntent();
        mUserName = data.getStringExtra("activity_user_name");
        if(mUserName != null)
        {
            setTitle(mUserName + "'s " + "Activity Tracker");
        }
        else
        {
            setTitle("Activity Tracker");
        }


        mListView = (ListView) findViewById(R.id.activity_list);

        mBackground = (LinearLayout) findViewById(R.id.Background);

        mSettingsButton = (ImageButton) findViewById(R.id.settings_button);


        ArrayList<ActivityModel> activities = new ArrayList<ActivityModel>();
        activities.add(new ActivityModel("drawing", "12", "14", "full owl", "owl head"));

        mArrayAdapter = new ActivityArrayAdapter(this, activities);

        mListView.setAdapter(mArrayAdapter);
        mListView.setOnItemClickListener(this);
        mListView.setOnCreateContextMenuListener(this);
        mSettingsButton.setOnClickListener(this);


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.main_menu_create)
        {
            launchCreateActivity();
            return true;
        }

        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId() == R.id.context_button_edit)
        {
            ActivityModel activity = mArrayAdapter.getItem(info.position);
            launchEditActivity(activity, info.position);
            return true;
        }

        if(item.getItemId() == R.id.context_menu_delete)
        {
            ActivityModel activity = mArrayAdapter.getItem(info.position);
            mArrayAdapter.remove(activity);
        }

        return false;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == REQUEST_ACTIVITY_CREATE)
        {
            if(data != null)
            {
                String name = data.getStringExtra("activity_name");
                String startDate = data.getStringExtra("activity_start");
                String endDate = data.getStringExtra("activity_end_date");
                String endGoal = data.getStringExtra("activity_end_goal");
                String progress = data.getStringExtra("activity_progress");

                ActivityModel added = new ActivityModel(name, startDate, endDate, endGoal, progress);
                mArrayAdapter.add(added);
            }
        }

        if(resultCode == RESULT_OK && requestCode == REQUEST_ACTIVITY_EDIT)
        {
            if(data != null)
            {
                int position = data.getIntExtra("activity_position", -1);
                String name = data.getStringExtra("activity_name");
                String startDate = data.getStringExtra("activity_start");
                String endDate = data.getStringExtra("activity_end_date");
                String endGoal = data.getStringExtra("activity_end_goal");
                String progress = data.getStringExtra("activity_progress");

                if(position != -1)
                {
                    ActivityModel activity = mArrayAdapter.getItem(position);
                    activity.setName(name);
                    activity.setStartDate(startDate);
                    activity.setEndDateGoal(endDate);
                    activity.setEndGoal(endGoal);
                    activity.setProgress(progress);

                    mArrayAdapter.notifyDataSetChanged();
                }

            }

            System.out.println(data.getStringExtra("background_color"));
            if(resultCode == RESULT_OK && requestCode == REQUEST_ACTIVITY_SETTINGS)
            {
                    if(data.getStringExtra("background_color").equals("blue"))
                    {
                        mBackground.setBackgroundColor(getColor(R.color.blue));
                    }
            }
        }
    }

    public static Intent newIntent(Context ctx)
    {
        Intent ret = new Intent(ctx, MainActivity.class);
        return ret;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.settings_button)
        {
            launchSettingsActivity();
        }

//        if(view.getId() == R.id.activity_list)
//        {
//            Intent actPage = ActivityPage.newIntent(this);
//            startActivity(actPage);
//        }
    }

    private void launchCreateActivity()
    {
        Intent createIntent =  new Intent(this, ActivityCreateActivity.class);
        startActivityForResult(createIntent, REQUEST_ACTIVITY_CREATE);
    }

    private void launchEditActivity(ActivityModel activity, int position)
    {
        Intent editIntent = new Intent(this, ActivityEditActivity.class);
        editIntent.putExtra("activity_position", position);
        editIntent.putExtra("activity_name", activity.getName());
        editIntent.putExtra("activity_start", activity.getStartDate());
        editIntent.putExtra("activity_end_date", activity.getEndDateGoal());
        editIntent.putExtra("activity_end_goal", activity.getEndGoal());
        editIntent.putExtra("activity_progress", activity.getProgress());
        startActivityForResult(editIntent, REQUEST_ACTIVITY_EDIT);

    }

    private void launchActivityPage(ActivityModel activity, int position)
    {
        Intent start = ActivityPage.newIntent(this);
        start.putExtra("activity_position", position);
        start.putExtra("activity_name", activity.getName());
        start.putExtra("activity_start", activity.getStartDate());
        start.putExtra("activity_end_date", activity.getEndDateGoal());
        start.putExtra("activity_end_goal", activity.getEndGoal());
        start.putExtra("activity_progress", activity.getProgress());
        startActivity(start);
    }

    private void launchSettingsActivity()
    {
        Intent setIntent = new Intent(this, ColorSelection.class);
        startActivityForResult(setIntent, REQUEST_ACTIVITY_SETTINGS);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        ActivityModel activity = mArrayAdapter.getItem(position);
        launchActivityPage(activity, position);
    }




}

