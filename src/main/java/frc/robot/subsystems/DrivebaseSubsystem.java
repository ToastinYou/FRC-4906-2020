package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DrivebaseSubsystem extends SubsystemBase {
  public static DifferentialDrive dDrive;

  public DrivebaseSubsystem() {
    WPI_TalonFX leftMotor1 = new WPI_TalonFX(Constants.CAN2);
    WPI_TalonFX leftMotor2 = new WPI_TalonFX(Constants.CAN3);
    WPI_TalonFX rightMotor1 = new WPI_TalonFX(Constants.CAN4);
    WPI_TalonFX rightMotor2 = new WPI_TalonFX(Constants.CAN5);

    dDrive = new DifferentialDrive(leftMotor1, rightMotor1);

    leftMotor2.follow(leftMotor1); // needed?
    rightMotor2.follow(rightMotor1); // needed?
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}