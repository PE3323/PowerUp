/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//Owen, add some code to add a deadzone to the controller sticks. They are very sensitive.
package frc.team3323;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Autonomous.*;
import frc.team3323.Drivetrain.Drivetrain;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

import java.util.ArrayList;
import java.util.List;


public class  Robot extends IterativeRobot
{
    private Arms arms = new Arms();
    private Wheels wheels = new Wheels();
    private Drivetrain drivetrain = new Drivetrain();
    private PowerDistributionPanel pdp= new PowerDistributionPanel();
    private Elevator elevator = new Elevator(pdp);
    private UI ui = new UI(arms, wheels);
    private List movements = new ArrayList();
    private double elevatorDrive;


    public void robotInit()
    {
        elevatorDrive = 0;
    }

    public void robotPeriodic()
    {
        drivetrain.log(pdp);
        arms.log(pdp);
        wheels.log(pdp);
        elevator.log(pdp);
        SmartDashboard.putNumber("Battery Voltage", pdp.getVoltage());
        SmartDashboard.putData("gyro", drivetrain.getGyro());
        if(elevator.limitSwitch.getVoltage() < 3)
            elevator.encoderElevator.reset();
    }

    public void autonomousInit() {
        movements.clear();
////        if(DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='R')
//        {
//            // Right Auto
//            movements.add( new Move("move1",1, drivetrain, drivetrain.getEncoderRight()));
//            movements.add( new Turn("turn2",90, drivetrain));
//            movements.add( new Move("move2",3, drivetrain, drivetrain.getEncoderRight()));
//            movements.add( new Turn("turn2",-90, drivetrain));
//            movements.add( new Move("move3",1, drivetrain, drivetrain.getEncoderRight()));
//        }
//        else
//        {
//           //Left Auto
//        movements.add( new Move("move1",1, drivetrain, drivetrain.getEncoderRight()));
//        movements.add( new Turn("turn2",-90, drivetrain));
//        movements.add( new Move("move2",5, drivetrain, drivetrain.getEncoderRight()));
//        movements.add( new Turn("turn2",90, drivetrain));
//        movements.add( new Move("move3",1, drivetrain, drivetrain.getEncoderRight()));
//        }
        if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R')
        {
            // Right Auto
             movements.add( new Move("move1",15, drivetrain, drivetrain.getEncoderRight()));
//          movements.add( new Turn("turn2",-45, drivetrain));
//          movements.add( new Move("move2",3, drivetrain, drivetrain.getEncoderRight()));
//          movements.add( new Turn("turn2",45, drivetrain));
//          movements.add( new Move("move3",5, drivetrain, drivetrain.getEncoderRight()));

        }
        else
        {
           //Left Auto
            movements.add(new Move("move1", 15, drivetrain, drivetrain.getEncoderRight()));
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


    public void teleopInit()
    {
        elevator.encoderElevator.setReverseDirection(true);
    }


    public void teleopPeriodic()
    {
        boolean elevatorDown = elevator.limitSwitch.getVoltage() < 3;
        if(elevatorDown)
        {
            if(ui.getXboxCube().getRawAxis(1)>0)
            {
                elevatorDrive=0;
            }
            else
                elevatorDrive = ui.getXboxCube().getRawAxis(1);
        }
        else
            elevatorDrive = ui.getXboxCube().getRawAxis(1);
        elevator.lift(elevatorDrive,ui);
        drivetrain.getDriveTrain().arcadeDrive(-ui.getXboxDrive().getRawAxis(1), ui.getXboxDrive().getRawAxis(0));
        drivetrain.fan(ui.fanSwitch);
        Scheduler.getInstance().run();
    }
}


