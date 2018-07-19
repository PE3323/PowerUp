package frc.team3323.Drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.RobotMap;

public class Drivetrain {

    private WPI_TalonSRX srxLB = new WPI_TalonSRX(RobotMap.leftBackID);
    private WPI_TalonSRX srxRB = new WPI_TalonSRX(RobotMap.rightBackID);
    private WPI_TalonSRX srxLF = new WPI_TalonSRX(RobotMap.leftFrontID);
    private WPI_TalonSRX srxRF = new WPI_TalonSRX(RobotMap.rightFrontID);
    private SpeedControllerGroup left = new SpeedControllerGroup(srxLF,srxLB);
    private SpeedControllerGroup right = new SpeedControllerGroup(srxRF,srxRB);
    private Spark fans = new Spark(9);

    private Encoder encoderLeft = new Encoder(RobotMap.leftBlueID, RobotMap.leftYellowID);
    private Encoder encoderRight = new Encoder(RobotMap.rightBlueID,RobotMap.rightYellowID);
    private DifferentialDrive driveTrain = new DifferentialDrive(left,right);
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    private boolean fanOn = false;
    private boolean beenPressed = false;

    public Drivetrain()
    {
      encoderLeft.setReverseDirection(true);
    }


    public void log(PowerDistributionPanel pdp)
    {
        SmartDashboard.putNumber("Draw LB", pdp.getCurrent(0));
        SmartDashboard.putNumber("Draw LF", pdp.getCurrent(1));
        SmartDashboard.putNumber("Draw RB", pdp.getCurrent(2));
        SmartDashboard.putNumber("Draw RF", pdp.getCurrent(3));
        SmartDashboard.putNumber("Encoder Left", pulsesToDistance(encoderLeft));
        SmartDashboard.putNumber("Encoder Right", pulsesToDistance(encoderRight));

        SmartDashboard.putNumber("angle", gyro.getAngle());
        SmartDashboard.putNumber("Amount Left", left.get());
        SmartDashboard.putNumber("Amount Right", right.get());
    }

    public ADXRS450_Gyro getGyro()
    {
        return gyro;
    }

    public Encoder getEncoderLeft()
    {
        return encoderLeft;
    }

    public Encoder getEncoderRight()
    {
        return encoderRight;
    }

    public DifferentialDrive getDriveTrain()
    {
        return driveTrain;
    }

    public void startMove(double speed)
    {
        driveTrain.arcadeDrive(speed,0);
    }


    public void startTurn(double speed, boolean right)
    {
        double rotation= 1;
        if (right)
            rotation= rotation*-1;
        driveTrain.arcadeDrive(speed,rotation);
    }

    public void stop()
    {
        driveTrain.stopMotor();
    }

    public double pulsesToDistance(Encoder encoder)
    {
        double conversion = SmartDashboard.getNumber("DPP", 650);
        double distance;
        distance = encoder.getRaw() / conversion;
        return distance;
    }
    public void fan ( JoystickButton fanButton)
    {

       if (fanButton.get())
           beenPressed=true;

       if (beenPressed&&fanButton.get()==false&&fanOn==false)
       {
           fanOn=true;
           beenPressed=false;
       }
       if (beenPressed&&fanButton.get()==false&&fanOn)
       {
           fanOn = false;
           beenPressed=false;
       }

        if (fanOn)
            fans.set(SmartDashboard.getNumber("Fans", 1));
        else
            fans.set(0);

    }
}