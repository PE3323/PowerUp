/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//Owen, add some code to add a deadzone to the controller sticks. They are very sensitive.
package frc.team3323;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Autonomous.Move;
import frc.team3323.Autonomous.State;
import frc.team3323.Autonomous.Turn;
import frc.team3323.Drivetrain.Drivetrain;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Manipulator;

import java.util.ArrayList;
import java.util.List;


public class Robot extends IterativeRobot
{
    private Manipulator manipulator = new Manipulator();
    private Drivetrain drivetrain = new Drivetrain();
    private PowerDistributionPanel pdp= new PowerDistributionPanel();
    private Elevator elevator = new Elevator(pdp);
    private UI ui = new UI(manipulator, elevator);
    private List movements = new ArrayList();

    public void robotPeriodic()
    {
        drivetrain.log(pdp);
        SmartDashboard.putNumber("Battery Voltage", pdp.getVoltage());
        SmartDashboard.putData("gyro", drivetrain.getGyro());
    }

    public void autonomousInit()
    {
        movements.clear();
        if(DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='R')
        {
            // Right Auto
            movements.add(new Move("move1", 35, drivetrain, drivetrain.getEncoderLeft()));
        }
        else
        {
            //Left Auto
            movements.add(new Move("move1", 37, drivetrain, drivetrain.getEncoderRight()));
            movements.add(new Turn("turn1", 90, drivetrain));
            movements.add(new Move("move2", 25, drivetrain, drivetrain.getEncoderRight()));
            movements.add(new Turn("turn2", 90, drivetrain));
            movements.add(new Move("move3", 37, drivetrain, drivetrain.getEncoderRight()));
            movements.add(new Turn("turn3", 90, drivetrain));
            movements.add(new Move("move4", 25, drivetrain, drivetrain.getEncoderRight()));
            movements.add(new Turn("turn4", 90, drivetrain));
        }
    }

    public void autonomousPeriodic()
    {
        if(movements.isEmpty())
            drivetrain.stop();
        else {
            State state = (State) movements.get(0);
            SmartDashboard.putString("State", state.getName());
            SmartDashboard.putBoolean("When", state.transitionWhen());
            state.doInitialize();

            if (state.transitionWhen()) {
                movements.remove(0);
                state.complete();
            } else {
                state.execute();
            }
        }
    }



    public void teleopPeriodic()
    {
        double driveAmount = ui.getXbox().getRawAxis(2) + ui.getXbox().getRawAxis(3);
        elevator.lift(ui.getXbox().getRawAxis(5));
        drivetrain.getDriveTrain().arcadeDrive(driveAmount, ui.getXbox().getRawAxis(0));
        Scheduler.getInstance().run();
    }
}
//Guard: Hey;, you are not allowed to bring food into the theater.
//Me: But it's my service burrito...
