package team.gif.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UI {
    /**
     *  Widgets (e.g. gyro, text, True/False flags),
     *  buttons (e.g. SmartDashboard.putData("Reset", new ResetHeading()); ),
     *  and Chooser options (e.g. auto mode, auto delay)
     *
     *  Placed in SmartDashboard network table
     *  After dashboard loads for the first time, manually move items from network table onto respective dashboard tab
     *  and save file as "YYYY elastic-layout.json"
     */
    public UI() {
        Robot.pigeon.addToShuffleboard("Gyro");
    }

    /**
     * Widgets which are updated periodically should be placed here
     *
     * Convenient way to format a number is to use putString w/ format:
     *     SmartDashboard.putString("Elevator", String.format("%11.2f", Elevator.getPosition());
     */
    public void update() {
        //Example
        //SmartDashboard.putNumber("Climber Position", Robot.elevator.getPosition())
        SmartDashboard.putNumber("Heading", Robot.pigeon.getCompassHeading());
        SmartDashboard.putNumber("Drive Left Position", Robot.driveTrain.getLeftPositionRotations());
        SmartDashboard.putNumber("Drive Right Position", Robot.driveTrain.getRightPositionRotations());
        SmartDashboard.putNumber("Drive Left Velocity", Robot.driveTrain.getLeftVelocityRPM());
        SmartDashboard.putNumber("Drive Right Velocity", Robot.driveTrain.getRightVelocityRPM());
    }
}
