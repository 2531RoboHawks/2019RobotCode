package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

public class HatchClamp extends Subsystem {

  private Solenoid open = new Solenoid(2);
  private Solenoid close = new Solenoid(3);

  @Override
  public void initDefaultCommand() {

  }

  public void clamp(boolean closed) {
    close.set(closed);
    open.set(!closed);
  }

  public boolean isClosed() {
    return close.get();
  }
}
