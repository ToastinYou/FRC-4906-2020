package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// power cell pickup

public class PickupSubsystem extends SubsystemBase {
  public static CANSparkMax pickupMotor;

  public PickupSubsystem() {
    pickupMotor = new CANSparkMax(Constants.CAN0, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}