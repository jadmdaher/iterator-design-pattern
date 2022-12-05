# iterator-design-pattern


How to run the program?

Enter folder “HelloFX” navigate to file “src” then file “application”. In file “application” you will find two classes “Main” and “MainController”. Open “Main” on your IDE, since it contains the main method, then run it.

Note: In case the program doesn’t run, then the issue is most likely due to not having JavaFX installed on your device. Therefore, you will have to download and install it from https://openjfx.io/openjfx-docs/ (find the version that best suits your device requirements). After installing JavaFX successfully, you will need to install JavaFX plugin. To do so using Eclipse, you will have to go to “Help”  “Eclipse Marketplace…” then find/search for “FX” and download “e(fx)clipse”. If you run into any more issues this short video might be of help: https://youtu.be/_7OM-cMYWbQ .

Overview:

The aim of this project is to provide a method of transportation to individuals that require transportation but either don’t have a car or choose not to use public transportation services. The suggested solution is to link individuals who need a ride with other individuals that are able to accommodate a ride free of charge.  

Upon launching the program, the user is prompted to enter their name, phone number, departure and arrival locations, expected departure time, in addition the user specifies whether they are a driver (meaning someone that has a car and is willing to give a ride to others) or a rider (meaning someone that needs a ride). The user then clicks “Submit” which triggers the program to run and check for any available drivers or riders.

How does the program work?

The input provided by the user is stored in two separate text files; one to store the drivers’ input and a second to store the riders’ input (Note: both text files are used as databases for the program). In addition, two HashMaps are used; one to store drivers’ input and a second to store riders’ input (Note: the user’s name and phone number (stored in one variable called “user”) are used as keys, while the departure and arrival locations as well as departure time (stored in one variable called “info”) are used as values). The (key; value) pairs of both maps are populated from the text files. Later on, the “values” of the HashMaps are compared and if they are equal they “keys” are returned.

There are four different outcomes:
  
  1.	If the user is a driver and is looking for a rider:
    a)	If there exists a rider that is going from and to the same locations as the driver at the same time  a message will be printed out saying: “rider’s name”             could use a ride.
    b)	Else, if there is no rider that has a value matching that of the driver  a message will be printed out saying: No available rides :(
  
  2.	If the user is a rider and is looking for a driver:
    c)	If there exists a driver that is going from and to the same locations as the rider at the same time  a message will be printed out saying: “driver’s name”             could give you a ride.
    d)	Else, if there is no driver that has a value matching that of the driver  a message will be printed out saying: Everyone has a ride :)
