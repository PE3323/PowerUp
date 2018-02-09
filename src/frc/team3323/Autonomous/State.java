package frc.team3323.Autonomous;

public abstract class State
{
    private boolean notCalled;
    private String name;

    public abstract boolean transitionWhen();

    public State( String name )
    {
        this.name = name;
    }

    protected void initialize() {}

    public void doInitialize()
    {

        if (notCalled)
        {
            initialize();
            notCalled = true;
        }
    }



}
