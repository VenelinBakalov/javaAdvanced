package trafficLights;

/**
 * Created by Venelin on 24.3.2017 г..
 */
public class TrafficLight {

    private Signal signal;

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public String update() {

        int currentOrdinal = this.signal.ordinal();
        Signal[] signals = Signal.values();
        this.signal = signals[(currentOrdinal + 1) % 3];
        return signal.name();

//  if (currentOrdinal == Signal.values().length - 1) {
//      this.signal = Signal.RED;
//      return this.signal.name();
//  }
//  for (Signal tempSignal : Signal.values()) {
//      if (tempSignal.ordinal() == currentOrdinal + 1) {
//          this.signal = tempSignal;
//          return tempSignal.name();
//      }
//  }
//  return null;
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
