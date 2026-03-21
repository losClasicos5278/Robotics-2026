// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.OperationConstants;

public class ShooterSubsystem extends SubsystemBase {
private static ShooterSubsystem m_instance;
  private final SparkMax m_shooter;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
      m_shooter = new SparkMax(OperationConstants.kShooter, SparkMax.MotorType.kBrushless);
  }

    public static ShooterSubsystem getInstance() {
    if (m_instance == null) {
      m_instance = new ShooterSubsystem();
    }
    return m_instance;
  }

  public void setShooterSpeed(double speed) {
    m_shooter.set(speed);
  }

  public boolean isShooterReady(double maxSpeed) {
    double currentSpeed = m_shooter.get();
    
    if (currentSpeed >= maxSpeed) {
      return true;
    }

    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
