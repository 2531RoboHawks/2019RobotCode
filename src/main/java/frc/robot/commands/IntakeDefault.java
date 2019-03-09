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
    if (OI.joystick_right.getRawButton(OI.IN_CARGO_BUTTON)) {
      Robot.intake.setMotor(-0.3);
    } else if (OI.joystick_left.getRawButton(OI.OUT_CARGO_BUTTON)) {
      Robot.intake.setMotor(0.3);
    } else {
      Robot.intake.stop();
    }
    if (OI.gamepad.getRawButton(OI.OPEN_HATCHCLAMP_BUTTON)) {
      Robot.hatchClamp.clamp(false);
    } else if (OI.gamepad.getRawButton(OI.CLOSE_HATCHCLAMP_BUTTON)) {
      Robot.hatchClamp.clamp(true);
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
