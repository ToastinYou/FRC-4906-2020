package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveSubsystem extends SubsystemBase {
  public static DifferentialDrive dDrive;
  public static double left, right;

  public DriveSubsystem() {
    WPI_TalonFX leftFrontMotor = new WPI_TalonFX(Constants.kCDriveLFront);
    WPI_TalonFX leftRearMotor = new WPI_TalonFX(Constants.kCDriveLRear);
    WPI_TalonFX rightFrontMotor = new WPI_TalonFX(Constants.kCDriveRFront);
    WPI_TalonFX rightRearMotor = new WPI_TalonFX(Constants.kCDriveRRear);

    leftFrontMotor.configFactoryDefault();
    leftRearMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    rightRearMotor.configFactoryDefault();

    leftFrontMotor.setInverted(true);
    leftRearMotor.setInverted(true);
    rightFrontMotor.setInverted(true);
    rightRearMotor.setInverted(true);

    dDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

    leftRearMotor.follow(leftFrontMotor);
    rightRearMotor.follow(rightFrontMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}