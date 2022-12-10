package frc.robot.subsystems

import com.revrobotics.CANSparkMax
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.SubsystemBase

class DrivetrainSubsystem(
    val leftMotor: CANSparkMax,
    val rightMotor: CANSparkMax,
    val controller: XboxController
) : SubsystemBase() {
  val leftEncoder = leftMotor.encoder
  val rightEncoder = rightMotor.encoder

  init {
    resetEncoders()
    //leftMotor.inverted = true
  }

  override fun periodic() {}
  fun resetEncoders() {
    leftEncoder.position = 0.0
    rightEncoder.position = 0.0
  }
  fun tankDrive(left: Double, right: Double) {
    leftMotor.set(left)
    print("left: $left \n right: $right")
    rightMotor.set(-right)
  }
  fun setVoltage(left: Double, right: Double) {
    leftMotor.setVoltage(left)
    rightMotor.setVoltage(right)
  }
}
