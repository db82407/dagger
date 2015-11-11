package coffee3;

import dagger.Component;
import javax.inject.Singleton;

public class ExpensiveCoffeeApp {
  @Singleton
  @Component(modules = { ExpensiveCoffeeModule.class })
  public interface Coffee {
    ExpensiveCoffeeMaker maker();
  }

  public static void main(String[] args) {
    Coffee coffee = DaggerExpensiveCoffeeApp_Coffee.builder().build();
    coffee.maker().brew();
  }
}
