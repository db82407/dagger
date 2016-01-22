package coffee2;

import javax.inject.Singleton;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import dagger.Lazy;
import dagger.producers.ProducerModule;
import dagger.producers.Produces;

@ProducerModule
class AsyncCoffeeModule {
    @Produces
    @Singleton
    ListenableFuture<CoffeeMaker> produceMaker(Lazy<Heater> heater, Pump pump, Grinder grinder) {
        System.out.println("@Producing CoffeeMaker..");
        return Futures.immediateFuture(new CoffeeMaker(heater, pump, grinder));
    }
    
    @Produces
    ListenableFuture<Grinder> produceGrinder() {
        System.out.println("@Producing Grinder..");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("done @Producing Grinder");
        return Futures.immediateFuture((Grinder) new ElectricGrinder());
    }
}
