# Admin UI

`build` script is a wrapper of maven and take any arguments that maven recognizes. 

## Generate a WAR file

    ./build install

## Run the webapp

    ./build jetty:run

## Continuous compile and hot deployment
* Open two terminals.
* Run the webapp.
```
    ./build jetty:run
```

* Run continuous compilation.
```
    ./build scala:cc
```

* Open http://localhost:8080 and see the initial rendering.
* Change some code and refresh the browser.
* Observe the change is reflected once jetty redeploys the app.
* Please note you need to restart jetty when you change the method signature or
  change the class hierarchy. Consider to buy JRebel license if it is not sufficient.

## IntelliJ Set up
* Add "*.zul" suffix to xhtml File type in Preferences.
* Add zul.xsd as an external resource for `http://www.zkoss.org/2005/zul` XML namespace so that
auto completion works for the most of the elements. Please note that it is not fully updated and some of the
attributes or elements recently added may not be recognized as valid.
![Settings in Preference](/images/Map_External_Resource_for_ZUL.png)
