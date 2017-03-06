package interviewpre.linmp4.com.interviewpre.Event.Otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class BusProvider {

    private static final Bus BUS = new Bus(ThreadEnforcer.MAIN);
    private static final Bus BUS2 = new Bus(ThreadEnforcer.ANY);

    private BusProvider() {

    }

    public static Bus getInstance() {
        return BUS;
    }

    public static Bus getInstance2() {
        return BUS2;
    }
}
