/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team3323;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends IterativeRobot 
{

    private CANTalon srx1 = new CANTalon(5);
    private CANTalon srx2 = new CANTalon(4);
    private Joystick joystickLeft = new Joystick(0);
    private Joystick joystickRight = new Joystick(1);

    public void robotInit()
    {
    }

    public void autonomousPeriodic() 
    {
    }


    public void teleopPeriodic() 
    {
        srx1.set(joystickLeft.getY());
        srx2.set(joystickRight.getY());
    }
}
