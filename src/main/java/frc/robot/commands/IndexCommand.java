package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.PickupSubsystem;
import frc.robot.subsystems.IndexSubsystem.Stage;
import edu.wpi.first.wpilibj2.command.CommandBase;

// TODO: utilize time of flight sensors -- CREATE ALGORITHM FOR HOLDING 5 BALLS!!

public class IndexCommand extends CommandBase {
  public IndexCommand(IndexSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // suck balls in with XB_RT (must be positive)
    IndexSubsystem.lowMotor.set(Math.abs(Constants.XboxRT() / 4));
    IndexSubsystem.highMotor.set(Math.abs(Constants.XboxRT() / 4));

    // push balls out with XB_LT (must be negative)
    double val = Constants.XboxLT() / 4;
    if (val >= 0) {
      val = -val;
    }

    IndexSubsystem.lowMotor.set(val);
    IndexSubsystem.highMotor.set(val);



    // waiting and pickupMotor is spinning to receive balls.
    if (IndexSubsystem.State == Stage.Wait && PickupSubsystem.pickupMotor.get() > 0) {
      
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
