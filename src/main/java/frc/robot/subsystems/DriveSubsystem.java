// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  SparkMax motorOne;
  SparkMax motorTwo;
  SparkMax motorThree;
  SparkMax motorFour;
  public DriveSubsystem(int id1, int id2, int id3, int id4) {
    motorOne = new SparkMax(id1, MotorType.kBrushless);
    motorTwo = new SparkMax(id2, MotorType.kBrushless);
    motorThree = new SparkMax(id3, MotorType.kBrushless);
    motorFour = new SparkMax(id4, MotorType.kBrushless);
  }
  
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void runMotor(double speed){
    //Speed is -1.0 to 1.0
    motorOne.set(speed);
    //motorTwo.set(speed);
    //motorThree.set(speed);
    //motorFour.set(speed);
  }

  }
  
