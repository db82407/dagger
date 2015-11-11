package coffee2;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = PumpModule.class)
class DripCoffeeModule {
	@Provides
	@Singleton
	@Named("water")
	Heater provideHeater() {
		return new ElectricHeater();
	}
}
