package coffee3;

import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Named;

// uses field injection, rather than constructor injection
class ExpensiveCoffeeMaker {
	@Inject
	@Named("water")
	Lazy<Heater> waterHeater;

	@Inject
	@Named("hot plate")
	Lazy<Heater> hotplateHeater;

	@Inject
	Pump pump;

	@Inject
	ExpensiveCoffeeMaker() {
	}

	public void brew() {
		waterHeater.get().on();
		hotplateHeater.get().on();
		pump.pump();
		System.out.println(" [_]P coffee3! [_]P ");
		waterHeater.get().off();
	}
}
