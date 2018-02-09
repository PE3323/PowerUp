package frc.team3323.Autonomous;

import frc.team3323.Drivetrain.Drivetrain;

public class Turn extends State
{
    private double angle;
    private Drivetrain drive;

    public Turn(String name, long angle, Drivetrain drive)
    {
        super( name );
        this.angle = angle;
        this.drive = drive;
    }

    protected void initialize()
    {
        drive.getGyro().reset();
    }

    public boolean transitionWhen()
    {
        return( this.angle == drive.getGyro().getAngle() );
    }

    public void excute()
    {
        drive.startTurn(.75,true);
    }
}
