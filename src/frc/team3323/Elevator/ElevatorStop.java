package frc.team3323.Elevator;

import edu.wpi.first.wpilibj.command.Command;


public class ElevatorStop extends Command
{

    private Elevator elevator;

    public ElevatorStop(Elevator elevator)
    {
        requires(elevator);
        this.elevator = elevator;
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    protected void execute()
    {
        elevator.stop();
    }
}