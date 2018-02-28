package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Elevator.Elevator;

import java.time.Duration;

public class ElevatorRise extends State
{
    private Elevator riseElevator;
    private double duration;
    private Encoder elevatorEncoder = new Encoder(4,5);
    private Spark motorElevator;
    private Elevator elevatorRise;
    private double goal = 3000;


    public boolean transitionWhen() { return(elevatorEncoder.getRaw()>goal);}
    public void execute()
    {
        //duration = StateDurationCounter();
        elevatorRise.motorElevator.set(0.5);
    }
    public void complete()
    {
        motorElevator.set(0);
    }

    public int elevatorToInches(Elevator riseElevator)
    {
        int elevatorInches;
        elevatorInches = elevatorEncoder.getRaw()/100;
        SmartDashboard.putNumber("elevatorInches", elevatorInches);
        return elevatorInches;
    }


    public ElevatorRise(String name, Elevator riseElevator, Duration durationElevator, double goal)
    {
        super( name );
        riseElevator = riseElevator;
        this.goal = goal;

    }
}
