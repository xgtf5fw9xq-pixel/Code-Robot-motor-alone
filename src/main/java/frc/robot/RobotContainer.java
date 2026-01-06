// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.PivotIntakeToAngle;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GroundIntake;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import static frc.robot.Constants.DriveSubsystemConstants.*;
import static frc.robot.Constants.GroundIntakeConstants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private static final DriveSubsystem m_driveSubsystem = new DriveSubsystem(kMotorIdFrontLeft, kMotorIdFrontRight, kMotorIdBackRight, kMotorIdBackLeft);
  private static final GroundIntake m_groundIntake = new GroundIntake(kPivotid, kIntakeid);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    // m_exampleSubsystem.setDefaultCommand(new RunCommand( ))
    m_driveSubsystem.setDefaultCommand(
        new RunCommand(() -> m_driveSubsystem.runDrivetrain(MathUtil.applyDeadband(m_driverController.getLeftY(), 0.1)),
            m_driveSubsystem));
    m_groundIntake.setDefaultCommand(new RunCommand(() -> m_groundIntake.intakeDefaultCommand(), m_groundIntake));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_driverController.leftBumper().whileTrue(
        new RunCommand(() -> m_driveSubsystem.runTurnLeft(0.2)));

    m_driverController.rightBumper().whileTrue(
        new RunCommand(() -> m_driveSubsystem.runTurnRight(0.2)));
    m_driverController.y().whileTrue(
        new RunCommand(() -> m_groundIntake.runIntake(0.5)));
    m_driverController.x().whileTrue(
        new RunCommand(() -> m_groundIntake.runIntake(-0.5)));
    m_driverController.b().whileTrue(
        new RunCommand(() -> m_groundIntake.runPivot(-0.1), m_groundIntake));

    m_driverController.povUp().whileTrue(
        new PivotIntakeToAngle(m_groundIntake, 45.)
    );

    m_driverController.povDown().whileTrue(
        new PivotIntakeToAngle(m_groundIntake, 90.)
    );

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * 
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.none();

  }
}
