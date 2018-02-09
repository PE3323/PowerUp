package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {
    private Manipulator mani;

    public Intake(Manipulator mani )
    {
        requires(mani);
        this.mani = mani;
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
    protected void execute()
    {
        mani.intake();
    }
    protected void end()
    {
        mani.stop();
    }
}