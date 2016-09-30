package gov.samhsa.c2s.phr.aspect;

public class CallTracker {

    private boolean called;

    public boolean isCalled() {
        return called;
    }

    public void setCalled(boolean called) {
        this.called = called;
    }

    public void resetCalled() {
        called = false;
    }

    public void trackCall() {
        called = true;
    }
}
