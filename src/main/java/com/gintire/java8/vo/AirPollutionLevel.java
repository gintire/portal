package com.gintire.java8.vo;

public class AirPollutionLevel implements java.io.Serializable {
    private static final long serialVersionUID = -8176160795706313070L;
    /**
     * @serial  The non-localized name of the level.
     */
    private final String name;

    /**
     * @serial  The integer value of the level.
     */
    private final int value;

    public AirPollutionLevel(String name, int value) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.value = value;
    }


    /**
     * Hazardous - almost die
     * Very Unhealthy
     * Unhealthy
     * Unhealthy for sensitive group
     * moderate
     * goooooooood
     * Maximum Integer is initialized
     */
    public static final AirPollutionLevel Hazardous = new AirPollutionLevel("Hazardous",Integer.MAX_VALUE);
    public static final AirPollutionLevel Very_unhealthy = new AirPollutionLevel("Very_unhealthy", 300);
    public static final AirPollutionLevel Unhealthy = new AirPollutionLevel("Unhealthy", 200);
    public static final AirPollutionLevel Unhealthy_for_sesitive = new AirPollutionLevel("Unhealthy_for_sesitive",150);
    public static final AirPollutionLevel Moderate = new AirPollutionLevel("Moderate",100);
    public static final AirPollutionLevel Good = new AirPollutionLevel("Good",0);

    /**
     * Get the integer value for this level.  This integer value
     * can be used for efficient ordering comparisons between
     * Level objects.
     * @return the integer value for this level.
     */
    public final int intValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
}