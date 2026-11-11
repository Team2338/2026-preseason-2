package team.gif.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class ResetHeading extends Command {

    public ResetHeading() {
        super();
    }

    @Override
    public void initialize() {
        Robot.pigeon.resetPigeonPosition();
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {}
}
