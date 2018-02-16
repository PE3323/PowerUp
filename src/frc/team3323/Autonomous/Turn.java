package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Drivetrain.Drivetrain;

public class Turn extends State
{
    private double angle;
    private Drivetrain drive;
    private double speed;

    public Turn(String name, long angle, double speed, Drivetrain drive)
    {
        super( name );
        this.angle = angle;
        this.drive = drive;
        this.speed = speed;
    }

    public Turn(String name, long angle, Drivetrain drive)
    {
        super( name );
        this.angle = angle-20;
        this.drive = drive;
        this.speed = .5; //Default speed if not set
    }

    protected void initialize()
    {
        drive.getGyro().reset();
    }

    public boolean transitionWhen()
    {
        return( this.angle <= drive.getGyro().getAngle() );
    }

    public void execute()
    {
        if(angle>0)
            drive.startTurn(speed ,true);
        else
            drive.startTurn( speed , false);
    }
    public void complete()
    {
        drive.stop();
    }
}
