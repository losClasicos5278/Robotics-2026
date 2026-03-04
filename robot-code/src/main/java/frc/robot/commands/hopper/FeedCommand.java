// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.hopper;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class FeedCommand extends Command {
  private final HopperSubsystem m_hopperSubsystem;
  private final ShooterSubsystem m_shooterSubsystem;

  private double m_initialHopperSpeed = 0.0;
  private double m_hopperSpeed = 0.2; 

  private double m_initialShooterSpeed = 0.0;
  private double m_shooterSpeed = 0.55;

   /** Creates a new FeedCommand. */
  public FeedCommand() {
    // Use addRequirements() here to declare subsystem dependencies.

    m_hopperSubsystem = HopperSubsystem.getInstance();
    addRequirements(m_hopperSubsystem);

    m_shooterSubsystem = ShooterSubsystem.getInstance();
    addRequirements(m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.setShooterSpeed(m_shooterSpeed);

    if (m_shooterSubsystem.isShooterReady(m_shooterSpeed)) {
       m_hopperSubsystem.setHopperSpeed(m_hopperSpeed);
    }
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterSubsystem.setShooterSpeed(m_initialShooterSpeed);
    m_hopperSubsystem.setHopperSpeed(m_initialHopperSpeed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
