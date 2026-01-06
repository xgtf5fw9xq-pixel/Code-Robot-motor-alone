// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GroundIntake extends SubsystemBase {
  SparkMax pivotMotor1;
  SparkMax intakeMotor;
  DutyCycleEncoder encoder = new DutyCycleEncoder(5);

  public GroundIntake(int pivot1, int intakeID) {
    this.pivotMotor1 = new SparkMax(pivot1, MotorType.kBrushless);
    // this.pivotMotor2 = new SparkMax(pivot2, MotorType.kBrushless);
    this.intakeMotor = new SparkMax(intakeID, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Ground Intake Pivot Angle", getEncoderVal());
  }

  public void runIntake(double speed) {
    this.intakeMotor.set(speed);
  }

  public void runPivot(double speed) {
    if (speed > 0) {
      if (getEncoderVal() < 5) {
        speed = 0;
      }
    }
    this.pivotMotor1.set(speed);
    // this.pivotMotor2.set(speed);
  }

  public double getEncoderVal() {
    return -(encoder.get()-0.4654)*360 - 60;
  }
  
  public void intakeDefaultCommand() {
    pivotMotor1.set(0);
    intakeMotor.set(0.);
  }
}
