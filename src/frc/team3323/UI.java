package frc.team3323;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3323.Drivetrain.Drivetrain;
import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

public class UI
{
    private XboxController xboxDrivetrain = new XboxController(0);
    private XboxController xboxCube = new XboxController(1);
    private JoystickButton intakeSwitch = new JoystickButton(xboxCube,6);
    private JoystickButton exhaustSwitch = new JoystickButton(xboxCube, 5);
    private JoystickButton openSwitch = new JoystickButton(xboxCube,2);
    private JoystickButton closeSwitch = new JoystickButton(xboxCube,3);
    private JoystickButton gripSwitch = new JoystickButton(xboxCube,1);
    public JoystickButton fanSwitch = new JoystickButton(xboxDrivetrain,8);

    public UI(Arms arms, Wheels wheels)
    {

        openSwitch.whileHeld(arms.getOpen());
        closeSwitch.whileHeld(arms.getClose());
        intakeSwitch.whileHeld(wheels.getIntake());
        exhaustSwitch.whileHeld(wheels.getExhaust());
        gripSwitch.whileHeld(arms.getGrip());

    }

    public XboxController getXboxDrive()
    {
        return xboxDrivetrain;
    }

    public XboxController getXboxCube()
    {
        return xboxCube;
    }
}
