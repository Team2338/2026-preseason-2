package team.gif.robot.commands.drivetrain;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ArcadeDrive extends Command {
    private final SlewRateLimiter speedLimiter;

    public ArcadeDrive() {
        super();
        speedLimiter = new SlewRateLimiter(Constants.Drivetrain.SLEW_RATE_LIMIT);
        addRequirements(Robot.driveTrain);
    }

    @Override
    public void initialize() {
        speedLimiter.reset(0);
    }

    @Override
    public void execute() {
        double speed = MathUtil.applyDeadband(-Robot.oi.driver.getLeftY(), Constants.Joystick.DEADBAND) * Constants.Drivetrain.SPEED_PERCENT;
        double rotation = MathUtil.applyDeadband(-Robot.oi.driver.getRightX(), Constants.Joystick.DEADBAND) * Constants.Drivetrain.SPEED_PERCENT;

        Robot.driveTrain.driveArcade(speedLimiter.calculate(speed), rotation);
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
