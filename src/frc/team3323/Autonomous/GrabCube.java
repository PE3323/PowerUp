package frc.team3323.Autonomous;

import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

public class GrabCube extends State
{


    private double duration;
    private Arms arms;
    private Wheels wheels;
    public boolean transitionWhen() {return(duration>3000);}
    public void execute()
    {
        duration = StateDurationCounter();
        arms.getArmLeft().set(0.5);
        arms.getArmRight().set(0.5);
        wheels.getWheelLeft().set(0.5);
        wheels.getWheelRight().set(0.5);

    }
    public void complete()
    {
        arms.stop();
        wheels.stop();


    }
    public GrabCube(String name, Arms arms, Wheels wheels)
    {
        super ( name );
        this.arms = arms;
        this.wheels = wheels;
    }
}
