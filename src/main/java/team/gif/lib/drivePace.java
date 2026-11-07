package team.gif.lib;

import team.gif.robot.Robot;

public enum drivePace {;

    private final double value;
    private final boolean isFieldRelative;

    drivePace(double value, boolean isFieldRelative) {
        this.value = value;
        this.isFieldRelative = isFieldRelative;
    }

    public double getValue() {
        return this.value;
    }
    public boolean getIsFieldRelative() {
        return this.isFieldRelative;
    }
}
