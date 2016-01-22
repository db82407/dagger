package coffee2;

import dagger.producers.ProductionComponent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import com.google.common.util.concurrent.ListenableFuture;

public class CoffeeApp {
  @Singleton
  @ProductionComponent(modules = { AsyncCoffeeModule.class, DripCoffeeModule.class, PumpModule.class })
  public interface Coffee {
      ListenableFuture<CoffeeMaker> maker();
  }

  public static void main(String[] args) throws Exception {
      ExecutorService es = Executors.newFixedThreadPool(3);

      Coffee coffee = DaggerCoffeeApp_Coffee.builder()
              .executor(es).build();

      CoffeeMaker maker = coffee.maker().get();
      maker.brew();

      es.shutdownNow();
  }
}
