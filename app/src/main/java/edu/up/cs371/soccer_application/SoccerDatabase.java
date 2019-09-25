package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB
{
    private Hashtable<String, SoccerPlayer> the_database = new Hashtable<>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
	public boolean addPlayer(String firstName, String lastName, int uniformNumber, String teamName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            Log.d("SoccerDatabase.java:34", "ERROR: PLAYER ALREADY EXISTS");
            return false;
        }

        SoccerPlayer sp = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
        the_database.put(fullName, sp);
        return true;
	}

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.remove(fullName);
            Log.d("SoccerDatabase.java:54", "PLAYER REMOVED");
            return true;
        }

        Log.d("SoccerDatabase.java:59", "ERROR: PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            Log.d("SoccerDatabase.java:65", "PLAYER EXISTS");
            return the_database.get(fullName);
        }
        Log.d("SoccerDatabase.java:68", "PLAYER DOES NOT EXIST");
        return null;
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpGoals();
            Log.d("SoccerDatabase.java:93", "GOALS++");
            return true;
        }

        Log.d("SoccerDatabase.java:97", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpAssists();
            Log.d("SoccerDatabase.java:113", "ASSISTS++");
            return true;
        }

        Log.d("SoccerDatabase.java:117", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpShots();
            Log.d("SoccerDatabase.java:133", "SHOTS++");
            return true;
        }

        Log.d("SoccerDatabase.java:137", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpSaves();
            Log.d("SoccerDatabase.java:153", "SAVES++");
            return true;
        }

        Log.d("SoccerDatabase.java:157", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpFouls();
            Log.d("SoccerDatabase.java:173", "FOULS++");
            return true;
        }

        Log.d("SoccerDatabase.java:177", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpYellowCards();
            Log.d("SoccerDatabase.java:193", "YELLOW CARDS++");
            return true;
        }

        Log.d("SoccerDatabase.java:197", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName)
    {
        String fullName = SoccerPlayer.createFullName(firstName, lastName);
        if(the_database.containsKey(fullName))
        {
            the_database.get(fullName).bumpRedCards();
            Log.d("SoccerDatabase.java:213", "RED CARDS++");
            return true;
        }

        Log.d("SoccerDatabase.java:217", "PLAYER DOES NOT EXIST");
        return false;
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName)
    {
        return -1;
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName)
    {
        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file)
    {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file)
    {
        return false;
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s)
    {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams()
    {
        return new HashSet<String>();
	}

}
