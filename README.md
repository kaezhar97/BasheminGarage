# BasheminGarage
Assignment number 2a for Programming 2

Computer Programming II				   Instructor: Greg Shaw
COP 3337 							    


Alternate Programming Assignment #2

(Arrays)


I. The Assignment

The Bashemin Parking Garage contains a single lane that can hold up to ten cars.  Arriving cars enter the garage at the rear and are parked in the empty space nearest to the front. Departing cars exit only from the front.  

If a customer needs to pick up a car that is not nearest to the exit, then all cars blocking its path are moved out temporarily, the customer's car is driven out, and the other cars are restored in the order they were in originally.  Whenever a car departs, all cars behind it in the garage are moved up one space.

Write a Java program to operate the garage. 

The program will read and process lines of input from a file until end-of-file. Each input line contains a license plate number and an operation (ARRIVE or DEPART), separated by spaces.  Cars arrive and depart in the order specified by the input.  Each input operation must be "echoed" to an output file, along with an appropriate message showing the status of the operation.

When a car arrives, the message will include the license number and state whether the car is being parked or turned away because the garage is full.  If the garage is full, the car leaves without ever having entered the garage.

When a car departs, the message will include the license number and the number of times the car was moved. 

The number of moves does not include the one where the car departs from the garage, or the number of times the car was moved within the garage. It is only the number of times it was moved out of the garage temporarily to allow a car behind it to depart.

If a DEPART operation calls for a car that is not in the garage, the message should so state.

 II. Specifications

 Create separate classes to implement a Car and a Garage

 The Car class will have private instance variables that store the license number and number of times the car has been moved, and any methods you discover to be necessary

 The Garage class must use an array (not an ArrayList) of Car objects to implement the garage

 To handle the arrival and departure of each car, your Garage class must implement separate methods arrive() and depart(), each of which returns a String showing the result of the operation (see above).

 Your garage class may contain other methods should you find them necessary or advisable.

 Also write a “test” class that reads the operations from the input file, echoes each to the output file, calls the appropriate Garage class method, and writes the result to the output file.

 As stated in 4. and 6. above, all output is to be done in the test class

 Make sure your classes adhere to the style and documentation standards discussed in class and in online notes 

 III. Data File

 The input file to be used - garage.txt - is available on the class web page

 IV. Due Date:  Tuesday, October 3rd
  
   V. What to Upload to Moodle

   Upload a zip file containing your project folder and the output file.  See the “Using NetBeans” document online for an easy way to capture the output and include it in the project. Make sure you zip the project folder itself, and not the individual .java files. No other kinds of compressed files will be excepted other than a .zip file.  See the “Submitting Your Assignments” document online to make sure you don’t lose credit for not following directions.
   

