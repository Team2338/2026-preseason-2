package team.gif.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class Shooter extends SubsystemBase {
    private final SparkMax motor;

    public Shooter() {
        motor = new SparkMax(RobotMap.SHOOTER_MOTOR, SparkLowLevel.MotorType.kBrushed);
        SparkMaxConfig config = new SparkMaxConfig();
        config
                .idleMode(SparkBaseConfig.IdleMode.kBrake)
                .inverted(Constants.Shooter.INVERTED);
        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setVoltage(double volts) {
        motor.setVoltage(volts);
    }

    public void stop() {
        motor.stopMotor();
    }
}
