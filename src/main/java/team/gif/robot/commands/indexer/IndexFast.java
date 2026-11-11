package team.gif.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class IndexFast extends Command {

    public IndexFast() {
        super();
        addRequirements(Robot.indexer);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Robot.indexer.setVoltage(Constants.Indexer.FAST_VOLTS);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.indexer.stop();
    }
}
