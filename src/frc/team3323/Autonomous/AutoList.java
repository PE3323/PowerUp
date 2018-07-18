package frc.team3323.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3323.Autonomous.*;
import frc.team3323.Drivetrain.Drivetrain;
import frc.team3323.Elevator.Elevator;
import frc.team3323.Manipulator.Arms;
import frc.team3323.Manipulator.Wheels;

import java.util.ArrayList;
import java.util.List;

public class AutoList {

    private Elevator elevator;
    private Drivetrain drivetrain;
    private Arms arms;
    private Wheels wheels;


    private List movements = new ArrayList();




    public void autoInit()
    {
        movements.clear();
//        if(DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='R')
//        {
//            // Right Auto
//        }
//        else
//        {
//           //Left Auto
//        }
//        movements.add(new Move("move",2,drivetrain, drivetrain.getEncoderRight()));
//        movements.add(new Turn("turn3", 90, drivetrain));
//        movements.add(new Move("move4", 5, drivetrain, drivetrain.getEncoderRight()));
//        movements.add(new Turn("turn4", -90, drivetrain));
        movements.add( new Move("move1",15, drivetrain, drivetrain.getEncoderRight()));
        movements.add( new GrabCube("grab1", arms,wheels,0,0));
        movements.add( new ElevatorRise("lift1", elevator, 5600));
        movements.add( new ReleaseCube("release1", arms, wheels));
    }

    public void autoPeriodic()
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


    public AutoList (String name, Elevator elevator, Drivetrain drivetrain, Arms arms, Wheels wheels)
    {
        this.elevator = elevator;
        this.drivetrain = drivetrain;
        this.arms = arms;
        this.wheels = wheels;
    }
}
