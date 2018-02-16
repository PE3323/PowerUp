package frc.team3323;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Manipulator;

public class UI
{
    private XboxController xbox = new XboxController(0);

    private JoystickButton maniIntakeSwitch = new JoystickButton(xbox,6);
    private JoystickButton maniExhaustSwitch = new JoystickButton(xbox, 5);
    private JoystickButton maniOpenSwitch = new JoystickButton(xbox,2);
    private JoystickButton maniCloseSwitch = new JoystickButton(xbox,1);

    public  UI(Manipulator mani, Elevator elev)
    {
        maniOpenSwitch.whileHeld(mani.getOpen());
        maniCloseSwitch.whileHeld(mani.getClose());
        maniIntakeSwitch.whileHeld(mani.getIntake());
        maniExhaustSwitch.whileHeld(mani.getExhaust());

    }

    public XboxController getXbox()
    {
        return xbox;
    }
}
