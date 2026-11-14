package team.gif.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class IndexReverse extends Command {

    public IndexReverse() {
        super();
        addRequirements(Robot.indexer);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Robot.indexer.setVoltage(Constants.Indexer.INDEXER_REVERSE);
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
