// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.hopper;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HopperSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class UnclogCommand extends Command {
  private final HopperSubsystem m_hopperSubsystem;
  private double m_initialSpeed = 0.0;
  private double m_speed = -0.2; 

  /** Creates a new UnclogCommand. */
  public UnclogCommand() {
    m_hopperSubsystem = HopperSubsystem.getInstance();
    addRequirements(m_hopperSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {m_hopperSubsystem.setHopperSpeed(m_speed);}


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {m_hopperSubsystem.setHopperSpeed(m_initialSpeed);}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
