package frc.team3323.Elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private WPI_TalonSRX srxElevator = new WPI_TalonSRX(5);

    public void initDefaultCommand()
    {
    }

    public LiftElevator getLiftElevator()
    {
       return new LiftElevator(this);
    }

    public void lift()
    {
        srxElevator.set(0.5);
    }

    public void stop()
    {
        srxElevator.set(0.5);
    }
}

