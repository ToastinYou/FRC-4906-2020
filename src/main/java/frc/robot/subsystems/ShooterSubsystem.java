package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterSubsystem extends SubsystemBase {
  public static WPI_TalonFX leftMotor;
  private WPI_TalonFX rightMotor;

  public ShooterSubsystem() {
    leftMotor = new WPI_TalonFX(Constants.CAN12);
    rightMotor = new WPI_TalonFX(Constants.CAN3);
    
    rightMotor.setInverted(true);

    leftMotor.follow(rightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}