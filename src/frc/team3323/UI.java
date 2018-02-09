package frc.team3323;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3323.Manipulator.Manipulator;

public class UI
{
    public Joystick joystickRight = new Joystick(1);
    public Joystick joystickLeft = new Joystick(0);

    private JoystickButton maniIntakeSwitch = new JoystickButton(joystickRight,2);
    public JoystickButton maniExhaustSwitch = new JoystickButton(joystickRight, 3);
    public JoystickButton maniOpenSwitch = new JoystickButton(joystickRight,4);
    public JoystickButton maniCloseSwitch = new JoystickButton(joystickRight,5);
    public JoystickButton elevLiftSwitch = new JoystickButton(joystickRight, 1);

    public  UI(Manipulator mani)
    {
        maniOpenSwitch.whileHeld(mani.getOpen());
        maniCloseSwitch.whileHeld(mani.getClose());
        maniIntakeSwitch.whileHeld(mani.getIntake());
        maniExhaustSwitch.whileHeld(mani.getExhaust());
    }
}
