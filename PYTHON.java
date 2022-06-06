//INSTALLL AND RUN
/* #region Main */

//INSTALL 
/*
//WINDOWS
INSTALL     -- >Install using link -- youtube.com/watch?v=rfscVS0vtbw (first few minute)
SET ENV VAR -- >Python file installed at C:\Users\DELL\AppData\Local\Programs\Python\Python37  add to to system var
                >python --version -- this should give python version
                
                                                          

//LINUX
INSTALL -- >sudo apt-get install software-properties-common
           >sudo add-apt-repository ppa:deadsnakes/ppa
           >sudo apt-get update
           >sudo apt-get install python3.8
           >sudo apt install python3-pip
           >python --version                                -->give version of python
           >pip --version                                   -->give version of pip
           >whereis python                                  --> gives usr/lib/python3  /usr/bin/python2,7,/usr/bin/pythom3.6 .....

SET ENV VAR -->cd /usr/lib/python3 
              >ls                                            -->this will give nothing                                      -->"NOT SURE ABOUT SETTING ENV VAR I DINT SET IT IN LINIX"
              >export PYTHON_HOME=/usr/lib/python3           --> set env var(PYTHON_HOME) to filepath(python3 ka path)
              >echo $JAVA_HOME                               -->echo env var 
*/

//RUN
/*

//WINDOWS
> python filename.py  -->runs python file
>py -3 -m venv .venv --> All pyton module installed will go to .venv instead of installing them globally
>call .venv/scripts/activate ->enter the virtual environment
>pip install modulename -->Instal module globaly or in venv

//LINUX
> python3 filename.py  -->runs python file
>python3 -m venv .venv -->All pyton module installed will go to .venv instead of installing them globally
>. .venv/bin/activate  -->enter the virtual environment
>pip install modulename -->Instal module globaly or in venv

*/

/* #endregion */


//STRUCTURE 
/*
PROJECTNAME                            --> INSTALL , RUN
|- packagename1                         
   |-init.py --> tells that it is a package  and not a directorty
   |-modulename1.py
   |-modulename2.py
|-packagename2
   |-init.py 
   |-modulename1.py
   |-modulename2.py
           |
    modulename.py
    impor pachagename.classname      -->IMPORT TLL CLASS, IMPORT TILL PACKAGE, IMPORT ACCESSIBILITY


    FUNCTION
    def fname ():                    -->NAMED FN, ANONYMOUS FN, GENERATOR FN, NESTED FN, 
       code                             PARAMETER AND ARGUEMENT

    CLASS                             -->CLASS
    class clasname(C1,C3):
        CLASS VAR
        CONST , INST VAR
        METHOD
        INHERITED METHID
        ABSTRACT METHOD
        OPERATOR OVERLOADING METHOD
    
    OBJECT                           -->.INT , STRING , LIST,TIUPLE,SET,DICTIONARY,NUMEDTUPLE,NESTED,NONE

    EXCEPTION                         -->EXCEPTION CLASS , EXCEPTION HANDLING 

    CONDITIONAL                        -->IF ; WHILE; FOR,FOR COMPREHENSION ; GENERATOR FN(functional instead of oopm) ;BREAK,CONTINUE

*/




//IMPORT
/* #region Main */

//IMPORT TILL THE FN/CLASS/OBJECT:
/*
from package.module import fn/class/object              import packag.module.fn/class/obj
fn= fn(); I1 = class() ; i =  obj                       fn= package.module.fn(); I1 = “”.class() ; i =””.obj
*/

//IMORT TILL  MODULE:
/*
from package import module                               import package.module
fn= module.fn(); I1 = module .class() ; i = module.obj   fn= package.module.fn(); I1 = “”.class() ; i =””.obj                                       



as  keyword --> replace the nam  before as by name after as        
Eg    from package.module  import fn as fnname --> myfn = fnname()
        import package.module.fn as fnname --> myfn = fnname() 
        from packag import module as modulename --> myfn = modulename.fn()                                                         
        import packagename.module as modulename ;  myfn = modulenme.fnname()
*/ 

//IMPORT  ACESSIBILITY:
/*
obj/fn/class            --> from : acessible by other modules                              (Eg1)
                           import : everything is acessible by other module
_obj/_fn/_class         -->from: not acessible to other modules                            (Eg 1)
                          import : everything is acessible by other module
__all__ = [obj/fn/class]-->from: only those in [] are acessible by other modules,rest not  (Eg 2)
                           import : everything is acessible by other module
as                      -->from:before as acessible by other module may create clash; after as acessible by module prevents clash
                           import: no clash created as acessed through module               (Eg 3,4)
if __name__ ==’main’    -->run only in the module and not acessible by other modules         (Eg 6)
                             code

Eg 1
Module1
a,b,_c,_d = 1,2,3,4

from module1 import *
print(a,b)              # 1 3
print(_b,_c)         #NameError: name '_b' is not defined
#import does not hide
import module1


print(module1.a,module1.b,module1._c,module1._d)  #1 2 3 4

Eg 2
a,b,_c,_d = 1,2,3,4
__all__ = ['a','_c']

from module1 import *
print(a,_c)#1 3
print(b,_d)#NameError: name 'b' is not defined
import module1
print(module1.a,module1.b,module1._c,module1._d)  #1 2 3 4



Eg 3
module1
X = 88
def fn1():
    global X
    X = 77

module2
from module1 import * --> X ; fn1() of module1 and mdule 2 clash
x = 99    
def fn1(): 
    pass

from module import x as mx ,fn1 as mfn1  --> mx;mfn1() belong to module1 X;fn1() belong to module2
x = 22  
def fn1(): 
    pass
print(mx1) 
mfn1() ----> fn1 belongs to module1

import module                             --> moddule1.x;module1.fn1() belong to module1 X;fn1() belong to module2
X  = 99     
def fn1():  
print(module.X)       
module.fn1()        



Eg 4
module 1
def fn1():
r = a+b
module 2:
def fn1():
r = a*b

module3                                   -->fn1() of module1,module2,module3()clash
from module1 import fn1()
from module 2 import fn1()
fn1()  --> module2 fn1() overlaps module1 fn1() now cant be accessed

from module1 import fn1() as m1fn1()         --> mfn1() belong to module 1; mfn2() belong to module2 ; fn1() belong to module3
from module 2 import fn1() as m2fn1()
def fn1()  
def  fn2()
m1fn1()
m2fn2()

import module1,module2                        -->module1.fn1() belong to module2.mfn2() belong to module2 ; fn1() belong to module3
def fn1()  
def fn2()
module1.fn1()  
module2.fn2()

Eg 5
module1
def maximum(*a):
    l = list(a)
    return max(l)
if __name__ == '__main__':     #run in module1 but not run in imported
    print(maximum(1,2,3,4))

*/


/* #endregion */

//FUNCTION
/* #region Main */

// NAMED FUNCTION --> FNS USED AS NORLAM FNS(NORMAL FN DECLARATIONS):
/*
def functionName(parameter): OR ------ (No arrow representation for named fn)
                            -->   pos arg , def/keywords arg(interchangble) , * , def/keyword arg(interchangeble) , ** 
                            --> parameter  position change ; argument pos change
                            --> parameter using fn name
                            -->parameter using annotations

fnname(arguements)       --> fnname(argument) is object
f = fnname(arguements)   --> fnname(arg) is object and f holds the return value  of function
f = fnname; f(arguments) --> fnname is object ; f holds the object reference
*/
 

//ANONYMOUS FN--> FNS USED AS PARAMETERS OR ARGS
/*
no normal representation for anonymous  fn   OR  lambda parameter:expression -->lambda par: exp is object  and variable f holds the 

f = lambda parameter:expression--> lambda par: exp is object  and variable f holds the
f(arguements)

Eg1
f = lambda a:a*2
f = lambda a,b:a if a < b else b
f = lambda a:[i*a for i in l if i%2 ==0]
f = lambda a:print(a+'is our integer')
print(f(2))

Eg2
f = lambda a =2,b=3,c=4:a+b+c
print(f(4,5,6))#override
print(f(a = 4,c=4))#override

Eg 3
l = [lambda x:x*2,lambda x:x*3,lambda x:x*4 ]
for i in l:
    print(i(2))

d = {
    'square':lambda x:x**2,
    'cube':lambda x:x**3,
    '4th':lambda x:x**4
    }


print(d['square'](2))
*/


//GENERATOR FN[Return generator obj at each iteration which can be iterated upon and return control to fn]   
/* 
Yield returns value(Eg 1)
def fn1(parameter):         --> yield returns value at each iteration, then takes back control to fn                  
     for i in range of ():
           yield expression
g = fn1(arguements) -->fn1(arguements) is agenerator  objand variable g holds reference to generator object which can be iterated over

Yield takes value(Eg 2)
def fn1(parameter):         --> yield returns value at each iteration, takes value gives it to x   ,then takes back control to fn  
     for i in range of ():
           x = yield i
g = fn1(arguements) -->fn1(arguements) is agenerator  objand variable g holds reference to generator object which can be iterated over
print(next(g))               -->   initialising 1st iteration is necessary before sending value
g.send(value)               -->   send 77 to yeild



Eg1
def fn1(n):
    for i in range(0,n):
        r = i*2
        yield r
g = fn1(3) # generator

i = iter(g)
print(next(g))#0
print(next(g))#1
for i in g:
    print(i)#0 1 4 9
l = list(g) #[0,1,4,9]
print(l)

def fn1():
    for i in range (0,10):
        x = yield i
        print(x)

g   = fn1()
print(next(g))  #    initialising 1st iteration is necessary before sending value
g.send(77)  #77    send 77 to yeild
g.send(88)#88 send 88 to yeild
*/


//NESTED FN
/*
def  fnname1(parameters1)
     def fnname2(parameters2)
        return 
     return fn2

f = fn1(arguements1)  --> fn1(arguements)  is object and f holds the reference to inner fn  fn2
f(arguements2)

Eg1
def fn1(x):
    def fn2(y):
        z = y*x
        print(z)
        return z
    return fn2
f = fn1(2)       # outer fn (arguement ) returns inner function so f = inner fn
f(2)              # inner fn (arguement)

g= fn1(3)        # outer fn (arguement ) returns inner function
g(3)             # inner fn (arguement)
*/


//PARAMETER , ARGUMENT
/*
Positional  arg   : def fn1(a)
                         fn1(1)
defination  arg   : def fn1(a = 2,b = 1)
                        fn1()   -> a, b need not be written
                        fn1(3)-> a overwritten
                        fn1(b = 2) -> b overwritten
  keyword arg     : def fn1(a,b)
                        fn1(a = 2, b = 3)
  *               : def fn1(*a,b)   -> collect the remaining values (1,2)
                        fn1(1,2,3)
                                
                    def fn1(a,b,c,d)
                        fn1(*iterable)   -> ass the values of iterable 1 by 1

 **               : def fn1(**d)    -> collect the remaining default arg and convert to dictionary
                        fn1(a = a, b = 2)
   
                    def fn1(a,b,c,d)
                        fn1(**iterable) -> pass the value of iterable 1 by 1
                                                                
                                                                 a = 2
parameter pos change: def fn1(a = 2): def fn1(a):   def fn1():   def fn1(a=a)                                   
                                        a = 2           a = 2           

                     
                                  b=1  
arguement pos change: def fn1(a) ;fn1(b) -->This may cause clash as def fn1(a) and you call fn1(b) so par = a; arg = b
                                            Shared variable(mutable , immutable)
                                            fn1(a)  
                                            b = 2    -> b = 2 ; b = a  so a = 2;b = 2
                                            fn1(b)
                                            Function recall (mutable, immutable)
                                            Immutables: Fn is recalled on a immutable obj ;the immutable obj do not retain change
                                            mutables: Fn is recalled on a mutable obj ;the mutable obj  retain change unless copied 
                                            
                                            EG1 #arguement pos change (shared var) ,# arguement pos change   (fn recall)


Parameter using fn name : fn1.parameter= vallie
                          EG1 #parameter using fn name

Parameter using annotations : parameter:annotation = argument -> return type         so annotation  is just an attachment to parameter
                             EG1 # Parameter using annotations
**NOTE:->return type is in syntax

Eg1
#positional arguement
def fn1(a):
    r = a * 2
    print(r)
    return r
fn1(1)

#default arguement
def fn1(a = 2):
    r = a*2
    print(r)
    return r
fn1()     # a need not be written
fn1(3)    #override a = 3
fn1(a = 4)# override a =3

def f(a, b=2, c=3):
    print(a, b, c)
fn1(1)       # b,c not compulsary
fn1(1,2,3)   #override b,c

def fn1(a, b=2, c=3):
    print(a, b, c)
fn1(1)     #1,2,3
fn1(1,5,c = 6)  #1 5 6
fn1(1,c = 6)    #1 2 6


# keyword arguement
def fn1(a, b):
    r = a + b
    print(r)
    return r


fn1(a=2, b=3)
fn1(b=2, a=3)  ## order is not imp


# *
def fn1(a,*b):       # collect all the remaining value and store in tuple
    print(a)#1
    print(b)#(2, 3, 4, 5, 6)
fn1(1,2,3,4,5,6)


def fn1(a,b,c,d):
    print(a,b,c,d) #1 2 3 4

fn1(*[1,2,3,4])      # pass value in the iterable object one by one in order


#**
def fn1(**)/fn1(**dictionary)
def fn1(**a):                      # collect all the remaining keyword arguements and store in dictionary
    print(a)#{'a': 1, 'b': 2}
fn1(a = 1,b=2)


def fn1(a,b,c):
    print(a,b,c)   #1 2 3

args = {'a': 1, 'b': 2, 'c': 3}
fn1(**args)                           # pass values of dictionary 1 by 1 order not important



#combination all keeping oreder in mind
def fn1(a,b=22,*c,d = 33,**e):    # poitional (a = 1)  , default ( b = 22 overwritten be 2) ,*(c = (3,4)), 
    print(a,b,c,d,e)                 default (d = 33 overwritten by 5)  **(e = {'x': 22, 'y': 33, 'z': 44}
fn1(1,2,3,4,5,x = 22,y=33,z=44)


def fn1(a,b,c,d):
    print(a,b,c,d)
fn1(1,2,3,4)    #1 2 3 4
fn1(a = 1,b =2, c = 3, d = 4) #1 2 3 4
fn1(1,2,c =3, d = 4)#1 2 3 4
fn1(*(1, 2), **{'d': 4, 'c': 3}) #1 2 3 4
fn1(1, *(2, 3), **{'d': 4})      #1 2 3 4
fn1(1, c=3, *(2,), **{'d': 4})   #1 2 3 4


def f(a, *b, c=6, **d):
    print(a, b, c, d) 
f(1, *(2, 3), c=7, **dict(x=4, y=5)) #1 (2, 3) 7 {'y': 5, 'x': 4}
f(1, c=7, *(2, 3), **dict(x=4, y=5)) # 1 (2, 3) 7 {'y': 5, 'x': 4}
f(1, *(2, 3), **dict(x=4,y=5, c=7)) # 1 (2, 3) 7 {'y': 5, 'x': 4}


def fn1(a, *b, c=6, **d):
    print(a,b,c,d)
fn1(1, 2, 3, x=4, y=5) #1 (2, 3) 6 {'y': 5, 'x': 4}
fn1(1, 2, 3, x=4, y=5, c=7)#1 (2, 3) 7 {'y': 5, 'x': 4}
fn1(1, 2, 3, c=7, x=4, y=5)#1 (2, 3) 7 {'y': 5, 'x': 4}


def fn1(a,*b,c):
    print(a,b,c)
fn1(1,2,c = 3) #1 (2,) 3
fn1(a = 1,c=3) #1,(),3


def fn1(a, *, b, c):
    print(a,b,c)
fn1(1, c=3, b=2) #1 2 3
fn1(c=3, b=2, a=1)#1 2 3


def fn1(a, *, b='spam', c='ham'):
    print(a,b,c)
fn1(1)  #1 spam ham
fn1(1, c = 3 )#1 spam ham
fn1(c=3, b=2, a=1)#1 2 3


def fn1(a, *, b, c='spam'):
    print(a,b,c)
fn1(1, b='eggs') # 1 eggs spam


def fn1(a, *, b=1, c, d=2):
    print(a, b, c, d)
fn1(3, c=4)#3 1 4 2
fn1(3, c=4, b=5)#3 5 4 2


def fn1(a,b=2,*c):
    print(a,b,c)     #4 5 (6, 7, 8)
fn1(4,5,6,7,8)


def fn1(a,*b,**c):
    print(a,b,c)         #1 (2, 3, 4) {'x': 1, 'y': 2, 'z': 3}
fn1(1,2,3,4,x = 1,y = 2,z = 3)


def fn1(a,*b,c= 22):
    print(a,b,c)
fn1(1,2,3,4,5) #1 (2, 3, 4, 5) 22


def fn1(a,*b,c):
    print(a,b,c)
fn1(1,2,3,4,c = 22) #1 (2, 3, 4, 5) 22


def fn1(a,*b):
    print(a,b)#1 (2, 3, 4)

fn1(*[1,2,3,4])


# parameter pos change
def fn1(a=2):
    age = a
    l = list(a)

def fn1(a):
    a = 2
    age = a
    l = list(a)

def fn1():
    a = 2
    age = a
    l = list(a)



# arguement position change(shared var)
def f(a):              
    print(a , b)  
b = 88               --> b = 88 ; b = a so a = 88 ; b = 88
f(b)       #88,88
print(b)   #88

def f(a):              
    a = 99
    print(a,b)    
b = 88                    --> b = 88 ; b = a so a = 99 , b = 88
f(b)      # 99,88
print(b)  # 88


def fn1(a):             
    a[0] = 5
    print(a,b)  
b = [1, 2, 3, 4]                    ---> b = [1,2,3,4] ;b = a ; a = [5,2,3,4,5] so a = [5,2,3,4,5] b = [5,2,3,4,5] 
fn1(b)    # [5, 2, 3, 4] [5, 2, 3, 4]   
print(b)  # [5, 2, 3, 4]



def fn1(a):
    l = a.copy()
    l[0] = 5
    print(a, b, l)  
b = [1, 2, 3, 4]         --> b = [1,2,3,4] ; b = a ; l = a.copy() ; l = [5,2,3,4] so a= [1,2,3,4,5] b = [1,2,3,4,5] , l = [5,2,3,4,5]
fn1(b)  # [1, 2, 3, 4] [1, 2, 3, 4] [5, 2, 3, 4]


def func(a, b, c):
    a = 2;
    b[0] = 'x';
    c['a'] = 'y'
    print(a,b,c)
l=1; m=[1]; n={'a':0}     -> l=1 m=[1]n={'a':0} ;l=a m=b n=c ; a=2 b=[x] c={'a':y} so l=1 a=2 m =['x'] b=['x'] ,n={'a':y} c={'a':y}  
func(l, m, n)              
print(l,m,n)

# arguement position change(fn recall)
#immutable do not retain chamnge
def fn1():
    print(s[0:4])
s = 'prasann'
fn1(s)#pra
fn1(s)#pra


#mutable retaion change
def fn1(l):
    l.append(1)
    print(l)
l = [1,2,3,4,5]
fn1(l)#[1, 2, 3, 4, 5, 1]
fn1(l)#[1, 2, 3, 4, 5, 1, 1]

#mutables do not retain change if copied
def fn1(l):
    l1 = l.copy()
    l1.append(1)
    print(l1)
l = [1,2,3,4,5]
fn1(l)#[1, 2, 3, 4, 5, 1]
fn1(l)#[1, 2, 3, 4, 5, 1]

#parameter using fn name
def fn1(a)
     def fn2(a)
        fn2.a1 = fn1.a1 + 1
     return fn2.a
   return fn2

#Parameter using annotations
def fn1(a,b,c):
   print(a,b,c)

def fn2(a = 4,b = 5 ,c = 6):
    print(a,b,c)

def fn1(a: 'spam', b: (1, 10), c: float) -> int:
    print(a,b,c)

def fn2(a: 'spam' = 4, b: (1, 10) = 5, c: float = 6)->int:
    print(a,b,c
print(fn1.__annotations__) #{'a': 'spam', 'b': (1, 10), 'c': <class 'float'>, 'return': <class 'int'>

*/


//FN AS OBJECT
/*
fnname(arguements)     :l = [fn1(1) , fn2(2) ; fn3(3)]                               l[0]
                        l = [func(arg) for func(arg) in [(fn1,1) , (fn2,2) ]  ]      l[0]
                        d = {‘key1’:fn1(arg1);’key2’:fn2(arg2)}                      d[‘key1’]
                        def function(func,arg)                                       function(fn1,arg1); function(fn2,arg2)
                            return func(arg)
f = fnname(arguements)  :l = [f1 , f2 ; f3]                                          l[0]
                         l = [func(arg) for func(arg) in [(f1,1) , (f2,2) ]  ]       l[0]
                         d = {‘key1’:f1;’key2’:f2}                                   d[‘key1’]
                         def function(func,arg)                                      function(f1,arg1); function(f2,arg2)
                            return func(arg)
f = fnname; f(arguments):l = [fn1,fn2,fn3]                                            l[0](2)
                        d = {‘key1’:fn1;’key2’:fn2}                                   d[‘key1’](arg)

Eg:
def fn1(a):
    r = a*2
    print(r)
    return r
def fn2(b):
    r = b*3
    print(r)
    return r
def fn3(a,b):
    s = a+b
    p = a*b
    print(s,p)
    return s,p

#fnname(arg)
l = [fn1(1),fn2(2),fn3(1,2)]                                                           ;print(l[0])
l = [func(arg) for (func,arg) in [(fn1,2),(fn2,3)]]                           ;print(l)
d = {'multiply 2':fn1(2),'multiply by 3':fn2(3),'multiply by 3 ':fn3(1,2), }   ; print(d['multiply by 3 '])
def function(func, arg):
    func(arg) # Call the passed-in object by adding ()
function(fn1, 2)
function(fn2,3)


#f = fnname(arg)
f1 = fn1 ; fn = fn2; f3 = fn3 
l = [f1(1),f2(2),f3(1,2)]                                                           ;print(l[0])
l = [func(arg) for (func,arg) in [(f1,2),(f2,3)]]                      ;print(l)
d = {'multiply 2':f1(2),'multiply by 3':f2(3),'multiply by 3 ':f3(1,2), }   ; print(d['multiply by 3 '])
def function(func, arg):
    func(arg) # Call the passed-in object by adding ()
function(f1, 2)
function(f2,3)

#f = fnname; f(arg)
l =[fn1,fn2,fn3]                                                               ;print(l[0](3))
d = {'multiply 2':fn1,'multiply by 3':fn2,'multiply by 3 ':fn3 }               ;print(d ['multiply 2'](2))
*/


/* #endregion */


//CLASSES
/* #region Main */


/*
class C1(C2, C3 ) :                  -->  Inherits first from Left then from right ie C2(var x,z) ;C3(w,z)  then C1 will inherit x , z of C2 ; w  and not z  of C3 
*/
          //CLASS VARIABLES:
          /*
           class var                        -->class variables belong to class 
           Classname.classvar = object      -->class variables are acessed through class and not object of class and 
                                               class var acessing, creation , overwriting changes in class ;so  future calling affected
                                               Eg 
                                               class C1:                                                                            
                                                  gpa = 3.44                                                                     

                                                C1.gpa            -> acessed gpa                                                                  
                                                C1.gpa = 3.77;   -> overwritten gpa    --> so class is also modified as                                                                           
                                                C1.gpa2 = 3.123   -> created gpa 2           gpa = 3.66; gpa2 = 3.123                                                      

                                                C1.gpa -> 3.77                         --> furure calling is affected  as gpa is 
                                                C1.gpa2 ->3.123                            overwritten value   and gpa 2 which is 
                                                                                            never in class is now  acessible
            Eg 1
           */

          //CONSTRUCTOR METHOD; INSTANCE VARIABLES:
          /*
          def __init__(self,parameter)                  --> when object of class is made(I1 =  C1(arg) then C1(arg) is object which is 
            self.instvar = parameter ;value             instanciated  by isnt var I) constructor is invoked.Constructor have acess to inst var 
                                                        and are mainly    used to initialise instance variables   
                                                                                                
          I1 = C1(arguement)                         
          I1.instvar ; C1(arguement).instvar          -->instance variables are acessed through  obj of class(like I1.inst var) or self 
                                                        keywor(like we do def fn1(a):a = self.gpa + 2 )
                                                        Instvar acessing, creation , overwriting changes in  constructor  also ;so  future  
                                                        calling affected                                                                                                                                                           
                                                        and inst var must not always be equal to parameters ; youmay have inst var with a
                                                        value so parameter is not req as it has a  value
                                                         Eg  
                                                        class C1:                                                                            
                                                            def __init__(self, name, gpa):                                   
                                                                self.name = name                                                        
                                                                self.gpa = gpa                                                                                                                               
                                                                self.sex = “male”          -> sex has value “male” so we don’t req to pass a parameter for male                                                    

                                                        I1 =C1("jim",3.1); 
                                                        I1.name;   -> name acessed           --> so inst var also change in constructor as 
                                                        I1.gpa = 12 =  -> gpa ovewritten            self.name = name  ;self.gpa = 12; self.car = “ferrari”                                                      
                                                        I1.car = “ferrari” -> car added

                                                        I1.name -> gove name                        --> future calling is affected as gpa is overwritten and  car inst var is added is  now available
                                                        I1.gpa -> give 12
                                                        I1.car -> give ferrari
            Eg 1
    
            */


          //METHODS
          //INSTANCEMETHODS --> most commonly used  
           /*                                            
          def fn(self,parameter):                                           -->method have acess to inst var and parameters ;
                elf.instvar,parameters                                                                                 

           I1.fn1(arg) ; C1(arg).fn1(arg)-  
           C1.fn1(args); C1.fn1(I1,args)                                    -->method are  acessed through  object of class  (bound  call)or class (unbound 
                                                                              call) by passing instance as 1st parameter
           */
          //CLASSMETHODS --> used for applications that need acess through class eg factory methods       
          /*
          @classmethod;                                      
            def fn(cls,parameter):                                           -->method  have acess to  class var  and parameters not inst variables
                C1.classvar/cls.classvar,parameter                             and methoc can return a class object cls() So I = C1.fn(arg) is equivalent to  I = 
                return cls(parameter)                                          C1(arg) which can even prevent calling of constructor as this does its job (Eg3)                                                                                                                    

            I1.fn1(arg);  C1(arg).fn1(arg)-                                  --> method acessed  through   object of class(bound call)     
            C1.fn1(arg) ; C1.fn1(I1,args)                                        class (unbound call)  withut passing instance as 1st parameter
                                                                                 but bound call is legal  not ethical
            */
          //STATICMETHODS-->used for applications when youneither need class or inst variabes
          /* 
           @ staticmethod
           def fn(parameter):                                                 -->method have acess parametersand none  of inst; var,class var
                parameter  
          
            I1.fn1(arg);  C1(arg).fn1(arg                                             
            C1.fn1(arg)  ; C1.fn1(I1,args)                                    -> method  acessed  through  object of  class(bound call)  or class (unbound) 
                                                                                 without passing inst   var as 1st arg but bound call is legal not ethical

           fn1 = classmethod(fn1);fn1 = staticmethod(fn1)                     -> return class method ; staticmethod
                                                                                 Declared after method in class
           C1.fn1 = classmethod(C1.fn1); C1.fn1 = static(C1.fn1);             ->return class method ; staticmethod
                                                                                Declared out of class

            Eg 2,3
            */
          //INHERITED METHOD:
          /*
            def fn(parameter) :                                               -> subclass inherits , extends , creates, overloads(PYTHON CANT OVERLOAD), overwrites , 
                                                                                 class variables and methods  of superclass acc to inheritance tree rule
                                                                                inherits:
                                                                                subclass inherits class  var and methods of superclass

                                                                                Creates:
                                                                                subclass can create its own class  var and methods

                                                                                
                                                                                Overloaded(compile time static polymorphism)
                                                                                Python cant overload

                                                                                0verriding(Runtime dynamic polyorphism):
                                                                                1.Overrideclass , method with same name  and differen parameters and body and override abstract method also without fail

                                                                                Extending function
                                                                                CASE 1:      
                                                                                C1;C2;C3(C1)
                                                                                1.Acess by class (Bound call)
                                                                                I1 = C1(arg)                           C2() cant be used as obj
                                                                                I1.fn1(arg) ; C1(arg).fn1(arg)
                                                                                2.Acess by class(Unbound )   
                                                                                C1.fn1(args) ;C1.fn1(self,args)        C2 cant be used as class       
                                                                                3.Acess by super method()                                                          
                                                                                super() = C1()  implicitly             super() = C2 ()manually                                                                                                                                                                                                                                                                                                                                                          
                                                                                super().fn1(args)                      super.fn1(args)  |
                                                                                                                                        |
                                                                                                                            do  C3._bases_ = (C2,)
                                                                            
                                                                               CASE 2:       
                                                                               C1;C2;C3(C1,C2)
                                                                                1.Acess by class (Bound call)
                                                                                I1 = C1(arg)                            I2 = C2(arg)
                                                                                I1.fn1(arg) ; C1(arg).fn1(arg )         I2.fn1(arg);C2.fn1(args)       
                                                                                2.Acess by superclass(Unbound )
                                                                                C1.fn1(args) ;C1.fn1(self,args)         C2(arg) ; C2.fn1(self,arg)
                                                                                3.Acess by super method()                                                          
                                                                                  super() = C1()  implicitly            super() = C2 ()manually                                                                                                                                                                                                                                                                                                                                                          
                                                                                  super().fn1(args)                     super.fn1(args)  |
                                                                                                                                         |
                                                                                                                                    do  C3._bases_ = (C2,)
              Eg 6,7,8,9
            */
          //ABSTRACT METHOD:
          /*
           from abc import ABCMeta,abstractmethod 
            Class A(metaclass = ABCMeta):
                 @abstractmethod
                  def fn1(self):          -->  method protype is made and it must be overwritten in subclass
                       pass:
                  def fn2(self):           --> if fn2() not overwridden  in subclass then it will raise Error
                      raise NotImplementedError('action must be defined!')/assert False, 'action must be defined

                class B(class A)
                   	def fn1(parameters)
            */
          //ENCAPSULATING  METHOD
           /*
            var/methods;__var/__methods          -> declaring var and methods public and private 
                                                            Same package    Same package     Same package     Different Pack  Different pack
                                                            Same class      subclass         Non-Subclass     Subclass        non Subclass
                                                    Public   Y              Y                Y                Y               Y                                            
                                                    Private  Y              N                N                N               N   

            public getmethdname(self)                         ->acess the   the private var , method through a public  method (any normal method is public
                 return self.__privatevariable/method            Like in eg 5 you used     salary in  display 
                                                                                                                                                                                         which  display iis a public method)
      
          Eg 5
          */
          //OPERTOR OVERLOADING METHODS:
          /*
          def __add___(self, parameter):                                               -->method have acess parametersand none  of inst; var,class var
             return self.instvar  + parameter
           I1 + argument  ; C1() +arguments                                            --> method  acessed  through  object of  class(bound call)  

          def __radd__(self, parameter):         
              return self. instvar + parameter
          argument  +I1  ; argument  + C1() 

          def __iadd__(self, parameter ):        
              return self. instvar + parameter
           I1 =  I1+ argument    ; C1 = C1()  +argument  

          def __add__(self, parameter):          
              return self.instvar + other
           def __radd__(self, parameter):
             return self.__add__( parameter )/return self + parameter
           I1 + argument  ; C1() +arguments   and  argument  +I1  ; argument  + C1()      --> both supported in this comnbined method

          def __sub__(self, parameter):                          
               return self. instvar - parameter    
           I1 - argument  ; C1() - arguments                                           

           def __mul__(self, parameter ):                        
              return self. instvar * parameter 
          I1 *argument  ; C1() * arguments                                           

           ##similarly we have sub; rsub; isub; sub and  rsub combo ; mul ; r mul; isi mul ;mul and  rmul combo

          def __eq__(self, parameter):      
                return self. instvar == parameter
           I1 == argument; C1() == arguments                                           

          def __ne__(self, parameter):      
            return self. instvar != parameter
          I1 != arguement `; C1() != arguments                                           

          def __gt__(self, parameter):      
            return self. instvar > parameter 
          I1 > argument; C1() > arguments                                           

          def __lt__(self, parameter):      
            return self. instvar < parameter
          I1 < argument; C1() < arguments                                           

          def __setitem__(self, keyparameter, valueparameter):                         
            self.instvar[keyparameter] = valueparameter
          I1[keyarg] = valuearg ; C1() * arguments                                           

          def __getitem__(self, itemparameter):                                 
            return self.instvar[itemparameter]                                
          I1([itemarg])  ;C1() * ([itemarg])                          -->instance attribute becomes iterable   eg   (a, b, c, d) = I1,for i in I1,list(map(str.upper, I1))

          def __getattr__(self, keyparameter):                                
            if keyparameter == 'X':
                return self.instvar
            else:
                raise AttributeError(key + 'not alowed')
          I1.keyarguement   ; C1().  keyarguement

          def __setattr__(self, keyparameter, valueparameter):                         
            if keyparameter  == 'x':
                self.__dict__[keyparameter] = valueparameter + 10
                OR
                object.__setattr__(self, keyparameter, valueparameter + 10)    -->use this  method used  instead of self.X = value + 10   to avoid recursion
            else:                                                               --> dont use else , beacuause it is creating error
                raise AttributeError(key + ' not allowed ')
          I1.keyarguement = valuearguement;   C1().keyarguement = valuearguement



          def __str__/__repr__(self):                                            
            return '[attributes are : %s, %s]' % (self.instancevar, self.instvar)        
            return str(self.gpa)# supports str only
          print(repr(I1));print(repr(C1()))                                       -->repr will be  run
          print(str(I1));print(str(C1())                                          -->repr will be run
          print(I1);print(C1())                                                   -->if both str and repr present then str > repr and repr run
                                                                                     if only str or only repr present then the present one is run
                                                                                     if neither str or repr present then print gives adress of class object


          def __bool__(self)/ __len__(self):       :       
            return True                 
          I1    ,C1()                                                                -->for __bool__return True if object of Class(C1()) is  present
                                                                                     for __lrn__return True if len!=0 ie  object of Class(C1()) is  present
                                                                                     if both __bool__ and __len__ are present bool is taken
                                                                                    * print(bool(I1))this inbuilt method does the above task also    

     
         Eg 4
           


        ***Note: 1st arg is taken as self , cls only and rest arg are parameters.This gives you freedom to declre other var than sef,cls 
                 Eg def  fn1(self)   def fn1(obj)
                    Self.gpa = 3.3      obj.gpa = 3.33
        */
          //EXAMPLES
          /*
        Eg1
        class C1:                                                                            
            gpa = 3.44                                                                     

                def __init__(self, name, gpa):                                   
                self.name = name                                                        
                self.gpa = gpa                                                                                                                               
                self.sex = “male”                                                              

        C1.gpa ; C1.gpa = 3.77; C1.gpa2 = 3.123   
        I1 =C1("jim",3.1);I2=C1("jill",3.3)      
        I1.name;I1.gpa = 12 =  ; I1.car = “ferrari” -> inst var sex added , name acessed ,gpa overwritten car added


        Eg 2
        class C1:
            def __init__(self, a, b):                                                     
                self.a = a
                self.b = b 
            
            def avg(self,c):                                                                    
                return (self.a + self.b+c) / 2                                       

        @classmethod    
            def info(cls,surname):                                                      
                return cls.name + surname                                        

        @staticmethod
            def info2(surname):                                                              
                return "This is a student class"+surname                   

        I1 = C1(1,2)
        I1.avg(3);  C1(1,2).avg(3); C1.avg(I1,3)
        I1.info(“patil”);  C1(1,2).info(“patil”); C1.info(“patil”)  
        I1.info2(“patil”);  C1(1,2).info2(“patil”) -> Legal not ethical      ;   C1.info(“patil”)                                                             

        Eg 3:
        class C1:
            def __init__(self, a, b):                                                     
                self.a = a
                self.b = b 
        

        @classmethod
            def info(cls,surname):                                                      
                return cls(surname) 

        I1 = C1(1,2)     
        I2 = C1.info(“patil”) -> equivalent to I2 = C1(“patil”)



        Eg 4
        Class C1:

            def __init__(self, name, gpa):                           
                self.name = name
                self.gpa = gpa
            I1 =C1("jim",3.1);I2=C1('jack', 3.9)

            def __add___(self, other):                                
                return self.gpa  + other
            no = I1 + 0.3  ; print(no)

            def __radd__(self, other):         
            return self.gpa + other
            no = 22 + I1

            def __iadd__(self, other):      
            return self.gpa + other   
            I1 = I1 + 2 
            
            def __add__(self, other):          
            return self.gpa + other
            def __radd__(self, other):
            return self.__add__(other)/return self + other
            no = I1 + 0.3 OR no = 0.3 + I1 
        
            def __sub__(self, other):                                  
                return self.gpa – other
            no = I1 - 3.0;  print(no)
        
            def __mul__(self, other):                                  
                return self.gpa*othe
            no = I1*22;print(no)

            def __eq__(self, other):      
                return self.gpa == other
            print(I1 == 22) T or F

            def __ne__(self, other):      
                return self.gpa != other
            print(I1 != 22) T or F

            def __gt__(self, other):      
            return self.gpa > other
            b = I1 > 22; print(b) T or F

            def __lt__(self, other):      
                return self.gpa < other
            b = I1 > 22 ; print(b) T or F

            def __setitem__(self, key, value):                         
                self.name[key] = value
            I1[2] = 's' ;  print(I1)
            def __getitem__(self, item):                                
                return self.name[item]                               
            l  = I1([2:5:2]) ; print(l)                      --> instance attribute becomes iterable   eg   (a, b, c, d) = I1,for i in I1,list(map(str.upper, I1))

            def __getattr__(self, key):                                
                if key == 'X':
                    return self.gpa
                else:
                    raise AttributeError(key + 'not alowed')
            print(I1.X)
            def __setattr__(self, key, value):                         
                if key  == 'x':
                    self.__dict__[key] = value + 10
                    OR
                    object.__setattr__(self, key, value + 10)  -->use this  method used  instead of self.X = value + 10   to avoid recursion
                else:                                          -->dont use else , beacuause it is creating error
                    raise AttributeError(key + ' not allowed ')
            I1.x = 40,print(I1.x) - > 50

            def __str__(self)
                return '[%s , %s]'%(self.name, self,gpa)
            def__repr__(self):
                return (%s)%(self.name)
            print(repr(I1));print(repr(C1()))        -->repr will be  run
            print(str(I1));print(str(C1())           -->repr will be run
            print(I1);print(C1())                   -->if both str and repr present then str > repr and repr run
                                                        if only str or only repr present then the present one is run
                                                        if neither str or repr present then print gives adress of class object
                                                        eg <__main__.C1 object at 0x0000000002960AC8>>


            def __bool__(self):       
            return True                
            def __bool__(self):       
            return True                                                         
            if I1 :
                print('I1 present')               --> for __bool__return True if object of Class(C1()) is  present
                                                    for __lrn__return True if len!=0 ie  object of Class(C1()) is  present
                                                    if both __bool_- and __len__ are present bool is taken
                                                    * print(bool(I1))this inbuilt method does the above task also    






        Eg5
        class C1:
        def __init__(self,empname):
            self.empname= None
                self.__salary = empname
        def display(self)
                print("Employee name is" ,self.eplname,"salary":,self.salary)

        employee = Employee(2000)
        employee.empname = "john" 
        employee.display() 








        Eg6
        class C1:
            a = 22;
            def __init__(self,name,gpa):
                self.name= name
                self.gpa = gpa
            def fn1(self , percent)
                    self.gpa= self.gpa/ percent
                    return self.gpa
        class C2:
            pass


        class C3(C1):
                                                                            ->inherits- inherits   clas var a and method    __init__  , fn1
        
            b  = 33                                                       ->creates class var b and method fn2
            def fn2(self , percent)
                    self.gpa = self.gpa*percent
                    return self.gpa


            a = 12                                                       ->overwride-   overwride class var a and  method __init__,fn 1()
            def __init__(self, name ,gpa , height):           
                self.name = name
                self.gpa = gpa
                self.height = height
            def fn1(self,percent,bonus):
                self.gpa = (percent + bonus/ 10 )
                print(self.gpa)

            def fn1(self,percent):                                     ->extender -  extend method fn1() if scenario was C1;C2(C2)
                #unbound method
                I1 = C1('prasann',2.3)                                   C2() cannot be used as obj
                I1.fn1(20);C1('prasann',2.3).fn1(20)
                #bound method
                C1.fn1(20); C1.fn1(self , 20)                            C2 cannot be used as class
                #supercall
                super() = C1() implicitly                                super()  = C2() manually , do C3.__bases__ = (C2,)
                super(). fn1(20);                                        super(). fn1(20);          
                

            def fn1(self,percent):                                     ->extender -  extend method fn1() if scenario was C1;C2(C2)
                #unbound method
                I1 = C1('prasann',2.3)                                    I2 = C2('prasann',2.3)
                I1.fn1(20);C1('prasann',2.3).fn1(20)                      I2.fn1(20); C2('prasann',2.3).fn1(20)
                #bound method
                C1.fn1(20); C1.fn1(self , 20)                             C1.fn1(20); C1.fn1(self , 20)
                #supercall
                super() = C1() implicitly                                 super()  = C2() manually , do C3.__bases__ = (C2,)
                super(). fn1(20);                                         super(). fn1(20);          



            

        I3 = C3(arg)                                                                -->acess class var and methods through subclass object or 
        I3.method(arg)   ; C3(arg).method(arg)
        C3.classvar/method(arg) ;C3.classvar/method(self.arg)   

                                                                                        
        Eg7:
        class C1:
            a = 22;
            def __init__(self,name,gp):
                self.name= name
                self.gpa = gpa
            def fn1(self , percent)
                    self.gpa= self.gpa/ percent
                    return self.gpa

        class C2(C1):
            def __init__(self, name ,gpa,gpa2 ):    ->added parameter in method(gpa2) 
                C1.__init__(self,name,3.22)          ->and assign argument to parameter of superclass method call (self.gpa = 3.22)
                        self.gpa2 = 22
                        
            def fn1(self,percent,bonus)              ->added parameter in method(bonus)        
                C1.percent(self,percent+bonus)       ->and assign argument to parameter of superclass method call (percent = percent+ bonus)
                    make changes here

        */


/* #endregion */


//OBJECT
/* #region Main */

//(
    /*
    Everyting on RHS  is object 
    a= 22  ; def fn() ; class C1();import math--> 22 ; fn();c1(),math are objects and a,f,I1 are variables assigned to them
    */
    //DECLARATION
    /* 
    Normal Assignment
    varname = obj   --> var references to object
    Sequential Assn 
    (var1 , var2 , var3 ) = object --> each var references to  each element in obj
    Extended assignment
    (var1 , var2 , *var3) = object--> each var references to  each element in obj *variable fills gap of less or more elements  by forming a list
    Nested Assn  
    (var1 , (var2) , *var3) = object--> each var references to  each element in obj *variable fills gap of less or more elements  by forming a list
    Iterating assignment
    for (var1, var2, var3) in [t1, t2]  --> (var1,var2,var3) = t1 fir 1st iteration ,  (var1,var2,var3) = t2 fir  2nd iteration

    Eg1
    s = 'spam'
    t  = ('yum', 'YUM')
    l = ['yum', 'YUM']
    s = {1,2,3,4,5,6}
    input = open('data.txt', 'r')

    #sequence assignment
    a, b, c, d = s   #a= s,b =p ,c = a,d=m
    (a,b,c,d) = s    #a= s,b =p ,c = a,d=m
    [a,b,c,d] = s    #a= s,b =p ,c = a,d=m

    a,b =l              #a = yum,b = TUM
    (a,b) = l           #a = yum,b = TUM
    [a,b]=l             #a = yum,b = TUM

    a,b = t         #a = yum,b = TUM
    (a,b) = t       #a = yum,b = TUM
    [a,b] = t       #a = yum,b = TUM

    (a,b,c,d,e) = input


    #extended assignments
    (a,b,c,d,e) = s    # error because mismatch elements on lhs rhs  so * fills in gap of mismatch element

    a,*b = s           #a = s,*b = pam,b = ['p', 'a', 'm']
    *a,b = s          #*a = spa ,a = ['s', 'p', 'a'], b = m ,
    a,*b,c = s       #a = s  , *b = p a , b =['p', 'a']  , c=m
    a, b, *c = s     # a = s , b = p , *c = am , c = ['a','m']
    (a,b,*c,d,e) = s     #  no error on mismatch  but * element assigned empty list a = s, b= p , *c = nothing , c = [] , d  = a , e = m
    a, *b, c, *d = s    # error because not more than 1 starred elements

    #nested assignments
    (a, (b, c)) = s[:2], s[2:]    # a = 'sp' , b = 'a' , c = 'm'
    (a, (*b, c)) = s[:1], s[1:]   # a = s , *b = p a , b = ['p', 'a'] , c = m

    # for loop
    t1= (1, 2, 3)
    t2 = (4, 5, 6)
    for (a, b, c) in [t1, t2]:      #(a,b,c ) = t1 for 1st iteration (a=1,b=2,c=3) (a,b,c) = t2 for 2nd iteration(a=4,b=5,c=6)
    print(a)

    t1 = ((1, 2), 3)
    t2 = ((4, 5), 6)
    for ((a, b), c) in [t1, t2]:   #t1 for 1st iteration (a=1,b=2,c=3) t2 for second(a=4,b=5,c=6)
        print(a)
    */
    //CONVERSION(CONVERSION OP)
    /*
    (Reason for conv: mutability , iterability , special properties(like string is required in print(""+ )  , set remove duplicates )
    Eg
    name = "bob"              
    l1 = list(name)    ->list are mutables
    l1[1] = "a"
    print("".join(l1)) 
    i = 22
    s = str(i)           -> string is iterable
    for i in s:
    l = [1,2,3,4,3,2,1]    
    se1 = set(l)         -> set remove duplicate
    l1 = list(se1)
    i = 22
    print("the integer is" + str(i)) -> str is required for concatenating through +)
    )

    ***Conversion from set is random  and conversion toset removes duplicate***
    Int(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to int
    i1 = int(i)

    float(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to float
    f1 = float(i)

    complex(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to complex
    c1= complex(i,i)

    bin(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to bin
    b1 = bin(i)

    oct(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to oct
    o1 = oct(i)

    hex(obj)-> converts object(obj must be int,,float,complex,bin,oct,hex) to hex
    h1 = hex(i)

    str(obj)-> converts obj(elements of l,t,se,d can be anything but it also includes [,(,{ characters in it) to str
    s1 = str(i,f,c,b,o,h)    
    s1 = str(l)
    s1 = str(t)
    s1 = str(se)   #random order
    s1 = str(list({key  for (key,value) in d.items() if key == 'middle'}))
    s1 = str(input)


    repr(object)-> eorks same as str but gives coded format
    i=22
    s='prasann'
    print(str(i)) #22
    print(repr(i)) #22
    print(str(i))  # prasann
    print(repr(i)) #'prasann'



    “”.join(obj)-> converts obj(elements of l,t,se,d can be string only  but does not  includes [,(,{ characters in it) to str
    s1 = str(i,f,c,b,o,h)     
    s1 = "".join(l) 
    s1 = "".join(t)  
    s1 = "".join(se)  #random order
    s1 = "".join(list({key  for (key,value) in d.items()}))  
    s1 = "".join(input)


    list(obj) -> converts obj(obj must be iterable ) to list
    l1 = list(str(i))  
    l1 = list(s)       
    l1 = list(t)       
    l1 = list(se)       #Random order
    l1 = list({key  for (key,value) in d.items() })  
    l1 = list(input)

    [i for i in objects ] -> converts obj(obj must be iterable ) to list
    l1 =  [ i for i in str(i)]
    l1 =  [ i for i in s]
    l1 =  [ i for i in t]
    l1 =  [ i for i in se]
    l1 = [key  for (key,value) in d.items()]


    tuple(obj) -> converts obj(obj must be iterable ) to tuple
    t1 = tuple(str(i))  
    t1 = tuple(s)       
    t1 = tuple(l)       
    t1 = tuple(se)      #Random order
    t1 = tuple({key  for (key,value) in d.items() if key == 'middle'})   
    t1 = tuple(input)

    (i for i in objects ) -> converts obj(obj must be iterable ) to tuple but this a genetaror fn so we need to add tuple() to it
    t1 = tuple(i for i in str(i))
    t1 = tuple (i for i in s)
    t1 = tuple (i for i in t)
    t1 = tuple ( i for i in se)
    t1 = tuple (key  for (key,value) in d.items())


    set(obj) -> converts obj(obj must be iterable ) to set
    se1 = set(str(i))  # remove duplicate
    se1 = set(s)       # remove duplicate
    se1 = set(l)       # remove duplicate)
    se1 = set(t)       #remove duplicate
    se1 = set({key  for (key,value) in d.items() if key == 'middle'}) # remove duplicate
    se1 = set(input)# remove duplicate

    {i for i in objects } -> converts obj(obj must be iterable ) to set
    se1 =  { i for i in str(i)} # remove duplicate
    se1 =  { i for i in s}# remove duplicate
    se1 =  { i for i in t}# remove duplicate
    se1 =  { i for i in se}# remove duplicate
    se1 = {key  for (key,value) in d.items()}# remove duplicate


    dict(zip(obj1,obj2)) -> converts obj1as key obj2 as value(obj1,obj2 must be iterable) to dictionary
    d1 =  dict(zip(str(i1),str(i2)))
    d1= dict(zip(str(s1),str(s2)))
    d1= dict(zip(str(l1),str(l2)))
    d1= dict(zip(str(t1),str(t2)))
    d1= dict(zip(str(se1),str(se2)))

    {obj.index(i):i   for i in objects } -> converts obj(obj must be iterable ) to dictionary
    d1 = {s.index(i):i for i in str(i)} # remove duplicate
    d1 = {s.index(i):i for i in s}   # remove duplicate
    d1  = {l.index(i):i for i in l}   # remove duplicate
    d1 = {t.index(i):i for i in t}  # remove duplicate
    d1 = {se.index(i):I  for i in se}  # remove duplicate
    d1 = {line.index(i):i  for line in input}# remove duplicate
    )
    */
    //DADATYPE(DATATYPE OP)
    /*
    typeof(operand)            -->returns  datatype of operand
    */
    //COMPARISION(COMPARISION OP, LOGICAL OP , INCLUSION OP)
    /*
    //COMPARISION OPERATOR 
    PRIM:< , > <= , >= , !=  ,==;     -->compare values                   ** = is assignment operator    
    REF:< , > <= , >= , !=  ,== ; is  -->compare values ;comare reference                             
                                   COMPARE VALUES 
                                    i1 = 3
                                    s1 ='3'
                                    i1 == s1 -- true

                                    COMPARE REFERENCE
                                    a = [1,2,3,4];b=a;b[1]= 99
                                    a==b          #True
                                    a is b        #True
                                    a = [1,2,3,4];b=list(a);b[1]= 99
                                    a==b         #False
                                    a is b       #False

                            
                                    int         -> compared by number
                                    String,     -> compared lexicgraphivcally  left to right acc to characters equivalent integer-- https://www.w3schools.com/charsets/ref_html_ascii.asp   
                                    list,tuple  -> compared left to right  y va;ue
                                    Set         -> = same set , < subset , > superset
                                    dictionary  ->sorted(d.item()) < sorted(d.item())

  
    //LOGICAL OPERATOR  
    and -->go on till values are true and return false if value is false)   ** & | ^ are bitwise operators
    or -->goes till value is true returns if value is true)    
    not  -->not        

    //INCLUSION OPERATOR
     in -- return true if object1 is a part of object 2)
           Eg1
           a = 1
           l = [1,2,3]
           a in l -- true
      

    */
   
    //IP,OP
    /*
    s = input(“string”)               -->takes string only
    s = conversion(input(“string”)  ) -->takes any obj

    print(“str ”,   end = ‘end char instead of newline ’ , sep = ‘seperation char instaed of space’ , file = ip/op )
                                            --> takes str so convert
                                                Concatenation by + and,Escape Sequence ,String types,Formatting(RE) --> Look in Application/String Formatting



    Eg
    i = int(input('enter no'))
    s = input('enter no ')
    l = list(input('enter no '))


    Eg
    x = 99
    y = 'spam'
    z = [1,2,3,4]

    s = “int is” + str(x); print(s)
    s = “string is” + y; print(s)
    s = “list  is”  “”.join(str(i) for i in l); print(s)
    print(“int is” + str(x))
    print(“string is” + y)
    print(“list  is”  “”.join(str(i) for i in l))

    print(s)
    print(“int is” ,x)
    print(“string is”  “ ,l) -> [] will also be included

    print(x,y,z,end='');print(x)   #99 spam [1, 2, 3, 4]99
    print(x,y,z,end='.');print(x)  #99 spam [1, 2, 3, 4].99
    print(x,y,z,sep = '')          #99spam[1, 2, 3, 4]
    print(x,y,z, sep=',')          #99,spam,[1, 2, 3, 4]

    print(x, y, z, sep='...', file=open('data.txt', 'w')) # write to file
    print(open('data.txt').read()) # read from file
    */
//)

                                        /*                                                                  
                                       1.REF TYPE : shared by  ref( var.metod() ;  ==)        PRIMIRIVE TYPE: not present in python
                                       2.MUTABLE : change in place (2 applications in eg2)    MMUTABLE :change by forming copy (2 app eg2)
                                       3.ITERABLE: We can iterate over the object              INITERABLE: convert OR use fns return iterable
                                                                                                Eg: Iterable Object--> give iterator
                                                                                                                      s,l,t,se file  
                                                                                                    Genarator fns --> give generator obj<map at ox500> that must be ierated over
                                                                                                                      def fn: yield ;range();zip();  ;enumerate(), map(), filter()-
                                                                                                    Generator expressions --> give generator obj <expression  at ox500> that must 
                                                                                                                               be ierated or (expression)
                                       */
//                                                       |
//                                                       |
//INT,FLOAT,COMP,POW,BIN,OCT,HEX ,DEC , FRACT, BOOL -->REF TYPE , IMMUTABLE , INITERABLE
/*
#integer
 i = 22 `   
#float                            
i = 22.22                               
#complex no
i = 22 +22j                            
#power
i = 3.14e-10 ->3.14 x 10^(-10) 
i = 4.0e+210 ->4.0 x 10^(210)
#binary            
i = 0b101010                       #base print(i) will convert it to decimal
#octal
i = 0o177                              
#hex
i = 0x9ff                                
#decimal
import decimal                                  
decimal.getcontext().prec = 3          #set precision globally (d3 d4 both will be upto 3 decimal places )
d1 = decimal.Decimal('1.0732')         #string ip only
d2 =decimal.Decimal('3.1234')
d3 = d1/d2
d4 = d1/d2

import decimal
d1 = decimal.Decimal('1.00')
d2 =decimal.Decimal('3.00')
with decimal.localcontext() as ctx:    #local precision(d3 = 2 dec places d4 not)
ctx.prec = 2
d3 = d1/d2
d4 = d1/d2
#fraction
from fractions import Fraction
f1 = Fraction(2, 3)
f2 = Fraction(2,5)f3 = Fraction(0.25) #f3 = 1/4
f3 = f1 +f2
print(f3)
#reason (decimal,fraction is different than floating and floating pt cannot provide accuracy)
print(0.1 + 0.1 + 0.1 - 0.3)  #op = 5.55111512313e-17from decimal import Decimal     #op = 0.0
print(Decimal('0.1') + Decimal('0.1') + Decimal('0.1') - Decimal('0.3'))
from fractions import Fraction   #op = 0
print(Fraction(1,10) + Fraction(1,10) + Fraction(1,10) - Fraction(3,10))

#boolean
i = True                                 
i = False

1.LOOKUP ,INSERT , SIZE
--

2.SLICING
--

3.FNS
i1 = round(i)
I1 = abs(i)
import math
#round
i1 = math.fabs(i)
i1 = math.floor(i)
i1 = math.ceil(i)
i1 = math.trunc(i)
#algebra
i1 = math.sqrt(i)
i1 = math.pow(i,2)
i1 = math.gcd(i,3)
#trignometry
i1 = math.sin(i)
i1 = math.cos(i)
i1 = math.tan(i)
i1 = math.asin(i)
i1=  math.acos(i)
i1 =  math.atan(i)
i1 = math.sinh(i)
i1 = math.cosh(i)
i1 = math.tanh(i)
i1 = math.asinh(i)
i1 = math.acosh(i)
i1 = math.atanh(i)
#exponential;
i1 = math.log(i,2)
i1 = math.exp(i)
i1 = math.erfc(i)
i1 = math.erf(i)
i1 = math.degrees(i)
i1 = math.radians(
*/

//STRING --> REF TYPE, IMMUTABLE , INITERABLE
/* 
s= ‘single Line' ; 
    ”single line” ;  
    ‘’’multiple line’’’ ; 
    r ‘raw sttr supresses special char’ ;
    b’byte string’ ;
    u ‘unicode string’                              
    concatenation by + and  , --> Look in Application/String Formatting
    Escape Sequence ,String types ,  
    Formatting(RE) 

1.LOOKUP ,INSERT , SIZE
#lookup
s[index]                  
s[start:end:step]
s.index('p')
s.find('p')
s.count('p')
s.startswith('p')
s.endswith('p')

#insert
s.add(object) , add(index,object) –
s.set(index,object) - 
s.replace(obj1,obj2, n) #replace obj1 by obj2 upto n occurencesn(n=1 default)


#size
s1 = len(s)


2.SLICING 
#slicing by [index] , [start:end(not ncluded):step] ] 
 s[index]                  
 s[start:end:step]

# slicing by s.strip() s.rstrip() s.lstrip() s.split(RE not included)
s.strip(); - returns a new string by removing  whitespace before and after string
s.lstrip()--> returns a new string by trimming all white space before string
s.rstrip()--> returns a new string by trimming all white space after string
s.split(‘RE’) – returns a new string by splitting  string at RE not including RE and returns list ofsplitted elements

Eg
s = "X-DSPAM-Confidence:    0.8475"
s1 = s.rstrip().split() #s2 is a list seperated by space  not including space([''X-DSPAM-Confidence','0.8475']
s = "i'mSPAMaSPAMlumberjack"
s1  = s.rstrip().split("SPAM")  # string seperated by SPAM not including spam["i'm", 'a', 'lumberjack']

s = "prasann.patil@gmail.com is my email"
s1 = s.rstrip().split()
s2 =s1[0] #prasann.patil@gmail.com
s3 = s2.split("@")
s4=s3[0]  #prasann.patil
s5 = s4.split(".")
s6 = s5[0]#prasan



3.FNS
len(s)
max(s)
min(s)
*/

//LIST --> REF TYPE,  MUTABLE , ITERABLE
/*
l = ["apple",1,2,[1,2,3,4],{1,2,3,4}]


1.LOOKUP ,INSERT , SIZE
#lookup
l[index]              
l[start:end:step]
l.copy()
l.index("apple")
l.count("banana")

#insert
l.append(object) , l.extend(object) ,l.insert(index, object)
l.set(index,object)
l.remove(object)  ,l.pop(n index) , #remove  object ; remove n indexes from behinds 
l.clear() # clear the list

#size
len(l)

2.SLICING
same as lookup


3.FNS
len(l)
max(l)
min(l)
sorted(l)
l = ['abc', 'ABD', 'aBe']                              #ascii of capital letter < small letter
l.sort()                                                         #['ABD', 'aBe', 'abc']
l.sort(key = str.lower)                              #['ABD', 'aBe', 'abc']
l.sort(key =str.lower ,reverse = True )   #['aBe', 'ABD', 'abc']
l.reverse()

*/

//TUPLE(Same as list but are immutable) --> REF TYPE IMMUTABLE , ITERABLE
/*
Declaring--> t = ("apple",1,2,[1,2,3,4],{1,2,3,4})

1,2,3.same as list but immutable

4.
#tuple of 2 sets concatenated
c = se1,se2      
#intersection
i = se1&se2     
#union 
u = se1|se2     
#difference
d = se1-se2    
#exor e  = se1^se2   
#True if 2 sets are equal (even if order is diff eg set('spam') = set('aspm'))
e = se1 == se2  
#True is se1 is superset of se2
s =se1 >se2      
*/

//SET (Same as list but are immutable, remove duplicates,and alow set theory operations)--> IMMUTABLE , ITERABLE
/*
se1 = {1,2,3,4,5,6}
se2 = {3,4,5,6,7,8}

1,2,3. Same as list but are immutable, remove duplicates,and alow set theory operations
*/

//DICTIONARY --> REF TYPE ,MUTABLE , ITERABLE
/*
#declare static            
d = {key:value}                                     keys -->immutable objects; values --> mutable objs
#declare dynamic
d = {} ;                                                   
d[key] = value                                           
#declare using dict ad keys need to be plain ie not 'name' but name
d1 = dict(name="Bob", age=40)          
# declare using zip
keys = ["name", "job", "age"]               
value = ["Bob", "dev", 40]
d1 = dict(zip(keys, value))     


1.LOOKUP , INSERT , SIZE
#lookup
d[key]   
d.get('1','not valid key')
d.copy()
d.keys()       #returns view object dict_keys([key1,key2]) which can be iterated using for key in d.keys()
d.values()     #returns view object dict_values([key1,key2]) which can be iterated using for values in d.values()
d.items()      #returns view object dict_values([(key1,value1),(key2,vqlue2)]) which can be iterated using for keys,values in d.items()

#insert
d.update(d1)  # similar to append but if key of d1 and d2 is same key of d replaced
d.set(key,value)
d.pop('d')
d.clear()


#size
len(d)

2.SLICING
same as lookup




3.FNS
len(d)
max(d)  #by key
min(d)   #by key
sorted(d)  #by key
list(d.keys())  sort by keys
list(d.values())
list(d.items())
l1 = [[key,value] for key,value in sorted(d.items())] ; l2 = sorted(l1)   #sort by keys
l1 = [[value,key] for key,value in d.items()]   ; l2 = sorted(l1) #sort by valu
*/

//NAMED TUPLE(namedtuples but give properties of both tuple and dictionary)
/*
from collections import namedtuple
t1  = namedtuple('t1', ['name', 'age', 'jobs'])
t = Rec(name ='Bob', age=40.5, jobs=['dev', 'mgr'])

1.2,3 -> same as tuple , same as dictionary d = t._asdict()


NESTED(acess each object by chain indexing and then perform object tasks)
l = ['abc', [(1, 2), ([3], 4)], 5]
l1 = l[1]       #[(1, 2), ([3], 4)]
l1 = l[1][1]    #([3], 4)
l1 = l[1][1][1]  #4


j = {
    "name": {
        "first": "Bob",
        "last": "Smith"
    },
       "job": [
        "dev"
        "mgr"
    ],
    "age": 40.5
}
l1 = j['name']['first'] #Bob
print(l1)
*/


/* #endregion */


//EXCEPTION
/* #region Main */

//(
    /*
    EXCEPTOPN --> Method  throws exception; exception  goes down stack to find  exception handler  . So when eexception handler not found till               
                end then java gives the stack trace in  err window (method on top ofstack wghich throws err wrtten 1st , method below it 2nd) 
    Eg
    class  Animal:
        def barker()[
                bark(null)}
        def  bark(String name){
        Sout(name.toUppercase();)}}

    class Main:
        def main(){
            Animal.barker()}}

    Bark   -> Bark Throws exception no handler found , exception  goes to barker no handler found  , goes to main no handler found      Exceprion at Java.Animal.Bark ExceptionType (Link to bark)
    Barker    Exceprion at Java.Animal.Barker ExceptionType (Link to Barker)
    Main      Exceprion at Java.Animal.Main  ExceptionType (Link to Main)
    */
//)

//EXCEPTION CLASSES
/*
inbuilt Exception class:
Exception 
  |--ArithmetricError 
                |--ZeroDivisionError 
                |--FloatingPointError
  |--LookupError 
           |--IndexError 
           |--KeyError
  |--NameError , AttributrError,TypeError,ValueError, SyntaxError
*/

//EXCEPTION HANDLING:
/*
1.If method throws checked exception automatically -->METHOD THROWS EXC  AUTOMAICALLY
f = new FileReader()  }                   -->wrap in try catch finally block    so the exception will be handled there  itself and will not travel down the stack   
                                            to find  exception handler
try:
    FileReader f = new FileReader()   --> raises  Exception() class

else:                                     -->try does not throw ExceptionClass then else is run

    catch ExcClassName as e:                -->e = ExcClassname()    
                e.method()                                                           
    catch ExcClassName as e                -->PLACE MULTIPLE EXCPTIONS
        e.method()                            Lowest subclass is placed 1st and highest superclass is last
                                            exception travels down ; 1st subclass  tries to catch if not then superclass tries to catch

    finally:                                 -->finally always runs so if try throws exc  and catch does not handle    finally does
                                                ie try  throws exc1 on line 1,exc2 on  then line2  so if exc1 is  executed cntrl goes to except block and exc2 not 
                                                executed ; so  we transfer exc2 to finally block


2.If method throws checked exc because you throw new exception()-->DON’T WANT  AUTOMATIC  EXC                                                                                       
def method(){                 
    rasie Exceptionclass(“message”)       -> throw ExceptionClass(“mess”)   
    assert  condition ‘ Message’          -> throw ‘message’  if condition True
                                            Exception is not   handed here so it will   travel down the stack and wrap the method call          
                                            in "try catch finally" block

def method2():
    try:
        method1()                      
    catch Exceprtion as  e):                 
*/


/* #endregion */


//CONDITIONAL
/* #region Main */


//IF
/*
(True = condition satisfied / non zero or non empty)
iIf(condition):    -                 
                                                                                                                                                      
elif(condition):                                                                                                                              
            |	                                                                                                                  
            |	                                                                                                                                                                                                       
else        |                                                                               GLOBAL , LOCAL
            |                                                                               Variables inside loops are local to that loop
            |                                                                                                              
            |	                                                                            MOST GENEROC LOOP ON TOP
            |	                                                                            if (a%5 ==0 && a%3 == 0) -> must be on top if on 
                                                                                            elseIf (a%3 ==0)            bottom  it will never be
                                                                                            else(a%5 ==0)                encountered 

        true , false        -> return true , false                                                                                             
        object              -> retuen true if element of obj Is true  [non zero/ non empty]                                       
        obj1 operator  obj2 -> return true, false acc to operator
              |                                                                                                                                                    
        COMPARISION OP, LOGICAL OP , INCLUSION OP ,DATATYPE OP : LOOK IN OBJECTS
        ARITHMETIC OPERATOR : +(overloaded for int , string) ,- , * , / , % , ^  
        INCREMENT/DECREMENT : x = x +1 ; x += x ; x++ ; ++x
                                                                                                 
                                                                                                         
                                                                                                         


SIMPLIFYING IF
1.TERNARY(we can do only assignment in ternary and not execution like printing etc)
a=0;b=0; 
if (b < 30): a =  “less” --> a =   (b < 30 ) ? “less” : “more”
else : s = “more”

2.SWITCH(you can take only = condition and not other conditions like <, > ……. )
String a ;                       -->String a
If (a = “prasann” )                 switch (a)
      print(“name ”)                  case :“prasann”:
                                        print (“name”);
                                        break ;
elif (a = “pradeep”)                  case : “pradeep”:
   print(“father”)                      print(“father’);
                                        break ;                                              
else                                  default: sout(“xyz”)
  print(“xyz”)


3.HARDCODE VALUE:     
Int temp = 30;      --> int temp = 30;      --> a = (temp == 30)
boolean a               boolean a = false
If (temp == 30)         if (temp == 30)
{ a = True}                a = True}                                       
else
{a = false}

*/

//WHILE
/*
While condition:
  
else:         |
                 |
                 |
        SAME AS IF

*/

//FOR
/*
for   i  in  object: -------------------------------
else: |                                             |
      |                                             |
   i/(a,b,c)/(keys,values)              iterable obj , generator obj , generator fn , generator expression 
   based on what obj returns

   EG1,2

FOR COMPREHENSION
l1 = [index for index in object] 
t1 = tuple(index  for index in object)-->(only () give generator fn )  OR l1 =[s.index(i):i for i in s] ->and then convert to t1,s1,d1 
s1 = {index for index in object}
d1 = {s.index(i):i for index in object} 
        |
        |
  Single obj:index
  Multiple objects [index1,index2] or (index1,index2) or {index1,index2}
  EG3

Eg 1
i = 22; s = 'prasann'; l = [11,22,311];t =(1,2,3);t1= (1, 2, 3);t2 = (4, 5, 6);t3 = (7,8,9);se = {1,2,3};d = {'spam': 1.25, 
input = open('data.txt','r')                                                                                                                                 'ham': 1.99,
 'eggs': 0.99,
'bacon': 1.10}
for i in s:
    print(i)
for i1 in l :
    for i2 in i1:
        print(i2)
for i in t:
    print(i)
for i in se:
    print(i)
for (key,value ) in d.items():
    print(key,value)
for i  in input:
    print(i)
for ((a, b), c) in [([1, 2], 3),
                    ['XY', 6]]:  # 1st iteration ((a, b), c) = ([1, 2], 3)  2nd iteration (a, b), c) = ['XY', 6]
    print(a)
for (a, b, c) in [t1, t2]:  # 1st iteration (a,b,c)= (1,2,3)  2nd iteration (a,b,c ) = (4,5,6)
    print(a)
for i in range(0,(len(l)+1)):
    print(l[i])
for (a,b,c)in zip(t1,t2,t3): #l = [(1,4,7),(2,3,8),(3,6,9)]   1st iteration (a,b,c ) =(1,4,7)    2nd iteration (a,b,c) = (2,3,8) ......
    print(a,b,c)
for i in list(zip(input,input)):
    print(i)
s = 'spam'
for (offset, element) in enumerate(s):                         # s appears at offset 0
    print(element, 'appears at offset', offset)                #p appears at offset 1
for i in list(enumerate(input)):
    print(i)
for i in map(ord , s):  # ord -->convert to ascii
    print(i)
for i in  filter(bool,l):
    print(i)
l1 = [(4, 5), 3.14]
l2 = ["aaa", 111, (4, 5), 2.01]

Eg 2
for key in l1:
    for item in l2:
        if item == key:
            print(key, "was found")
            break
    else:
        print(key, "not found!")

# equivqlent using same i
l1  = [(4, 5), 3.14]
l2 = ["aaa", 111, (4, 5), 2.01]

for key in l1:
    if key in l2:
        print(key, "was found")
    else:
        print(key, 'not found' )



Eg3
s = 'bobby';l = [1,2,3,4,5,6];x = [1,2,3,4,5];y = [4,5,6,7,8];m = [[1, 2, 3],[4, 5, 6],[7, 8, 9]];n = [[2, 2, 2], [3, 3, 3], [4, 4, 4]];d = {
input = open('data.txt','r')                                                                                                                                                   'name': 'prasann',
                                                                                                                                                                                                  'midle':'pradeep',
                                                                                                                                                                                                   'surname':'patil',}
l1 = [i for i in s if i=='b']
l1 = list(i for i in s if i=='b')
l1 = [[i**2,i**3] for i in l if i%2 == 0]          #sq and cube of n natural nos
l1 = [row[1] for row in m if row[1] % 2 == 0]    # column2 even elements
l1 = [sum(row) for row in m]                     # sum of rows of m
l1 = [m[i][i] for i in [0, 1, 2]]                # diag elements of m
l = [x[i1][i2] + n[i1][i2] for i1 in range(0, len(x)) for i2 in range(0, len(x[i1]))] # sum of each element in m , n 1 by 1
d1 = {i : sum(m[i]) for i in range(0, 3)}        # row:sum of rows
d1 = {value for(key,value) in d.items() if key == 'midle'}  #values when key is middle
s1 = {line for line in input}
s1 = {ix: line for ix, line in enumerate(input)}
s1 = {line for line in input if line[0] == 'p'}
l = [i1+i2 for i1 in x if i1%2 ==0 for i2 in y if i2%2 ==0] #2 +4,2+6,2+8,4+4,4+6,4+8,...
*/

//GENERATOR FUNCTIONS
/*
FN TYPES
Consumer function: Takes  argument returns nothing
Supplier function: Takes no arg and returns no  value
Predicate function: Takes arg and returns Boolean
Function function  : Takes argument and returns value	       
      |-UnaryOperatoor:Extends Functuio
      |-Binary Operator: Extends BiFunction



range(start,end,step) -->returns integers in given range
list (enumerate(iterableobj))--> return list of [( offset addr of element1 ,element 1 )  , (offset addr element 2 , element2)]
list(zip(obj1, obj2)) --> return list of [(1st element f=of all obj ),(2nd element of all obj)]
list(map(function fn,iterableobject)) -->return list of [( fn(1st element of obj)  ) ,(   fn(2nd element of obj)  )] 
list(filter(predicate fn,iterableobject)) -->return list of [( fn(1st element of obj)  ) ,(   fn(2nd element of obj)  )] 
f|rom functools import reduce
r|educe(function fn,iterable obj) -->return fn on element 1 of obj->eturn fn on element 1 of obj -> returns a single value 
  |              |                   Remembers return value            remembers return value       so it is not a generator fn
  |              |                   and gives return value             and gives return value      so it is not iterated upon
  |              |                   to 1st arg of fn                    to 1st arg of fn 
  |              |
  |               -->function:predefined     math.method(), str.method() ,ord-> ascii value , bool -> filters true values
  |                                   user defined      fn, lambda fns                  
  |
  |--> list:Generator fns produce generator objects which store adress. These generated objects must be iterated upon by 
              list(),for etc  which give values
               Eg z = zip((1,2,3),(4,5,6))         #<zip object at 0x0000000002621A08>
                  l = list(zip((1,2,3),(4,5,6)))  # force it into list

Eg
i = 22
s = 'prasann'
l = [11,22,311]
t =(1,2,3)
t1= (1, 2, 3)
t2 = (4, 5, 6)
t3 = (7,8,9)
se = {1,2,3}
d = {'spam': 1.25,
'ham': 1.99,
 'eggs': 0.99,
'bacon': 1.10}
input = open('data.txt','r')


#range
r = range(0,len(l))

# enumerate
s = 'spam'
l = list(enumerate(s))  # [(0, 's'), (1, 'p'), (2, 'a'), (3, 'm')]

#zip
l = list(zip(t1,t2,t3)) #l = [(1,4,7),(2,3,8),(3,6,9)]   1st iteration (a,b,c ) =(1,4,7)    2nd iteration (a,b,c) = (2,3,8) .....


#map
#built in fn
l = list(map(int.bit_length(),i))#on each term of i return bitlength
l = list(map(str.upper,s))  #on each term of s  convert to upper
l = list(map(pow,t1,t2))       #on each term of t1,t2 pow
l = list(map(ord , s))       #on each term of s convert to ascii
#user defined fn
def inc(a):
    return a+10
l = list(map(inc,l))            
l = list(map(lambda x:x+10,l))

#filter
# built in fn
l = list(filter(str.lower,s)) # for each element in string filter lowercase only
l = list(filter(bool,l)) # for each element in list filter true values only
#user defined
def  fn1(x):
    if x%2 ==0:
        return x
l = list(filter(fn1,l))  #for each element in l1 filter divisible by 2 elements only

#reduce
from functools import reduce
r = reduce((lambda x, y: x + y), [1, 2, 3, 4]) #remembers value of fn on obj1 and uses it for fn on obj2 so we get single non iterabe op
print(r) #10
*/


//BREAK , CONTINUE
/*
pass --> when we want to keep body empty or fill in later
break --> stop at certsin iteration and jump out of loop block
continue --> skip certain cond and jump  to start of loop 
*/


/* #endregion */






