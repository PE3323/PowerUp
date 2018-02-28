package frc.team3323.Elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;

public class Elevator extends Subsystem {

    public Spark motorElevator = new Spark(RobotMap.elevatorID);
    public Encoder encoderElevator = new Encoder(RobotMap.elevatorBlueID, RobotMap.elevatorYellowID);
    public AnalogInput limitSwitch = new AnalogInput(RobotMap.limitSwitch
    );
    PowerDistributionPanel pdp;

    public void log(PowerDistributionPanel pdp)
    {
        SmartDashboard.putNumber("Encoder Draw", encoderElevator.getRaw());

    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new ElevatorStop(this));
    }

    public LiftElevator getLiftElevator()
    {
       return new LiftElevator(this);
    }

    public void reset()
    {
        motorElevator.set(-0.5);
        if (limitSwitch.getVoltage()>4)
        {
        encoderElevator.reset();
        motorElevator.set(0);
        }
    }

    public double elevatorToInches(Elevator riseElevator)
    {
        double elevatorInches;
        elevatorInches = encoderElevator.getRaw()/100;
        SmartDashboard.putNumber("elevatorInches", elevatorInches);
        return elevatorInches;
    }






    public void lift(double speed)
    {
            motorElevator.set(speed);
            //SmartDashboard.putNumber("Elevator Current",motorElevator.getOutputCurrent());
    }

    public Elevator(PowerDistributionPanel pdp)
    {
        this.pdp = pdp;
    }

    public void stop()
    {
        motorElevator.set(0.0);
    }

    public Spark getMotorElevator()
    {
        return motorElevator;
    }
}

