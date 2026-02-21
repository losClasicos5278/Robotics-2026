package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.OperationConstants;



public class IntakeSubsistem extends SubsystemBase  {

    private final SparkMax rollermotor = new SparkMax(OperationConstants.kIntakeRollerMotorCanId, MotorType.kBrushless);
    private final SparkMax armLeader = new SparkMax(OperationConstants.kArmLeader, MotorType.kBrushless);
    private final SparkMax armFollower = new SparkMax(OperationConstants.kArmFollower, MotorType.kBrushless);


    
}
