# SwingLibraryTracker

SwingLibraryTracker is a simple library database management software, to manage a library catalog, register library members and to track the status of books. 

## Technologies

- Java 1.8
- Java Swing 
- MySQL Community Server version 5.7
- MySQL Connector/J 8.0
- MySQLWorkbench 6.3
- Netbeans 8.2

## Prerequisites

- Java Runtime Environment (JRE) 8
- MySQL Community Server version 5.7
- MySQL Connector/J 8.0
- Optional: MySQLWorkbench 6.3

## Setup

#### Install

- To run the project, go to the 'dist' folder and double click on the "SwingLibraryTracker.jar" file

- or to launch the program from the command line, locate the 'dist' folder and type the following:
```
java -jar SwingLibraryTracker.jar 
```
    

#### Create a MySQL database
- **Download .sql files from https://github.com/gittaszabo/swinglibrarytrackerdb.git**

	```LibraryTrackerDatabase/librarytracker.sql``` will create an empty database
  
	```LibraryTrackerDatabase/librarytrackersample.sql``` will create a database with sample data

- **Create a database** 

	Note, that these .sql files will create databases with the names 'librarytracker' and 'librarytrackersample', respectively.
	(Existing databases with the same name will be deleted when running the .sql scripts.)

	Create a database **using the command line**:
  
	```mysql -u root -p <librarytracker.sql``` -> empty database 
  
	```mysql -u root -p <librarytrackersample.sql``` -> sample database


	...**or in MySQL Workbench**
  
	select ```File > Run SQL script > Run```

- **Connect to your database**

	Go to the ```Settings > Connect to database``` in the main window of LibraryTracker. Enter your connection data to load your database.


## Built With

Netbeans 8.2


## Author

* Gitta Szabo - https://github.com/gittaszabo
