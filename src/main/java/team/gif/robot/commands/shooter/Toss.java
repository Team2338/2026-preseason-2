package team.gif.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class Toss extends Command {

    public Toss() {
        super();
        addRequirements(Robot.shooter);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Robot.shooter.setVoltage(Constants.Shooter.TOSS_VOLTS);
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
