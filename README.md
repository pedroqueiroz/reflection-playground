# reflection-playground
This playground was used as example to a Java User Group - Pernambuco Meetup.

There are two parts for this playground.

**The first one**, `com/demo/Main.java`, is about general capabilies of the Reflection API, such as:

* Listing Fields
* Listing Constructors
* Listing Methods
* Invoking private constructors
* Invoking private methods

**The second one**, `com/demo/genie/Main.java` is a funny example on how Reflection API should be used in very dynamic situations. In this example, the user inputs a String containg a wish in this format: `I want a ${vehicleColor} ${vehicleClass} from ${vehicleMaker}` and magically the Genie creates this vehicle for you using the Reflection API.
