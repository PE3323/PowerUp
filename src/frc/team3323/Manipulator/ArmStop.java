package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;


public class ArmStop extends Command
{
    private Arms arms;

    public ArmStop(Arms arms)
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
        arms.stop();
    }
}