// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;


public class Climber extends SubsystemBase {
    
    //attributes
    //motor controller
     private WPI_TalonFX climberMotor = new WPI_TalonFX(CLIMBER);
    
    
    //constructor
    //runs the methods written below
    public Climber(){
        
    }



    //methods
    public void climbStop(){
        climberMotor.set(ControlMode.PercentOutput, 0);
    }

    public void climbExtend(XboxController xbox){
        while(xbox.getRightBumper()){
            climberMotor.set(ControlMode.PercentOutput, 0.5);
        }  
        climbStop();
    }

    public void climbRetract(XboxController xbox){
        while(xbox.getLeftBumper()){
            climberMotor.set(ControlMode.PercentOutput, -0.5);
        }
        climbStop();
    }


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}

