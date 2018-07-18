package frc.team3323.Autonomous;

import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

public class GrabCube extends State
{


    private double duration;
    private Arms arms;
    private Wheels wheels;
    public boolean transitionWhen() {return(duration>1500);}
    public double armSpeed;
    public double wheelSpeed;
    public void execute()
    {
        duration = StateDurationCounter();
        arms.moveArm(true, .75,true);
        arms.moveArm(false, .75,true);
        wheels.moveWheels(true, .4,false);
        wheels.moveWheels(false, .4,false);
    }
    public void complete()
    {
        arms.moveArm(true, 0,true);
        arms.moveArm(false, 0,true);
        wheels.moveWheels(true, 0,false);
        wheels.moveWheels(false, 0,false);
    }
    public GrabCube(String name, Arms arms, Wheels wheels, double wheelSpeed, double armSpeed)
    {
        super ( name );
        this.arms = arms;
        this.wheels = wheels;
        this.wheelSpeed = wheelSpeed;
        this.armSpeed = armSpeed;
    }
}
