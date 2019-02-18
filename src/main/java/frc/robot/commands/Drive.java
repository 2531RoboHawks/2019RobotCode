package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Drive extends Command {

  private boolean lastgear;

  public Drive() {
    requires(Robot.driveSystem);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Drive");
    Robot.driveSystem.shiftGear(false);
    lastgear = Robot.driveSystem.isHighGear();
  }

  @Override
  protected void execute() {
    if (OI.joystick_right.getRawButton(OI.SHIFT_DRIVE_BUTTON)) {
      Robot.driveSystem.shiftGear(true);
      if (lastgear != true) {
        System.out.println("high gear");
        lastgear = true;
      }
    } else {
      Robot.driveSystem.shiftGear(false);
      if (lastgear != false) {
        System.out.println("low gear");
        lastgear = false;
      }
    }
    double r = OI.joystick_right.getRawAxis(OI.Y_AXIS);
    double l = OI.joystick_left.getRawAxis(OI.Y_AXIS);
    if (Math.abs(r) > 0.2 || Math.abs(l) > 0.2) {
      Robot.driveSystem.tankDrive(l, r);
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
