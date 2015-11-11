package coffee2;

import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Named;

class CoffeeMaker {
	private final Lazy<Heater> heater; // Create a possibly costly heater only when we use it.
	private final Pump pump;

	@Inject
	CoffeeMaker(//
			@Named("water")
			Lazy<Heater> heater, //
			Pump pump) {
		this.heater = heater;
		this.pump = pump;
	}

	public void brew() {
		heater.get().on();
		pump.pump();
		System.out.println(" [_]P coffee2! [_]P ");
		heater.get().off();
	}
}
