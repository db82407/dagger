package coffee2;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import dagger.producers.ProducerModule;
import dagger.producers.Produces;

@ProducerModule
class PumpModule {
    @Produces
    ListenableFuture<Pump> producePump(Thermosiphon pump) {
        System.out.println("@Producing Pump..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("done @Producing Pump");
        return Futures.immediateFuture((Pump)pump);
    }
}