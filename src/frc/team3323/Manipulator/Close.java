package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Close extends Command {
    private Manipulator mani;

    public Close(Manipulator mani)
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
        mani.close();
    }
    protected void end()
    {
        mani.stop();
    }
}