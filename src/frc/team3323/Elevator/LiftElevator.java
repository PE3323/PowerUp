package frc.team3323.Elevator;

import edu.wpi.first.wpilibj.command.Command;

public class LiftElevator extends Command {
    private Elevator elev;

    public LiftElevator(Elevator elev )
    {
        requires(elev);
        this.elev = elev;
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
    protected void execute()
    {
        elev.lift();
    }
    protected void end()
    {
        elev.stop();
    }
}