package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabHatch extends CommandGroup {

  public GrabHatch() {
    addSequential(new SetHatchClamp(false));
    addSequential(new AdjustLift(2));
    addSequential(new SetHatchClamp(true));
  }
}
