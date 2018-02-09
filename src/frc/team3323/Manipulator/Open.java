package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Open extends Command {
    private Manipulator mani;

    public Open(Manipulator mani )
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
        mani.open();
    }
    protected void end()
    {
        mani.stop();
    }
}