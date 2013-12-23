/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemode;

/**
 *
 * @author Cuper
 */
public class GameModeSetting {

    public static int currentGameModeID = 1;
    public static final String GM_STANDARD_IDENTIFIER = "Standard";
    public static final int GM_STANDARD_SNAKELENGTH = 3;
    public static final int GM_STANDARD_HORIZONTALTILE = 45;
    public static final int GM_STANDARD_VERTICALTILE = 35;
    public static final int GM_STANDARD_FOODLIMIT = 10;
    public static final int GM_STANDARD_ID = 1;
    public static final String GM_FOODMANIA_IDENTIFIER = "FoodMania";
    public static final int GM_FOODMANIA_SNAKELENGTH = 3;
    public static final int GM_FOODMANIA_HORIZONTALTILE = 45;
    public static final int GM_FOODMANIA_VERTICALTILE = 35;
    public static final int GM_FOODMANIA_FOODLIMIT = 200;
    public static final int GM_FOODMANIA_ID = 2;
    public static final String GM_HARDCORE_IDENTIFIER = "HardCore";
    public static final int GM_HARDCORE_SNAKELENGTH = 10;
    public static final int GM_HARDCORE_HORIZONTALTILE = 20;
    public static final int GM_HARDCORE_VERTICALTILE = 10;
    public static final int GM_HARDCORE_FOODLIMIT = 20;
    public static final int GM_HARDCORE_ID = 3;
    public static final String[] IDENTIFIER = {"Custom", GM_STANDARD_IDENTIFIER, GM_FOODMANIA_IDENTIFIER, GM_HARDCORE_IDENTIFIER};
}
