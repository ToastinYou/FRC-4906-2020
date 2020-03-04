package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  public static WPI_VictorSPX leftMotor;
  private WPI_VictorSPX rightMotor;

  public IndexSubsystem() {
    leftMotor = new WPI_VictorSPX(Constants.CAN11);
    rightMotor = new WPI_VictorSPX(Constants.CAN12);
    
    rightMotor.setInverted(true);

    leftMotor.follow(rightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
