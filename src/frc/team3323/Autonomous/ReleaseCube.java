package frc.team3323.Autonomous;


import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

public class ReleaseCube extends State
{


    private double duration;
    private Arms arms;
    private Wheels wheels;
    public boolean transitionWhen() {return(duration>1500);}
    public void execute()
    {
        duration = StateDurationCounter();
        arms.moveArm(true, .75,false);
        arms.moveArm(false, .75,false);
    }
    public void complete()
    {
        arms.moveArm(true, 0,true);
        arms.moveArm(false, 0,true);
        wheels.moveWheels(true, 0,false);
        wheels.moveWheels(false, 0,false);
    }

    public ReleaseCube(String name, Arms arms, Wheels wheels)
    {
        super( name );
        this.arms = arms;
        this.wheels = wheels;
    }
}
