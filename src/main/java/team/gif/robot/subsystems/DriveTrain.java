package team.gif.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    private final SparkMax left;
    private final SparkMax right;
    private final RelativeEncoder leftEncoder;
    private final RelativeEncoder rightEncoder;
    private final DifferentialDrive drive;

    public DriveTrain() {
        left = createController(RobotMap.LEFT_SPARK_MAX, Constants.Drivetrain.LEFT_INVERTED);
        right = createController(RobotMap.RIGHT_SPARK_MAX, Constants.Drivetrain.RIGHT_INVERTED);

        leftEncoder = left.getEncoder();
        rightEncoder = right.getEncoder();
        resetEncoders();

        drive = new DifferentialDrive(left::set, right::set);
    }

    private static SparkMax createController(int id, boolean inverted) {
        SparkMax controller = new SparkMax(id, SparkLowLevel.MotorType.kBrushless);
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .idleMode(SparkBaseConfig.IdleMode.kBrake)
                .smartCurrentLimit(Constants.Drivetrain.CURRENT_LIMIT_AMPS)
                .inverted(inverted);
        controller.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        return controller;
    }

    public void driveArcade(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    public void driveTank(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive.stopMotor();
    }

    public double getLeftPositionRotations() {
        return leftEncoder.getPosition();
    }

    public double getRightPositionRotations() {
        return rightEncoder.getPosition();
    }

    public double getLeftVelocityRPM() {
        return leftEncoder.getVelocity();
    }

    public double getRightVelocityRPM() {
        return rightEncoder.getVelocity();
    }

    public void resetEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }
}
