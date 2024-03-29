package frc.robot;

import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.WheelDrive;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Arm;
import frc.robot.commands.DriveWithJoysticksTrial;
import frc.robot.commands.IntakeNote;
import frc.robot.commands.Shoot;
import frc.robot.commands.Feed;
import frc.robot.commands.Climb;


public class RobotContainer {
    
    //xbox controllers
    public static XboxController driverController = new XboxController(Constants.Controller.DRIVE_CONTROLLER);
    public static CommandXboxController operatorController = new CommandXboxController(Constants.Controller.OPERATOR_CONTROLLER);

    //create each wheel 
    public static final WheelDrive backRight = new WheelDrive (Constants.Drive.REAR_RIGHT_TURNING, Constants.Drive.REAR_RIGHT_DRIVE, Constants.Drive.REAR_RIGHT_ENCODER, Constants.Drive.kRearRightAngleZero);
    public static final WheelDrive backLeft = new WheelDrive (Constants.Drive.REAR_LEFT_TURNING, Constants.Drive.REAR_LEFT_DRIVE, Constants.Drive.REAR_LEFT_ENCODER, Constants.Drive.kRearLeftAngleZero);
    public static final WheelDrive frontRight = new WheelDrive (Constants.Drive.FRONT_RIGHT_TURNING, Constants.Drive.FRONT_RIGHT_DRIVE, Constants.Drive.FRONT_RIGHT_ENCODER, Constants.Drive.kFrontRightAngleZero);
    public static final WheelDrive frontLeft = new WheelDrive (Constants.Drive.FRONT_LEFT_TURNING, Constants.Drive.FRONT_LEFT_DRIVE, Constants.Drive.FRONT_LEFT_ENCODER, Constants.Drive.kFrontLeftAngleZero);

    public static final WPI_Pigeon2 pigeon2 = new WPI_Pigeon2(Constants.Drive.PIGEON2);

    //create LimeLight
    public static final LimeLight limeLight = new LimeLight();
    
    //create swerve drive
    public static final SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft, pigeon2, limeLight);

    //create all subsystem objects
    private final Intake intake;
    private final Feeder feeder;
    private final Shooter shooter;
    private final Arm arm;


    //create all repeatCommands (because the whileHeld() method no longer exists)
    private final RepeatCommand intakeNote;
    private final RepeatCommand intakeReverse;
    private final RepeatCommand feed;
    private final RepeatCommand feedReverse;
    private final RepeatCommand shoot;
    private final RepeatCommand shootReverse;
    private final RepeatCommand climb;
    private final RepeatCommand climbReverse;

    

    SendableChooser<Command> chooser = new SendableChooser<>();
    
    public RobotContainer() {

        

        //new drive object and teleop drive command
        DriveWithJoysticksTrial dtt = new DriveWithJoysticksTrial(swerveDrive);
        swerveDrive.setDefaultCommand(dtt);

        

        //new intake object and all intake commands
        intake = new Intake();
        intakeNote = new RepeatCommand(new IntakeNote(intake, Constants.Intake.SPEED, Constants.Intake.DIRECTION));
        intakeNote.addRequirements(intake);
        intakeReverse = new RepeatCommand(new IntakeNote(intake, Constants.Intake.SPEED_REVERSE, Constants.Intake.REVERSE_DIRECTION));
        intakeReverse.addRequirements(intake);

        //new feeder object and all feeder commands
        feeder = new Feeder();
        feed = new RepeatCommand(new Feed(feeder, Constants.Feeder.SPEED, Constants.Feeder.DIRECTION));
        feed.addRequirements(feeder);
        feedReverse = new RepeatCommand(new Feed(feeder, Constants.Feeder.SPEED_REVERSE, Constants.Feeder.REVERSE_DIRECTION));
        feedReverse.addRequirements(feeder);

        //new shooter object and all shoot commands
        shooter = new Shooter();
        shoot = new RepeatCommand(new Shoot(shooter, Constants.Shooter.SPEED, Constants.Feeder.DIRECTION));
        shoot.addRequirements(shooter);
        shootReverse = new RepeatCommand(new Shoot(shooter, Constants.Shooter.SPEED_REVERSE, Constants.Feeder.REVERSE_DIRECTION));
        shootReverse.addRequirements(shooter);

        //new arm object and all climb commands
        arm = new Arm();
        climb = new RepeatCommand(new Climb(arm, Constants.Arm.SPEED, Constants.Arm.DIRECTION));
        climb.addRequirements(arm);
        climbReverse = new RepeatCommand(new Climb(arm, Constants.Arm.SPEED_REVERSE, Constants.Arm.REVERSE_DIRECTION));
        climbReverse.addRequirements(arm);

 
        //Add choice to smart dashboard
        SmartDashboard.putData("Autonomous", chooser);


        configureButtonBindings();
    }

    private void configureButtonBindings() { 


        //intake buttons
        Trigger intakeButton = operatorController.b();
        intakeButton.whileTrue(intakeNote);

        Trigger intakeReverseButton = operatorController.y();
        intakeReverseButton.whileTrue(intakeReverse);

        //feeder buttons
        Trigger feederButton = operatorController.a();
        feederButton.whileTrue(feed);

        Trigger feedReverseButton = operatorController.x();
        feedReverseButton.whileTrue(feedReverse);

        //shooter buttons
        Trigger shootButton = operatorController.rightBumper();
        shootButton.whileTrue(shoot);

        Trigger shootReverseButton = operatorController.leftBumper();
        shootReverseButton.whileTrue(shootReverse);

        //climb buttons
        Trigger climbButton = operatorController.povUp();
        climbButton.whileTrue(climb);

        Trigger climbReverseButton = operatorController.povDown();
        climbReverseButton.whileTrue(climbReverse);

    }

    public void teleopInitFunc() {

    }    

    public Command getAutonomousCommand() {
      //An ExampleCommand will run in autonomous
      return chooser.getSelected();
    }
}