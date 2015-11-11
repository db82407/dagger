package coffee2;

import dagger.Component;
import javax.inject.Singleton;

import coffee2.DaggerCoffeeApp_Coffee;

public class CoffeeApp {
  @Singleton
  @Component(modules = { DripCoffeeModule.class })
  public interface Coffee {
    CoffeeMaker maker();
  }

  public static void main(String[] args) {
    Coffee coffee = DaggerCoffeeApp_Coffee.builder().build();
    coffee.maker().brew();
  }
}
