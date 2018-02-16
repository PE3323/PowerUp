package frc.team3323.Elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {

    public Spark motorElevator = new Spark(4);
    PowerDistributionPanel pdp = new PowerDistributionPanel();

    public void initDefaultCommand()
    {
    }

    public LiftElevator getLiftElevator()
    {
       return new LiftElevator(this);
    }

    public void lift(double speed)
    {
            motorElevator.set(speed);
    }

    public Elevator(PowerDistributionPanel pdp)
    {
        this.pdp = pdp;
    }

    public void stop()
    {
        motorElevator.set(0.0);
    }
}

