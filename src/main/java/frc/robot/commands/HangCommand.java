package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.HangSubsystem;

public class HangCommand extends CommandBase {
    public HangCommand(HangSubsystem subsystem) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(subsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      // default to inward
      HangSubsystem.sol.set(DoubleSolenoid.Value.kReverse);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (HangSubsystem.sol.get() == Value.kReverse) {
        if (OI.getStickLeftAxisUp() && HangSubsystem.topLimit.get()) {
          HangSubsystem.hangMotorLeft.set(Constants.kSpeedHangRev);
          HangSubsystem.hangMotorRight.set(Constants.kSpeedHangFwd);
        }
        else if (OI.getStickLeftAxisDown() && HangSubsystem.bottomLimit.get()) {
          HangSubsystem.hangMotorLeft.set(Constants.kSpeedHangFwd);
          HangSubsystem.hangMotorRight.set(Constants.kSpeedHangRev);
        }
        else {
          HangSubsystem.hangMotorLeft.set(0);
          HangSubsystem.hangMotorRight.set(0);
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