package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Drivetrain.Drivetrain;

public class Move extends State
{
    private long distance;
    private Drivetrain drive;
    private double speed;
    private Encoder encoder;

    public Move(String name, long distance, double speed, Drivetrain drive, Encoder encoder)
    {
        super( name );
        this.distance = distance;
        this.drive = drive;
        this.speed = speed;
        this.encoder = encoder;
    }

    public Move(String name, long distance, Drivetrain drive, Encoder encoder)
    {
        super( name );
        this.distance = distance-1;
        this.drive = drive;
        this.encoder = encoder;
        this.speed = .5; // Default speed if not set
    }

    protected void initialize()
    {
        drive.getEncoderLeft().reset();
        drive.getEncoderRight().reset();
    }

    public boolean transitionWhen()
    {
        return(this.distance <= drive.pulsesToDistance(encoder));
    }

    public void execute()
    {
      if (distance > 0)
          drive.startMove(-speed);
      else
          drive.startMove(speed);
    }

    public void complete() {}
}

