# example-async

This example is modified from the 'simple' coffee example.

It attempts to show how Dagger can instantiate components in parallel using the annotations in the dagger.producers package.


The changes made to the simple coffee example are:

 * CoffeeApp is now annotated with @ProductionComponent and has to supply an Executor to the Builder.
	
 * AsyncCoffeeModule is an @ProducerModule which produces the CoffeeMaker and Grinder
 
 * CoffeeMaker now uses a Grinder (so we can construct the Pump and Grinder in parallel)
 
 * PumpModule is now an @ProducerModule
 
 * println has been added so we can easily follow the injections
 
 
Running CoffeeApp.main produces the following output:

	@Provide Heater
	@Inject Thermosiphon
	@Producing Pump..
	@Producing Grinder..
	done @Producing Grinder
	done @Producing Pump
	@Producing CoffeeMaker..
	~ ~ ~ grinding ~ ~ ~
	~ ~ ~ heating ~ ~ ~
	=> => pumping => =>
	 [_]P coffee! [_]P 
 
 This shows that
 
 * The Heater is created first as it's needed for the Thermosiphon constructor.
 
 * The Pump and Grinder are then created in parallel.
 
 * The CoffeeMaker is not produced until the Pump and Grinder are available.
 
 If you reduce the size of the thread pool executor to 1, then you will see that the Pump and Grinder are not created in parallel.
 
## Snags

Running against 2.1-SNAPSHOT on 2016-01-22
 
 * mvn clean compile fails:
 
	coffee2/AsyncCoffeeModule_ProduceMakerFactory.java:[60,19] cannot find symbol
	symbol:   method transformAsync(com.google.common.util.concurrent.ListenableFuture<java.util.List<java.lang.Object>>,<anonymous com.google.common.util.concurrent.AsyncFunction<java.util.List<java.lang.Object>,coffee2.CoffeeMaker>>,java.util.concurrent.Executor)
	location: class com.google.common.util.concurrent.Futures 

Manually editing the generated code to refer to transform() instead of transformAsync() seems to fix the problem.

Running from git HEAD on 2016-01-22, mvn still failed, but it was OK in Eclipse because Futures resolved to guava-19. When running against 2.1-SNAPSHOT, Futures resolved to within the dagger snapshot.



 
 