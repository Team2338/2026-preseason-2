// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class TalSuckSub extends SubsystemBase {
    SparkMax shooter;
    /** Creates a new ExampleSubsystem. */
    public TalSuckSub() {
        shooter = new SparkMax(RobotMap.NEO_COLLECT_ID, SparkLowLevel.MotorType.kBrushed);
        SparkMaxConfig sparkmaxconfig = new SparkMaxConfig();
        sparkmaxconfig.idleMode(SparkBaseConfig.IdleMode.kBrake);
        sparkmaxconfig.inverted(true);
        shooter.configure(sparkmaxconfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setVoltage(double voltage) {
        shooter.setVoltage(voltage);
    }
}
