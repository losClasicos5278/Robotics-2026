package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import frc.robot.Constants.OIConstants;
import frc.robot.Constants.OperationConstants;

public class IntakeSubsystem extends SubsystemBase {
    private static IntakeSubsystem m_instance;

    private final SparkMax rollermotor = new SparkMax(OperationConstants.kIntakeRollerMotorCanId, MotorType.kBrushless);
    private final SparkMax armLeader = new SparkMax(OperationConstants.kArmLeader, MotorType.kBrushless);
    private final SparkMax armFollower = new SparkMax(OperationConstants.kArmFollower, MotorType.kBrushless);

    private final SparkMaxConfig rollerConfig = new SparkMaxConfig();
    private final SparkMaxConfig armConfig = new SparkMaxConfig();
    private boolean isArmDown = false;

    public IntakeSubsystem() {
        rollerConfig.smartCurrentLimit(30).idleMode(IdleMode.kCoast);
        armConfig.smartCurrentLimit(40).idleMode(IdleMode.kCoast);

        armConfig.closedLoop
                .p(0.1)// TODO: find correct limit
                .i(0.0)
                .d(0.0)
                .outputRange(-0.2, 0.2);

        armConfig.softLimit.forwardSoftLimit(24)// TODO: Find real limit
                .forwardSoftLimitEnabled(true)
                .reverseSoftLimit(0.5)// TODO Find Real Limit
                .reverseSoftLimitEnabled(true);

        SparkMaxConfig followerConfig = new SparkMaxConfig();

        followerConfig.follow(OperationConstants.kArmLeader, true);

        rollermotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        armLeader.configure(armConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        armFollower.configure(followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public static IntakeSubsystem getInstance() {
        if (m_instance == null) {
            m_instance = new IntakeSubsystem();
        }
        return m_instance;
    }

    public void setRollers(double speed) {
        rollermotor.set(speed);
    }

    public void toggleArm() {
        double target;

        if (isArmDown) {
            target = 0;// TODO find real and make property
        } else {
            target = 15.85;// TODO find real and make property
        }

        armLeader.getClosedLoopController().setReference(target, ControlType.kPosition);
        isArmDown = !isArmDown;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Position:", armLeader.getEncoder().getPosition());
        SmartDashboard.putBoolean("Arm is Down:", isArmDown);
    }

}
