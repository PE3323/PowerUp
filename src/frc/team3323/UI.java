package frc.team3323;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

public class UI
{
    private XboxController xbox = new XboxController(0);

    private JoystickButton intakeSwitch = new JoystickButton(xbox,6);
    private JoystickButton exhaustSwitch = new JoystickButton(xbox, 5);
    private JoystickButton openSwitch = new JoystickButton(xbox,2);
    private JoystickButton closeSwitch = new JoystickButton(xbox,1);

    public  UI(Arms arms, Wheels wheels, Elevator elev)
    {
        openSwitch.whileHeld(arms.getOpen());
        closeSwitch.whileHeld(arms.getClose());
        intakeSwitch.whileHeld(wheels.getIntake());
        exhaustSwitch.whileHeld(wheels.getExhaust());

    }

    public XboxController getXbox()
    {
        return xbox;
    }
}
