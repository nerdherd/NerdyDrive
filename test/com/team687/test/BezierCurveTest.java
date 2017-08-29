package com.team687.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.team687.frc2017.Constants;
import com.team687.frc2017.utilities.BezierCurve;

/**
 * Bezier curve unit testing
 * 
 * @author tedlin
 *
 */

public class BezierCurveTest {

    private static final double kEpsilon = 1E-9;

    @Test
    public void testBezierInput() {
	BezierCurve bezierCurve = new BezierCurve(0, 0, 0, 100300, 0, 100300, -48000, 100300);
	double[] xVal = { 0, 0, 0, -48000 };
	double[] yVal = { 0, 100300, 100300, 100300 };
	assertArrayEquals(xVal, bezierCurve.getXParam(), 0);
	assertArrayEquals(yVal, bezierCurve.getYParam(), 0);
    }

    @Test
    public void testBezierSize() {
	BezierCurve bezierCurve = new BezierCurve(0, 0, 0, 100300, 0, 100300, -48000, 100300);
	bezierCurve.calculateBezier();
	assertEquals(Constants.kBezierStep + 1, bezierCurve.getXPoints().size(), 1);
	assertEquals(Constants.kBezierStep + 1, bezierCurve.getYPoints().size(), 1);
	assertEquals(Constants.kBezierStep + 1, bezierCurve.getArcLength().size(), 1);
	assertEquals(Constants.kBezierStep + 1, bezierCurve.getHeading().size(), 1);
    }

    @Test
    public void testEndPoints() {
	BezierCurve bezierCurve = new BezierCurve(0, 0, 0, 100300, 0, 100300, -48000, 100300);
	bezierCurve.calculateBezier();
	assertEquals(0, bezierCurve.getXPoints().get(0), kEpsilon);
	assertEquals(0, bezierCurve.getYPoints().get(0), kEpsilon);
	assertEquals(-48000, bezierCurve.getXPoints().get(bezierCurve.getXPoints().size() - 1), kEpsilon);
	assertEquals(100300, bezierCurve.getYPoints().get(bezierCurve.getYPoints().size() - 1), kEpsilon);
    }

    @Test
    public void testDynamicStraightPower() {
	BezierCurve bezierCurve = new BezierCurve(0, 0, 0, 100300, 0, 100300, -48000, 100300);
	bezierCurve.calculateBezier();

	ArrayList<Double> heading = bezierCurve.getHeading();
	int counter = 1;
	double baseStraightPower = 1; // always equal to 1
	for (counter = 1; counter < heading.size(); counter++) {
	    double headingError = Math.abs(heading.get(counter) - heading.get(counter - 1));
	    double rotPower = Constants.kRotPBezier * headingError;
	    double straightPower = baseStraightPower / (headingError * Constants.kStraightPowerAdjuster);

	    double sign = Math.signum(straightPower);
	    if (Math.abs(straightPower) > Constants.kMaxStraightPower) {
		straightPower = Constants.kMaxStraightPower * sign;
	    }

	    double leftPower = straightPower + rotPower;
	    double rightPower = straightPower - rotPower;

	    System.out.println("Counter: " + counter);
	    // System.out.println("Current Heading:" + heading.get(counter));
	    // System.out.println("Last Heading: " + heading.get(counter - 1));
	    // System.out.println("Heading Error: " + headingError);
	    // System.out.println("Rot Power: " + rotPower);
	    System.out.println("Straight Power: " + straightPower);
	    System.out.println("Left Power: " + leftPower);
	    System.out.println("Right Power: " + rightPower);

	    assertTrue(0.0 <= leftPower && leftPower <= 1.0);
	    assertTrue(0.0 <= rightPower && rightPower <= 1.0);
	}
    }

}
