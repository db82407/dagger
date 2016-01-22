package coffee2;

import dagger.Lazy;
import javax.inject.Inject;

class CoffeeMaker {
  private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.
  private final Pump pump;
  private final Grinder grinder;

  @Inject CoffeeMaker(Lazy<Heater> heater, Pump pump, Grinder grinder) {
    this.heater = heater;
    this.pump = pump;
    this.grinder = grinder;
  }

  public void brew() {
	grinder.grind();
    heater.get().on();
    pump.pump();
    System.out.println(" [_]P coffee! [_]P ");
    heater.get().off();
  }
}
