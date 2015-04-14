/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.mwm.twitter.client;

/**
 *
 * @author fperez
 */
public class TwitterConfiguracion {
    private static TwitterConfiguracion instance = null;
    private long delay_mmsec = 500;
    private long period_mmsec = 100000;
    private int num_tweets = 20;

    /**
     * @return the instance
     */
    public static TwitterConfiguracion getInstance() {
        if(instance == null){
            return new TwitterConfiguracion();
        }
        return instance;
    }

    /**
     * @return the delay_mmsec
     */
    public long getDelay_mmsec() {
        return delay_mmsec;
    }

    /**
     * @param aDelay_mmsec the delay_mmsec to set
     */
    public void setDelay_mmsec(long aDelay_mmsec) {
        delay_mmsec = aDelay_mmsec;
    }

    /**
     * @return the period_mmsec
     */
    public long getPeriod_mmsec() {
        return period_mmsec;
    }

    /**
     * @param aPeriod_mmsec the period_mmsec to set
     */
    public void setPeriod_mmsec(long aPeriod_mmsec) {
        period_mmsec = aPeriod_mmsec;
    }
    
    protected TwitterConfiguracion(){
    }

    /**
     * @return the num_tweets
     */
    public int getNum_tweets() {
        return num_tweets;
    }

    /**
     * @param num_tweets the num_tweets to set
     */
    public void setNum_tweets(int num_tweets) {
        this.num_tweets = num_tweets;
    }
    
    public String toString(){
        String msg;
        msg = "Numero Tweets: " + this.getNum_tweets() + "\n";
        msg += "Timer.Period: " + this.getPeriod_mmsec() + "\n";
        msg += "Timer.Delay: " + this.getDelay_mmsec() + "\n";
        return msg;
    }
    
}
