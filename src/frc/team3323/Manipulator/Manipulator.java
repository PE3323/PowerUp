package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Manipulator extends Subsystem {

    private SpeedController armLeft = new Talon(0);
    private SpeedController armRight = new Talon(3);
    private SpeedController armWheelLeft = new Talon(1);
    private SpeedController armWheelRight = new Talon(2);
    private double speed = .5;
    private double speed2 = .5;


    public void stop()
    {
        armLeft.set(0);
        armRight.set(0);
        armWheelLeft.set(0);
        armWheelRight.set(0);
    }

    public void close()
    {
        armLeft.set(speed);
        armRight.set(speed);
    }

    public void open()
    {
        armLeft.set(-speed);
        armRight.set(-speed);
    }

    public void intake()
    {
        armWheelLeft.set(speed2);
        armWheelRight.set(speed2);
    }

    public void exhaust()
    {
        armWheelLeft.set(-speed2);
        armWheelRight.set(-speed2);
    }

    public Open getOpen()
    {
        return new Open(this);
    }

    public Close getClose()
    {
        return new Close(this);
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
            setDefaultCommand(new ManiStop(this));
    }
}

