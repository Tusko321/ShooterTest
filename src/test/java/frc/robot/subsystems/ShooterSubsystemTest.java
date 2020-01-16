package frc.robot.subsystems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.lang.management.ManagementFactory;

import com.revrobotics.CANSparkMax;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ShooterSubsystemTest
 */
public class ShooterSubsystemTest {
    ShooterSubsystem shooter;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void init() {
        shooter = new ShooterSubsystem(mock(CANSparkMax.class), mock(CANSparkMax.class), mock(CANSparkMax.class), mock(CANSparkMax.class));
    }

    @Test
    public void testGetRPM() {
        assertEquals(5098, this.shooter.getRPM(0.85), 0.001);
        assertEquals(2907, this.shooter.getRPM(0.5), 0.001);
        assertEquals(2281, this.shooter.getRPM(0.4), 0.001);
        assertEquals(1655, this.shooter.getRPM(0.3), 0.001);
        assertEquals(1029, this.shooter.getRPM(0.2), 0.001);
        assertEquals(903.8, this.shooter.getRPM(0.18), 0.001);

        System.out.println("0.8: " + this.shooter.getRPM(0.8));
        System.out.println("0.75: " + this.shooter.getRPM(0.75));
        System.out.println("0.7: " + this.shooter.getRPM(0.7));
        System.out.println("0.65: " + this.shooter.getRPM(0.65));
        System.out.println("0.6: " + this.shooter.getRPM(0.6));
    }

    @Test
    public void testGetSetPoint() {
        assertEquals(0.85, this.shooter.getSetPoint(5098), 0.001);
        assertEquals(0.5, this.shooter.getSetPoint(2907), 0.001);
        assertEquals(0.4, this.shooter.getSetPoint(2281), 0.001);
        assertEquals(0.3, this.shooter.getSetPoint(1655), 0.001);
        assertEquals(0.2, this.shooter.getSetPoint(1029), 0.001);
        assertEquals(0.18, this.shooter.getSetPoint(903.8), 0.001);

        System.out.println("5098: " + this.shooter.getSetPoint(5098));
        System.out.println("2907: " + this.shooter.getSetPoint(2907));
        System.out.println("2281: " + this.shooter.getSetPoint(2281));
        System.out.println("1655: " + this.shooter.getSetPoint(1655));
        System.out.println("1029: " + this.shooter.getSetPoint(1029));
        System.out.println("903.8: " + this.shooter.getSetPoint(903.8));
    }

    @Test
    public void testRPMExceptions() {
        this.expected.expect(NumberFormatException.class);
        this.expected.expectMessage("Speed should not be less than zero");
        this.shooter.getRPM(-1);
        this.shooter.getRPM(-0.003);
    }

    @Test
    public void testSetPointExceptions() {
        this.expected.expect(NumberFormatException.class);
        this.expected.expectMessage("RPM should not be less than zero");
        this.shooter.getSetPoint(-2000);
        this.shooter.getSetPoint(-6000);
    }   
}