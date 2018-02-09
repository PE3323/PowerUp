package frc.team3323.Autonomous;

import frc.team3323.Drivetrain.Drivetrain;

public class Move extends State
{
    private long distance;
    private Drivetrain drive;

    public Move(String name, long distance, Drivetrain drive)
    {
        super( name );
        this.distance = distance;
        this.drive = drive;
    }

    protected void initialize()
    {
        drive.getEncoderLeft().reset();
    }

    public boolean transitionWhen()
    {
        return(this.distance == drive.getEncoderLeft().getRaw());
    }

    public void excute()
    {
        drive.startMove(.50);
    }
}

