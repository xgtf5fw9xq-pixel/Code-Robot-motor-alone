// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class GroundIntakeConstants {
    public static final double kP = 0.;
    public static final double kI = 0.;
    public static final double kD = 0.;
    public static final int kPivotid = 6;
    public static final int kIntakeid = 5;
    
  }

public static class DriveSubsystemConstants {
  public static final int kMotorIdFrontLeft = 1;
  public static final int kMotorIdFrontRight = 2;
  public static final int kMotorIdBackRight = 3;
  public static final int kMotorIdBackLeft= 4;
}


}