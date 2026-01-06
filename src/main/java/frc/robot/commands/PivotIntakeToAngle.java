// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.GroundIntake;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PivotIntakeToAngle extends Command {
  GroundIntake groundIntake;
  double setpoint;
  PIDController angleController;
  /** Creates a new PivotIntakeToAngle. */
  public PivotIntakeToAngle(GroundIntake groundIntake, double setpoint) {
    this.groundIntake = groundIntake;
    this.setpoint = setpoint;
    angleController = new PIDController(0,0,0);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.groundIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    angleController.setSetpoint(setpoint);
    SmartDashboard.putData("Controller", angleController);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    groundIntake.runPivot(-angleController.calculate(groundIntake.getEncoderVal())-0.075);
    // System.out.println(angleController.calculate(groundIntake.getEncoderVal()));
    // SmartDashboard.putNumber("Controller Output", angleController.calculate(groundIntake.getEncoderVal()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return angleController.atSetpoint();
  }
}
