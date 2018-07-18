package frc.team3323.Elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;
import frc.team3323.UI;

public class Elevator extends Subsystem {

    public Spark motorElevator = new Spark(RobotMap.elevatorID);
    public Encoder encoderElevator = new Encoder(RobotMap.elevatorBlueID, RobotMap.elevatorYellowID);
    public AnalogInput limitSwitch = new AnalogInput(RobotMap.limitSwitchID);
    PowerDistributionPanel pdp;

    public void log(PowerDistributionPanel pdp)
    {
        SmartDashboard.putNumber("Elevator Encoder", encoderElevator.getRaw());
    }

    public void initDefaultCommand()
    {
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

    public void lift(double speed, UI ui)
    {
        if(encoderElevator.getRaw()<15000)
            motorElevator.set(speed);
        else
        {
            if(ui.getXboxCube().getRawAxis(1)<0)
            {
                motorElevator.set(0);
            }
            else
                motorElevator.set(speed);
        }
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

