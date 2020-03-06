package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HangSubsystem extends SubsystemBase {
  public static CANSparkMax hangMotorLeft;
  private CANSparkMax hangMotorRight;

  public static DigitalInput topLimit, bottomLimit;

  public HangSubsystem() {
    hangMotorLeft = new CANSparkMax(Constants.kCHangLeft, MotorType.kBrushless);
    hangMotorRight = new CANSparkMax(Constants.kCHangRight, MotorType.kBrushless);

    hangMotorRight.setInverted(true);

    hangMotorLeft.follow(hangMotorRight);

    topLimit = new DigitalInput(Constants.kDHangTop);
    bottomLimit = new DigitalInput(Constants.kDHangBottom);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}