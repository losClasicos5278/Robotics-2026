// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.OperationConstants;

public class HopperSubsystem extends SubsystemBase {
  private static HopperSubsystem m_instance;
  private final SparkMax m_hopper;

  /** Creates a new HopperSubsystem. */
  public HopperSubsystem() {
    m_hopper = new SparkMax(OperationConstants.kHopper, SparkMax.MotorType.kBrushless);
  }

  public static HopperSubsystem getInstance() {
    if (m_instance == null) {
      m_instance = new HopperSubsystem();
    }
    return m_instance;
  }

  public void setHopperSpeed(double speed) {
    m_hopper.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
