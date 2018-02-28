package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Exhaust extends Command {
    private Wheels wheels;

    public Exhaust(Wheels wheels )
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
        wheels.exhaust();
    }
    protected void end()
    {
        wheels.stop();
    }
}