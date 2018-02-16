package frc.team3323.Drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain {

    private WPI_TalonSRX srxLB = new WPI_TalonSRX(2);
    private WPI_TalonSRX srxRB = new WPI_TalonSRX(3);
    private WPI_TalonSRX srxLF = new WPI_TalonSRX(4);
    private WPI_TalonSRX srxRF = new WPI_TalonSRX(5);
    private SpeedControllerGroup left = new SpeedControllerGroup(srxLF,srxLB);
    private SpeedControllerGroup right = new SpeedControllerGroup(srxRF,srxRB);

    private Encoder encoderLeft = new Encoder(0, 1);
    private Encoder encoderRight = new Encoder(2,3);
    private DifferentialDrive driveTrain = new DifferentialDrive(left,right);
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public Drivetrain()
    {
      left.setInverted( true );
      right.setInverted( true );
    }

    public void initDefaultCommand()
    {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    public void log(PowerDistributionPanel pdp)
    {
        SmartDashboard.putNumber("Draw LB", srxLB.getOutputCurrent());
        SmartDashboard.putNumber("Draw LF", srxLF.getOutputCurrent());
        SmartDashboard.putNumber("Draw RB", srxRB.getOutputCurrent());
        SmartDashboard.putNumber("Draw RF", srxRF.getOutputCurrent());
        SmartDashboard.putNumber("Encoder Left", pulsesToDistance(encoderLeft));
        SmartDashboard.putNumber("Encoder Right", pulsesToDistance(encoderRight));
        SmartDashboard.putNumber("angle", gyro.getAngle());
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
        if (right == true)
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
}