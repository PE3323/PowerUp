package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Elevator.Elevator;

import java.time.Duration;

public class ElevatorRise extends State
{
    private Elevator elevator;
    private double goal;


    public boolean transitionWhen() { return(elevator.encoderElevator.getRaw()>goal);}
    public void execute()
    {
        elevator.motorElevator.set(-0.5);
    }
    public void complete()
    {
        elevator.motorElevator.set(0);
    }

    public int elevatorToInches(Elevator riseElevator)
    {
        int elevatorInches;
        elevatorInches = elevator.encoderElevator.getRaw()/100;
        SmartDashboard.putNumber("elevatorInches", elevatorInches);
        return elevatorInches;
    }


    public ElevatorRise(String name, Elevator elevator, double goal)
    {
        super( name );
        this.elevator = elevator;
        this.goal = goal;

    }
}
