package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// power cell pickup

public class IntakeSubsystem extends SubsystemBase {
  public static CANSparkMax pickupMotor;
  public static DoubleSolenoid sol1;

  public IntakeSubsystem() {
    pickupMotor = new CANSparkMax(Constants.kCIntake, MotorType.kBrushless);
    sol1 = new DoubleSolenoid(Constants.kPIntakeFwd, Constants.kPIntakeRev);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}