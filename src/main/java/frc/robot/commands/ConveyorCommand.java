package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ConveyorSubsystem.Stage;
import edu.wpi.first.wpilibj2.command.CommandBase;

// TODO: utilize time of flight sensors -- CREATE ALGORITHM FOR HOLDING 5 BALLS!!

public class ConveyorCommand extends CommandBase {
  public ConveyorCommand(ConveyorSubsystem subsystem) {
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
    ConveyorSubsystem.verticalMotor.set(Math.abs(Constants.XboxRT() / 4));
    ConveyorSubsystem.horizontalMotor.set(Math.abs(Constants.XboxRT() / 4));

    // push balls out with XB_LT (must be negative)
    double val = Constants.XboxLT() / 4;
    if (val >= 0) {
      val = -val;
    }

    ConveyorSubsystem.verticalMotor.set(val);
    ConveyorSubsystem.horizontalMotor.set(val);




    // waiting and pickupMotor is spinning to receive balls.
    if (ConveyorSubsystem.State == Stage.Wait && IntakeSubsystem.pickupMotor.get() > 0) {
      ConveyorSubsystem.State = Stage.First;
    }

    if (ConveyorSubsystem.State == Stage.First && IntakeSubsystem.pickupMotor.get() > 0) {
      ConveyorSubsystem.verticalMotor.set(0.01);

      // cannot see ball
      while (ConveyorSubsystem.tof1.getRange() > 101) {
        // wait
      }

      // can see ball
      while (ConveyorSubsystem.tof1.getRange() < 101) {
        // wait
      }

      ConveyorSubsystem.verticalMotor.set(0);

      ConveyorSubsystem.State = Stage.Second;
    }

    
    while (true) {
      // pickupMotor is sucking in balls.
      if (IntakeSubsystem.pickupMotor.get() > 0) {
        if (ConveyorSubsystem.State == Stage.First) {
          ConveyorSubsystem.verticalMotor.set(0.01);
          
          ConveyorSubsystem.State = Stage.WaitForBall;
          ConveyorSubsystem.ReturnState = Stage.Second;
        }
        if (ConveyorSubsystem.State == Stage.WaitForBall) {
          // can see ball
          if (ConveyorSubsystem.tof1.getRange() < 101) {
            ConveyorSubsystem.State = Stage.WaitForNoBall;
          }
        }
        if (ConveyorSubsystem.State == Stage.WaitForNoBall) {
          // cannot see ball
          if (ConveyorSubsystem.tof1.getRange() > 101) {
            ConveyorSubsystem.State = ConveyorSubsystem.ReturnState;
          }
        }
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
