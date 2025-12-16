// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GroundIntake extends SubsystemBase {
  SparkMax pivotMotor1;
  // SparkMax pivotMotor2;
  SparkMax intakeMotor;
  public GroundIntake(int pivot1, int intakeID) {
    this.pivotMotor1 = new SparkMax(pivot1, MotorType.kBrushless);
    // this.pivotMotor2 = new SparkMax(pivot2, MotorType.kBrushless);
    this.intakeMotor = new SparkMax(intakeID, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runIntake(double speed) {
    this.intakeMotor.set(speed);
  }

  public void runPivot(double speed) {
    this.pivotMotor1.set(speed);
    // this.pivotMotor2.set(speed);
  }

  public double getEncoderVal() {
    return 0.0;
  }

}
