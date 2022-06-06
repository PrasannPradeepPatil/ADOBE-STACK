

//INSTALL AND RUN
/* #region Main */
//INSTALL
/*
//WINDOWS
1.Install -->https://github.com/gorvgoyl/MinGW64/releases(install MinGW64 and unzip in c drive)
            
2.SET ENV VAR--> C:\MinGW64\bin -->add this toi system env var
                 >g++ --version -->to check if c++ installed

//LINUX
1.Install -->-->https://github.com/gorvgoyl/MinGW64/releases

2.SET ENV VAR--> Automatically added
                 >g++ --version -->to check if c++ install
 */

//RUN
/*
 //WINDOWS
 > g++ Test.cpp -o Test && "PATH CPP FILE IS STORED"CppFilename withot .cpp

 */

/* #endregion */

//INCLUDE
/*
 
#if defined(_MSC_VER)  // Microsoft compiler   --if else for includes(will take this from config file of different syetems)
#  include <windows.h>
#elif defined(__APPLE__)  // Apple compiler
#  include <dlfcn.h>
#  include <errno.h>


*/

// ::
/*
1.Namespace members:Look in namespace
2.class method , class static member:Look in class
3.Global obj: int x;   int main(){int x = 10;  xcout << "Value of global x is " << ::x;}

*/


// *; &
/*
int a = 22;   //a holds value 22
int b = a;    //b holds value 22 by value(changing b doesnt affects a)
int &b = a;   //&b holds mem adress of value 22; b holds value 22 by reference(changing b affects a)
int* b = &a;  //b holds mem adress of value 22 ; *b holds value 22 by reference(derefrencing)(changing b affects a)
             //  (datatype of b must be same as a)

EG:
int a = 22;  
int b = a;
int &c = a;
int* d  = &a; 

cout << a; //22
cout << b    //22
cout << &c; //0x7fff183ea104
cout << c; //22
cout << d; //0x7fff183ea104
cout << *d //22

b = 33;
cout <<a; //22
cout << b; //33

c = 33;
cout <<a;//33
cout << c; //33

*d = 33;
cout << a; //33
cout << *d; //33
    




 */


//CONVERSION
/* 
(datatype2)var   --convert to datatype
(*datatype)      --convert to datatype ptr

EG
 const auto context = (void*)(info[2].As<Number>().operator int64_t()); -->tyoecast to void ptr 

*/

//NAMESPACE
/*
namespace namespaceName
{
    class className{
        public:
            void methodName() {}
    };
    void fName();
}
using namespace namespaceName; -->bring entire namespace into scope:
className obj;obj.methodName();     
fnName()
OR
using namespaceName::className; -->bring  namespace ka one member into scope
className obj;obj.methodName();
using namespaceName:fnName()
OR
namespaceName::className obj;  -->bring  namespace ka one member into scope
obj.methodName();
namespaceName::fnName(obj);
 */


//CLASSES
 /*
 class className :public superClassName1, public superClassName2{
     acessmod:
        clasName(){}                                     --constructor
        nonAcessMod retType var                           --var
        nonAcessMod retType methodName(datatype param)    --method
        OR
        class className::methodName(datatype param){}     --method outside class
    }                                                    //ACESS MOD
                                                        private - members cannot be accessed (or viewed) from outside the class
                                                        protected - members cannot be accessed from outside the class, however, they can be accessed in inherited classes
                                                        public - members are accessible from outside the class

                                                        //NON ACESS MODIFIER
                                                        non static -- belongs to object
                                                        static -- belongs to class

                                                        //RETYPE
                                                        datatype -- returning value
                                                        *datatype -- returning a memory adress
                                                        void --nothing
                                                        auto --any datatype
                                                        EG
                                                        int call(){} -- returns int
                                                        int* call(){} -- returns adress of type int 


                                                       
                                                

                                                        //LAMBDA FNS
                                                        [retType](datatype var1, datatype var2)->{return }
                                                        retType --> & -- retType is a memory adress
                                                                    = -- retType is null

                                                        






 ClassName obj;
 obj.var;obj.methodName();       //acess non static members
 obj::var ; obj::methodName();  //acess static members
  a.fnName()

 ClassName* obj = new ClassName();
 obj->var obj->methodName()     //instead of derefrencing




 */

//STRUCT AND ENUM
/*
struct {           --Group variables
  int num;
  string str;
} structName;
structName.num = 1;



enum enumName{     --One of the the following variable used
     a = 1;
     b = True;
}
enumName fnName() -- retType can be any one of the enum variables
 */


//STL
/*
using namespace std;
//CONST
const int a = 22 -->once initialised cant be reassigned

//INT
int myNum = 5;               
float myFloatNum = 5.99;     
double myDoubleNum = 9.98;   

//char
char myLetter = 'd';       

//boolean
bool myBoolean = true;      


//STRING
String s = "";
s[0]
s.length()
String s = s1 + s2 --concatenate and return another string
String s = s1.append(s2) --append and return another string

//ARRAY
string arr[4];
string arr[] = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0]
sizeOf(arr)
 
 */


 //DOUBTS 
 /*

  1.using FnT = dunamis_error (*)(DUNAMIS_HTTP_NEW_SESSION_CALLBACK);
  const auto fn = (FnT)getFunction(_g_LibHandle, "dunamis_http_setNewSessionCallback");
  using FnT = dunamis_error (*)(char*);

  2.Mutex , semaphores , Threads
  class ThreadSafeCallback::Impl {
 public:
  Impl(Napi::Reference<Napi::Value>&& receiver, Napi::FunctionReference&& callback)
      : receiver_(std::move(receiver)), callback_(std::move(callback)), close_(false) {
    if (receiver_.IsEmpty())
      receiver_ = Napi::Persistent(static_cast<Napi::Value>(Napi::Object::New(callback_.Env())));
    uv_async_init(uv_default_loop(), &handle_, &static_async_callback);
    handle_.data = this;
  }

  #define is global var
  
    
  */