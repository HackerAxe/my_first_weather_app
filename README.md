# my_first_weather_app
This weather app taught/reinforced several Java and general software-engineering concepts.

## Things I Learned
- ### APIs
    - To get data we want from APIs, I learned to use a Client > Request > Response pattern, and how I can do that with Java for the first time using Open-Meteo.
- ### Maven
    - I learned that maven is a very powerful Java automation tool that helps with JUnit testing, adding libraries by downloading them for you via the pom.xml and dependencies, keeping things up to date, and many other things. But most notably the JUnit testing help and adding libraries automatically by just compiling the pom.xml after adding a dependency. And, after all that, you can just hit run above the main method to run the dependencies from Maven! I did learn that you MUST run the main method through maven to get your dependencies to work, like GSON, as I did not manually install it. Maven's a pretty handy tool!

    - I also learned that pom.xml needs to be in the src folder, and for CI in GitHub actions, the .github folder needs to be in the root folder.
- ### Encaspulation, Cohesion, and Modularity
    - First, I wrote all of the code needed for this project in main, but I used **modularity** to separate each task into a method. Then, since each method had to do with the weather, I **encapsulated** the weather methods and fields into its own separate java class file. As the weather class only dealt with tasks related to the weather, the weather java class file remained **cohesive**.
- ### Abstraction
    - The main method in App.java can create a weather object and only has access to the getter methods that return the temperature, wind speed, and weather codes of the current weather. The way the weather information is retrieved or how the weather JSON is parsed is completely **abstracted** from the user of the weather class.
- ### Low and Tight Coupling
    - I asked Copilot how I should test a method that is supposed to be privated, without sacrificing my method's privacy, and I learned that tests that are too reliant on the code's structure are **tightly coupled**. To avoid this, I tested the entire program as a whole, and kept in mind that a test should focus on the "what," or the result of the methods being tested, and not the "how," or in what way the code was written to make a specific result occur.
- ### Static vs Instance Methods
    - Static methods belong to a class, and Instance methods belong to a particular object, and affect that objects fields. I encountered an error when I tried to access the temperature field in my "setWeather" method because it was a static method. It should have been an instance method because it directly affected an object's fields. Static methods should be reserved for methods that are more like "tools" that do not tie to a specific object.
- ### Builder Methods
    - I understand now that builder methods are like constructors in the way that they help "construct" and object, but are more readable and maintainable than a constructor with many parameters. Builders can be read like a sentence, chaining them together to understand what each does to help build an object. By changing the parameters of a constructor, code outside of the class may have to change, and would be too hard to maintain.

