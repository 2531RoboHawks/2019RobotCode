package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetHatchClamp extends Command {

  private boolean state;
  private boolean done;

  public SetHatchClamp(boolean closed) {
    requires(Robot.intake);
    state = closed;
  }

  @Override
  protected void initialize() {
    System.out.println("-> Set Hatch Clamp");
    done = false;
  }

  @Override
  protected void execute() {
    Robot.hatchClamp.clamp(state);
    done = true;
  }

  @Override
  protected boolean isFinished() {
    return done;
  }

  @Override
  protected void end() {
    System.out.println("-! Set Hatch Clamp");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
