package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterSubsystem extends SubsystemBase {
  public static WPI_TalonFX leftMotor, rightMotor;

  public ShooterSubsystem() {
    leftMotor = new WPI_TalonFX(Constants.kCShooterLeft);
    rightMotor = new WPI_TalonFX(Constants.kCShooterRight);
    
    leftMotor.configFactoryDefault();
    rightMotor.configFactoryDefault();

    leftMotor.setInverted(false);
    rightMotor.setInverted(true);

    leftMotor.follow(rightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}