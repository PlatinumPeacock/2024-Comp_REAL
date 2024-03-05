package frc.robot;

public final class Constants {

    public static final class Controller {
        public static final int DRIVE_CONTROLLER = 0;
        public static final int OPERATOR_CONTROLLER = 1;
        public static final int LEFT_X_AXIS = 0;
        public static final int LEFT_Y_AXIS = 1;
        public static final int RIGHT_X_AXIS = 4;
    }

    public static final class Intake {
        //port numbers for intake
        public static final int LEFT_INTAKE = 2; //CHANGE THIS IS NOT ACCURATE
        public static final int RIGHT_INTAKE = 2;
        public static final double INTAKE_SPEED = 1;
        public static final double INTAKE_SPEED_REVERSE = 1;
        public static final int DIRECTION = 1;
        public static final int REVERSE_DIRECTION = -1;
    }

    public static final class Shooter {
        //port numbers for intake
        public static final int UPPER_LEFT_SHOOTER = 2; //CHANGE THIS IS NOT ACCURATE
        public static final int UPPER_RIGHT_SHOOTER = 2;
        public static final int LOWER_LEFT_SHOOTER = 2;
        public static final int LOWER_RIGHT_SHOOTER = 2;
    }



    public static final class LimeLight {
        public static final double AUTO_DRIVE_SPEED = 0.1;
        public static final double AUTO_ROTATE_SPEED = 0.1;
        public static final double DESIRED_TARGET_AREA = 0.9; // area of the target when the robot reaches desired distance

        //VALUES LISTED BELOW ARE NOT REAL VALUES TO USE!!!!
        // how many degrees back is your limelight rotated from perfectly vertical?
        public static final double MOUNT_ANGLE_DEGREES = 25.0; 

        // distance from the center of the Limelight lens to the floor
        public static final double LENS_HEIGHT_INCHES = 20.0; 

        // THESE VALUES ARE CORRECT BELOW :D
        // aprilTag distance from the target to the floor, in inches
        public static final double SPEAKER_HEIGHT = 51.875; 
        public static final double AMP_HEIGHT = 48.125; 
        public static final double STAGE_HEIGHT = 47.5; 
        public static final double SOURCE_HEIGHT = 48.125;
    }



    public static final class Drive {

        //swerve drive constants
        public static final double L = 0.43815; //length between axles // Distance between front and back wheels on robot
        public static final double W = 0.43815; //width between axles // Distance between centers of right and left wheels on robot
        public static final int PIGEON_ID = 2;
        public static final double MAX_VOLTS = 8;   

        // Angular offsets of the modules relative to the chassis in radians
        /* 
        public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
        public static final double kFrontRightChassisAngularOffset = 0;
        public static final double kBackLeftChassisAngularOffset = Math.PI;
        public static final double kBackRightChassisAngularOffset = Math.PI / 2;
        */

        //motor and encoder ports
        public static final int FRONT_LEFT_DRIVE = 10;
        public static final int REAR_LEFT_DRIVE = 15;
        public static final int FRONT_RIGHT_DRIVE = 13;
        public static final int REAR_RIGHT_DRIVE = 14;
    
        public static final int FRONT_LEFT_TURNING = 11;
        public static final int REAR_LEFT_TURNING = 17;
        public static final int FRONT_RIGHT_TURNING = 12;
        public static final int REAR_RIGHT_TURNING = 16;
    
        public static final int FRONT_LEFT_ENCODER = 5;
        public static final int REAR_LEFT_ENCODER = 4;
        public static final int FRONT_RIGHT_ENCODER = 3;
        public static final int REAR_RIGHT_ENCODER = 6;

        public static final int PIGEON2 = 2;
    
        public static final double kFrontLeftAngleZero = 349.45;
        public static final double kRearLeftAngleZero = 0;
        public static final double kFrontRightAngleZero = 75.32;
        public static final double kRearRightAngleZero = 270;

        //auton driving
        public static final double AUTON_SPEED = 0.3;
        public static final double TIME = 4; //time robot drives forward in auton
    
      }
      
}
