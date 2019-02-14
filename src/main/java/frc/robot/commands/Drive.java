package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Drive extends Command {

  public Drive() {
    requires(Robot.driveSystem);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Drive");
    Robot.driveSystem.shiftGear(false);
  }

  @Override
  protected void execute() {
    if (OI.joystick.getRawButton(OI.SHIFT_DRIVE_BUTTON)) {
      Robot.driveSystem.shiftGear(true);
    } else {
      Robot.driveSystem.shiftGear(false);
    }
    double x = OI.joystick.getRawAxis(OI.X_AXIS);
    double y = OI.joystick.getRawAxis(OI.Y_AXIS);
    if (Math.abs(x) > 0.1 || Math.abs(y) > 0.1) {
      Robot.driveSystem.arcadeDrive(y, x);
    } else {
      Robot.driveSystem.stop();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveSystem.shiftGear(false);
    Robot.driveSystem.stop();
    System.out.println("-! Drive");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
