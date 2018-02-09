package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class ManiStop extends Command {
    private Manipulator mani;

    public ManiStop(Manipulator mani) {
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
        mani.stop();
    }
}