

//INSTALL AND RUN
/* #region Main */

//INSTALL
/*
//WINDOWS
INSTALL     -- >Install using link -- https://www.oracle.com/java/technologies/javase-jdk14-downloads.html
SET ENV VAR -- >JAVA_HOME  C:\Program Files\Java\jdk1.7.0_72\bin   -> set env var(set  PATH directly "OR" set   JAVA_HOME then add  to PATH) to filepath(JAVA ka bin folder)
                PATH    path1;path2;%JAVA_HOME%                        
                PATH path1;path2;C:\Program Files\Java\jdk1.7.0_72\bin   
                >java -version          -->gives java version
                
                                                          

//LINUX
INSTALL -- >sudo apt install default-jdk
           >sudo apt install default-jre
           >java -version                 -->gives java version
           >whereis java                  --> gives usr/lib/jvm  /usr/bin/java /usr/share/java 

SET ENV VAR -- >cd /usr/lib/jvm
              >ls                                                  -->gives default-java  java-1.11.0-openjdk-amd64  java-11-openjdk-amd64  openjdk-11
              >export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64  --> set env var(JAVA_HOME) to filepath(jdk ka path)
              >echo $JAVA_HOME                                      -->echo env var 
*/

//RUN 
/*
//WINDOWS
> javac filename.java  -->compiles .java(java  file)  to .class(binary file)
>java filename          -->runs the .class(binary files)

//LINUX
> javac filename.java  -->compiles .java(java  file)  to .class(binary file)
>java filename          -->runs the .class(binary files)



*/

/* #endregion */


//STRUCTURE
/*
PROJECTNAME                                       -->INSTALL,RUN      
|- packagename1                               
   |-classname1.java
   |-classname2.java
|-packagename2
   |-classname1.java
   |-classname2.java
      |
      |
    CLASSNAME.JAVA
    import packagename.classname               --> IMPORT TILL CLASS,IMPORT TILL PACKAGE                                                                                               
    public  ---- class  ClassName{             -->1.CLASS DECLAREATION,2.CLASS ACESS                                             
        Nested class                           -->CLASS            
        Instance variable
        Constructor
        Getter
        Setter
        Object Class
        Iterable , Iterator Interface
        Comparable ,Comparator Interface
        Functional interface  - Consumer Interface , Supplier Interface , Predicate Interface , Function interface –U , B
        Stream – creating stream , methods of stream                       - 
    
    OBJECT                                             -->.INT ,INTEGER,CHAR, CHARACTER,STRING,STRINGBUFFER,sTATIC ARRAY, LIST, STACKS , QUEUES , MAP,SET 
    EXCEPTION                                          -->EXCEPTION,EXCEPTIN HANDLING,EXCEPTION CLASS                                                    
    THREAD                                             -->CREATE  THREAD,START THREAD,JOIN THREAD,PAUSE  THREAD,INTERRUPT THREAD,THREAD HELPERS


    CONDITIONAL                                        -->IF ;WHILE,DO WHILE ;FOR,FOR –EACH ; STREAMS(FUNCTIONAL INSTEAD OF OOPM); BREAK CONTINUE

*/


//IMPORT
/* #region Main */

//IMPORT TILL CLASS:
/*
import package.class (* = all class)
Class varname = new Class()
*/

                                
//IMORT TILL  PACKAGE
/*
import package
Package.Class varname = new package.Class()
*/

/* #endregion */


//CLASS
//1.CLASS DECLARATION
/* #region Main */
/*
acessmod nonacessmod   Class  classname/interFaceName  <Generic>    extends/ implements  classmame/interface{                                                                    
           acessmod  nonacessmod   datatype   memberVariable                          -->NestedClass,Methods,memberVariables are members of class
           acesmod   nonacessmod    <GenericMethod> returntype  methodname(parameters){    --/
                localVariable 
            }
}
*/
                                                            //1. ACESS MODIFIER 
                                                           /*
                                                           Class                             -->public , P-P(default)    
                                                           NestedClass,Methods,instanceVar,  --> public, protected,  P-P, private,
                                                          
                                                                           Same package     Same package     Same package     Different Pack  Different pack
                                                                            Same class      subclass         Non-Subclass     Subclass        non Subclass
                                                           Public                 Y          Y                Y                Y               Y               
                                                           Protected              Y          Y                Y                Y               N                                         
                                                           Public-protect(d)      Y          Y                Y                N               N                                        
                                                           Private                Y          N                N                N               N   
                                                           */
                                                           
                                                            //2.NON ACESS MODIFIER :
                                                            /*
                                                           Class                                     -->  abstract , final
                                                           NestedClass,  methods, memberVariable     -->  Static, Non static, abstract,final,default,transient, synchronised,volatile 
                                                                                
                                                                                                           
                                                            Static(class members)                    -->  1.Class,Interface :Not available
                                                                                                          2.Members:
                                                                                                           Members belong to class;hence are same across all objects ;
                                                                                                           Members cant be overwridden; hence can be present in class and not interface(new Java feature allows static members in interface)
                                                                                                           Static methods can acess only static members;Static members can be acessed both by class and object of class(Look in CLASS ACESS)
                                                            Non static(instance members)             --> 1.Class,Interface :Not available   
                                                                                                         2.Members:
                                                                                                           Members belong to object;hence are different for all objects 
                                                                                                           Members can be overwridden; hence can be present in class and  interface
                                                                                                           Non Static methods can acess both static and non static members ;Non Static members can be acessed both onlyd object of class(Look in CLASS ACESS)
                                                                                                           Eg:
                                                                                                           public static class C1{public int[] arr = new int[]{1,2,3,4,5};}
                                                                                                           C1 c1 = new C1();C2 c2 = new C2(); 
                                                                                                           c1.arr[2] = 100;c2.arr[3] = 100;    -->c1 = [1, 2, 100, 4, 5] ;c2 = [1, 2, 3, 100, 5]

                                                                                                           public static class C1{public static int[] arr = new int[]{1,2,3,4,5};}
                                                                                                           C1 c1 = new C1();C2 c2 = new C2(); 
                                                                                                           c1.arr[2] = 100;c2.arr[3] = 100;    -->c1 = [1, 2, 100, 4, 5] ;c2 = [1, 2, 100, 100, 5]
  
                                                                                                                                                                        

                                                            Abstract                                 -->   1.Class,Interface:Class cant be instanciated but can be inherited;hence class and interface can be abstract
                                                                                                           2.Members:Members must be overwridden; hence can be present ony in abstract class or abstract interface                                                                                                        
                                                            Final                                    -->   1.Class,Interface:Class can be instanciated but cant be inherited;hence class can be final but interface cant be final
                                                                                                           2.Members:Members cant be overwridden; hence can be present only in class and not interface
                                                            Default                                  -->   1.Class,Interface:Not available
                                                                                                           2.Members:Members cant be overwridden; hence can be present in class and not interface(new Java feature allows default in interface)
                                                                                                       


                                                            Transient:                               -->   1.Class,Interface:Not available
                                                                                                           2.Members:  skipped when serializing the object containing them
                                                            synchronised:                            -->   1.Class,Interface:Not available
                                                                                                           2.Members: Put a lock on shared method , var and only 1 thread can acess 
                                                                                                           Sequentially(Explained Thread-> Create Thread->Race cond)
                                                            volatile:                                -->   1.Class,Interface: Not available
                                                                                                           2.Members: instance variable’s value is not cached     thread-locally, and is 
                                                                                                             always read from the "main memory"concurrently """"Explained Thread-> Create Thread ->Visibility Problem)""""
                                                          */
           
                                                            //3.RETURN TYPE,DATATYPE:
                                                            /*
                                                            Datatye :-->primitive , reference
                                                            Returntype --> void,primitive , reference 
                                                            */
                                               
                                                            //4.MEMBER VARIABLE, LOCAL VARIABLE
                                                            /*
                                                            member variable    -->Declared in class and value not requires; be given  by default constuctor OR  userdefined constructor ,getter setter
                                                                                 Default: Byte , short , Int , long , -> 0 , float , double -> 0.0 ,  Bool -> false ; ref var -> null
                                                            Local variable:   -->Declared in method and value must be given  ie int a = 22; int a(X);
                                                             */

                                                            //5.EXTENDS, IMPLEMENTS(NORMAL,ANONYMOUS INNERCLASS,LAMBDA FN,LAMBDA FN + METHOD REFERENCE)-->INHERIT,CREATE,EXTEND,OVERRIDE,OVERLOA
                                                            /*
                                                            acessmod nonacessmod Class superClass{}                     -->declare a class with members that can be reused 
                                                            acessmod nonacessmod Class subclass extends superclass{} 

                                                            acessmod nonacessmod interface InterfaceName{               -->declare a instance with members that are to be overwriden thus providing class structore for future use                                        
                                                            acessmod nonacesmod Class subclass implements InterfceName{}  They are also used for "multiple inheritance" and decpupling
                                                                                                                         **public and abstract are default modifiers
                                                                                                                            NORMAL IMPLEMENTATION
                                                                                                                            public interface Animal{ 
                                                                                                                                public abstract void bark(String s);}

                                                                                                                            public class Dog implements Animal {     -->Dog subclass  Implement Animal class by overrides the method
                                                                                                                                @override
                                                                                                                                public  void bark(String s){sout(s)}; 
                                                                                                                            }
                                                                                                                            Animal animal = new Dog();
                                                                                                                            animal.bark("pras");

                                                                                                                            ANONYMOUS INNER CLASS IMPLEMENTATION(Only for Functional Interface ie It=nterface with only 1 abstract method)
                                                                                                                            Animal animal = new Animal(      
                                                                                                                                @Override                            -->Directly implement Animal class by overridinhg the bark method
                                                                                                                                public void bark(String s){          
                                                                                                                                    Sout(s);    
                                                                                                                                } 
                                                                                                                            );
                                                                                                                            animal.bark("pras");
                                                                                                                            
                                                                                                                            LAMBDA FN IMPLEMENTATION(Only for Functional Interface ie It=nterface with only 1 abstract method)
                                                                                                                            Animal animal = (String s) ->{Sout(s)}   -->Directly implement Animal class by overridinhg the bark method
                                                                                                                            animal.bark("pras");   
                                                                                                                            
                                                                                                                            LAMBDA FN + METHOD REFERENCING
                                                                                                                            Animal animal = (String s) ->{Animal.calculateValue(s);} -->Since Lambda Fn is only calling a method from class we can write it as
                                                                                                                            Animal animal = (Animal:calculateValue)                     ClassName:MethodName
                                                                                                                                                                                        LOOK IN CLASS=>3.CLASS=> COMPARABLE INTERFACE=> LAMBDA FN CAN BE WRITTEN IN 4 WAYS



                                                      
                                                            INHERITS:
                                                            subclass inherits  members of superclass
                                                            Constructor not autoinherted so inherit using super() -->  Keyword  this, super

                                                            CREATES:
                                                            subclass can create its own members

                                                            EXTENDS:
                                                            subclass can extend methods of superclass by super.method()--> keyword this, super,

                                                            OVERLOAD(compile time static polymorphism)
                                                            Same method for different parameters
                                                            1.Methodname:Same 
                                                            2.MethodParameter:Different  
                                                            3.Modifiers:Same or Diff  
                                                            4.ReturnType:Same or Diff 

                                                            OVERRIDE(Runtime dynamic polyorphism):-->
                                                            Same method of superclass changed in subclass
                                                            @override
                                                            1.MethodName:Same 
                                                            2.MethodParameter:Same   
                                                            3.Modifiers:Acess modifiers:Same Or Higher accessibility 
                                                                        Non-Acess modifiers:Abstract members must be overwridden and Static,Final,Default members cannot be overwridden
                                                                        EG1
                                                            4.Ret type :Same or Subclass
                                                                        EG2

                                                                        EG1
                                                                        private void method1(){}
                                                                        @Override
                                                                        public void method2(){}  --acess modifier has hogher acessibility(public > private)

                                                            
                                                                        EG 2:
                                                                        public Animal method1(){}
                                                                        @Override
                                                                        public Dog method1(){}   --retType Dog is subclass of Animal
                                                                
                                                                
                                          

                                                                                    



                                                                                                           
                                                                */
                                                            //MULTIPLE INHERITANCE
                                                            /*
                                                            Multiple inheritace:-> subclass extends superclass1 ,superclass 2 (not allowed )
                                                                                subclass implements superclass1 ,superclass 2;(allowed)
                                                                                subclass extends sup1 implements superclass22
                                                                                                
                                                                                                    
                                                            Pets                          Animal 
                                                            |                /          |             \
                                                            |               /           |              \
                                                            |            Canine        Hippo         feline                       Canine IS-A Animal ; Hippo IS-A Anima l felline IS-A Animal
                                                            |          /    \                         /   \
                                                            |       Dog     wolf                    cat   Lion                   Dog IS-A Canine ; Wolf IS-A Canine; Cat IS-A feline; Lion IS-A feline
                                                            |____|________________|                                              IS-A Pets                                               IS-A pets            

                                                            Public class Animal{}
                                                            Public interface pets{}
                                                            Public class Canine extends Animal{}
                                                            Public class hippo extends Animal{}
                                                            Public class feline extends Animal{}
                                                            Public class Dog extends Canine implements Pets{}
                                                            Public class Wolf extends Canine {}
                                                            Public class Cat extends feline  implements Pets{}
                                                            Public class Lion extends feline  {}
                                                                                                                                                                                                                

                                                            */
                                                            //DECOPULING
                                                            /*
                                                                    TC
                                                            Class A----------class B     -->Class A , Class B are tightly coupled   because class must use 
                                                                                            another class and not instamciate it    

                                                            Class A Intarface             -->Class A , Class B are decoupled using  Interface which 
                                                                I /  \   CI, SI,MI          is implemented  and constructor injection ,setter injection , method injection
                                                                /     \                          
                                                            Class A     Class B             


                                                            EG1
                                                                    TC
                                                            Animal   -----  Dog

                                                            Animal.java
                                                            public class Animal {
                                                                private double dB;

                                                                public Animal(double dB) {
                                                                    this.dB = dB;}

                                                                public double sound(){
                                                                    return dB*0.3;
                                                                }
                                                            }

                                                            Dog.java
                                                            public class Dog {
                                                                private Animal animal;

                                                                public Dog() {
                                                                                animal = new Animal(100);}           --> TIGHT COUPLE                                                                         
                                                                public void dogsound(){                                  Animal animal = new Animal();
                                                                    var sound = animal.sound();
                                                                    System.out.println(sound);   }
                                                            }


                                                                        AnimalInterface
                                                            Implements   /  \   CI,SI,MIS
                                                                        /     \
                                                                    Animal     Dog
                                                            AnimalInterface.java
                                                            public interface AnimalInterface {
                                                                public double sound();
                                                            }

                                                            Animal.java
                                                            public class Animal implements  AnimalInterface {
                                                                private double dB;

                                                                public Animal(double dB) {
                                                                    this.dB = dB;}

                                                                @override
                                                                public double sound(){
                                                                    return dB*0.3;
                                                                }}

                                                            Dog.java
                                                            public class Dog {
                                                                private AnimalInterface  animal;

                                                                public Dog(AnimalInterface animal ) {            -->CONSTRUCTOR INJECTION 
                                                                    this.anmimal =animal}                           AnimalInterface animal = new Animal(1000)

                                                                public void setAnimal(AnimalInterface animal ) {   -->SETTER  INJECTION 
                                                                    this.anmimal =animal}                               AnimalInterface animal = new Animal(1000)                                                                             


                                                                public void dogsound(AnimalInterface animal){    --> METHOD INJECTION
                                                                    var sound = animal.sound();                     AnimalInterface animal = new Animal(1000)                                                                                       
                                                                    System.out.println(sound);   }
                                                            }


                                                            Main.java
                                                            var animal = new Animal(1000);   
                                                            var dog  = new Dog(animal);        

                                                            var animal = new Animal(1000);   
                                                            var dog  = new Dog();
                                                            dog.setAnimal(animal);

                                                            var animal = new Animal(1000);   
                                                            var dog  = new Dog();
                                                            dog.dogsoundl(animal);


                                                            EG2-->Intellij code ->MyTube -> MyTube_question , MyTube_soln
                                                                TC = tight couple , CI = const inj, SI = setter inj , MI = methd inj
                                                                                    
                                                            MyTube_question,
                                                                                                            MI           TC
                                                                |------------------------------------------EmalService---------------------------\
                                                                |                                           MI          TC                        \
                                                            User-------------------Video---------------VideoEncoder-----------------------------VideoProcessor-Main
                                                            |                             |              MI                     TC             /    |
                                                            |                             |---------------------VideoDatabase----------------/      |
                                                            |                                                                                       |
                                                            |---------------------------------------------------------------------------------------|

                                                            MyTube_soln


                                                                                                                        EmailServiceInterface, VideoEncoderInterface, VideoDatabaseInterface
                                                                                                    Implements       /         \
                                                                                                            MI        /           \
                                                                |------------------------------------------EmalService              \  CI
                                                                |                               MI                                   \            
                                                            User-------------------Video---------------VideoEncoder-             VideoProcessor-----Main
                                                                                            |   MI                                                   |      
                                                            |                            |---------------------VideoDatabase                      |
                                                            |                                                                                     |
                                                            |                                                                                     |
                                                            |--------------------------------------------------------------------------------------|


                                                        */

                                                            //6.GENERIC<T/?>
                                                             /*
 
                                                            T(placeholder) can be assigned in generic class/generic method and all T inside generic class and generic methods must be assigned same
                                                            <T> = <T extends Object>      -->Object class or any of its subclass
                                                            <T extends Class/Interface>   -->class/interface or any of its subclass
                                                            

                                                            ?(wildcard) can be  assigned in inbuild classes and each ? can be assigned differrnt
                                                            <?> = <? extends Object>       -->Object class or any of its subclass
                                                            <? extends Class/Interface>    -->Class/Interface or any of its subclass
                                                            <? super Class/Interface>      -->Class/Interface or any of its superclass
                                                             2.? cant be used

                                                            **GENERICE DO NOT TAKE PRIMITIVES

                                                            EG 1
                                                            public class C1<T extends Number>{        -->T can be assigned Number and subclass(T is assigned in generic class)
                                                                private T  value;                     -->T can be assigned Number and subclass(T inside generic class must be assigned same)
                                                                private T[] arr;                      -->T can be assigned Number and subclass(T inside generic class must be assigned same)                          
                                                                private List<T> arr;                  -->T can be assigned Number and subclass(T inside generic class must be assigned same)
                                                                private HashMap<T,T>                  -->T can be assigned Number and subclass(T inside generic class must be assigned same)
                                                                public T methodname(String s, T val1,  T val2 ){}  } --?(T inside generic class must be assigned same)

                                                                public static <T extends Number> void       -->T can be assigned Number and subclass(Tis assigned in generic method)
                                                                    fnName1(List<T> src, T dest) {}         -->T can be assigned Number and subclass(T inside generic method must be assigned same)

                                                            C1<Integer> c = new C1(); 
                                                            c.value = new Integer(1);
                                                            c.arr = new Integer[1,2,3];              
                                                            c.hashMap<Integer,Integer>                                                  
                                                            c.methodname(s,Integer ka value , Integer ka value)

                                                            EG2:
                                                           public class C1<? extends Number>{                        -->xx( ? cant be assigned only in inbuild class)
                                                                private T  value;                                    -->xx( ? cant be assigned only in inbuild class)
                                                                private T[] arr;                                     -->xx( ? cant be assigned only in inbuild class)     
                                                                private List<? extends Number> arr;                  --? can be assigned Number and subclass( ? cant be assigned only in inbuild class and each ? can be assigned different)
                                                                private HashMap<? extends Number,? extends String>   -->1st ? can be assigned Number and subclass, 2nd ? an be assignes str and subclass( ? cant be assigned only in inbuild class and each ? can be assigned different)
                                                                public T methodname(String s, T val1,  T val2 ){}  } -->xx( ? cant be used only in inbuild class)

                                                                public static <? extends Number> void                -->xx( ? cant be assigned only in inbuild class)
                                                                    fnName1(List<?> src, ? dest) {}                   -->1st ? can be assigned Number and subclass( ? cant be assigned only in inbuild class and each ? can be assigned different)
                                                                                                                         2nd ? is wrong( ? cant be assigned only in inbuild class)

                                                        

                                                            EG3
                                                            public interface ExternalTransformBuilder<ConfigT, InputT extends PInput, OutputT extends POutput>{

                                                        	}
                                                            public Map<String, List<? extends ExternalTransformBuilder<?, ?, ?>>> knownBuilders() {
		                                                                     --> Map that takes String and List that takes   ExternalTransformBuilder and its subclass 
                                                                                 ExternalTransformBuilder takes  Object class and its subclass , Object class and its subclass ,Object class and its subclass 
                                                               */
         
                                                            //7.NAME
                                                            /*
                                                            ClassName                 --> pascalCase(ClassName)
                                                            Method, variablename      -->camelCase(methodName)         	
        
                                                            pascal naming: Cannot be a keyword like for ,if….
                                                                           1st word 1st  letter-> alphabet(capit al) ,underscore ,   $  numbers(cannot)    
                                                                           2nd word 1st letter -> alphabet(capital)
                                                                           Eg PrasannPatil(),$prasannPatil() ,     _prasannPatil()
                                                            camelCase: Cannot be a keyword like for ,if….
                                                                       1st word 1st  letter-> alphabet(small) ,underscore , $  numbers(cannot)
                                                                       2nd word 1st letter -> alphabet(capital)
                                                                       Eg prasannPatil(),$prasannPatil() ,  _prasannPatil()

                                                            */
/* #endregion */

//2.CLASS ACESS
/* #region Main */
/*
    Classname.members                                   -->acess members through classNames(Only Static members can be acessed through class)
    Referencetypr var = new ObjectType();varName.member -->acess members through objects(Both Static and non static members   can be acessed through class)
    this.member;this()                                  -->this refers to current class ka object;this() refers to current class constructor
    super.member;super()                                -->super refers to super class ka object ;super() refers to super class ka constructor 
                                                            **super(arg) must be declared as Constructor not autoinheroted so subclass must explicityy declare                                                                                                                                                                                                 
                                                            **super(arg) and this(arg ) must be declared in 1st line of constructor then    you  can either use super() or this()  
                                                            
                                           

                                                        REFERENCETYPE , OBJECTTYPE (NOCAST , UPCAST , UPCAST + DOWNCAST)
                                                        Dog  d = new Dog()      -->1.Referene type is Dog so it can take Object type Dog only  
                                                                                2.Objecttype is Dog so "d"  can acess all the methods of Dog class
                                                        Animal a = new Dog(); -->1.Ref type is Animal so it can take Objtype as all  subclasses Of Animal like Dog(),Cat() 
                                                                                2.Objecttype is Dog so "a" can acess all the methods of Dogs present in Animal ie overwritten  methods in Dog                                                                                                    
                                                        Animal a = new Dog(); -->>1.Ref type is Animal soy oy can take Objtype as all  subclasses Of Animal like Dog(),Cat() 
                                                        Dog d = (Dog)a;            2.Objecttype Dog so "d"  can acess all the methods of Dog class
                                                                                **Condition must be checked for downcast(if(a  instanceof Dog)

                                                        MEMBER = NEETED INNER CLASS
                                                        InnerClass i = new OuterClass.InnerClass();    -->acess innerclass through className(Only static innerclass can be acessed through outerClass) 
                                                        OR
                                                        InnerClass i = Outer.new Inner(); 
                                                        
                                                        OuterClass o = new OuterClass();             -->-acess innerclass through object of outerClass(Both Static and non static innerclass can be acessed through class)
                                                        InnerClass i = o.new InnerClass();


*/

                                               

/* #endregion */


//3.CLASS
/* #region Main */
/*
                                                                                               
acessmod nonacessmod   Class  classname/interFaceName  <Generic>    extends/ implements  classmame/interface{ 
*/    

    //NESTED CLASS
    /*
    Private --  class   ClassName{} -->Define a user defined inner class 
                                        Eg private class Node{}
    */

    //MEMBER VARIABLE
    /*
    acessmod  nonacessmod   datatype   memberVariable  -->Define member variable 
                                                          Value  be given  by default constructor/userdefined constructor ,getter setter
                                                          Default: Byte , short , Int , long , -> 0 , f , d -> 0.0 ,  Bool -> false ; ref -> null
                                                           Eg Int a; int[] a;  Node node;Animal animal
    */

    //CONSTRUCTOR
    /*
    public -- noreturntype ClassName( datatype instvar){  -->Define user defined constructor to onitialise member values   else JAVA will define default constructor 
        this.var1 = var1; OR  var1 = var1                    else JAVA will define default constructor  to onitialise default memberVariable values                     
    }                                                        Byte , short , Int , long , -> 0 , f , d -> 0.0 ,  Bool -> f ; ref var -> null 
                                                             this,this(),super,super() --   Explained in CLASS ACESS(                                                                                    
    */

    //GETTER
    /*
    acesmod   nonacessmod    <Generic> returntype  setMemberVariable(parameters){ -->Define getter to get member variables
        return memberVariable;                                                       
    }
    */

    //SETTER
    /*	
    acesmod   nonacessmod    <Generic> returntype  setMemberVariable(parameters){  -->Define setter to get member variables
        memberVariable = parameters;
        return memberVariable;
    }
    */

    //METHODS
    /*
    acesmod   nonacessmod    <Generic> returntype  setMemberVariable(parameters){ ->Define methods that Inherit, Create , Extend , overwride , Overload methods
    */

    //OBJECT CLASS 
    /*
    1.OBJECT CLASS
    public class Object{                                        

       public static String toString(){                               -->return the string representation of the object as className@hashCodeOfObject 
            return getClass().getName()+ "@"+Integer.toHexString(hashCode());    
        }

        public static String hashCode(){                              -->returns hashcode based on mem loc of  object reference 
            return Objects.hash(this);                                   this = object of class on which we apply hashCode method 
        }
        
        public static  String equals(Object o){                      -->returns boolean by comparing object reference 
            this == o;                                                 this = object of  class on which we apply equals method                        
        }                                                              o = object of class passed as arg to equals metod

    }

    2.EXTEND OBJECT CLASS
    public class C1 extends Object{                                  -->All classes  extend Object class and inherit object methods
        int val1;                                                       C1 = class on which we call all methodsl;this = object of current class C1
        int val2;                                                       C2 = class which we pass as arguements to all methods;c2= object of class C2 
        public C1(int val1,int val2){this.val1 =val1;this.val2 = val2 } val1,val2 = members of class        

        @override
        public string toString(){                                      -->return the string representation of the object as required 
            return  "string representation of object"                    **sout(obj) = sout(object.toString())-->sout takes any obj and appends toString() to it which is required to be overloaded to it                      
        }                                                              

        @Override                                                      -->returns hashcode based on values of object
        public int hashCode() {                                          val1,val2 = members of class based on which we find hashcode 
            return Objects.hash(val1,val2);                              
        }

        @Override                                              
        public boolean equals(C2 c2)   {                                  -->returns boolean by comparing object members as required       
            if (this == c2) return true;                                    C1 = class on which we apply equals method;this = object of current class C1
            if (c2== null || getClass() != o.getClass()) return false;      C2 = class which is passed as arg to equals metod;c2= object of class C2 
                                                                            val1,val2 = members of class based on which we find equals 
            return this.val1 == c2.val1 && this.val2 == c2.val2;                        if this.val1 == c2.val1 && this.val2 == c2.val2 returns true
                                                                                        if this.val1 != c2.val1 && this.val2 != c2.val2 returns false                                                                                 
        }                                                                               this.val1 == c2.val1 && this.val2 == c2.val2   -->compare integers
    }                                                                                   this.val1.compareTo(c2.val1) && this.val2.compareTo(c2.val2) -->compare strings lexicographically 
    
    3.CALL METHODS
    C1 c1 = new C1(val1,val2);                                           -->call the toString(),hashcode(),equals() method           
    C2 c2 = new C2(val1,val2)
    c1.toString();                                                    
    c1.hashCode();                                                    
    c1.equals(c2);                                                    

    EG 1(USER DEFINED CLASS FOR toString()) 
    Class Dog{
        int[] arr = new int[5];
        public void add(int val){...}
        public void remove(int index){...}

        @override
        public string toString()
            return  Arrays.toString(array}                                       
    }    
    Dog d = new Dog();
    Sout(d)  = Sout(d.toString()) //Dog@7D277 if we dont override toString()
    Sout(d)  = Sout(d.toString()) //[1,2,3,4,5] if we override toString()


    EG 2(INBUILD CLASS FOR toString())
    List<Integer> list = new ArrayList<>();
    list.add(1,2,3) 
    Sout(linkedlist)  = Sout(linkedlist.toString())   //[1,2,3] as list class overrides toString() internally 

    Look in OBJECTS=>IP-OP=>OP


    EG 3(UDER DEFINED CLASS FOR  hashCode())
    class Pointer{
        int x;int y;
        public Pointer(){this.x = x;this.y = y;}
        @Override                                                          
        public int hashCode() {
            return Objects.hash(x, y);
        }
    Point point1 = new Point(1,2);
    Point point2 = new Point(1,2);
    System.out.println(point1.hashCode());   //1595428806; 1072408673 if we dont override hashcode() 
    System.out.println(point2.hashCode());   //994; 994 if we dont override hashcode() 
            
    EG 4(INBUILD CLASSES FOR hashCode())
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);list1.add(2);list1.add(3);

    List<Integer> list2 = new ArrayList<>();
    list2.add(1);list2.add(2);list2.add(3);

    list2.hashCode(); //30817;30817 as list class overrides hashcode() internally  
    list2.hashCode();  

    EG 5(UDER DEFINED CLASS FOR equals())
    class Pointer{
        int x;int y;
        public Pointer(){this.x = x;this.y = y;}

        @Override                                                           
        public boolean equals(Point p) {
            if (this == p) return true;
            if (p == null || getClass() != o.getClass()) return false;
            return this.x == p.x && this.y == p.y;
        }
    }
    Point point1 = new Point(1,2);
    Point point2 = new Point(1,2);
    System.out.println(point1.equals(point2));//false if we dont override equals()
    System.out.println(point1.equals(point2)) //true if we  override equals()

    
    EG 6(INBUILD CLASS  FOR equals())
    String s1 = "abc";
    String s2 = "abc";
    s1.equals(s2)  //true  as string class overrides equals() internally                                                 
    Look in OBJECTS=>COMPARISIONS=>OP



    */

    //COMPARBLE INTERFACE 
    /* 
    1.COMPARABLE INTERACE                  
    public abstract interface Comparable<T extends Object>{  -->T can be assigned Object class and its subclass(T is assigned in generic class)                                      
       public abstract int compareTo(Object  o){}            -->abstract method that needs to be implemented                    
    }

    2.IMPLEMENT COMPARABLE INTERFACE : COMPARABLE IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN
    public  Class  C1 implements Comparable<C1>{     --> C1 = class on which we call on all  Method;this = object of current class C1
        int val1;                                        C2 = class which we pass as arguements to all methods;c2= object of class C2 
        int val2;                                        val1,val2 = members of class                                    
        public C1(int val1,int val2){ 
            this.val1 =val1;this.val2 = val2 }    

        @Override
        public int compareTo(C2 c2){                  -->return int by comparing object members as required 
            return this.val1 - c2.val1;                C1 = class on which we apply compareTo method;this = object of current class C1
       }                                               C2 = class which is passed as arg to compareTo metod;c2= object of class C2 
    }                                                  val1,val2 = members of class based on which we find equals
                                                            if this.val > c2.val returns >0 Or +1(acc to your code)
                                                            if this.val < c2.val returns <0 or -1(acc to your code)
                                                            if this.val = c2.val returns 0
                                                            this.val = c2.val         --> compare integers
                                                            this.val.compareTo(val2) -->compare strings lexicographically                                                                             
    OR
    Comparable<C1> comparableObject = new Comparable<>(){} -->Cant do anonymous inner class  as you cannot use "this" insode of anonymous inner class 
    OR
    Comparable<C1> comparableObject = () ->{}              -->Cant to lambda fn as you cannot use "this" inside lambda fn

    3.CALL METHODS
    C1 c1 = new C1(val1,val2);                            -->call the compareTo() method
    C2 c2 = new C2(val1,val2);
    c1.compareTo(c2)       


    EG 1(UDER DEFINED CLASS)
    class Pointer extends Comparable<Pointer>{
        private String age;
        private String name;

        public Pointer(){this.name = name;this.surname = surname;}

        @Override                                                           
        public boolean compareTo(Point p) {
            return this.age - p.age;
            return this.name - p.name;
        }
    }
    Point point1 = new Point(1,"p");
    Point point2 = new Point(2,"q");
    System.out.println(point1.compare(point2));//null as method is abstract
    System.out.println(point1.compare(point2)) //false if we  override compare()

    
    EG 2(INBUILD CLASS)
    String s1 = "a";
    String s2 = "b";
    s1.compareTo(s2)    //false  as string class overrides compareTo() internally                                                 
    Look in OBJECTS=>COMPARISIONS=>OP
                                                                          
    */

    //COMPARATOR  INTERFACE 
    /*
    1.COMPARATOR INTERFACE
    public abstract interface Comparator<T extends Object>{         -->T can be assigned Object class and its subclass(T is assigned in generic class)                                        
       public abstract int compare(Object  o1,Object o2){}          -->abstract method that needs to be implemented                    
    }  

    2.IMPLEMENT COMPARATOR INTERFACE: COMPARATOR IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  Class  ComparatorClass implements Comparator<C>{   --> ComparatorClass =  class whic we pass as comparatorObject to sort method
                                                                    C = class on which we sort
        @Override                                                          
        public int compare(datatype ele1,dataype ele2){        -->returns int by comparing values and then sorts based on return value
            return ele1 - ele2                                    datatype ele1,datatype ele2= elements of class on which we sort
        }                                                          ele1-ele2  if val1 > val2 eq returns >0 or +1(acc to your code) and method does not swap values; 
    }                                                                         if val1 < val2 eq returns <0 or -1(acc to your code)and method swaps values
                                                                              if val1 ==val2 eq returns 0 and method doesnt swap  
                                                                              val1 - val2  OR val2 - val1                                              --> sort in asc/desc based on values of Integers
                                                                              value1.compare(value2) OR value2.compare(value1)                         --> sort in asc/desc orded based on "lexicographical" values of String
                                                                              a[0] != b[0]) ? a[0] - b[0] :a[1] - b[1]                                  -->sort in ascending order based on 0th index of arrays and if they are same sort in asc order based on 1st index of arrays  
                                                                              map.get(value1) != map.get(value2)) ? map.get(value1) - map.get.(value2):value1- value2   -->sort in ascending order based on value of hashmap and if they are same same sort in asc  based on element                
    }
    ComparatorClass comparatorObject = new ComparatorClass()
    OR
    Comparator<C> comparatorObject = new Comparator<>{                     -->same as above
        @Override
        public int compare(datatype ele1,dataype ele2){                     -->same as above
            return ele1-ele2;
        }
    }     
    OR
    Comparator<C> comparatorObject =                                    -->same as above
        (datatype ele1,dataype ele2)->{return ele1-ele2;}                -->same as above
         |
         |
        LAMBDA FN CAN BE WRITTEN IN 4 WAYS
        1.LAMBDA FN
        Comparator<Animal> comparatorObject = (Animal a1,Animal a2)->{ return a1.name.compateTo(a2.name);}  -->Compare based on name
        
        2.LAMBDA FN + METHOD REFERENCING 
        Comparator<Animal> comparatorObj    = (Animal:: compareName}                                        -->Since Lambda fn is only calling a method we can use method reference as ClassName:methodName
                                                                                                             (write a compareName fn in Animal class--> public int compareName(Animal a1, Animal a2)->{return a1.name.compateTo(a2.name)})
        3.COMPARATOR(LAMBDA FN)
        Comparator<Animal> comparatorObj    = Comparator.comparing((Animal animal) -> animal.name);         -->Compare based on name           
    
        4.COMPARATOR(LAMBDA FN) + METHOD REFERENCING 
        Comparator<Animal> comparatorObj    = Comparator.comparing(Animal::getName)                         ->Since Lambda fn is only calling a method we can use method reference as ClassName:methodName
                                                           |
                                                           |
                                            Comparator.comparing()        -- compare strings
                                            Comparator.comparingInt()     -- compare Integers
                                            Comparator.comparingLong()     --compare Long
                                            Comparator.comparingFloat()     --compare Float
                                            Comparator.comparingDouble()   -- compare Double






    3.CALL METHOD
    C1 c1 = new C1();                                               
    Arrays.sort(arr,startIndex,endIndex)      -->override the compare method in Array internally
    Arrays.sort(arr,comparatorObject)       -->override the compare method in Array class manually(Array datattype must be reference ie Integer[] arr)
    Collections.sort(list)                    -->override the compare method in List class internally
    Collections.sort(list,comparatorObject);  -->override compare method manually
    
    EG1
    class Animal{
        int age;
        String name;
        public Animal(int age, String name){this.val1 = val1, this.val2 = val2;}
        public int getAge(){return age;}   
        public String getName(){return name;}
        public int compareName(Animal a1,Animal a2)(return a1.compareTo(a2);)
    }
    
    public static class comparatorClass implements Comparator<Animal>{
        @Override
        public int compare(Animal a1,Animal a2){
            return a1.val1- a2.val2;
        }
    }
    ComparatorClass comparatorObject = new ComparatorClass();
    OR
    Comparator<Animal> comparatorObject = new Comparator<>(){
        @Override
        public int compare(Animal a1,Animal a2){
        return a1.val1- a2.val2;
        }
    };
    OR
    Comparator<Animal> comparatorObject = (Animal a1,Animal a2)->{ return a1.name.compateTo(a2.name);}  
    Comparator<Animal> comparatorObj    = (Animal:: compareName}                                      
    Comparator<Animal> comparatorObj    = Comparator.comparing((Animal animal) -> animal.name);                 
    Comparator<Animal> comparatorObj    = Comparator.comparing(Animal::getName)                      


    List<Animal> list = new ArrayList<>();list.add(new Animal(5,6));list.add(new Animal(3,4));
    Collections.sort(list,comparatorObject);

    EG2:
    Look in OBJECTS=>SORTING

        



    */
    
    //ITERABLE,ITERATOR INTERFACE KE METHOD  
    /*
    1.ITERABLE,ITERATOR INTERFACE
    public abstract interface Iterable<T >{              -->T can be assigned Object class and its subclass(T is assigned in generic class)                                 
        public Iterator<T>(){ {}                         -->abstract method that needs to be implemented                    
    }  

    2.IMPLEMENT ITERATOR,ITERABLE INTERFACE
    public  Class C implements Iterable<T> {                             -->T can be assigned Object class and its subclass(T is assigned in generic class)          
                                                                            C = class on which we iterate; this = object of class C
        @Override                                            
        public Iterator<T>(){                                            -->returns iterator Obj Current class
            ClassIterator classIteratorObject = new ClassIterator(this);    C = class on which we iterate; this = object of class C                                
            return classIteratorObject;                                     ClassIterator = iterator class of current class;classIteratorObject = object of class ClassIterator
    }                                                
                                                                  
    private class ClassIterator<T> implements Iterator<T > {    -->T can be assigned Object class and its subclass(T is assigned in generic class)                   
        C<T> c;                                                     C = class on which we iterate; c = object of class C
        public ClassIterator(C c){
            this.c = c
        }
        @Override                                                         
        public boolean hasnext(){                                   -->returns true if indexptr has not reahed end of object
            return indexptr < c .size()                               C = class on which we iterate ; c = Object of class c
        }                                                              indexptr = ptr which we move whenwe add ordelete from object 
        @Override                                                  -->return next indexptr of object       
        public T next(){                                              C = class on which we iterate ; c = Object of class c
            return c[indexptr]                                        indexptr = ptr which we move whenwe add ordelete from object
         }                                                             
    }                                                                      


    3. CALL METHOD
    C c = new C();                                                    -->for loop will call hasNext() and next() method in following manner
    for(var i:c){                                                        while(iterator.hasNext()){- When you iterate over your object
                                                                             return next()}            this code runs internally
    }


    EG1(USER DEFINED CLASS)

    public static class ListCustom<T> implements Iterable<T> {
        private T[] items = (T[]) new Object[10];
        private int indexptr;

        public void add(T item) {
            items[indexptr++] = item;
        }

        public T get(int index) {
            return items[indexptr];
        }

        @Override
        public Iterator<T> iterator() {
            return new ListCustomIterator(this);
        }                     
    }                         
                              
    private static class ListCustomIterator<T> implements Iterator<T> {
        private ListCustom<T> listCustom;
        private int indexptr;

        public ListCustomIterator(ListCustom<T> listCustom) {
            this.listCustom = listCustom;
        }

        @Override
        public boolean hasNext() {
            return (indexptr < listCustom.indexptr);
        }

        @Override
        public T next() {
            return listCustom.items[indexptr++];
        }
    }

    ListCustom<Integer> list = new  ListCustom<>();  
    list.add(1);                                              
    list.add(2);
    for(var i : list){  -->We can iterate if we overload iterator()
        sout(i)}           We cant iterate if we dont overload iterator
    
    EG 2(INBUILD)
    List<Integer> list = new ArrayList<>();
    list.add(1); list.add(2);
    for(int i:list){
        sout(i)
    }
 
    */


    //FUNCTIONAL INTERFACES KE METHODS
    /*
    FUNCTION INTERFACE -->Interface Interface with only 1  abstract method 
    Consumer Interface  :Method of the interface takes arg returns no value
    Supplier Interface  :Method of the interface takes no arg and returns value
    Predicate Interface :Method of the interface takes arg and returns Boolean
    Functional Interface:Method of the interface takes argument and returns value	       
        |-UnaryOperatoor :Extends Functuion
        |-Binary Operator: Extends BiFunction

    Comparable and comparator ate also functional interface(Function interface)

    */
    //a.CONSUMER  INTERFACE
    /* 
    1.CONSUMER NTERFACE
    public interface Consumer<T>/ BiConsumer<T,U> /IntConsumer/LongConsumer/ DoubleConsumer {                                                     
        public abstract void accept(T t){}                                                                      
        public default Consumer<T> andThen(Consumer<? super T> after){} 
    }


    2.IMPLEMENT CONSUMER INTERFACE:CONSUMER IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public static class consumerClass implements Consumer<C1>{               -->C1 = input type of Consumer
                                                                                void = ret type of Consume
        @Override                                                
        public void accept(C1 val){                                           -->takes arguements and returns void
            return void;                                                         C1 = input type of Consumer
        }                                                                        void = ret type of Consumer
    }
    consumerClass consumerObj = new consumerClass();
    OR
    Consumer<C1>   consumerObj = new Consumer(){@Override}                     -->same as above
    OR 
    Consumer<C1>            consumerObj  =(C1 arg1)          ->{returns void}  -->same as abopve
    BiConsumer<C1,C1>       consumerObj  =(C1 arg1, C1 arg2) ->{returns void}     
    Int/Long/DoubleConsumer consumerObj  =(i/l/d arg1)       ->{returns void}
    
    3.CALL METHODS  
    consumerObj.accept(value)                                                   --> call the accept method which  pass the value to arg of function
    consumerObj1.andThen(consumerObj2).andThen(consumerObj) apply(value)        -->call the  andThen method which chains consumerOjects1 -->consumerOjects2


    EG
    Consumer<String> print = (String i) -> { System.out.println(i); };
    Consumer<String> printToUpperCase = (String i)->{ System.out.println(i.toUpperCase()); }
    Consumer<String> printToLowerCase = (String i) -> { System.out.println(i.toLowerCase());};

    print.accept("p") //p
    print.andThen(printToUpperCase).andThen(printToLowerCase).apply("p") //p P p
    */
    //b. SUPPLIER  INTERFACE
    /* 
    1.SUPPLIER INTERFACE
    public interface supplier<T>/IntSupplier/Longsupplier/DoubleSupplier/Booleansupplier{
        public abstract  T  get()      }

    2.IMPLEMENT SUPPLIER INTERFACE:SUPPLIER IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  class SupplierClass implements supplier<C1>{                                  -->void = input type of Supplier
                                                                                              C2 = return type of Supplier
        @Override
        public C2 get(){                                                                    -->takes no arguements and returns value
            return val;                                                                        void = input type of Supplier
        }                                                                                       C2 = return type of Supplier
    }
    SupplierClass supplierObject = new SupplierClass();
    OR
    SupplierClass<C1> supplierObject = new SupplierClass(){{@Overide..}                       -->same as above
    OR
    Supplier<C1>                    supplierObj  =(no arg) ->{returns value}                   -->same as above
    Int/Long/Double/BooleanSupplier supplierObj  =(no arg) ->{returns value of type i/l/d/b}      

    3.CALL METHODS
    supplierObj.get()                                                                          --> call the get method which gets the return value from function

    EG
    Supplier<Double> generateRandom = () ->{ return Math.random();};
    int b = generateRandom.get();
    System.out.println(b);  //1.11

    */
    //c. PREDICATE INTERFACE
    /*
    1.PREDICATE INTERFACE

    Public  interface Predicate<T>/ Bipredicate<T,U> /IntPredicate/ LongPredicate / DoublePredicate {                      
        public abstract boolean Test(T t );
        public default Predicate<T> and(Predicate<? super T> other){}
        public default Predicate<T> or(Predicate<? super T> other){}
        public default Predicate<T> isEqual(Object targetRef){}
        public default Predicate<T> negate(){}
    }

    2.IMPLEMENT PREDICATE INTERFACE:PREDICARE IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  class PredicateClass implements Predicate<C1>{                                         -->C1 = input type of Predicate
                                                                                                       boolean = return type of Predicate
        @Override
        public boolean Test(C1 c1){                                                                -->takes  arguements and returns booleanvalue
            return T/F;                                                                               C1 = input type of Supplier
        }                                                                                             boolean = return type of Predicate
    }
    PredicateClass predicateObject = new PredicateClass();
    OR
    Predicate<C1> predicateObject = new Predicate<>(){@Overide..}                                     -->same as above
    OR
    Predicate<C1>                   predicateObj  =(C1 arg1)         ->{returns value of type boolean} -->same as above
    BiPredicate<C1,C1>              predicateObj  =(C1 arg1,C1 arg2) ->{returns value of type boolean}     
    Int/Long/Double/BooleanPredicate predicateObj =(i/l/d/b arg1)    ->{returns value of type boolean}         

    3.CALL METHODS
    predicateObj.test(val)                                                                              --> call the test method which passes val to  arg of fn and gets return value from function
    predicateObj1.and(predicateObj2).and(predicateObj2).test(value)                                     -->call the and method which chains consumer consumerojects1 && consumerojects2
    predicateObj1.or(predicateObj2).or(predicateObj2).test(value)                                       -->call the or method which chains consumer consumerojects1 || consumerojects2
    predicateObj1.isEqual(predicateObj2).test(value)                                                    -->call the isEqual method which chains consumer consumerojects1 == consumerojects2
    predicateObj1.or(predicateObj2).or(predicateObj2).test(value)                                       -->call the negate which chains consumer !consumerojects1()
    predicateObj1.negate()
    
    EG
    Predicate<Integer> isPositive = (Integer i) -> {return i > 0;};
    Predicate<Integer> isGreaterThan10 = (Integer i) -> {return i > 10;};
    Predicate<Integer> isGreaterThan100 = (Integer i) -> {return i > 100;};
    
    boolean a = isPositive.test(5); //true
    boolean b = isPositive.and(isGreaterThan10).and(isGreaterThan100).test(200); //true
    boolean c = isPositive.or(isGreaterThan10).or(isGreaterThan100).test(200); //true
    boolean d = isPositive.negate().test(100); //false

    */
    //d.FUNCTION INTERFACE
    /*
    1.FUNCTION INTERFACE
    public interface Function<T,R>/ IntFunctionr<T>/LongFunctionr<T>/DoubleFunction<R>/ToIntFunction<T>/ToLongFunction<T>/ToDoubleFunction<T>{
        public abstract R  apply(T t)                                                                             
        public default<V> andThen(Function<? super R,? extends V> after)
        public default <V> Function<V,R> compose(Function<? super V,? extends T> before)
        public  static <T> Function<T,T> identity()
    }

    2.IMPLEMENT FUNCTION INTERFACE:FUNCTION IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  class FunctionClass implements Function<C1>{                                        -->C1 = input type of Functiom
                                                                                                  C2 = return type of Function
        @Override
        public C2 apply(C1 c1){                                                                   -->takes  arguements and returns value
            return val ;                                                                             C1 = input type of Function
        }                                                                                            C2 = return type of Function
    }
    FunctionClass functionObject = new FunctionClass();
    OR
    FunctionClass<C1> functionObject = new FunctionClass<>(){@Overide..}                            -->same as above
    OR
    Function<C1>            functionObject  =(C1 arg1)         ->{returns value }                   -->same as above
    BiFunction<C1,C2>       functionObject  =(C1 arg1,C2 arg2) ->{returns value}                   
    Int/Long/DoubleFunction functionObject  =(i/l/d arg)       ->{returns value}
    ToInt/ToLong/ToDoubleFunction functionObject  =(i/l/d arg) ->{returns value of type i/l/d}         



    3.CALL METHOD
    functionObject.apply(val)                                                                  --> call the apply method which passes val to arg of fn and gets return value from function
    functionObject1.andThen(functionObject2).andThen(functionObject3).apply(value)             -->call the  andThen method which chains functionObject1 -->functionObject2
    functionObject1.compose(functionObject2).compose(functionObject3).apply(value)             -->call the  compose method which chains functionObject1 -->functionObject2


    EG1
    Function<String,String> replaceColon = (String s) -> {return s.replace(":","=");};
    Function<String,String> addBraces  = (String s) ->{return "{" + s + "}";};

    String s1 = replaceColon.apply("pras:patil") //"pras=pat"
    String s2 = replaceColon.andThen(addBraces).apply("pras:patil"); //"{pras=pat}"
    String s3 = replaceColon.andThen(addBraces).apply("pras:patil"); //"{pras=pat}"
    var s = replaceColon.compose(addBraces).apply("key=value");
    */
    //d.I UNARYOPERATOR INTERFACE
    /*
    1.UNARYOPERATOR INTERFACE
    public interface UnaryOperator<T>/ IntUnaryOperator/ LongUnaryOperator /DoubletUnaryOperator   extends Function<T,R> {
        public abstract R  apply(T t)                                                                             
        public default<V> andThen(Function<? super R,? extends V> after)
        public default <V> Function<V,R> compose(Function<? super V,? extends T> before)
    }


    2.IMPLEMENT UNARYOPERATOR INTERFACE :UNARYOPERATOR IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  class UnaryOperatorClass implements UnaryOperator<C1>{                               -->C1 = input type of UnaryOperator
                                                                                                  C2 = return type of UnaryOperator
        @Override
        public C2 apply(C1 c1){                                                                   -->takes  arguements and returns value
            return val ;                                                                             C1 = input type of UnaryOperator
        }                                                                                            C2 = return type of UnaryOperator
    }
    UnaryOperatorClass unaryOperatorObject = new UnaryOperatorClass();
    OR
    UnaryOperator<C1> unaryOperatorObject = new UnaryOperator<>(){@Overide..}                 -->same as above
    OR
    UnaryOperator<C1>            unaryOpetoorObjectObject  =(C1 arg1)     ->{returns value }    -->Same as above
    Int/Long/DoubleUnaryOperator unaryOpetoorObjectObject  =(i/l/d arg)   ->{returns value}        

    3.CALL METHOD
    unaryOpetoorObjectObject.apply(val)                                                   --> call the apply method which passes val to arg of fn and gets return value from function
    unaryOpetoorObjectObjec1.andThen(unaryOpetoorObjectObject2).apply(value)              -->call the  andThen method which chains unaryOpetoorObjectObject1 -->unaryOpetoorObjectObject2
    unaryOpetoorObjectObject.compose(unaryOpetoorObjectObject)apply(value)                -->call the  compose method which chains unaryOpetoorObjectObject1 -->unaryOpetoorObjectObject2


    EG
    UnaryOperator<Integer> square = (Integer a)->{return a*a;};
    UnaryOperator<Integer> increment = (Integer a) ->{return a+1;};

    int a = square.apply(2)// 4
    var b = square.andThen(increment).apply(3); //10  
    */
    //d.II BINARYOPERATOR INTERFACE
    /*
    1.BINARYOPERATOR INTERFACE
    public interface BinaryOperator<T,U> IntBinaryOperator / LongOperator/ DoubleOperator      extends BiFunction<T,U,R>{
        public abstract R  apply(T t , U,u ) 
        public default<V> andThen(Function<? super R,? extends V> after)}

    2.IMPLEMENT BINARYOPERATOR: BINARY OPERATOR IS A FUNCTIONAL INTERFACE(ONLY 1 ABSTRACT METHOD) SO IT CAN BE IMPLEMENTED  BY NORMAL ,ANONYMOUS INNER CLASS ,LAMBDA FN]
    public  class BinaryOperatorClass implements BinaryOperator<C1,C1>{                           -->C1 = input type of Functiom
                                                                                                    C2 = return type of Function
        @Override
        public C2 apply(C1 c1){                                                                   -->takes  arguements and returns value
            return val ;                                                                             C1 = input type of Supplier
        }                                                                                            C2 = return type of Function
    }
    BinaryOperatorClass binaryperatorObject = new BinaryOperatorClass();
    OR
    BinaryOperatorClass<C1> binaryperatorObject = new BinaryOperatorClass<>(){@Overide..}         -->same as above   
    
    BinaryOperator<C1,C2>         binaryOpetorObject  =(C1 arg1,C1 arg2)        ->{returns value } -->Same as above
    Int/Long/DoubleBinaryOperator binaryOpetorObject  =(i/l/d arg1,i/l/d arg2)  ->{returns value}      

    3.CALL METHODS
    binaryOpetoorObjectObject.apply(val)                                                           --> call the apply method which passes val to arg of fn and gets return value from function
    binaryOpetoorObjectObject1.andThen(binaryOpetoorObjectObject2).apply(value)                    -->call the  andThen method which chains binaryOpetoorObjectObject1 -->binaryOpetoorObjectObject2
    binaryOpetoorObjectObject1.compose(binaryOpetoorObjectObject2)apply(value)                     -->call the  compose method which chains binaryOpetoorObjectObject1 -->binaryOpetoorObjectObject2



    EG
    BinaryOperator<Integer,Integer> add =  (Integer a,Integer b) ->{return a+b;};
    int a = add.apply(2,3)// 5
    
    */

    //STREAMS --> To replace imperative by functional/Declaratove
    //a.CREATING STREAM
    /*
    Arrays.stream(arrayobject)                  --> returns a Stream<elements of array>
    Collectionobject.stream()                   --> returns a Stream<elements of collection> 
    Stream.of(obj1,obj2..)                      --> returns a Stream <objects>
    Stream.generate(SupplierObj)                 -->returns stream<elements returned by Supplier Object> infinitely                                                                                                                                                                                                                                      
    IntStream.range(start,end  not included)     --> returs Stream<Integer> of integers in range
    LongStream.range(start,end  not included)    --> returs Stream<Long> of Long in range
    DoubleStream.range(start,end  not included)   --> returs Stream<Double> of Double in range
    */
    //b.METHOD OF STREAM
    /*      
    List<Animal> animallist = List.of(new Animal(size:1,height:10,name:"A")  ,new Animal(size:2, height20, ,name:"B")    )
    animallist.stream () --comparatorObject    :LOOK in COMPARATOR  INTERFACE  
            .slicer   ()   predictaeObject     :LOOK iN PREDICATE INTERFCE                       
            .selector ()   supplierObject      :LOOK IN SUPPLIER INTERFACE               
            .reducer  ()   functionObject      :LOOK IN FUNCTION INTERFACE
            .terminals()   unaryOperatorObject :LOOK IN UNARY OPERATOR INTERFACE
            .collector()   binaryOperaterObject:LOOK IN BINARYOPERATOR INTERFACE
                       
                       
                       
                       
    1.SLICERS
    limit(int n)                        -->take n and
                                           returns stream<Animal> by limiting upto  1st n elements 
    skip(int n)                         -->take n and 
                                          returns stream<Animal> by skipping 1st n elements  
    takewhile(predicateObject )         -->take predicate object which takes arg and returns boolean 
                                          returns Stream<Animal> by applying predicate fn on each element and  take stream elements only while fn returns True
    dropWhile(predicateObject)           -->take predicate object which takes arg and returns boolean 
                                           returns Stream<Animal> by applying predicate fn on each element and  take stream elements only while fn returns False


    2.SELECTORS
    filter(predicateObject)             -->take predicate object which takes arg and returns boolean 
                                           return   stream <Animal>  by applying predicate fn on each element and  filter stream elements for  only true values returned by fn
    map(functionObject)                 -->take function object which takes arg and returns value 
                                           return stream <Animal> by applting function on each object
    mapToInt/ToLong/ToDouble(fnObj)     -->take function object which takes arg and returns int/long/double
                                           return stream <Animal> by applting function on each object
    sort(comparatorObject )             -->take  comparator object which takes arg and returns sorted value
                                          return Stream<Animal> by sorting acc to comparatorObject
    distinct()                           --> take nothing                                                                                  
                                           return  stream <Animal> with only distinct values

    3.REDUCERS-->Reduce stream to somehing 
    reduce(binaryOpetatorObject).get()  -->take binaryOperator object which takes 2 arg and returns value  
                                           return single value by applying  binaryOperator on 2 elements and then their result and 3rd eleme
    anyMatch(predicateObject)           -->take predicate object which takes arg and returns boolean  
                                           return  boolean  by applying predicate fn on each element and if any values returned by fn is True then return T 
    allMatch(predicateObject)           -->take predicate object which takes arg and returns boolean 
                                           return  boolean  by applying predicate fn on each element and if all values returned by fn is True then return T 
    NoneMatch(predicateObject)          -->take predicate object which takes arg and returns boolean  
                                           return  boolean  by applying predicate fn on each element and if No values returned by fn is True then return T
    findFirst().get()                   -->takes nothing 
                                          returns  1st Animal 
    findAny().get()                     -->takes nothing 
                                           returns any Animal 
    max/min(comparatorObject).get()     -->take binaryOperator object which takes 2 arg and returns value 
                                           returns max/min value                                                               
    Count()                             -->takes nothing
                                            returns count of stream

    4.TERMINALS -->Print stream on terminals
    forEach(consumerObject)             -->take consumer object which takes arg and returns no value
                                           returns no value by applying consumer function on each element  
                                           Hence usually we write sout(ele) which will print elements of stream on terminal
    peek(consumerObject)                -->take consumer object which takes arg and returns no value
                                           returns no value by applying consumer function on each element  
                                           Hence usually we write sout(ele) ; butunlike forEach it doesnt print on  Terminal and   can be used in middle and not necessarily at end as terminal


    5.COLLECTORS-->Collect stream in a Collection
    collector<Collectors.tolist()>                  -->take nothing 
                                                       return List<Animal>
    collector<Collectors.toset()>                   -->take nothing 
                                                        return Set<Animal>
    collector<Collectors.tomap(fnObj1,fnObj2)>      -->take fnObj1 which takes arg and returns value
                                                       return  Map<Animal,Animal> where key = value returned by fnobj1 and value = value returned by fnObje
    collector<Collectors.summingInt (fnObj)  >      -->take fnObj1 which takes arg and returns value
                                                       return int/long/double by applying fnObject on each elemeny and finding sum all elements 
    collector<Collectors.sumarizingInt(fnObj)      -->take fnObj1 which takes arg and returns value 
                                                       return Int/Long/DoubleSummaryStatisticsSummary{count , sum , min , avg} by applying fnObject on each element  
    collector<Collectors.joining(delimeter:"" ) )>  -->takes nothing                                                       
                                                      return string by joining the Strings in stream  seperated by delimeter,


    EG
    0.CREATE STREAMS
    Collection/List<Integer> collection  = new ArrayList<>();     
    Stream<Integer>  stream = collection.stream();                             //return stream<Integer>

    int[] array = {1,2,3,4};
    Stream<Integer> stream =     Arrays.stream(array);                        //return stream<Integer>

    Stream<Integer> stream1 = Stream.of(1,2,3,4,5);                          //return stream <Integer>
    Stream<Double> stream2 = Stream.generate(()->{return Math.random();});  //return stream<Double>
    Stream<Integer>  stream3 = Stream.iterate(1,(int n)->{return n+1;});    //return stream<Integer>

    IntStream a = IntStream.range(1,5);// returns IntStream 1 2 3 4
    IntStream b = IntStream.rangeClosed(1,5);// returns IntStream 1 2 3 4 5

    List<Animal> animallist = List.of(new Animal(size:1,height:10,name:"A") ,
                                      new Animal(size:2, height20, ,name:"B") ,
                                      new Animal(size:3, height:30, ,name:"C")
                                      )

    1.SLICERS
    //print the height of  3nd, 4th  animal animal
    animallist.stream()                                             // return stream<Animal>
            .skip(2)                                               // skip 1st  2 animal                                          
            .limit(4)                                              //take 1st 4 animals                              
            .map((Animal animal) ->{return animal.getHeight();})  //return stream<int>
            .forEach((Integer a) ->{ System.out.println(a); });  // return void

    2.SELECORS
    //return   the count of animals whose height > 10
    var a = animallist.stream().                                           //return stream<Animal>
                    .filter( (Animal animal)->{animal.getHeight()>10;}  ) //return stream<int>
                    .count();                                            //return int

    //print  the height of animals
    animallist.stream()                                                      // return stream<Animal>
            .map((Animal animal) ->{return animal.getHeight();} )           //return stream<int>
            .forEach((Integer integer) -> {System.out.println(integer);}); //return void


    //print animal mame sorted by their name  ; print animal mame sorted by their  height
    animallist.stream()                                                                                              //return stream<Animal>
            .sorted((Animal animal1 , Animal animal2)->{return (animal1.getName()).compareTo(animal2.getName()) ;}) //return stream<Animal>
         OR .sorted(Comparator.comparing(Animal::getName)) 
            .forEach((Animal animal) -> { System.out.println(animal.getName());                                     //return void

    animallist.stream()                                                                                          //return stream<Animal>
            .sorted((Animal animal1 , Animal animal2)  ->{return animal1.getHeight() - animal2.getHeight();} )  // return stream<Animal>
         OR .sorted(Comparator.comparingInt(Animal::getHeight))
            .forEach((Animal animal) ->{ System.out.println(animal.getName()); });                               // return void


    //print unique animal name
    animallist.stream()                                       	  //return stream<Animal>
            .map((Animal animal) -> {return animal.getName();})   //return stream<String>
            .distinct()                                           //return stream<String>
            .forEach((String s) -> { System.out.println(s); });   //return void 

    3.REDUCERS
    //return T  if any  Animal has height > 10 ,  all animals ht  10 , none animals have ht > 10
    boolean a  = animallist.stream()                                             //return stream<Animal>
                .anyMatch((Animal animal) ->{return animal.getHeight() > 10;});  //return boolean

    boolean a  = animallist.stream()                                              //return stream<Animal>
                .allMatch((Animal animal) ->{return animal.getHeight() > 10;});  //return boolean

    boolean a  = animallist.stream()                                             //return stream<Animal>
                .NoneMatch((Animal animal) ->{return animal.getHeight() > 10;}); //return boolean



    //return 1st  animal , any  animal 
    Animal a  = animallist.stream()         //return stream<Animal>
                .findFirst().get()          //return Animal
    

    Animal a  = animallist.stream()        //return stream<Animal>
                .findAny().get()           //return Animal
                .get();                 

    //reduce Animal acc to ht ie [1,2,3] ->[1+2+3]  
    Integer a  = animallist.stream()                                                  //return stream<Animal>                                        
                .map((Animal animal) ->{return animal.getHeight();})                  //return stream<Integer>
                .reduce((Integer ht1,Integer ht2) ->{return (ht1+ht2)  ; }).get();    //return int

    //return Animal with max ht , return animal with min ht , count f animimal with ht > 10
    Animal a  = animallist.stream()                                        //stream<Animal>
                .max(Comparator.comparingInt(Animal::getHeight)).get()     //return Animal


    Animal a  = animallist.stream()                                       //return Stream<Animal>
                .min(Comparator.comparingInt(Animal::getHeight)).get()    //return Animal                                                                     


    Int a  = animallist.stream()                                             //return stream<Animal>
                .filter((Animal animal)->{return animal.getheight() >10})    //retirn stream<Animal>
                .count()                                                    //return int


    //Print animals whose ht > 10
    animallist.stream()                                                                        //return stream<Animal>
            .filter((Animal animal)->{return animal.getHeight() <10;} )                       //return stream<Animal>
            .map((Animal animal) -> {return animal.getName();})                               //return stream<String>
            .forEach((String s) -> { System.out.println(s); });                              //return void

    //print  animals whose height > 10 and at each step write the procedure
    animallist.stream()                                                                           	     
            .filter((Animal animal)->{return animal.getHeight() <10;} )                                   //return stream<Animal>
            .peek((Animal animal) ->{ System.out.println("filter executed on " + animal.getHeight()); }) //return void
            .map((Animal animal) -> {return animal.getName();})                                          //return Stream<Strings>
            .peek((String s )->{ System.out.println("map executed"+ s); })//Consumer<? Super String>     //return void
            .forEach((String s) -> { System.out.println(s); });//Consumer<? extends String>              //return void


    5.COLLECTORS
    //return a list of ht , set of ht and map of name:ht
    List<Integer> a  = animallist.stream()                                 //return Stream<Animal>
                .map((Animal animal) ->{return animal.getHeight();})      //return Stream<Integer>
                .collect(Collectors.toList());                            //return List<Integer>

    Set<Integer> a  = animallist.stream()                                    //return Stream<Animal>
                .map((Animal animal) ->{return animal.getHeight();})        //return Stream<Integer>
                .collect(Collectors.toSet());                              //return Set<height>
    

    Map<String,Integer> map = animallist. stream()                                                                                    //return stream<Animal>
                            .collect(Collectors.toMap((Animal a) ->{return a.getName();}, (Animal a) ->{return a.getHeight();}) );   //return Map<String(name),Integer(height)>


    //return the sum of height of Animal                                                                                                            
    int sumheight = animallist.stream()                                                                        //return Stream<Animal>
                            .collect(Collectors.summingInt((Animal animal)->{return animal.getHeight();} )) ; //return int 
    
    //return count , sum , min ,max of  height in  stream
    IntSummaryStatistics  sumary = animallist.stream()                                                                            //return stream<Animal>
                                            .collect(Collectors.summarizingInt((Animal animal)->{return animal.getHeight();} )) ;//return IntSummaryStatistics = IntSummaryStatistics


    //Return string by joining  all the names of Animal 
    String s= animallist.stream()                                              //return Stream<Animal>
            .map((Animal animal) -> {return   animal.getName() ;} )           //return Stream<String>
            .collect(Collectors.joining(", "));                               //return String


    */

/* #endregion */


//OBJECT  
/* #region Main */

//( 
    //DECLARATION 
    /*
    Reftype varname = new ObbjectType()                        --> Reftype can take its subclasses or implements classes
    var varname = new Objecttype();                            --> var can be used as reference type and Java compiler decides reference type
    */
    //DATATYES(DATATYPE OPERATION)
    /*
    var a = obj
    if( a.getClass().getName().equals("ClassName"){
            CLASSNAME
            b/s/i/l/f/d a = 1                       --> No class available for primitive
            B/S/I/L/F/D  a = 1                      -->java.lang.Byte/Short/Integer/Long/Float/Double
            char ch = 'c'                           --> No class available for primitive 
            Character Ch = 'c'                      --> java.lang.Character ------------------
            String s = "abc"                        --> java.lang.String                    |
            StringBuffer sb = new StringBuffer("a") -->java.lang.StringBuffer               |
            int[] a = new int[]{1,2,3}              -->java.lang.Array                      |
            List<Integer> list = new ArrayList<>()  -->java.util.ArrayList                  |
            List<Integer> ll   = new LinkedList<>() -->java.util.LinkedList                 |
            List<Integer> stack = new Stack<>()     -->java.util.Stack                      |
            Deque<Integer> queue = new ArrayDeque<>()-->java.util.ArrayDeque                |
            Queue<Integer> pq = new PriorityQueue<>()-->java.util.PriorityQueue             |
            Map<Integer,Integer> map = new Hashmap<>()-->java.util.HashMap                  |
            Set<Integer> set = new HashSet<>         --java.util.HashSet                    |
                                                                                            |
                                                                char ch= 'c'--> this can be letter or a digit
                                                                Character.isLetter(ch)
                                                                Character.isDigit(ch)
                                                                Character.isLetterOrDigit(ch)
                                                                EG
                                                                String s = "a1b2"
                                                                if( Character.isLetter(s.getCharAt(0)))
    */
    //CONVERSION(CONVERSION OPERATION)
    /*



            1.DECLARATION
            byte/short/int/long/float/double     a = 1    --1 taken as int ; 1.11 taken as double;7/3 takn as int by truncating decimale
            Byte/Short/Integer/Long/Float/Double a = 1    --converted internaly
            char                                 ch = 'a' 
            Character                            Ch = 'a' --converted internally
            String                               s  = "abc"'
            StringBuffer                         sb = new StringBuffer("abc")   --not converted internally              
                                                                                       
            
            2.CONVERSION                    
            byte/short/int/long/float/double     i2 = (byte/short/int/long/float/double) i1        -->within primitive(LOWER TO HIGHER DONE INTERNALLY)
            Byte/Short/Integer/Long/Float/Double I2 = (Byte/Short/Integer/Long/Float/Double)I1     -->within reference(LOWER TO HIGHER DONE INTERNALLY)
            byte/short/int/long/float/double     i = (byte/short/int/long/float/double) I          -->reference to primitive(CONVERSION DONE INTERNALLY)
            Byte/Short/Integer/Long/Float/Double I = new Byte/Short/Integer/Long/Float/Double(i)   -->primitive to reference(CONVERSION DONE INTERNLLY)
            Character                            C  = new Character(ch);                           -->primitive to reference(CONVERSION DONE INTERNLLY) 
            char                                 ch  = (char) C                                    -->reference to primitive(CONVERSION DONE INTERNALLY)
            StringBuffer                         sb = new STringBuffer(s)                          -->reference to reference(CONVERSION "NOT" DONE INTERNLLY) 
            String                               s  = sb.toString()                                -->reference to reference(CONVERSION "NOT" DONE INTERNALLY)
                                                                                                    EG:List<Integer> list  = new ArrayList<>();
                                                                                                        list.add(1); --int converted to Integer internally
                                                                                                        int a = list.get(0) --Integer converted to int internally
                                                                                                        list.get(0) == list.get(1) --Integer converted to int internally
                                                                                                        Integer a = 22 --int converted to Integer internally
            3.LOSSY CONVERSIONS
            Converting higher to lower is lossy
            EG
            public calculate(long n){
                int b = (int)n  --> For long<= Integer.MIN_VALUE and long >= Integer.MAX_VALUE there will be lossy conversion
            }

            4.OVERFLOW 
            INTEGER
            Integer.MINVALUE = -2^31 = -2147483648
            Integer.MIN_VALUE = 2^31 - 1 = 2147483647 
            Integer.MINVALUE -1 = Integer.MAX_VALUE ; Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
            Integer.MIN_VALUE *- 1 = Integer.MIN_VALUE; Integer.MIN_VALUE/(-1) = Integer.MIN_VALUE  (because +2^31 doesnt exists its 2^31-1)


            CHARACTER-->https://www.w3schools.com/charsets/ref_html_ascii.asp
            'A' = 65 'Z' = 90
            'a' = 97 'z' = 122
            ''= 0    'some question mark' = 126
            Character.MIN_VALUE = '' = 0 ;    
            Character.MAX_VALUE 'some question mark' = 126  
            
            5.FNS
            Math.max(a,b)      --takes int returns int
            Math.min(a,b)      --takes int , returns int
            Math.random()      --returns random double value bw 0(incl) ,1(excl)  
            Math.abs(a)        --takes int/long ;return int
            Maths.ceil(a)      --takes double;return int
            Maths.floor(a)     --takes double;return int
            Math.pow(a,b)      --takes double;return double
            Math.sqrt(a)       --takes double;return double
    |-------Math.log(a)        --takes int /long;return double
    |                            Math.log(a)   --base e(default) gives precision issue
    |                            Math.log10(a)  -- base 10 doesnt give precision issue
    |                            EG:numberIsAPowerOf2(),numberIsAPowerOf3(),numberIsWhatPowerOf2()
    |    
    |
    | 
    |                                                                                                             
    |           i+""                                                                                              Reference Type (Integer[] arr = new Integer[];) 
    |         String.valueOf(i)	                                                                                  List<datatype> list = new ArrayList(Arrays.asList(arr))-->Arrays.asList(arr) returns view list ie mutable list whose change affects  array; new ArrayList returns normal list ie mutable and changes doesnt affect arr
    |        Integer.toString(i)**                               s.toCharArry()                                   List<datatype> list = new ArrayList(List.of(arr))       -->List.of(arr)      returns copy list ie immutable list whose change doesnt affect arr; new ArrayList returns normal list ie mutable and changes doesnt affect arr
    Int-------------------------------------->String   -------------------------------------------------> Array   ---------------------------------------------------------->-ArrayList
    | <-------------------------------------           <---------------------------------------------------        Primitive Type (int[] arr = new int[])                                                                                                                      
    |       Integer.parseInt(s)**             |             Arrays.toString(arr) -->"[a,b,c]"                      for(datatype i: arr){list.add(i)}
    |                     Charater.totring(ch)|             String.valueOf(arr)-->"abc" as an iterable            
    |                     String.valueOf(ch)  |             String.join(delimeter , iterator)  ->"abc"             
    |                     "" + ch             |             Eg String.join("" , [1,2,3,4]) – 1234     
    |       (char) i                          |                                                                     Reference Type (Integer[] arr = new Integer[])
    |------------------------------------> Char                                                                     datatype [] arr = var.toArray(new datatype[var.size()])
    |  <----------------------------------(char,int values = look above)                                            datatype [] arr  = (datatype[] )var.toArray()
    |       (int) c                                                                                                <--------------------------------------------------------ArrayList,Stack,Queue
    |                                                                                                                Primitive Type (int[] arr = new int[])       
    |                                                                                                                datatype[] arr = new int[list.size()]
    |                                                                                                                for(datatype i:arr ) {arr[index++] = list.get(i)}
    |                                                                                                             
    |                                                                                                              <--------------------------------------------------------ArrayList,Stack,Queue     
    |      Integer.toBinaryString(i)**                                                                                String s = var.toString()                         
    |------------------------------------->Bin                                                                       **toArray() , toSTring() of these classes aare overloaded
    |<-----------------------------------                                                                               for custom class you need to overload these methods
           Integer.parseInt(binaryString,2)**
 


    **means like integer do same for byte,short,int ,long, float,double
    */
    //COMPARISION(COMPARISION OPERATION)
    /*
    
    //COMPARISION OPERATOR
    PRIMITIVE : ==,<=,+=,!=               -->Compare values                         ** = is assignment operator           
    REFERENCE : ==;equals() compareTo()  -->compare referenc;compare values 
                                            EG
                                            i1 == <= , >=  ;!=  i2  -- return boolean by comparing  value of integers 
                                            I1 == <= , >=  ;!=  I2  -- return boolean by comparing  value of Integers (reference type are internally converted to primitive)
                                            
                                            c1  == < , >  ;!= c2  -- return boolean by comparing  value of integer equiovalent of charscters(ASCII)
                                            C1  == < , >  ;!= C2  -- return boolean by comparing  value of integer equiovalent of charscters(ASCII) (reference type are internally converted to primitive)
                                                                     Eg:c1 = '1' , c2 = '2' --> c1 < c2 -- true
                                                                        c1 = 'a' , c2 = 'b' --> c1 < c2 --> true  


                                            s1 == s2               -->return boolean by  comparing  reference  of s1 and s2 
                                            s1.equals(s2)          -->return boolean by  comparing  value of s1 and s2 
                                            s1.compareTo(s2) ><=0  --> return int(>0,<0,=0)by compare value of s1 and s2  lexicographically  
                                                                      Eg: s1 ="42", s2 = "2277"   --> s1 > s2 -- true
                                                                          s1 = "amm" s2 = 'c'     --> s1 < s2 -- true
                                                                          s1 = "car"  s2 = s1     --> s1 == s2 -- true
                                            
                                            sb1 == sb2                                    -->return boolean by  comparing  reference  of s1 and s2 
                                            sb1.toString().equals(sb2.toString())         -->return boolean by  comparing  value of sb1 and sb2 
                                            sb1.toString().compareTo(sb2.toString()) ><=0 --> return int(>0,<0,=0)by compare value of sb1 and sb2  lexicographically  
                                            
                                            
                                            arr1 == arr2             -->return boolean by  comparing  reference  of  arr1,arr2
                                            Arrays.equals(arr1,arr2) --> returns boolean by comparing contents of arr1,arr2
                                            

                                            list1== list2            -->return boolean by  comparing  reference  of list1,list2
                                            list1.equals(list2)       -->returns boolean by comparing contents of list1,list2
                                            
                                            ll1== ll2                -->return boolean by  comparing  reference of linkedList1,linkedList2
                                            ll1.equals(ll2)          -->returns boolean by comparing contents of linkedList1,linkedList1
                                            
                                            stack1== stack2         -->return boolean by  comparing  reference of stack1,stack2
                                            stack1.equals(stack2)   -->returns boolean by comparing contents of stack1,stack2

                                            ad1== ad2               -->return boolean by  comparing  reference of arraydeque1,arraydeque2
                                            ad1.equals(ad2)         -->returns boolean by comparing contents of arraydeque1,arraydeque2

                                            pq1 = pq2               -->return boolean by  comparing  reference of priorityqueue1,priorityqueue2
                                            pq1.equals(pq2)         -->returns boolean by comparing contents of priorityqueue1,priorityqueue2

                                            hm1 = hm2              -->return boolean by  comparing  reference of hashmap1,hashmap2
                                            hm1.equals(hm2)        -->returns boolean by comparing contents of hashmap1,hashmap2
                                            
                                            hs1 = hs2              -->return boolean by  comparing  reference  of hashset1,hashset2
                                            hs1.equals(hs2)        -->returns boolean by comparing contents of hashset1,hashset2

                                            Dog d1 = new Dog(1,2,3);
                                            Dog d2 = new Dog(1,2,3);
                                            Dog d3 = new Dog(4,5,6);
                                            d3 = d2
                                            d1 == d2 --> False as  both reference different objects
                                            d2 == d3 -->True as both referennce same objects
                                            d1.equals(d2) -->True as bth object have same value(Override equals in dog class)
                                            d1.equals(d3)--> false as both object hve different value(Override equals in dog class)


                                                                                                                                    
    */
    //ARITHMETIC(ARITHMETIC OPERATION, BITWISE OPERATION )
    /*        
    //ARITHMETIC OP 
    2+3 = 00..0010 + 00..0011 = 00..0010 = 2             
    3-2 = 00..0011 - 00..0011 = 00..0001 = 1              
    2*3 = 00..0010 * 00..0011 = 00..0010 = 6  
    2/3 = 00..0010 / 00..0011 = 00..0010 = 0 (FLOOR(QUOTIENT))
    2%3 = 00..0010 / 00..0011 = 00..0010 = 0 (REMAINDER)
           (32 bit )                       -->INT TO BIN  
                                            2 = 000000000000000000000000000000010   
                                            -2 = 11111111111111111111111111111110 (2 ka 2's comp = 2 ka 1's comp + 1)
                                            (int(Java) :signed integers format(-2^31 to 2^31-1) ; not unsigned integers format(0 to 2^64) 
                                            bin(Java) :32 bits binary for

                                            OPERATION
                                            + -- 0 + 0 = 0; 0 + 1 = 1 ;1 + 0 = 1 ; 1 + 1 = 0 carry 1 
                                            - -- 0 - 0 = 0; 0 - 1 = 1 borrow 1 ; 1 - 0 = 0 ; 1 - 1 = 0 
                                            * -- 0 * 0 = 0; 0 * 1 = 1 ;1 * 0 = 0 ; 1 * 1 = 1 
                                            / --  0 / 0 = nd; 0 / 1 = 0 ;1 / 0 = nd ; 1 / 1 = 1 


          
    x++  = (x = x +1 ; x += x ; x++ ; ++x  )

    //BITWISE OP 
    2&3  = 00..0010 & 00..0011  = 00..0010  = 2 
    2|3  = 00..0010 | 00..0011  = 00..0011  = 3                           
    2^3  = 00..0010 ^ 00..0011  = 00..0011  = 3  
    ~2   = ~00..0010            = 11..1101  =-3   
    9<<2 = 00..1001 << 2        = 00.100100 =36                  
    9>>2 = 00..1001 >> 2        = 00.0010   =4     
    9<<<2 = 00..1001 << 2       = 00.100100 =36  
    9>>>2 = 00..1001 >> 2       = 00.0010   =4  -->INT TO BIN  
           (32 bit )                              2 = 000000000000000000000000000000010   
                                                  -2 = 11111111111111111111111111111110 (2 ka 2's comp = 2 ka 1's comp + 1)
                                                  (int(Java) :signed integers format(-2^31 to 2^31-1) ; not unsigned integers format(0 to 2^64) 
                                                   bin(Java) :32 bits binary format(1 bit for sign and 31 bits for magnitude))
                                                    

                                                    OPERATIONS
                                                    &   -- 0 & 0 = 0 ; 0 & 1 = 0 ; 1 & 0 = 0 ; 1 & 1 = 1
                                                    |   -- 0 | 0 = 0 ; 0 | 1 = 1 ; 1 | 0 = 1 ; 1 | 1 = 1
                                                    ^   -- 0 ^ 0 = 0 ; 0 ^ 1 = 1 ; 1 ^ 0 = 1 ; 1 ^ 1 = 0 (1 if 2 bits are different 0 is both bits are same)
                                                    ~   -- ~0 = 1    ;~1 = 0
                                                    a<<n --left  shift(preserve -ve nos) by n bits and discard displaced bits on left and  a<<n = a*2^n
                                                    a<<<n--left  shift(doesnt preserve -ve nos) by n bits and discard displaced bits on left 
                                                    a>>n --right shift(preserve -ve nos) by  bits and discard displaced bits on right and a>>n = a/2^n
                                                    a>>>n--right shift(doesnt preserve -ve nos) by  bits and discard displaced bits on right and a>>n = a/2^n
                                                          Preserve -ve nos
                                                          a = -2 =  000000000000000000000000000000010 ka 2's = 111111111111111111111111111111110
                                                          a>>1  --111111111111111111111111111111111 --> it will not right shift directly to preserve negative number
                                                                                                        but it will right shift "2" by 1 bit and then convert the result to -ve by 2's comp
                                                          a>>>1 --011111111111111111111111111111111 --> it will directly right shift without preserving negative number 






    1.
    mask = 1 <<< n -->mask ka index = n from right is set ; rest all 0 
    a & mask -->get bit at index = n from from right
    a|mask   -->set bit at index = n from from right
    a ^ mask -->flip bit at index = n from from right

    2.
    mask = n ^ -n -->mask ka index = "n ka 1st set index from right "is set ; rest all 0 
    a & mask      -->get bit at index = n ka 1st set index from right
    a | mask      -->set bit at index = n ka 1st set index from right
    a ^ mask      -->flip bit at index = n ka 1st set index from right
    
    3.
    a^b     --> eliminate elements in even pair(a^a=0 ) and leave 1 element 
    a <<< n  --> reduce a by n bits on left ie  move ptr ahad by n
    a >>> n   -->reduce a by n bits on right ie move ptr behind  by n


    EG:LOOK IN RELATED QUES BIT MANIPULATION
        



                                                                    
    
    */
    //SORTING
    /*
    //SORTING TERMS
    Increasing/Non Decreasing          -->Ascending with duplicates
    Increasing/Non Decreasing strictly -->Ascending without duplicates
    Decreasing/Non Increasing          -->Descending with duplicates
    Decreasing/Non Increasing  strictly-->Descending without duplicates

    //SORTING
    Arrays.sort(arr,startIndex,endIndex)    -->override the compare method in Array internally
    Arrays.sort(arr,comparatorObject)       -->override the compare method in Array class manually(Array datattype must be reference ie Integer[] arr)
    Collections.sort(list)                  -->override the compare method in List class internally
    Collections.sort(list,comparatorObject);-->override the compare method in List class manually 
                                             (comparatorObject = LOOK IN CLASS=>3.CLASS=> COMPARABLE INTERFACE to get comparatoeObject 
                                                                 by normal overload,anonymous inner class,lambda fn(4 types of lambda fn))                 


    EG:arraykClosestElementsToPoint();arrayKTopfrequentElements();arraykClosestElementsToOrigin();arrayKNearlySortedSort();arrayfrequencySort();  arraySetBitsFrequencySort(),arrayLargestNumberOnRearrangingSort() , arrayCompareNArraysForMergingInRange()
       arrayContinuousSumEqualsMinCost_RopesJoining()
       arrayPermutationFractionalKnapSack()
       arrayDataStreamMedian() 

    Eg:All problems in heap()
       matrixCompareRowsForMergingInMeetingRoomRangeI()


    
    */
    //SUBARRAY/SUBSTRING,SUBSEQUENCE,SUBSET, COMBINATION,PERMUTATION
    /*
    S = "abc"     
    COMBINATION   : Element are non-continuous,non-ordered
    PERMUTATION     "",a , b , c , ab , ac , bc , ac ,abc   
                                   ba , ca , cb , ca ,acb
                                                    ,bac
                                                    ,bca
                                                    ,cab
                                                    ,cba
                                                     |
                                                    PERMUTATATION


    SUBSET        : Element  are non-continuous,non-ordered
                    "",a , b , c , ab , ac , bc , ac ,abc   
                                    OR   OR   OR   OR  OR
                                    ba , ca , cb , ca ,acb
                                                       OR
                                                       bac
                                                       OR
                                                       cab
                                                       OR
                                                       cba

    SUBSEQUENCE : Element are non-continuous,ordered
                    a , b , c , ab , ac , bc , ac  abc  

    SUBSTRING   : Element are continuous,ordered  
                    a , b , c , ab ,bc ,abc                                                
            
                    



    NOTE:
    COMBINATION WITH UNIQUE PAIR = SUBSET WITH UNIQUE PAIRS
    SUBSET = SUBSEQUENCE  + []
    EG:
    https://leetcode.com/problems/combination-sum-ii/
    array ka unique combination ka sum equals target ka arrays  =array ka  unique subsequence ka sum equals target ka arrays
    arraySubsequenceKaSumEqualsTargetKaArraysII_CoinChangeCombinationArray()
    
    https://leetcode.com/problems/combination-sum/
    array ka unique combination ka sum equals target ka arrays  =array ka  unique subsequence ka sum equals target ka arrays
    arraySubsequenceKaSumEqualsTargetKaArraysI()

    https://leetcode.com/problems/combination-sum-iii/
    array ka unique combination of size k ka sum equals target ka arrays  =array ka  unique subsequence of size k ka sum equals target ka arrays
    arraySubsequenceOfSizeKKaSumEqualsTargetKaArraysI()
    
    https://leetcode.com/problems/combinations/
    array ka unique combination of size k ka arrays= array ka unique subsequence of size k ka arrays
    arraySubArraySubsequenceSubsetCombinationPermOutationfSizeK



                                
    */
    //UNIQUE PAIR,ARRAY
    /*

    UNIQUE PAIR :Pair are Eements are non continuous, ordered 
                 EG  ab , ac , bc , ac  abc 
                 Pair of values are unique if they have  different even though formed from different elements or different combination
                 Eg:[4,4,1,4]
                 (4(0th index), 1) , (4(1st index), 1) --same pair as they must have same values even though formed from different 4
                 (4(0th index), 1) , (1,4(3rd index)) -- same pair as they have same values in different combination

                1.SORTING ARRAY AND SKIPPING DUPLICATES
                Sort arr and skip the duplicates

                2.ADDING UNIQUE KEY TO SET
                [1,2,1] -->[(1,2), (1,1), (2,1),(2,1),(1,2)]
                ele1#ele2#ele3#         (no sort)-- (1,2) - 1#2 
                                                    (2,1) -- 2#1
                                                    They generates different key but they must generate same key as they are same pairs
                ele1#ele2#ele3#         (sort)    --(1,2) -- 1#2# 
                                                    (2,1) -- 2#1# 
                                                    They generate same key  
                ele1#count1#ele2#count2 (map) --(1,2) --{1:1,2:1} --1#1#2#1 
                                                (2,1) --{2:1,1:1}  2#1#1#
                                                They generates different key but they must generate same key as they are same pairs
                ele1#count1#ele2#count2 (arr)   (1,2) -- [0 1 1] -- 0#0#1#1#2#1#  
                                                (2,1) -- [0,1,1] -- 0#0#1#1#2#1#
                                                They generate same key 
                                                (ARR CAN BE USED IF ELEMENTS ARE CHARACTERSLIKE 'a'-'z' OR 'A'-'Z' etc so that you know array size)                                    
                Eg:
                arraypair2TargetSumI(), arraypair2TargetSumII(),-->1.SORT ARR AND SKIP DUPLICATES :Array multiptr approaches  
                arraypair3TargetSumI(),arraypair3TargetSumII(),    2.ADDING UNIQUE KEY TO SET     :Hashmap approaches 
                arrayPairKTargetSumI()
                arraypair2TargetDifferenceI()
                
                arraySubsequenceKaArrays()                      -->1.SORT ARR AND SKIP DUPLICATES :RECURSIVE IP-OP TREE + FOR
                arraySubsetKaArrays()                              2.ADDING UNIQUE KEY TO SET     :RECURSIVE IP-OP TREE
                arrayPermutaionKaArray()                               
                arrayCombinationKaArray()

                matrixCompareRowsForAnagramsGrouping()             -->1.SORT ARR AND SKIP DUPLICATES :--
                                                                      2.ADDING UNIQUE KEY TO SET     :BOTH APPROACHES

    CONVERT ARRAYS OF INT TO UNIQUE STRING :ele1#ele2#ele3#(not sorted) -- Iterate pair and do not sort;add pair ka value + #
                                           Eg:binaryTreeSerializeDeserialize(),binarySearchTreeSerializeDeserialize()

    CONVERT ARRAYS OF STR TO UNIQU STRING  :ele1#ele2#ele3#                    -- Iterate arr and add element + # ;but string may contain anything even "#" so can use any character as delimeter
                                           :ele1KaLength#ele1ele2KaLength#ele2 -- Iterate arr and add element ka length + #  + element
                                           Eg: stringEncodeDecode()
                    
            
    */

    //IP,OP
    /*
    //IP
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();                                  --> takes int
    String s = sc.nextLine();                              --> takes string
    Datatype varname  = ConversionToString(sc.nextLine())  --> takes any object 
      
    //OP
    Sout(obj) = sout(obj.toString()) -->sout takes string 
                                       println -prints new line , print –doesnt print newline
                                       Concatenation by + ,co|ncat , append , join  , Escape Sequence , Formatting(RE) --> Look in Application/String Formatting
                        
                                        Eg 
                                        Sout(short,byte,int,float,long,double)                 -->Primitive types are printed by sout don’t know how          
                                        Sout(Short,Byte,int,float,long,double)                 -->Overwride toString method inside inbuild Integer class to return the string representation of the object as required                                                        
                                        Sout(Arrays.toString(staticarray))                     -->static arrays are printed using Arrays.toString()
                                        Sout(arrayList)     =  Sout(arrayList.toString())      -->Overwride toString method inside inbuild ArrayList class
                                        Sout(linkedList)    = Sout(LinkedList.toString())      -->Overwride toString method inside inbuild LinkedList class
                                        Sout(Stack)         = Sout(Stack.toString())           -->Overwride toString method inside inbuildStack class
                                        Sout(queue)         = Sout(queue.toString())           -->Overwride toString method inside inbuild Queue class 
                                        Sout(priorityQueue) = Sout(priorityQueue,.toString())  -->Overwride toString method inside inbuild PQ class 
                                        Sout(hashmap)       = Sout(Hashmap,.toString())        -->Overwride toString method inside inbuild HashMap class
                                        Sout(hashset)       = Sout(HashSet.toString())         -->Overwride toString method inside inbuild HashSet class
                                        Sout(Animal)         = Sout(Animal.toString())         -->Overwride toString method inside inbuild  Animal class
                                            


    )




    */
//)





            /*
            PRIMITIVE TYPE                                REFERENCE TYPE
            var a= object  -->holds object                reftype a = object-->holds reference to object           
                            __________                                        ____________          
                            |  var  a |  ---->Obj                             |  Ref class |   --->  Object
                            |_________|                                       |____________|           
                                
                                    |
                                    |
                                    | 
                                    |                                                                                                                      
            1.REF , PRIMITIVE:------|
            PRIMITIVE TYPE                          
            Int a = 22                  a -----22            (int is primitove so shared by value)
            Int b = 33                  b ------33
            c = b                       c -------33

            REF TYPE                                           (book is reference so shared by reference)    
            Book b = new Book()    b ------Book()   reference = 2(b,c)          -> active ref = 2 ;null ref = 0                   
            Book c = new Book()    c ------Book()   Object = 2 (Book() Book())  -> reachable obj = 2 ; abandoned obj = 0
                                                    
            Book b = new Book()  b ------ Book()    reference = 3(b,c,d)        -> active ref = 3 ;null ref = 0                  
            Book c = new Book()  c ------ Book()    Object = 2 (Book() Book())  -> reachable obj = 2 ; abandoned obj = 0 
            d = c                d------/          
            (d ref to c)

            Book b = new Book()  b ------- Book()   reference = 2(b,c)           -> active ref = 2 ;null ref = 0
            Book c = new Book()   c  -----/ Book()  Object = 2 (Book() Book())   -> reachable obj = 1 ; abandoned obj = 1
            c = b                                                  
            (c ref to book2 is broken)

            Book b = new Book()    b ------- Book()   reference = 2(b,c)          -> active ref = 1 ;null ref = 1
            Book c = new Book()    c         Book()   Object    = 2 (Book() Book())  -> reachable obj = 1 ; abandoned obj = 1
            c = b                                |--------null                  
            (c ref to book2 is broken)
            c= null
            (c ref to book1 broken)                  
                        
            Book b = new Book()  b ------ --Book()                      
            Book c = new Book()  c ------/  Book()  reference = 3(b,c,d)          -> active ref = 3 ;null ref = 0
            d = c                d---- /            Object = 2 (Book() Book())    ->reachable obj = 1 ; abandoned obj = 1
            (d ref to c)
            c = b
            (c ref to book 2 is broken)           


            2.MUTABLE IMMUTABLE:-
            IMMUTABLE
            String x = "pras"     x------>"pras"  
            String y = x          y------/

            y = "pat"                x ------->"pras"  (string  is immutable so change  by  forming copy)
                                    y --------->"pat"
                                                                
            MUTABLE
            int[] arr1 = {1,2,3,4}    arr1 ---->{1,2,3,4}   
            int[] arr2 = arr1         arr2 -------/

            arr2[1]  = 5             arr1 -------------{1,2,5,4}   (array   is mutable so change  in place)
                                    arr2 -------------/
           
                                    

            3.ITERABLE, INITERABLE:
            for(i in arr)                   (array is iterable hence we can iterate)
            for(i in str.toCharArray())      (string is initerable hence convert to array)                                                                                                                 

            */

//          |          
//          |
//INT--> PRIMITIVE,   IMMUTABLE , INITERABLE
/*
byte/short/int/long/float/double a = 1  -->Look in Conversion:int ka 1.Declaration , 2.Conversion


1. lookup , insert , length
--

2. slicing
--

3.fns(Math.fn())
Math.fn()                        -->Look in Converstio :int ka 4.Fn
*/

//INTEGER  --> REFERENCE, IMMUTABLE , INITERABLE
/*
Byte/Short/Integer/Long/Float/Double a = 1   -->Look in Conversion:int ka 1.Declaration , 2.Conversion

1. 
#lookup by index, value
--

#add,remove,set 
--

#size
--

#slicing
--

2.FNS
Math.fn()                        -->Look in Converstio :int ka 4.Fn
*/

//CHAR  -->PRIMITIVE, IMMUTABLE , INITERABLE
/* 
Char ch = 'a'       -->Look in Conversion:int ka 1.Declaration , 2.Conversion
1.
#lookup by index, value
--

#add,remove,set 
--

#size
--

#slicing
--

2.FNS
--
*/

//CHARACTER--> REFERENCE, IMMUTABLE , INITERABLE
/*
Character Ch =  'p'     -->Look in Conversion: 1.Declaration , 2.Conversion


1.
#lookup by index, value
--

#add,remove,set 
--

#size
--

#slicing
--

2.FNS
--
*/

//STRING-->REFERENCE, IMMUTABLE , INITERABLE
/*
String s = "prasann"                                       -->Look in Conversion:int ka 1.Declaration , 2.Conversion
           Concatenation by + concat , append , join  , )   -->Look in Application/String Formatting)
           Escape Sequence , 
           Formatting(RE)

1.
#lookup by index, value
charAt(0),charAt(s.length-1),charAt(index)            --> returns obj at first,last,given index                              O(1),O(1),O(1)
indexOf("as"),---, s.contains("as")                   --> returns first occurence,last occurrence,presecce of characters      O(n),--,O(n)    

#add,remove,set 
--,s+ "str",--                                       --> returns a nes string by adding character  at first,last,given index  --,O(n),--
--,
s.replace('char1','char2' OR "str1","str2" )         --> returns new string replacing "ALL" occurenc of char1 by char2 OR str1 by str2          O(n)
s.replaceAll(RE,'char' OR RE, 'str')                 --> returns new string replacing "ALL" occurenc of RE by char or str                       O(n)

#size
s.length() -> takes string finds length and returns int                                                                                        O(1)                                                                                         

#slicing
trim()            --> returns a new string by removing  whitespace before and after string                                                   O(n)
trimleft()        -->returns a new string by trimming all white space before string                                                          O(n)
trimright()       --> returns a new string by trimming all white space after string                                                          O(n)
split('RE',limit) --> returns a new list of string by splitting  string at RE not including RE,limit for array to limit size so RE will be matched limit-1 times  O(n)
                       s.trim().split(" ");   //returns array of words from a string with words seperated by single space 
                       s.trim().split(" +"); //returns array of words from a string with words seperated by single space 
substring(si,ei)  --> returns a new trimmed  string  from startindex(default 0)  to endindex (default n) exclusive                          O(n)
     |
second s is small 



2.FNS
--
*/

//STRING BUFFER/STRINGBUILDER -->REFERENCE, MUTABLE , INITERABLE
/*
StringBuffer sb = new String Buffer(""); OR  StringBuilder s = new StringBuilder("");  -->Look in Conversion:int ka 1.Declaration , 2.Conversion
StringBuilder sb = new StringBuilder(string)                                            -->StrinhBuffer is thread sefe , StringBuilder is not


1.
#lookup by index, value
charAt(0),charAt(s.length-1),charAt(index)                      --> returns obj at first,last,given index                             O(1),O(1),O(1)
indexOf("as"),---, contains("as")                               --> returns first occurence,last occurrence,preseNce of characters    o(n),--/,(n)      

#add,remove,set 
--, append("string"),---                     -->  appending the string at first,last,given index                                       --,O(1),--
delete(0),delete(sb.length()),deleteCharAt(i)/delete(si,ei)  --> delete from firt,last,given/start to end index exclusive,            O(1),O(1),O(1)/O(n)
--

#size
length() -> returns length of stringBuffer                                                                                            O(1)

#slicing            
substring(startindex,endindex) -->returns a new trimmed  string  not SB  from startindex(default 0)  to endindex (default n) exclusive  O(n)
   |
   |
second s is small 

2.FNS
sb.reverse()  -- revere stringbuffer in place           O(n)
*/

//STATIC ARRAYS -->REFERENCE, MUTABLE , ITERABLE
/*
datatype[]  a = new datatype[length]         --> array that soores datatype 
datatype[] a = new datatype[] {1,2,3,4,5}   --> array that takes any datatype  
                                    

1.
#lookup by index, value
a[0],arr[arr.length],a[index]                O(1),(1),O(1)
--

#add,remove,set 
--                            
--
a[index] = length                             O(1)

#size
a.length NOT length()                         O(1)           

#slicing
Arrays.copyOfRange(array,from:startindex,to:endindex) --> copy array from startindex to endindex  exclusive  O(n)


2.FNS
Arrays.eqauals(al1,al2)                                                            -->compares array                                                                  O(n)
Arrays.copyOfRange(array,from:startindex,to:endindex)                              -->return a  copy array from startindex to endindex  exclusive                     O(n)
Arrays.sort(arr,startindex,endindex)                                               -->sorts array,ist in place from startindex to endindex exclusive[LOOK IN SORTING]  O(n logn)        
Arrays.sort(arr,comparatorObject)
Collections.sort(list)
Collections.sort(list,comparatorObject)                                                 
Collections.reverse(list                                                            -->reverses list in place                                                          O(n)

                                             
*/

//ITERABLE INTERFACE
/*
                                    Iterable Interface             -->Interfaces extend other interfaces
                                                |                     Classes implement interface
                                                |
                                     CollectionInterface
                                          /     |  \   \
                List(I)                                        Queue(I)                           Map(I)                            Set(I) 
                |                                               |         |                        |             |                   |             |         
                |                           ____ __ _________Deque(I)     |                        |           SortedMap(I)          |         SortedSet(I)        
                |                          |                 |            |                        |             |                   |             |        
                |-ArrayList                |                 |-ArrayDeque |-PriorityQueue          |--HashMap    |- TreeMap          |--HashSet    |-TreeSet     
                |-LinkedList<------------- |                                                           |                                 |
                |-Vector                                                                               |                                 |
                    |                                                                                  |                                 |
                    |-Stack                                                                            |-LinkedHashMap                   |--LinkedHashSet
                (ArrayList – exoands b 50% when full 
                Vector- expands by 100% when full)
*/

//LIST-->ERFERENCE, MUTABLE , ITERABLE     
/*     
List<datattype> = new subclass<>();



1.
#lookup by index, value
get(0),get(arr.size()) ,get(index)                             --> returns obj at first,last,given index                                                 
indexof(obj),  ----, contains(obj)                             --> returns index of 1st occurrence ,last occurnce,presence  of obj    
indexOf(obj,startIndex) -- return indexOf object starting from startIndex
 

#add,remove,set 
add(0, obj),add(arr.size(),obj),add(index.obj)                 --> add object at first,last,given index                                   
remove(0) , remove (arr.size()),remove (index);   remove(obj)  --> remove and return object at first,last,given index ,remove obj   
set(index,obj)                                                 --> set obj atgiven index  

#size
isEmpty()                                                  --> returns true if list is Empty                                                                                    
size()                                                          -->return size of a List                                                                                                        




#slicing
List<Integer> al2  = new ArrayList<>(al1.subList(startindex,endindex))-->al.subList(arr) returns view list ie mutable list that change whose change affects al1; new ArrayList returns normal list ie mutable and changes doesnt affect al1
                                                                        EG:
                                                                        List<Integer> list1 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
                                                                        List<Integer> list2 = list1.subList(0,3);
                                                                        list2.add(9); -->l1 = [0, 1, 2, 9, 3, 4, 5];l2 = [0, 1, 2, 9]

                                                                        List<Integer> list1 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
                                                                        List<Integer> list2 = new ArrayList<>(list1.subList(0,3));
                                                                        list2.add(9); -->l1 = [0, 1, 2, 3, 4, 5];l2 = [0, 1, 2, 9]

     
                                                           
                                                                            

                                                                   
2.FNS
Arrays.eqauals(al1,al2)                                                            -->compares array                                                                  O(n)
Arrays.copyOfRange(array,from:startindex,to:endindex)                              -->return a  copy array from startindex to endindex  exclusive                     O(n)
Arrays.sort(arr,startindex,endindex)                                               -->sorts array,ist in place from startindex to endindex exclusive[LOOK IN SORTING]  O(n logn)        
Arrays.sort(arr,comparatorObject)
Collections.sort(list)
Collections.sort(list,comparatorObject)                                                 
Collections.reverse(list                                                            -->reverses list in place                                                          O(n)


*/

//QUEUE -->REFERENCE, MUTABLE , ITERABLE          
/*
Queue<datattype> = new subclass<>()

1.
#lookup by index, value
peek(),---,---           --> returns obj at first,last,given index        
--,---,contains(obj)     --> returns if queue contains object

#add,remove,set 
--,add(item),---          --> add item to first,last,given index                        
remove(),--,---          -->removing and return   item from first,last,given index         

#size
isEmpty()                 -->return if stack is empty or not                                
size()                    -->return size of queue

peek ke badel element     --> return obj and  do  throw exc if queue is empty     
add ke badle offer        --> add item and don’t thorw exc if queue is full          
remove ke badle poll      --> remove item and  don’t thorw exc if queue is full                                                                

#slicing
--


2.FNS
--


*/

//MAP-->REFERENCE, MUTABLE , INITERABLE          **key:unique or null,  value: duplicat or null
/*
Map<datatype> map = new subclass<>()

1.
#lookup by index, value
---,----,get(key)/getordefault(key,default value) --> return  the value of the first,last,given key and if not present default value
---, ----, containskey(key)/containsValue(value)  --> returns first occurrence,last occurrence,presence of key and presence of value
KeySet(),Values(),entrySet()                      --> return set<keys>/ collection<values>/ set<entry<key,value>                  
                                                               |                               |
                                    Set<Integer> set = map.keySet();                            for(var i:map.entryset())     
                                   Integer[] arr  = map.values().toArray(new Integer[set.size()])       i.getKey()     -> get  key  at each iteration                     
                                                                                                        i.getValue()     -> get  value   at each iteration   
                                                                                                        setvalue(value) -> set value at each iteration

#add,remove,set
----,----,put(key,value)                           -->add key and value to map and if key is already present override key                                                      
---,-----,remove(key)  ; remove(key,value)         --> remove  key and and return  its corresponding value ; remove key value pair
                                                                                                                                                                                      

#size
isEmpty()                                         -->return true if map is empty                                                                                                                                          
size()                                            --> returns size of map                                                                                                                                                              
                        

#slicing
--


2.FNS
--

*/

//SET-->REFERENCE, MUTABLE , INITERABLE          **key:unique or null
/*
Set<datatype> set = new subclass<>()
1.
#lookup by index, value
---/---/containskey(key)     --> returns true if key present        

#add,remove,set
--/---/add(key)              -->add key to set                           
---/---/remove(key),         --> remove  and dont return key from set                       
                                                                                                                                                                                      

#size
isEmpty()                     -->return true if map is empty                                                                                                                                            
size()                        --> returns size of map                                                                                                                                                                  
                        

#slicing
--

2.FNS
--


*/


//ARRAYLIST    -->REFERENCE, MUTABLE , ITERABLE          
/*
List<datatype> arrayList = new ArrayList<>();                     -->All the methods of List interface overwridden in ArrayList implements class can be called
ArrayList<datatype> arrayList = new ArrayList<>();           -->All List interface overwridden in ArrayList implements class + ArrayList methods
List<datatype> arrayList = new ArrayList<>(Arrays.asList(1,2,3))   -->Lokk in conversion Arrays to List
List<datatype> arrayList = new ArrayList<>(List.of(1,2,3))         -->Lokk in conversion Arrays toList
(<datatype> not mentioned then any datatype can be taken)


ARRAYLIST  SELF METHODS
1.
#lookup by index, value
get(0),get(arr.size()) ,get(index) set(index,obj)                   -->returns obj at first,last,given index                     O(1),O(1),O(1)                                       
indexof(obj)/indexOf(obj,si),lastIndexOf(obj) , contains(obj)     --> returns index of 1st occurrence /1st occ starting from startindex,last occurnce,presence  of obj        O(n)/O(n),O(n),O(n) 


#add,remove,set
add(0, obj),add(arr.size(),obj)/add(obj) ,add(index,obj)       --> add object at first,last,given index                                    O(n),O(n),O(n)      --> add operations of AL 
remove(0) , remove (arr.size()),remove (index)                 --> remove and ret obj t at first,last,given index                          O(n),O(n),O(n)          Worts case: O(n),Amortised:O(1) 
set(index,obj)                                                 -->set obj atgiven index                                                    O(1)                    as as we do not double and copy arr for  each operation but only when array is filled           

#size 
isEmpty()                                                       --> returns true if list is Empty                                          O(1)
size()  
                                                             -->return size of a List                                                   O(1)

#slicing
--

2.FNS
Arrays.eqauals(al1,al2)                                                            -->compares array                                                                  O(n)
Arrays.copyOfRange(array,from:startindex,to:endindex)                              -->return a  copy array from startindex to endindex  exclusive                     O(n)
Arrays.sort(arr,startindex,endindex)                                               -->sorts array,ist in place from startindex to endindex exclusive[LOOK IN SORTING]  O(n logn)        
Arrays.sort(arr,comparatorObject)
Collections.sort(list)
Collections.sort(list,comparatorObject)                                                   
Collections.reverse(al/ll/stack)                                                   -->reverses list in place                                                          O(n)


*/

//LINKED  LISTS-->REFERENCE, MUTABLE , ITERABLE
/*
List<datatype> linkedList = new LinkedList<>();                    -->All the methods of List interface overwridden in LinkedList implements class can be called
LinkedList<Datatype> linkedList =  new LinkedList< >();            --> All the methods of List interface overwridden in LL implements + LL lclass meyhods
(<datatype> not mentioned then any datatype can be taken)

EG
LinkedList<ArrayList<Integer> > linkedList = new LinkedList<>();--->Reftype = LL that stores Al that stores NodeObjtype = Linked List

                                                                    

LINKEDLIST  SELF METHODS(METODS IN "" ARE METHODS OF LL )
1.
#lookup by index, value
getfirst() , getlast(),get(index)                         --> returns obj at first,last,given imdex                          O(1),O(1),O(n)
indexof(obj),lastIndexOf(obj) ,contains(obj)              --> returns index of 1st occurrence,last occ,presence of obj      O(n),O(n),O(n)

#add,remove,set
addfirst(obj),addLast(Obj)/add(obj),add(index,obj)       --> add object at first,last,given index                           O(1),O(1),O(n)
removefirst(),removeLast(), remove (index)               -->remove and ret obj  at first,last,given ind                     O(1),O(n),O(n) 
set(index,object)                                        --> set the object at given index                                  O(n)

#size
isEmpty()                                                      --> returns true if list is Empty                            O(1)
size()                                                         -->return size of a List                                     O(1)

#slicing
--

2.FNS

*/

//STACK -->REFERENCE, MUTABLE , INITERABLE
/*
List<datatype> stack = new Stack<>();        -->All the methods of List interface overwridden in Stack  implements class can be called
Stack<Datatype> stack =  new  Stack< >();   --> All the methods of List interface overwridden in Stack  implements class can + stack class
(<datatype> not mentioned then any datatype can be taken)

STACK  SELF METHODS(METODS IN "" ARE METHODS OF STACK )
1.
#lookup by index, value
--- ,peek()---                               --> return  item to first,last,given index              --,O(1),---
--,---,contains(obj)                          -->returns if queue contains object                    --,---, O(n)

#add,remove,set 
--- , push(item) ,-------                 --> push item to first,last,given index                  ---,O(1),---
---- ,pop()  ,  -------                    -->pop and return item from first,last,given index      ---,O(1),---
---
  
#size
isEmpty()                                     -->return if queue is empty or not                      O(1)                           
size()                                         -->return size of queue                                O(1)

#slicing
--

2.FNS
--

*/

//ARRAYDEQUEUE,LINKEDLIST -->REFERENCE, MUTABLE , INITERABLE -->**values :non null
/*                                                                                                                            
Deque<datatype> arraydeque = new ArrayDeque<>();        -->All the methods Deque  interface overwridden in ArrayDeque  class
ArrayDeque<Datatype> arraydeque = new ArrayDeque<>()   --> All the methods of Deque  interface overwridden in  + ArrayDeque class methods 
(<datatype> not mentioned then any datatype can be taken)                                                                                                                                                    
        
Deque<datatype> linkedList = new LinkedLIst<>();          -->All the methods Deque  interface overwridden in ArrayDeque  class[QUEUE USING LL TAKES NULL VALUES] 
LinkedList<Datatype> linkedList = new ArrayDeque<>()     --> All the methods of Deque  interface overwridden in  + LinkedList class methods 
(<datatype> not mentioned then any datatype can be taken)                                                                                                                                                    
        

ARRAY DEQUE SELF METHODS(METODS IN "" ARE METHODS OF ADQ AND LL )
1.
#lookup by index, value
peekFirst()/peek() , peekLast()  ,----              -->returns obj at first,last,given index                           O(1),O(n),--
--,---,contains(obj)                                -->returns if queue contains object                                --,--,O(n)

#add,remove,set 
addFirst(item)  ,addLast(item)/add(item) ,----        -->add item to first,last,given index                              O(n),O(1),---
removeFirst()/remove() ,removeLast()    ,---       -->remove and return  item from first/last/given index                O(1),O(n),----
--

#size
isEmpty()                                                 -->return if queue is empty or not                                O(1)                           
size()                                                    -->return size of queue                                           O(1)
     
peek()   ke badel element()                               -->return obj and  do  throw exc if queue is empty     
add()    ke badle offer()                                 --> add item and don’t thorw exc if queue is full          
remove() ke badle poll()                                  --> remove item and don’t thorw exc if queue is full      

#slicing
--

2.FNS
--


*/

//PRIOROTY QUEUE/MAX MIN HEAP -->EFERENCE, MUTABLE , INITERABLE
/*
Queue<datatype>  priorityQueue = new PriorityQueue<>();                 -->All the methods of Queue  interface overwridden in Priority Queue  class can be
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();   -->All the methods of Queue  interface overwridden in PQ + PQ class methods    
(<datatype> not mentioned then any datatype can be taken)          (minHeap = asc = min element at front; maxHeap = desc = max element at Front)
                                                    

PRIORITY  QUEUE/MAX MIN HEAP  SELF METHODS(METODS IN " " ARE METHODS OF PQ )
1.
#lookup by index, value
peek() , ----  ,-------                                  --> return  item to first,last,given index in guaranteed asc/desc order              ---,O(1),---                                                                         
---,----,contains(obj)                                   -->returns if queue contains object                                                  ---,---,O(n)

#add,remove,set 
-- , add(item)  ,-------                                --> add item to first,last,given indexin non quaranteed asc/dec order               ---,O(log n),---
remove() ---, -------                                   -->remove and return  item from first,last,given index in guaranteed asc/desc order  ---,O(log n),----
--

#size
isEmpty()                                               -->return if queue is empty or not                                                     O(1)                           
size()                                                  -->return size of queue                                                                O(1)
 
peek()   ke badel element()                               -->return obj and  do  throw exc if queue is empty     
add()    ke badle offer()                                 --> add item and don’t thorw exc if queue is full          
remove() ke badle poll()                                  --> remove item and don’t thorw exc if queue is full      

#slicing

2.FNS
--
*/

//HASHMAP-->REFERENCE, MUTABLE , INITERABLE --> **key unique and non-null,  value: duplicate and null
/*
Map<key datatype,value datatype>  hashmap =  new HashMap<>();      -->All the methods of Map interface overwridden in Hashmaps  implements Hashmaps<key Datatype,Value Datatype > map = new  Hashmaps<> --> All methods of HashMaps  class can be called (Keys added in any order)
HashMap<key datatype,value datatype>  hashmap =  new HashMap<>()    -->All the methods of Map interface overwridden in HashMap + HashMap class methods
(<datatype> not mentioned then any datatype can be taken)                

HASHMAP   SELF METHODS(METODS IN " " ARE METHODS OF HM )
1.
#lookup by index, value
---,----,get(key)/getordefault(key,def value)             --> return  the value of the first,last,given key /given key  not present default value    --,--,O(1)/O(1)
---, ----, containskey(key)/containsValue(value)          --> returns first occ,last occ,presence of key/ presence of value                          --,---,O(1)/O(n)
KeySet(),values(),entrySet()                              --> return set<keys>/ Collection<values>/ Set<Map.Entry<key,value> 
                                                                        |
                                                                        |
                                                            Set<Integer> keys = map.keySet();
                                                            for(Integer key:keys){}

                                                            Collection<Integer> values = map.values()
                                                            for(Integer value:values){}


                                                            Set<Map.Entry<Integer,Integer> entrySet = map.entrySet();
                                                            for(Map.Entry<Integer,Integer> entry :entrySet){
                                                                Integer key = entry.getKey();
                                                                Integer val = enytry.getValue();
                                                            }


#add,remove,set
----,----,put(key,value)                                  -->add key and value to map and if key is already present override key                --,---,O(1)   
-----,----remove(key,value)/remove(key)                    --> remove  key and and return  its value ; remove key value pair                      --,/---,O(1) 
---

#size
isEmpty()                                                 -->return true if map is empty                                                           O(1)
size()                                                    --> returns size of map                                                                  O(1)
   
#slicing
--

2.FNS

*/

//HASHSSET-->REFERENCE, MUTABLE ,ITERABLE -->**key unique and non-null,  
/*
Set<key datatype >  hashset  =  new subclass<>();        -->All methods of set interface class overwridden in Hashsets subclass can be called
Hashsets<key datatyoe> hashset = new Hashsets<>()<       --> All methods of HashSets class can be called  (keys added in any order)
(<datatype> not mentioned then any datatype can be taken)                                                                                                                        


HASHSET   SELF METHODS(METODS IN " " ARE METHODS OF HS)
1.
#lookup by index, value
---/---/----
---/---/containskey(key)                               --> returns true if key present            --,---,O(1)  --> Contains operation of set
                                                                                                                  WorstCase:O(1) ,Average: O(1)
                                                                                                                  as set operation internally uses
#add,remove,set                                                                                                   TreeMap and collision may cause logn 
--/---/add(key)                                      -->add key to set                            ---,---,O(1)                   
---/---/remove(key)                                 --> remove  and dont return key from set     ---,---,O(1)
---


#length
isEmpty()                                             -->return true if map is empty              O(1)                                                                                                                          
size()                                                --> returns size of map                     O(1)                                                                                                                       

#slicing

2.FNS



*/


/* #endregion */


//EXCEPTION
/* #region Main */
//EXCEPTION
/*
EXCEPTOPN --> Method  throws exception; exception  goes down stack to find  exception handler  . So when eexception handler not found till               
            end then java gives the stack trace in  err window (method on top ofstack wghich throws err wrtten 1st , method below it 2nd) 
Eg
Public class  Animal{
    public static void barker()[
        bark(null)}
    public  stativ void bark(String name){
    Sout(name.toUppercase();)}}

Public class main{
Public statoic vod main(String[] args){
        Animal.barker()}}

Bark   -> Bark Throws exception no handler found , exception  goes to barker no handler found  , goes to main no handler found      Exceprion at Java.Animal.Bark ExceptionType (Link to bark)
Barker    Exceprion at Java.Animal.Barker ExceptionType (Link to Barker)
Main      Exceprion at Java.Animal.Main  ExceptionType (Link to Main)

*/

//EXCEPTIN HANDLING
/*
CHECKED EXC/COMLIE TIME : These Exceptions are handles at complie time and are   compulsay to handle
                        1.If method throws checked exception automatically 
                        public void method(){
                                FileReader f = new FileReader()  }  -->wrap in try catch finally block    so the exception will be handled there 
                                                                    itself and will not travel down the stack   to find  exception handler 
                        public void method(){
                            try{
                                FileReader f = new FileReader()}   --> throws new CheckedException()
                                                                                            
                            Catch(Reftype e){                      -->Reftype ex = new Objecttype()    
                                e.method()}                           1.PLACE MULTIPLE EXCPTIONS
                                                                        Lowest subclass is placed 1st and highest superclass is last
                            Catch(Reftype e){                           So thrown exception travels down ; 1st subclass  tries to 
                                e.method}                               catch if not then superclass tries to catch
                                                                        2.COLLAPSE MULTIPLE EXCEPTIONS INTO ONE 
                            Catch(exc1 |exc 2 e){                        Similar exceptions can be collapsed into 1 using( exc1|exc2 e )     
                                e.method()}

                            finally{}                               -->finally always runs so if try throws exc  and catch does not handle finally does
                                                                        ie try  throws exc1 on line 1,exc2 on  then line2  so if exc1 is 
                                                                        executed cntrl goes to except block and exc2 not executed ; so  
                                                                        we transfer exc2 to finally block
                            EG1

                        2.If method throws checked exc because you throw new exception()                                                                                     
                        public void method(){                                                        
                            throw new checkedExceptionClass();}   --> Make method throws CheckedExceptionclass() so exception  is not 
                                                                        handed here so it will   travel down the stack and wrap the method call          
                                                                        in try catch finally block

                        public  void method() throws CheckedExceptionClass {
                            throw newcheckedExceptionClass() }} --> throws new CheckedException()
                        public void method2()
                            try{
                                method1()}                      --> throws new CheckedException()
                            catch(Exceprtion e){     }          --> same as above                     
                            finally{   }                        -->same as above    
                        
                        EG 2

                        **If we rethrow Exception where we catch it then we need to again make method throws and catch it down the 
                        stack with try catch finally
                        EG 3 

UNCHECKED EXC/RUNTIME EXC : These exception are checked at runtime  and are not compulsary to handle as JVM handles them
                           1.If method throws unchecked exception automatically-
                            Public void method(String s){
                                UncheckedException()}  -->Method throws exc is not handled here so travels down tack
                                                            to find handler but it is not handled so java handles exception
                            EG 4           

                            2.If method throws checked exc because you throw new exception()
                            Public void method(String s){
                                throws new UnCheckedException()}  -->Method throws exc is not handled here so travels down tack
                                                                    to find handler but it is not handled so java handles exception
                            EG 5         

EG1
QUESTION
Public static void convert(String s)
       FileReader file = new FileReader("prasann"); -->WRAP IN TRY CATCH FINALLY BLOCK
        var value = file.read();                                               
        newSimpleDataFormat().parse();}
SOLUTION
public static void convert(String s){
    try {
        FileReader file = new FileReader("prasann"); -->throws new FileNotFoundException()
         newSimpleDataFormat().parse();                 throws new ParseException()
        var value = file.read();                        hrows new IOException()      
        

    }


    catch (FileNotFoundException e) {   -->catch  FileNotFoundExc = new FileNotFoundEx();
        e.printStackTrace();}                                                             
	                                                                                               --> collapse   catch (FileNotFoundExc|ParseExc  e)
   catch (ParseException e) {             catch ParseException e = new ParseException()  them                         {e.printStackTrace();}
    e.printStackTrace();}

    catch (IOException e) {               catch IOException  e = new IOException()
        e.method();
    }

   Catch (Exception e)                    catch Exception e =  new FileNotFoundException();
       System.out.prin                                         new ParseException()
                                                               new IOException()

finally {                                 --> try throws 3 exc on line1 , line2 , line 3 so if any of exc is executed cntrl goes to catch and rest are ignored  
    try {                                      so we handle close in finally 
        if(file != null)               
            file.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

EG2
QUESTION
puplic Class Animal{
public bark(Int  a) 
        if(a >10 ){
        throw new IOException();}}    -->Make method throws CheckedExceptionclass() so exception  is not 
                                        anded here so it will   travel down the stack and wrap the method call in try catch finally 
SOLUTION
puplic Class Animal{
public bark(Int  a) throws IOException(){
    if(a >10 ){
        throw new IOException();}}    --> throws new IOException();
public class  main {
   public static void main(String[] args){
Animal animal = new Animal();
try{
    animal.bark(12)}                  --> throws new IOException();
Catch(IOException e){                 --> catch IOException e = new IOException();
    e.printStaackTrace();}}

EG3
QUESTION
public static void convert(){
    file = new FileReader("prasann");        -->WRAP IN TRY CATCH FINALLY BLOCK

SOLUTION
    file = new FileReader("prasann");


public static void convert() throws IOException {
    FileReader file = null;
    try {
        file = new FileReader("prasann"); }     -->throw new IOException()
    catch (IOException e){
        System.out.println("LOGGING........."); --> catch IoException = new IOException();
         throw e;}                              -->RETHROWN EXCEPTION
                                                   Make method throws IOEXCEPTION() so exception  is not 
                                                   handed here so it will   travel down the stack and wrap the method call in try catch finally 
}

public static void main(String[] args) {
    try {
        Tester.convert("prince");             
    } catch (IOException e) {
        e.printStackTrace();
    }
}

EG 4 
Puplic Class Animal{
public bark(String a){           -->Method thows new NullPointerException()is not handled here so travels down tack                                                                                        
    if(a == null){                 to find handler but it is not handled so java handles exception
a.toUppercase();}

Animal animal = new Animal();
animal.bark(null)

EG5 
Puplic Class Animal{
public bark(String a){            --> Method thows new IllegalArguementException ()is not handled here so travels down tack                                                                                        
    if(a == null){                    to find handler but it is not handled so java handles exception
        throw new IllegalArguementException();}
    a.toUppercase()}
 
}
Animal animal = new Animal();
animal.bark(null)


5.CREATING EXCEPTION CLASS
               Unchecked -> Runtime Exception; Checked -> Excption
              /     
public – class  ExceptionClassNameException  extends  Exception/ Runtime Exception {
    public -- -- ExceptionClassNameException(){                --> const that does not take arguements
       super("Message you want to print");}

   public -- -- ExceptionClassNameException (String message)){  --> const that take arguements
        super(message);}

}

OR 
Hover over FileReader f = new FileReader() and More action-->Surround with try catch

OR 
Hover over throw new Exception()  and  More action-->add exception to method signature
Hover over class1.method()and More action-->surround with try catch 


EG6
public class InsuffucientFundsException extends Exception{
    public InsuffucientFundsException() {
        super("Insufficient funds");}
    public InsuffucientFundsException(String message) {
        super(message);}
}

public class Tester {
    public static void calculate(int a) throws InsuffucientFundsException {
        if(a > 10)
            throw new InsuffucientFundsException();
    }
}

public static void main(String[] args) {
    try {
        Tester.calculate(1);
    } catch (InsuffucientFundsException e) {
        e.printStackTrace();
    }
}
*/

//EXCEPTION CLASS 
/*
a.INBUILD EXCEPTION CLASS
                                        Object
                                            |
                                      Throwable
                         /            getmessage()            \
                        /             printstckstate           \    
                       /                                        \
Exception
|
|
CheckedException/Complile Time Exc            
|--IO exception                                
|--SQL exception                             
|-- FileNameNotFound 
|--ParseException               
|-- UncheckedException /RunTimeExcetion                  
              |--IllegalArguementException
              |--IllegalStateException
              |--NullPointerException
              |--ArithmeticException


Error(Error is irrevocable)
|--Stackoverflowerror
|--virtualmachineerror
|--out of memory error

UncheckedException /RunTimeExcetion      :These Exceptions are handles at runtime and are not  compulsay to handle
Checked Exception/Compile time exception :These exception are checked at runtime itself and are compulsary to handle


b.USER DEFINED EXCEPTION CLASS
public – class  ExceptionClassNameException  extends  Exception(for checked)/ Runtime Exception(for unchecked) {
public -- -- ExceptionClassNameException(){                         --> constructor  that does not take arguments and directly prints the err msg
    super("Message you want to print");}

public -- -- ExceptionClassNameException (String message)){          --> constructor  that take error message arguement
    super(message);}

EG 6 IN EXCEPTIN HANDLING
*/


/* #endregion */


//THREAD
/* #region Main */
//CREATE THREAD
/*
//EXTEND THREAD CLASS
public class ThreadClass extends Thread {
  @Override
  public void run() {
     CODE OF THREAD  
  }
}
ThreadClass threadObject1 = new ThreadClass("ThreadName");
ThreadClass threadObject2 = new ThreadClass("ThreadName");
thread1 = threadObject1
thread2 = threadObject2
OR
Thread thread1 = new Thread("ThreadName"){
     @Override
    public void run() {
     CODE OF THREAD  
  }
)
Thread thread2 = new Thread("ThreadName")
     @Override
    public void run() {
     CODE OF THREAD  
  }
)



//IMPLEMENT RUNNABLE INTERFACE
public classThread implements Runnable{
   @Override
   public void run() { 
      CODE OF THREAD                
    }
}
classThread threadObject = new classThread();
Thread thread1 = new Thread(threadObject,"ThreadName");
Thread thread2 = new Thread(threadObject,"ThreadName");
OR
Runnable threadObject = new Runnable(
    @Override
    public void run(){
        CODE OF THREAD
    }
);
Thread thread1 = new Thread(threadObj,"ThreadName");
Thread thread2 = new Thread(threadObj,"ThreadName");
OR
Runnable threadObject  = ()=>{CODE OF THREAD}
Thread thread1 = new Thread(threadObj,"ThreadName");
Thread thread2 = new Thread(threadObj,"ThreadName");

*/
            //RACE CONDITION , VISIBILITY CONDITION
            /*
            //RACE CONDITION
            public class class{
                private int var;                         
                public  void getVar(){return var;}  
                public  void updateVar(){var++;}      
            }                                                      
                                                            
            public class ThreadClass  implements Runnable{
                public int var;
                public Class c;
                public ThreadClass(class c){
                    this.c = c;
                }
                @Override
                public void run() {
                    c.updateVar();
                } 
            }
            Class classObject = new Class();
            ThreadClass threadObject = new ThreadClass(classObject);
            Thread thread1 = new Thread(threadObj);     --Multiple thread share same classObject then all threads share members of class
            Thread thread2 = new Thread(threadObj);       So if multiple thread tries to update shared var at same time we get race condition


            //VISIBILITY CONDITION
            public class class{
                private int var;                         
                public  void getVar(){return var;}  
                public  void updateVar(){var++;}      
            }                                                      
                                                            
            public class ThreadClass1  implements Runnable{
                public int var;
                public Class c;
                public ThreadClass(class c){
                    this.c = c;
                }
                @Override
                public void run() {
                    c.updateVar();
                } 
            }
            public class ThreadClass2  implements Runnable{
                public int var;
                public Class c;
                public ThreadClass(class c){
                    this.c = c;
                }
                @Override
                public void run() {
                    c.getVar();
                } 
            }
            Class classObject = new Class();
            ThreadClass1 threadObject1 = new ThreadClass1(classObject);
            ThreadClass1 threadObject2 = new ThreadClass1(classObject);
            Thread thread1 = new Thread(threadObj1);     --Multiple thread share same classObject then all threads share members of class
            Thread thread2 = new Thread(threadObj2);       So One thread tries to update shared var and other thread tries to read shared var we get visibility cond 

            */
            //NEW CLASS OBJECT[CONCURRENT]
            /*
            public class class{
                private int var;                         
                public  void getVar(){return var;}  
                public  void updateVar(){var++;}      
            }                                                      
                                                            
            public class ThreadClass  implements Runnable{
                public int var;
                public Class c;
                public ThreadClass(class c){
                    this.c = c;
                }
                @Override
                public void run() {
                    c.updateVar();
                } 
            }
            Class classObject = new Class();
            ThreadClass threadObject = new ThreadClass(new Class());
            Thread thread1 = new Thread(new ThreadClass(new Class()););     --1.Multiple thread share different  classObject then all threads do not  share members of class
            Thread thread2 = new Thread(new ThreadClass(new Class()););       2.Threads can run CONCURRENTLY
                                                                            [SOLVES RACE , VISIBILITY CONDITION]


            */
            //SYNCHRONIZED METHOD[SEQUENTIAL]
            /*
            public class class{
                public int var;
                public synchronoized void getVar(){return var;}  -->Puts a lock on the method 
                public synchronoized void updateVar(){var++;}      1.If Multiple thread share same classObject then all threads share members of class
            }                                                      So if one thread  is acessing shared method all other threads acessing the shared method are blocked
                                                                  2.Threads run SEQUENTIALLY 
                                                                  [SOLVES RACE , VISIBILITY CONDITION]
                                                                
            */
            //SYNCHRONISE BLOCK OF CODE [SEQUENTIAL]
            /*
            public class class{
                public int var;
                public synchronoized void getVar(){return var;}  
                public synchronoized void updateVar(){
                    synchronise(this){                            -->Puts a lock on the block of code for the object passed as arg(this = object of current class)
                        var++;}                                     1.If Multiple thread share same classObject then all threads share members of class
            }                                                       So if one thread  is acessing shared block of code all other threads acessing the shared block of code are blocked
                                                                    2.Threads run SEQUENTIALLY 
                                                                    [SOLVES RACE , VISIBILITY CONDITION]
                                                                    
            */ 
            //LOCK BLOCK OF CODE[SEQUENTIAL]
            /*

            public class class{
                public  int var;  
                private Lock lock = new ReentrantLock();           -->Puts a lock on the block of code                           
                public synchronoized void getVar(){return var;}      1.If Multiple thread share same classObject then all threads share members of class
                public synchronoized void updateVar(){               So if one thread  is acessing shared block of code all other threads acessing the shared block of code are blocked
                    lock.lock();                                     2.Threads run SEQUENTIALLY 
                    try{                                             [SOLVES RACE  CONDITION]
                        var++;
                    }
                    finally{
                        lock.unlock();
                    }
                }      
            }                                                    
            */
            //LOCK COLLECTION VARIABLE[SEQUENTIAL]
            /*
            public class class{
                List<Integer> list = new Collections.synchronisedCollection( new ArrayList<>())        
                public synchronoized void getVar(){return var;}      Put lock on the collection variable
                public synchronoized void updateVar(){var++;}        1.If Multiple thread share same classObject then all threads share members of class      
            }                                                        So if one thread  is acessing shared collection var of code all other threads acessing the shared block of code are blocked
                                                                     2.Threads run SEQUENTIALLY 
                                                                     [SOLVES RACE  CONDITION]
                    
                
            */
            //VOLATILE VARIABLE[CONCURRENT]
            /*
            public class class{
                public volatile int var;                         -->Puts the variable in main memory
                public synchronoized void getVar(){return var;}    1.If Multiple thread share same classObject then all threads share members of class
                public synchronoized void updateVar(){var++;}      So if thread tries to update shared var other thread tries to read it it can be done as ver is in main memory
            }                                                      2.Threads can run concurrently
                                                                [SOLVES VISIBILITY CONDITION]
            */ 
            //ATOMIC VARIABLE[CONCURRENT]
            /*
            public class class{
                AtomicClass var = new AtomicClass();              -->Make the variable atomic means operation on variable is either done fully or not at all(all 3 steps of variable operation ie get update and return are done fully or not at all ) 
                public synchronoized void getVar(){return var;}     1.If Multiple thread share same classObject then all threads share members of class
                public synchronoized void updateVar(){ }            So if thread tries to update shared var one of them wins and other threads are not blocked but also cannot update shared var
                                                                    2.Threads can run concurrently
                                                                    [SOLVES RACE CONDITION]

                                                                    ATOMIC CLASS
                                                                    AtomicInteger var = new AtomicInteger();
                                                                    AtomicLong var = new AtomicLong();
                                                                    AtomicBoolean var = new AtomicBoolean();


                                                                    ATOMIC METHODS
                                                                    var.get()              //return var
                                                                    var.set(val)           //return var = val
                                                                    var.getAndIncrement()  //return var++
                                                                    Var.incrementAndGet()  //return ++var
                                                                    var.getAndDecremet()   //return var--
                                                                    var.decrementAndGet()  //return --var
                                                                    var.addAndGet(val)     //return var + val
                                                                    var.compareAndSet(val1,val2) //return var = val2 if var = val1 




            }

            */                                    
            //ADDER VARIEBLE[CONCURRENT]
            /*
            public class class{
                AdderClass var = new AdderClass();                -->Make the variable adder means operation on variable is either done fully or not at all
                public synchronoized void getVar(){return var;}     1.If Multiple thread share same classObject then all threads share members of class
                public synchronoized void updateVar(){ }            So if thread tries to update shared var one of them wins and other threads are not blocked but also cannot update shared var
                                                                    2.Threads can run concurrently
                                                                    [SOLVES RACE CONDITION]

                                                                    ADDER CLASS
                                                                    LongAdder var = new LongAdder();
                                                                    DoubleAdder var = new DoubleAdder();

                                                                    ATOMIC METHODS
                                                                    var.getinvalue() , var.getfloatvalue() //returns  equivalent int , float,long double etc
                                                                    var.increment()                        //var++
            }

            */                                    
            //PARTITION COLLECTION VARIABLE
            /*
            public class class{
                Map<String,Integer> map = new ConcurrentHashMap<>()   
                public synchronoized void getVar(){return var;}       Wrap the  collection var so that  the collection are partioned 
                public synchronoized void updateVar(){var++;}         1.If Multiple thread share same classObject then all threads share members of class      
            }                                                         So  many threads can work on each partition
                                                                      2.Threads run CONCURRENTLY 
                                                                      [SOLVES RACE  CONDITION]

                                                                      PARTITION CLASS
                                                                     Map<String,Integer> map = new ConcurrentHashMap<>() ;
                                                                     List<Integer> list = new CocurrentLinkedList<>()






            */
                                                


//THREAD METHODS
/*
//START THREAD
thread.start()                             -->start thread which starts run methos ; returns immediately without waiting for run method to return
                                            Eg 1 
//PAUSE THREAD

try {
    Thread.sleep(time in ms);             -->pause thread for T ms 
    }                                        EG 1
catch (InterruptedException e) {             
    e.printStackTrace();
}


//JOIN THREADS
try {                                        
    thread.join();                      -->  Join thread and wait for any previous thread to complete 
} catch (InterruptedException e) {          1.If you Join immediately after starting then threads are joined and run "sequentially" 
e.printStackTrace();                        2.If you collect the started threads in an array and then iterate over the array and join  threads 
                                            then threads start  concurrently and then you join threads means you "wait for all threads to end" 
                                            so that Main thread can start after that 
                                            EG 1

//INTERRUPT THREAD
Thread To be interrupted:
if(Thread.currentThread().isInterrupted()){}           -->  receive the interrup and exit the current thread              
    return ;                                     
}

Thread from where you are sending interrupt request:
Thread thread = new Thread(threadObj);
try {Thread.sleep(1000);}                              --> Pause the current thread and send  interrupt to thread
catch (InterruptedException e) { e.printStackTrace();}     EG 2               
thread.interrupt()



//THREAD HELPER METHODS
Runtime.getRuntime().availableProcessors()    -->returns no of available threads Eg: 4 threads-> 2 core and each core has 2 threads available
Thread.activeCount()                          -->returns no of active threads    Eg: 2 threads -->1 is Main method and 1 is baground thread
Thread currentThread = Thread.currentThread() -->returns reference to current Thread
currentThread.getName()                       -->returns name  of current thread
currentThread.getName()                         -->returns id of current thread

*/


//EXAMPLES
//EG 1
/*
DownloadFile.java
public class DowloadFile implements  Runnable{
    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() +  " running" );

        try {
            Thread.sleep(5000);                            --> Pause thread for 5 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " complete");
    }
}



Main.java
public class Main {
    public static  void main(String[] args) {
        for (var i = 0 ; i<=10;i++){
            DowloadFile threadObject = new DowloadFile();       -->create 10 threads
            Thread thread = new Thread(threadObject);           
            thread.start();                                     -->start 10 threads parallely     
            try {                                                   
                thread.join();                                  -->Join 10 threads immediately and convert them to sequntial                                                                                       
            } catch (InterruptedException e) {                  
                e.printStackTrace();                                                              
            }                                                                                                                                     
        }                                                                           
}
Thread-0 running 
5 sec later 
Thread-0 complete
Thread- 1 running
5 sec later
Thread- 1 complete..

Main.java
public class Main {
    public static  void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (var i = 0 ; i<=10;i++){
            DowloadFile threadObject = new DowloadFile();       -->create 10 threads
            Thread thread = new Thread(threadObject);           
            thread.start();                                     -->start 10 threads parallely                                                                                                                                         
        }                                                                           

        try {                                                   
            thread.join();                                       -->Join 10 threads immediately and convert them to sequntial                                                                                       
        } 
        catch (InterruptedException e) {                  
            e.printStackTrace();                                                              
        } 
}

Thread-0 running     Thread 1 running….  
5 sec later
Thread-1 running     Thread 2 running….  
   
*/
//EG2
/*
DownloadFile.java
public class DowloadFile implements  Runnable{
    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() +  " running" );

        for(var i =0 ; i < Integer.MAX_VALUE; i++){
            if(Thread.currentThread().isInterrupted()){return;}     --> receive the interrupt and exit  "current thread" = DwnloadFile thread             
            System.out.println("......");
        }
        
        System.out.println(Thread.currentThread().getName() + " complete");
    }
}

Main.java
public class Main {
    public static  void main(String[] args) {

        Thread thread = new Thread(new DowloadFile());
        thread.start();                                         -->start thread

        try {                                                    --> Pause the current thread(main thread) for 1 sec
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();                                       -->send interrupt req after 1 sec

    }
}


Thread-0 running  -->till 1 sec then stop after that
*/





/* #endregion */


//CONDITION
/* #region Main */

//IF
/*
(True = condition satisfied / non zero or non empty)
if(condition){}    -->The object ioutside condition are global and obj inside  conditional is local to thet scop; most generic if is at top
elseif(condition){}                                                                          | 
else{}     |    	                                                                         |                                                                                      
           |                                                                               GLOBAL , LOCAL
           |                                                                               Variables inside loops are local to that loop
           |                                                                                                              
           |	                                                                            MOST GENEROC LOOP ON TOP
           |	                                                                            if (a%5 ==0 && a%3 == 0) -> must be on top if on 
           |                                                                                elseIf (a%3 ==0)            bottom  it will never be
           |                                                                                else(a%5 ==0)               encountered     
        true , false        --> return true , false                                                                                             
        object              --> retuen true if element of obj Is true  [non zero/ non empty] IF; IF VS IF ELSE IF                                      
        obj1 operator  obj2 --> return true, false acc to operator                           IF ; IF -->Every condition is encountered
                    |                                                                        IF;ELSEIF -->Only 1 condition encountered                                                                                    
                    |                                                                                     when you use var as cond as well as update that var then use else if
        COMPARISION OP, LOGICAL OP , INCLUSION OP ,DATATYPE OP : LOOK IN OBJECTS              Eg
        ARITHMETIC OPERATOR : +(overloaded for int , string) ,- , * , / , % , ^               if(ptt.left < val){ptr = ptr.left} -->-->ptr is getting updated inside above if and used as condition in this if  ;hence  use "ELSE IF"
        INCREMENT/DECREMENT : x = x +1 ; x += x ; x++ ; ++x                                   else if(ptr>val){ptr = ptr.right}
                                                                                                          
       

SIMPLIFYING IF
1.TERNARY(we can do only assignment in ternary and not execution like printing etc)
String a;                           -->  int  b; String a =   (b < 30 ) ? "less" : "more"
if (b < 30){ a =  "less"}
else{s = "more"}

2.SWITCH(you can take only = condition and not other conditions like <, > ……. )
String a ;                       -->  String a
if (a = "prasann" )                   switch (a)
{                                     {
      Sout("name ")                    case "prasann":
}                                        sout("name");
                                         break ;
else if (a = "pradeep")                case  "pradeep":
{                                         sout("father’);
   Sout("father")                          break ;
}                                                 
else{                                  defaultL sout("xyz")
  sout("xyz")
}

*/

//WHILE(Usually used as outerLoop with break, continue)
/*
While(condition)
{               |
}               |
                 |
        SAME AS IF
*/

//DO WHILE(Usually used as outerLoop with break, continue)
/*
do
{
}while(condition)
              |
              |
               |
        SAME AS IF
*/

//FOR
/*
FOR
for(int i = 0 ; i < = obj.method(); i ++) {}

FOR EACH
for (datatype i : iterable obj){ }   

FOR EACH
obj.stream().forEach(consumerObj) >3.CLASSES=>STREAMS=b.METHOD OF STREAMS =>4.TERMINAL 

*/                                                                                                                                         

//STREAMS
/*
LOOK IN CLASSES=>3.CLASSES=>STREAMS
*/

//BREAK, CONTINUE
/*
break --> stop at certsin iteration and jump out of loop block
continue --> skip certain cond and jump  to start of loop 
*/

/* #endregion */