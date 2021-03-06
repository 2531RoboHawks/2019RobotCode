package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class CameraGimbalDefault extends Command {
  public CameraGimbalDefault() {
    requires(Robot.cameraGimbal);
  }

  @Override
  protected void initialize() {
    System.out.println("-> Camera Gimbal");
  }

  @Override
  protected void execute() {
    double a = OI.joystick_right.getRawAxis(OI.AUX_AXIS);
    Robot.cameraGimbal.set(a);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.cameraGimbal.reset();
    System.out.println("-! Camera Gimbal");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
