package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class WheelStop extends Command {

    private Wheels wheels;

    public WheelStop(Wheels wheels)
    {
        requires(wheels);
        this.wheels = wheels;
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    protected void execute()
    {
        wheels.moveWheels(true,0,true);
        wheels.moveWheels(false,0,true);
    }
}