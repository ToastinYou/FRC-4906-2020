package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// power cell pickup

public class IntakeSubsystem extends SubsystemBase {
  public static CANSparkMax intakeMotor;
  public static DoubleSolenoid sol;

  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(Constants.kCIntake, MotorType.kBrushless);
    sol = new DoubleSolenoid(Constants.kPIntakeFwd, Constants.kPIntakeRev);

    intakeMotor.restoreFactoryDefaults();
    intakeMotor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static boolean isIntakeDown() {
    return sol.get() == DoubleSolenoid.Value.kReverse;
  }

  public static boolean isIntakeUp() {
    return sol.get() == DoubleSolenoid.Value.kForward;
  }

  public static void setIntakeDown() {
    if (isIntakeUp()) {
      for (int i = 0; i < 50; i++) {
        sol.set(DoubleSolenoid.Value.kReverse);
      }
    }
  }

  public static void setIntakeUp() {
    if (isIntakeDown()) {
      for (int i = 0; i < 50; i++) {
        sol.set(DoubleSolenoid.Value.kForward);
      }
    }
  }
}