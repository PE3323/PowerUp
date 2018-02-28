package frc.team3323.Manipulator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;

public class Arms extends Subsystem {

    private WPI_TalonSRX armLeft = new WPI_TalonSRX(RobotMap.armLeftID);
    private WPI_TalonSRX armRight = new WPI_TalonSRX(RobotMap.armRightID);
    private double speed = .5;
    private double speed2 = -.5;

    public void log(PowerDistributionPanel pdp)
    {

        SmartDashboard.putNumber("Left Arm", pdp.getCurrent(10));
        SmartDashboard.putNumber("Right Arm", pdp.getCurrent(11));
    }

    public void stop()
    {
        armLeft.set(0);
        armRight.set(0);
    }

    public void close()
    {
        armLeft.set(speed);
        armRight.set(speed);
    }

    public void open()
    {
        armLeft.set(speed2);
        armRight.set(speed2);
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


    public void initDefaultCommand()
    {
            setDefaultCommand(new ArmStop(this));
    }
}

