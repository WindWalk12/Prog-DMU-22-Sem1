package Exercise1;

import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan plan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Return the training plan
     */
    public TrainingPlan getPlan() {
        return plan;
    }

    /**
     * Register training plan
     * @param plan
     */
    public void setPlan(TrainingPlan plan) {
        if (this.plan != plan) {
            this.plan = plan;
        }
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time: lapTimes) {
        	if(best > time) {
        		best = time;
        	}
        }
        return best;
    }

    /**
     * Return how many training hours the swimmer has each week
     */
    public int allTrainingHours () {
        if (plan == null) {
            return 0;
        }
        return plan.getWeeklyWaterHours() + plan.getWeeklyStrengthHours();
    }

    /**
     * Return true if the swimmer has a plan or false if not
     * @return true or false
     */
    public boolean hasPlan() {
        return plan != null;
    }
}
