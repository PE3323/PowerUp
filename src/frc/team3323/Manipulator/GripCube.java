package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.command.Command;


public class GripCube extends Command {
    private Arms arms;

    public GripCube(Arms arms)
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
        arms.moveArm(true,1,true);
        arms.moveArm(false,1,true);
    }
}
