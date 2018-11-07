package frc.team3323.Manipulator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;

public class Arms extends Subsystem {

    private WPI_TalonSRX armLeft = new WPI_TalonSRX(RobotMap.armLeftID);
    private WPI_TalonSRX armRight = new WPI_TalonSRX(RobotMap.armRightID);

    public void log(PowerDistributionPanel pdp)
    {
        SmartDashboard.putNumber("Left Arm", pdp.getCurrent(10));
        SmartDashboard.putNumber("Right Arm", pdp.getCurrent(11));
    }

    public void moveArm(boolean isRight, double speed, boolean directionOut)
    {
        double adjustedSpeed;
        if(directionOut)
            adjustedSpeed = speed;
        else
            adjustedSpeed = -speed;
        if(isRight)
            armRight.set(-adjustedSpeed);
        else
            armLeft.set(adjustedSpeed);

    }

    public WPI_TalonSRX getArmLeft()
    {
        return armLeft;
    }

    public WPI_TalonSRX getArmRight()
    {
        return armRight;
    }


    public Open getOpen()
    {
        return new Open(this);
    }

    public Close getClose()
    {
        return new Close(this);
    }

    public GripCube getGrip()
    {
        return new GripCube(this);
    }

    public void initDefaultCommand()
    {
            setDefaultCommand(new ArmStop(this));
    }
}

