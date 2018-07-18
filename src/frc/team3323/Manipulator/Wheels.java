package frc.team3323.Manipulator;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;

public class Wheels extends Subsystem
{
    private WPI_TalonSRX wheelLeft = new WPI_TalonSRX(RobotMap.armWheelLeftID);
    private WPI_TalonSRX wheelRight = new WPI_TalonSRX(RobotMap.armWheelRightID);

    public void log(PowerDistributionPanel pdp)
    {

        SmartDashboard.putNumber("Left Wheel", pdp.getCurrent(13));
        SmartDashboard.putNumber("Right Wheel", pdp.getCurrent(14));
    }

    public void moveWheels(boolean isRight, double speed, boolean directionOut)
    {
        double adjustedSpeed;
        if(directionOut)
            adjustedSpeed = speed;
        else
            adjustedSpeed = -speed;
        if(isRight)
            wheelRight.set(adjustedSpeed);
        else
            wheelLeft.set(adjustedSpeed);

    }


    public WPI_TalonSRX getWheelLeft()
    {
        return wheelLeft;
    }

    public WPI_TalonSRX getWheelRight()
    {
        return wheelRight;
    }


    public Intake getIntake()
    {
        return new Intake(this);
    }

    public Exhaust getExhaust()
    {
        return new Exhaust(this);
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new WheelStop(this));
    }
}

