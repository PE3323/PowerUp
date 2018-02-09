package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Exhaust extends Command {
    private Manipulator mani;

    public Exhaust(Manipulator mani )
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
        mani.exhaust();
    }
    protected void end()
    {
        mani.stop();
    }
}