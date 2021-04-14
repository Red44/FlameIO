
# FlameIO

---

FlameIO provides a framework for **composing a valid query and sending it**. 
It consists of a simple set of functions that makes it easy to for requesting , adding, manipulating  and operate data.
There is also a **permission System** which consists of module instances each of them can create an own set of collections
which means that every module ius isolated from each other. The System **only grants access writes to the modules responsible 
for the collections**. It is only **possible to request data if the using module is not the owner of the collection**.

FlameIO is extremely **responsive** and **easy to use** tool and provides optimal data usage by caching the data used.
The API **differentiates between writes and reads** which makes it even more sorted.

## FlameIO access

The resulting object grants you permission for read and writes.

```java
public ILocalDatabase createNewAccessForYourModule(){
    IFlameIO io = flameCore.getModule("flameio");
    FlameModule yourModuleInstance;
  
    return io.getLocalDataBase(yourModuleInstance);
        
  }
```
##FlameIO Find
The externalDataBase or the localDataBase access is needed for this step

```java
 public IOperator createNewFind(ILocalDatabase db){
    return db.createNewFind();
  }
```
###FlameIO Find Syntax
When you attempt to locate data every time you have to use a IFindOperator to create one there is a special syntax.
#### Basic finds
```java
public IFindOperator simpleFind(IOperator op){
    return op.and().eq("name","John").finish();
  }
```
This query locates every object containg a field with "name" with the relation value "John"
Every query has to start with a logical operator. 
Why ?

```java
 public IFindOperator invert(IOperator op){
    return op.not().eq("name","John").finish();
    }
```
This is why.
#### Operator stacking
Operators are stacking until the next operator is given.
```java
  public void operatorStacking(IOperator op,IOperator op2){
    IFindOperator find = op.and().eq("x","y").and().exists("aaa").and().gte("f",32).or().exists("ssds").finish();
    IFindOperator operatorStacking = op2.and(). eq("x","y").exists("aaa").gte("f",32).or().exists("ssds").finish();
    assert(equals(find,operatorStacking));
    }
```
#### Bracket Operators
For every logical operator exist a second with the ending B.
It means that every logical operator is in brackets changing the logical statement.
Usage : 
```java
  public IFindOperator complexity(IOperator op){
    return op.or().gte("net_worth",1000000).and().andB().eq("name ","john").eq("gender","male").finish();
    }
```
This expresses that the tow "eq" operators are in a B like Bracket so mathematically it would be
`a or (b and c)` others wise if you had used the normal "and", it would be ` a or b and c` 
which would lead to the fact that you now locate things with a net_worth about 1000000 or named john
and only one of them most be true as also the gender and is true. So it got from he must be John and a mal 
or being rich to rich or named john, and he also must be male, so it now has a completely other sense.
####Find actions
Every action can be found in the IFind class and is there to locate data. 
```java
  public void actions(IFindOperator op){
    op.gte("money",1223);// gte -> greaterThanEquals , lte -> lessThaEquals and so on
    op.eq("name","John"); // checks if the element has a field name with the value John -> equals
    op.exists("name"); // returns every element with a field called name
    op.mod("year",4);//returns every element where year % 4 == 0 -> modulo
    op.text("John"); // returns every element containg the string John
    op.eleMatch("stats");// the whole think is json bastes so it goes into the called element. From there you can locate other thinks
    op.regex("date","^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$"); // returns every field with the correct date pattern
    op.finish();// ends the find and makes it ready for sending
    }
```

####Find cloning
Finds are cloned by using copy. The copy is a deep copy.
```java
  public void deepCopy(IOperator op) {
    op.not().eq("name","john").copy();
    }
```
####Find template
During  find creation  you can add to each action a changeable attribute.
Now is it possible to create a template from the find and changed the addressed actions;
```java
  public void template(IOperator op){
    IFindOperator find = op.and().eq("name","John").changeable("name").eq("gender","male").finish();
    
    IFindOperator changedFind =  find.asNewTemplate().change("name","Alex").build();
    }
```
## FlameIO requests 
The request is done by presenting the collection name to the api, so it is possible to modify 
the current request.
```java
  public IResultCollection request(ILocalDatabase localDB, IFindOperator find) {

    IDatabaseRead databaseRead = localDB.getCollectionRead("stats");

    IReadRequest request = databaseRead.createNewReadRequest(find);

    request.sortBy(Sort.ASCENDING,"kills"); // sort kills ascending

    request.size(15); // there is no limit until you set it

    request.selectOnly("player_id"); // only returns the single player

    return request.requestMany().getResult();
    }
```
There is also another way tp request data. It is possible to count the elements that would be given.
```java
  public long playersEverKilledAPlayer(ILocalDatabase localDB, IFindOperator find) {

    IDatabaseRead databaseRead = localDB.getCollectionRead("stats");

    IReadRequest request = databaseRead.createNewReadRequest(find);

    request.sortBy(Sort.ASCENDING,"kills"); // sort kills ascending

    request.selectOnly("player_id"); // only returns the single player

    return request.count().getResult();
    }
```
##FlameIO Data transfer
Between the application and the backend is data transferred or shared.
Here are IResultCollection used to transfer data bidirectional.
###IResultCollection
The IResultCollection interface provides in its inner a list of IResultPieces which can be used to read the data from it.
Each ResultPiece represents a json, and the IResultCollection is a list of them. 
```java
  public void resultCollectionTest(IResultCollection resultCollection) {
  
     resultCollection.size();

     resultCollection.asList();

     resultCollection.asStream();

     resultCollection.get(1);

     resultCollection.first();
  }
```
###IResultPiece
An IResultCollection provides a navigator for the json in its inner.
As a reminder the interface is meant to navigate to a know target and not to process something.

```java
class Car{
  String color;
  int worth;
  String name;
  String[] parts;
  Engine engine;
}
class Engine{
  String name;
  long ps;
  long kmh;
}
class CarDealer{
  Car[] inventory;
}
```
A possible answer from the api.
```json5
{
  "inventory" : [
    {
      "color" : "red",
      "worth" : 50000,
      "name " : "blue",
      "parts " : [
          "doors",
          "wheel"
      ],
      "engine" : {
        "name" : "X",
        "ps" : 400,
        "kmh" : 300
      }
    },
    {
      "color" : "blue",
      "worth" : 50000,
      "name " : "red",
      "parts " : [
        "doors",
        "wheel"
      ],
      "engine" : {
        "name" : "XIII",
        "ps" : 475,
        "kmh" : 350
      }
    },
    {
      "color" : "rainbow",
      "worth" : 50000,
      "name " : "invisible",
      "parts " : [
        "doors",
        "wheel",
        "rgb"
      ],
      "engine" : {
        "name" : "rainbow",
        "ps" : 999999,
        "kmh" : 1080000000
      }
      
    }
  ]
  
}
```
#### Navigation
There are three main methods to navigate through the json : get(name), pointAsAnArray(index), pointAsAnArray(index,name)
The example should explain hwo to navigate through the data shown above
Target is to get the speed of the car "invisible"

```java
  public IResultPiece navigation(IResultPiece resultPiece) {
    resultPiece.pointAsAnArray(2,"inventory"); // goes into the inventory an select the third row #countFromZero
    resultPiece.get("engine"); // select engine 
    resultPiece.get("kmh");// select kmh
    return  resultPiece;
    }
```
#### Data request
When the navigation is finished, It is possible to get the Data with two options : 
1. Direct parsing => kmh => long 
```java
  public long getSpeed(IResultPiece resultPiece) {
    resultPiece.pointAsAnArray(2,"inventory"); 
    resultPiece.get("engine"); 
    resultPiece.get("kmh");
    
    return resultPiece.getValue(DefaultClass.LONG); // parses mkh directly 
  }
```
2. Object parsing => Car => car.engine.kmh;
```java
  public long getSpeed(IResultPiece resultPiece) {
    resultPiece.pointAsAnArray(2,"inventory");
    
    Car invisibleCar = resultPiece.getValueAsObject(Car.class);
    
    return invisibleCar.engine.kmh;
  }
```
###Result building
To send data you have to build an own IResultCollection and IResultPiece.

####IResultPiece building








