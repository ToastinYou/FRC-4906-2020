package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.subsystems.PickupSubsystem;

// power cell pickup

public class PickupCommand extends CommandBase {
    private final PickupSubsystem m_subsystem;
    private boolean pickupPiston = false;
  
    public PickupCommand(PickupSubsystem subsystem) {
      m_subsystem = subsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // default pickup to upward
      PickupSubsystem.sol1.set(DoubleSolenoid.Value.kReverse);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (Constants.XboxControl.getXButton()) {
        PickupSubsystem.pickupMotor.set(0.01);
      }
      else if (Constants.XboxControl.getBButton()) {
        PickupSubsystem.pickupMotor.set(-0.01);
      }
      else {
        PickupSubsystem.pickupMotor.set(0);
      }

      // DPAD RIGHT
      if (Constants.XboxControl.getPOV(90) != 1) {
        if (!pickupPiston) {
          pickupPiston = true;
          PickupSubsystem.sol1.set(DoubleSolenoid.Value.kForward);
        }
        else {
          pickupPiston = false;
          PickupSubsystem.sol1.set(DoubleSolenoid.Value.kReverse);
        }
      }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}