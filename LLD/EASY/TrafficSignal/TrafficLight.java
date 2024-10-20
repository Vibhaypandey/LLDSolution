package LLD.EASY.TrafficSignal;

public class TrafficLight {


    private String id;

    private Signal currentsignal;

    private int redduration;
    private int yellowduration;
    private int greenduration;

    public TrafficLight(String id, int redduration,int yellowduration ,int greenduration) {
        this.id = id;
        this.currentsignal = Signal.RED;
        this.redduration = redduration;
        this.yellowduration = yellowduration;
        this.greenduration = greenduration;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Signal getSignal() {
        return currentsignal;
    }

    public void setSignal(Signal signal) {
        this.currentsignal = signal;
    }

    public int getRedduration() {
        return redduration;
    }

    public void setRedduration(int redduration) {
        this.redduration = redduration;
    }

    public int getYellowduration() {
        return yellowduration;
    }

    public void setYellowduration(int yellowduration) {
        this.yellowduration = yellowduration;
    }

    public int getGreenduration() {
        return greenduration;
    }

    public void setGreenduration(int greenduration) {
        this.greenduration = greenduration;
    }


    public void changeSignal(Signal newSignal){
        this.currentsignal = newSignal;
        notifyObserver();
    }

    private void notifyObserver() {
    }
}

