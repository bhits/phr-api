package gov.samhsa.mhc.phr.aspect;

/**
 * Created by sadhana.chandra on 12/24/2015.
 */
public class CallTracker {

    private boolean called;

    public boolean isCalled() {
        return called;
    }

    public void setCalled(boolean called) {
        this.called = called;
    }

    public void resetCalled(){
        called = false;
    }
    public void trackCall(){
        called = true;
    }
}
