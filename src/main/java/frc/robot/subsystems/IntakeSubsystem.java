package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.IntakePistonCommand;

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

    IntakePistonCommand.State = IntakePistonCommand.Piston.Up;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}