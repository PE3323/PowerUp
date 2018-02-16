package frc.team3323.Autonomous;

public abstract class State
{
    private boolean beenCalled;
    private String name;

    public abstract boolean transitionWhen();
    public abstract void execute();
    public abstract void complete();

    public State( String name )
    {
        this.name = name;
    }

    protected void initialize() {}

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
