package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import frclib.sensors.ADIS16448;
import frclib.vision.Camera;

public class RobotMap {

    // vex encoder 360 counts per revolution

    // scaling variables
    public static double liftEncoderScale = ((96 / 33.6) * (1.3 * Math.PI)) / 360;
    public static double crabEncoderScale = 1;
    public static double climbEncoderScale = 1;

    // heights of game locations to the nearest inch in inches

    // HAB
    public static final int HAB_LEVEL3 = 19; // climb height for level 3 hab platform
    public static final int HAB_LEVEL2 = 6; // climb height for level 2 hab platform
    // Cargoship
    public static final int CARGOSHIP_HATCH = 19;// lift height of hatch placement on cargoship
    public static final int CARGOSHIP_CARGO = 40;// lift height of cargo drop on cargoship
    // Rocket
    public static final int ROCKET_LEVEL1_HATCH = 19; // lift height of level 1 hatch placement on rocket
    public static final int ROCKET_LEVEL2_HATCH = 47; // lift height of level 2 hatch placement on rocket
    public static final int ROCKET_LEVEL3_HATCH = 75; // lift height of level 3 hatch placement on rocket
    public static final int ROCKET_LEVEL1_CARGO = 28; // lift height of level 1 cargo drop on rocket
    public static final int ROCKET_LEVEL2_CARGO = 56; // lift height of level 2 cargo drop on rocket
    public static final int ROCKET_LEVEL3_CARGO = 84; // lift height of level 3 cargo drop on rocket
    // Loading Station
    public static final int LOADING_CARGO = 43; // lift height to take cargo from loading station
    public static final int LOADING_HATCH = 19; // lift height to take hatch from loading station

    // PID On Target Identifiers
    public static boolean liftOnTarget = false;
    public static boolean crabOnTarget = false;

    // Adjustments
    public static double liftAdjustment = 0;

    // Global lift height
    public static int liftTargetHeight = 0;

    // Sensors
    public static Camera view;
    public static Camera linefinder;
    public static ADIS16448 imu = new ADIS16448();
    public static DigitalInput cargoDetestionSwitch = new DigitalInput(0);
}
