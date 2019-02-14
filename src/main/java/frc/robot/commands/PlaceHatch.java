package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceHatch extends CommandGroup {

  public PlaceHatch() {
    addSequential(new SetHatchClamp(false));
    addSequential(new AdjustLift(-2));
    addSequential(new SetHatchClamp(true));
  }
}
