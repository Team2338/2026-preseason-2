package team.gif.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class Collect extends Command {

    public Collect() {
        super();
        addRequirements(Robot.collector);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        Robot.collector.setVoltage(Constants.Collector.COLLECT_VOLTS);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.collector.stop();
    }
}
