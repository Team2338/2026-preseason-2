package team.gif.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class Shoot extends Command {

    public Shoot() {
        super();
        addRequirements(Robot.shooter);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Robot.shooter.setVoltage(Constants.Shooter.SHOOT_VOLTS);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.shooter.stop();
    }
}
