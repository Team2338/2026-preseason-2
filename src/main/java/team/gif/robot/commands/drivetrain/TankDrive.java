package team.gif.robot.commands.drivetrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class TankDrive extends Command {

    public TankDrive() {
        super();
        addRequirements(Robot.driveTrain);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double leftSpeed = MathUtil.applyDeadband(-Robot.oi.driver.getLeftY(), Constants.Joystick.DEADBAND) * Constants.Drivetrain.SPEED_PERCENT;
        double rightSpeed = MathUtil.applyDeadband(-Robot.oi.driver.getRightY(), Constants.Joystick.DEADBAND) * Constants.Drivetrain.SPEED_PERCENT;

        Robot.driveTrain.driveTank(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.driveTrain.stop();
    }
}
