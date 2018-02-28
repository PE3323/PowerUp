package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;

public class Open extends Command {
    private Arms arms;

    public Open(Arms arms )
    {
        requires(arms);
        this.arms = arms;
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
    protected void execute()
    {
        arms.open();
    }
    protected void end()
    {
        arms.stop();
    }
}