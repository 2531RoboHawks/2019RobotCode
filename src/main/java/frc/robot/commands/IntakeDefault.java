package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class IntakeDefault extends Command {

  private Command action = null;

  public IntakeDefault() {
    requires(Robot.intake);
    requires(Robot.hatchClamp);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Intake Default");
  }

  @Override
  protected void execute() {
    if (OI.joystick_right.getRawButton(OI.GRAB_HATCH_BUTTON)) {
      action = new GrabHatch();
    } else if (OI.joystick_right.getRawButton(OI.GRAB_CARGO_BUTTON)) {
      action = new GrabCargo();
    } else if (OI.joystick_right.getRawButton(OI.PLACE_BUTTON)) {
      if (RobotMap.cargoDetestionSwitch.get()) {
        action = new PlaceCargo();
      } else {
        action = new PlaceHatch();
      }
    } else {
      action.cancel();
    }
    if (action != null && RobotMap.liftOnTarget) {
      if (!action.isRunning()) {
        action.start();
      }
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    System.out.println("-! Intake Default");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
