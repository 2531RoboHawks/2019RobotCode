package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.CameraGimbalDefault;

public class CameraGimbal extends Subsystem {

  private Servo servo = new Servo(0);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CameraGimbalDefault());

  }

  public void set(double d) {
    servo.set(d);
  }

  public void reset() {
    set(0);
  }
}
