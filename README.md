# IF2210 - ArkavQuarium

## Description
This repository is a task for IF2210-Object Oriented Programming, Department of Informatics, Bandung Institute of Technology. 

----
## Authors

* **[Jason Wiguna](https://github.com/jasonwiguna)** - 13516024
* **[Steven Sukma Limanus](https://github.com/stevensukma)** - 13516102
* **[Eric Jonathan](https://github.com/ericjonathan6)** - 13516117
* **[Christian Wibisono](https://github.com/christianwbsn)** - 13516147

----
## Usage
Compile with following command:

```
javac -d bin src/*.java
```

The program is available on the bin folder, execute the program with this following command:

```
java -cp bin Main
```
---
## Unit Testing
Compile with following command:

```
javac -d bin -cp bin:toolkit/hamcrest-core-1.3.jar:toolkit/junit-4.10.jar test/*.java
```

The unit test program is available on the bin folder, execute the program with this following command:

```
java -cp bin:toolkit/junit-4.10.jar:toolkit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore DroppableItemTest FishTest GuppyTest LinkedListTest PiranhaTest PlayerTest PositionTest
```
---
## JavaDoc
To generate javadoc, run the following command:
```
javadoc -d doc/javadoc src/*.java
```
The html file will be available at doc/javadoc
---
## JDepend
To show jdepend, run the following command:
```
java -cp toolkit/jdepend-2.9.1/lib/jdepend-2.9.1.jar jdepend.swingui.JDepend .
```

## Other
You can find the c++ version **[here](https://github.com/stevensukma/IF2210-ArkavQuarium)**