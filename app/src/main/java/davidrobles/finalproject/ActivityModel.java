package davidrobles.finalproject;

public class ActivityModel
{
    private String mName;
    private String mStartDate;
    private String mEndDateGoal;
    private String mEndGoal;
    private String mProgress;

    public ActivityModel(String name, String startDate, String endDate, String endGoal, String progress)
    {
        mName = name;
        mStartDate = startDate;
        mEndDateGoal = endDate;
        mEndGoal = endGoal;
        mProgress = progress;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public String getStartDate()
    {
        return mStartDate;
    }

    public void setStartDate(String startDate)
    {
        mStartDate = startDate;
    }

    public String getEndDateGoal()
    {
        return mEndDateGoal;
    }

    public void setEndDateGoal(String endDateGoal)
    {
        mEndDateGoal = endDateGoal;
    }

    public String getEndGoal()
    {
        return mEndGoal;
    }

    public void setEndGoal(String endGoal)
    {
        mEndGoal = endGoal;
    }

    public String getProgress()
    {
        return mProgress;
    }

    public void setProgress(String progress)
    {
        mProgress = progress;
    }
}
