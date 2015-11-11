package coffee3;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = PumpModule.class)
class ExpensiveCoffeeModule {
	@Provides
	@Singleton
	@Named("hot plate")
	Heater provideHotplateHeater() {
		return new ElectricHeater("hot plate");
	}

	@Provides
	@Singleton
	@Named("water")
	Heater provideWaterHeater() {
		return new ElectricHeater("water");
	}
}
