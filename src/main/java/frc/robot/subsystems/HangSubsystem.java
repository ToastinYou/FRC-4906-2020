package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HangSubsystem extends SubsystemBase {
  public static CANSparkMax hangMotorLeft;
  private CANSparkMax hangMotorRight;

  public HangSubsystem() {
    hangMotorLeft = new CANSparkMax(Constants.CAN9, MotorType.kBrushless);
    hangMotorRight = new CANSparkMax(Constants.CAN10, MotorType.kBrushless);

    hangMotorRight.setInverted(true);

    hangMotorLeft.follow(hangMotorRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}