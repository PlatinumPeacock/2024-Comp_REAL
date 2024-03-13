package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

public class WheelDrive {
    private TalonFX angleMotor;
    private TalonFX speedMotor;
    private CANCoder encoder;
    private PIDController pidController;
    private double offSet;
    

    public WheelDrive(int aM, int sM, int encoder, double oS) {
        angleMotor = new TalonFX(aM);
        speedMotor = new TalonFX(sM);
        this.encoder = new CANCoder(encoder);
        offSet = oS;
        
        
        pidController = new PIDController (0.005, 0, 0);
        pidController.enableContinuousInput(-180, 180);
        pidController.setTolerance(1);

    }


    public void drive(double speed, double angle) {
        
        speedMotor.setControl(new DutyCycleOut(speed));
         
        
        double setpoint = angle;
        pidController.setSetpoint (setpoint);
        double cmd = -1 * pidController.calculate(encoder.getAbsolutePosition() + offSet, setpoint);
        
       
        angleMotor.setControl(new DutyCycleOut(MathUtil.clamp(cmd, -1, 1)));
    
        
    }

}
