package frc.team3323.Manipulator;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Manipulator extends Subsystem {

    private SpeedController armLeft = new Spark(0);
    private SpeedController armRight = new Spark(1);
    private Spark armWheelLeft = new Spark(3);
    private Spark armWheelRight = new Spark(2);
    private double speed = 1;
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
        armRight.set(-speed);
    }

    public void open()
    {
        armLeft.set(-speed);
        armRight.set(speed);
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

