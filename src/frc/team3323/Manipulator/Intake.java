package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {
    private Wheels wheels;

    public Intake(Wheels wheels )
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
        wheels.intake();
    }
    protected void end()
    {
        wheels.stop();
    }
}