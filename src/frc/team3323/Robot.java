/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team3323;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Autonomous.AutoState;
import frc.team3323.Drivetrain.Drivetrain;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Manipulator;


public class Robot extends IterativeRobot
{
    private Elevator elevator = new Elevator();
    private Manipulator manipulator = new Manipulator();
    private Drivetrain drivetrain = new Drivetrain();
    private PowerDistributionPanel pdp= new PowerDistributionPanel();
    private UI ui = new UI(manipulator);
    private AutoState autoState = null; //Unknown State
    int distance1 = 37;
    int distance2 = 23;

    public void robotPeriodic()
    {
        drivetrain.log(pdp);
        SmartDashboard.putData("gyro", drivetrain.getGyro());
    }

    public void autonomousInit()
    {
        drivetrain.getEncoderLeft().reset();
        drivetrain.getEncoderRight().reset();
        autoState = AutoState.Inital;
    }

    public void autonomousPeriodic()
    {
        SmartDashboard.putString("Auto State", autoState.name());
        if(autoState == AutoState.Inital)
        {
            autoState = AutoState.Forward1;
        }

        if(autoState == AutoState.Forward1 )
        {
            drivetrain.startMove(-.5);
            if( drivetrain.pulsesToDistance(drivetrain.getEncoderLeft()) > (distance1-1) ) {
                autoState = AutoState.Turn1;
                drivetrain.getGyro().reset();
            }

        }

        if(autoState == AutoState.Turn1)
        {
            drivetrain.startTurn(-.75,true);
            if (drivetrain.getGyro().getAngle()> 75) {
                autoState = AutoState.Forward2;
                drivetrain.getEncoderLeft().reset();
            }
        }


        if(autoState == AutoState.Forward1 )
        {
            drivetrain.startMove(-.5);
            if( drivetrain.pulsesToDistance(drivetrain.getEncoderLeft()) > (distance1-1) ) {
                autoState = AutoState.Turn1;
                drivetrain.getGyro().reset();
            }

        }

        if(autoState == AutoState.Turn1)
        {
            drivetrain.startTurn(-.75,true);
            if (drivetrain.getGyro().getAngle()> 75) {
                autoState = AutoState.Forward2;
                drivetrain.getEncoderLeft().reset();
            }
        }

        if(autoState == AutoState.Forward1 )
        {
            drivetrain.startMove(-.5);
            if( drivetrain.pulsesToDistance(drivetrain.getEncoderLeft()) > (distance1-1) ) {
                autoState = AutoState.Turn1;
                drivetrain.getGyro().reset();
            }

        }

        if(autoState == AutoState.Turn1)
        {
            drivetrain.startTurn(-.75,true);
            if (drivetrain.getGyro().getAngle()> 75) {
                autoState = AutoState.Forward2;
                drivetrain.getEncoderLeft().reset();
            }
        }

        if(autoState == AutoState.Forward1 )
        {
            drivetrain.startMove(-.5);
            if( drivetrain.pulsesToDistance(drivetrain.getEncoderLeft()) > (distance1-1) ) {
                autoState = AutoState.Turn1;
                drivetrain.getGyro().reset();
            }

        }

        if(autoState == AutoState.Turn1)
        {
            drivetrain.startTurn(-.75,true);
            if (drivetrain.getGyro().getAngle()> 75) {
                autoState = AutoState.Forward2;
                drivetrain.getEncoderLeft().reset();
            }
        }

        if(autoState == AutoState.End)
            drivetrain.stop();

//        DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L'
    }



    public void teleopPeriodic()
    {
        drivetrain.getDriveTrain().tankDrive(ui.joystickLeft.getY(), ui.joystickRight.getY());
        Scheduler.getInstance().run();
    }
}
