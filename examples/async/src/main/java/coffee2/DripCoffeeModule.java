package coffee2;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
class DripCoffeeModule {
  @Provides @Singleton Heater provideHeater() {
	System.out.println("@Provide Heater");
    return new ElectricHeater();
  }
}
