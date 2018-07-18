package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class State
{
    private boolean beenCalled;
    private String name;
    double startTime;

    public abstract boolean transitionWhen();
    public abstract void execute();
    public abstract void complete();

    public State( String name )
    {
        this.name = name;
    }

    protected void initialize()
    {startTime = System.currentTimeMillis();}

    public double StateDurationCounter()
    {
        double duration = System.currentTimeMillis() - startTime;
        return duration;
    }

    public String getName() {
        return name;
    }

    public void doInitialize()
    {
        if (beenCalled == false)
        {
            initialize();
            beenCalled = true;
        }
    }



}
