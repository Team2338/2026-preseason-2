package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class TalShoot extends Command {

    public TalShoot() {
        super();
        //addRequirements(Robot.climber); // uncomment
        addRequirements(Robot.shoot);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.shoot.setVoltage(6);
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {}

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {Robot.shoot.setVoltage(0.0);}
}
