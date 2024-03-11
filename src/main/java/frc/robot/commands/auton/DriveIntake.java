package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.Intake;

public class DriveIntake extends Command{
    SwerveDrive driveTrain;
    Intake intake;
    double time;
    private boolean finish = false;
    Timer timer;

    /** Creates a new DriveIntake. */
    public DriveIntake(SwerveDrive dt, Intake i, double t) {
    driveTrain = dt;
    intake = i;
    addRequirements(driveTrain);
    addRequirements(intake);
    time = t;
    timer = new Timer();
    }

  // Called when the command is initially scheduled.
  //"Some things are ugly, not me, you." - Meta 3-23-23
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < time)
    {
        intake.intake(Constants.Intake.AUTON_SPEED, Constants.Intake.DIRECTION);
        driveTrain.driveForward(Constants.Drive.AUTON_SPEED_INTAKE);
    }
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
    intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
