
//IMPORT EXTERNAL MODULE
import React, { useState, useEffect } from 'react';                              //sudo npx create-react-app client
import { useDispatch } from 'react-redux';                                       //sudo npm install react-redux
import { Container, AppBar, Typography, Grow, Grid } from '@material-ui/core';   //sudo npm install @material-ui/core

//IMPORT MODULES
import Posts from './components/Posts/Posts';
import Form from './components/Form/Form';
import { getPosts } from './actions/posts';
import useStyles from './styles';
import memories from './images/memories.png';

//CLASS  COMPONENT 
/* #region Main */
//class Counter extends Component { 
    //STATE OBJECT :holds data of component 
    /*
    state = {count:0,ticks:0}                                                            -->create state  
    this.state.count;{this.stats.count}                                                  -->use state  inside class,jsx                   
    this.setState({count:this.state.count+1});{this.setState({count:this.state.count+1}) }-->update state   inside class,jsx
    this.state.count = this.state.count+1 X                                          
    */
                                   

    //STYLES :styles of component
    /*
    const classes = useStyles();                        -->create styles (imported from styles.js as each file has a corresponding styles.js)
    this.classes.styleName ; {this.classes.styleName}   -->use styles in fn,jsx
    */
    
    
    //CONSTRUCTOR:Initialises properties of component
    /*
    constructor(props){       
      super(props)                                      -->INHERIR :Inherit parent constructor compulsarily                                            
      this.state.count =0                                -->INITIALISE STATE : In constructor no need to do this.setState()
      this.state.ticks = this.props.value                -->USE PROPS : Props must be given as an arguement to constructor
      this.arrowfnName = this.arrowfnName.bind(this)     -->BINDING EVENTHANDLER FNS :So that  "this" inside the arrowfnName methods references class object)         
      
    } 
    */                                      
    
    
    //METHOD()
    /*
    async fnName(){}                                                          -->create short fn(For other fns)
    fnNmme = async (params) => {}                                             -->create arrow fn(For evenTHandler fns )
    this.fnName(arg)/this.fnName ; {() =>{this.fnName(arg)}/this.fnName}       -->use arrow fn  inside fn ; jsx                     
    */


    //RENDER METHOD :Converts JSX into REACT ELEMENT(VIRTUAL DOM)
    /*
    render() {               
      return(
          <div>           --><DIV> TAG : React.createElement('elementtype') calls the first element of jsx                                                                    
              HTML CODE                  so if jsx is  <h1></h1> <img></img> it will call 'h1' but if you wrap all code inside div it will call 'div'              
          <div>            -->HTML CODE                         
      );                     DYNAMIC VAR,METHOD,FOR,IF
                              {this.state.count}                                                -->using variable dynamically
                              {this.methodName()}                                               -->using normal method methods dynamically 
                              {this.methodName} OR {()=>{this.methodname(arg)}}                 -->using eventHandler method methods  dynamically
                              <ul>{this.state.names.map(name =><li key=name>{name}</li> )}<ul>  -->using for loop dynamically(JSX is not a template hence we dont have syntax for ror loop)
                                                                                                  <ul>{names}</ul> :<ul></ul> is a jsx exp insode which you use names array dynamically
                                                                                                  <li>{name}</li>  :<li></li> is a jsx exp insode which you use name element of array dynamically
                                                                                                  key =name        :the elements of array taken here must be unique so you must provide unique property to key
                                                                                                                  EG : in our case all the name in names arr are unique hence key=name
                                                                                                                      if names arr was like [{id:1,}{id:2,}] then you would do key=name.id
                              {this.state.name.length === 0 && "This is empty"}               -->using if dynamically(JSX is not a template hence we dont have syntax for if )  
                                                                                                  if condition used as a first operand  if condition op used as a second operand 
                                                                                                  so both must be truthy 

                              CSS,EVENT                                                                    
                              <tagName className="classname">  OR <tagname style = {{"key1":"value1","key2":"value2"}}>   --> classname= instead of class=
                                                                                                                              style={{"key1":"value1","key2":"value2"}} instead of style="key1":"value1";"key2":"value2"
                              <tagname eventName = {this.eventHandlerMethodName}>                                              --> eventHandlerFnName not eventHandlerFnName()

                                              
                                        
     

    }


    render(){}
        return(    
        <Tagname                                                     -->Tagname from materialUI ; Tagname can also be child Component
                attr=value,                                           -->attr   and their values
                style = {{"key1":"val1","key2":"val2"}}                -->styles keys and values                                (style={{"key1":"value1","key2":"value2"}} instead of style="key1":"value1";"key2":"value2")
                className = {this.classes.styleName},                  -->classes are taken from styles.js of each filename.js  (className instead class)
                eventName={this.fnName(arg)}/this.fnName},              -->events  are handled by fns
                propvarname={this.fnName(arg)}/this.fnName/this.varname}-->propvar are given fns or variables of the fn
            </Tagname>                                                     propvar are passed to childComponent and are caught function arguement of child component
                                                                           (NOTE:key="uniqueProperty" is not considered a value and not passed from parent as it is used to uniquely identify values in dynamic for  
                                                                           Eg:<div>{count.map((name)=>{<Component1 key=name.id ,value={this.state.count}})  


        {this.varName/() =>{this.fnName(arg)}/this.fnName}        -->using varname, fnName dynamically in JSX
        <ul>{this.names.map(this.name =><li key=name>{this.name}</li> )}<ul -->using for loop dynamically(JSX is not a template hence we dont have syntax for "for loop" hence we have to use array)
                                                                    <ul>{names}</ul> :<ul></ul> is a jsx exp insode which you use names array dynamically
                                                                    <li>{name}</li>  :<li></li> is a jsx exp insode which you use name element of array dynamically
                                                                    key =name        :the elements of array taken here must be unique so you must provide unique property to key
                                                                                    EG : in our case all the name in names arr are unique hence key=name
                                                                                        if names arr was like [{id:1,}{id:2,}] then you would do key=name.id
        {this.name.length === 0 && "This is empty"}              -->using if dynamically(JSX is not a template hence we dont have syntax for if hence we use && || )  
                                                                    if condition used as a first operand  if condition op used as a second operand 
                                                                    so both must be truthy  

        
      );
    }
    EG:
    <Form currentId={currentId} setCurrentId={setCurrentId} />                               -->Form is child Component ;currentId prop is given currentId state var ; setCurrentId prop is given  setCurrentId function
                                                                                                In components/Form/Form.js const Form = ({ currentId, setCurrentId }) currentId,setCurrentId are collected
    <Typography className={classes.heading} variant="h2" align="center">Memories</Typography> -->Typography is a tag from material UI ; classNmae is given {classes.heading} ;variant align  attributes are given values
    <Button variant="contained" color="secondary" size="small" onClick={clear}>Clear</Button> -->Button is a tag from material UI ;variant color size  attributes are given values; onclick event os given clear function



    */                                       
         
    
    //COMPONENTDIDMOUNT METHOD: Called after mounting component  and  rendering REACT ELEMENT(VIRTUAL DOM) in HTML ELEMENT(ACTUAL DOM)
    //                      
    /*      
    componentDidMount(){      
    }
    */

    //COMPONENTDIDUPDATE METHOD:Called after updating component and rendering REACT ELEMENT(VIRTUAL DOM) in HTML ELEMENT(ACTUAL DOM)
    //                       
    /*
    componentDidUpdate(previousProps,previousState){ 
         previousProps -- holds previous props before updating
         previousState -- holds previous state before updating
    }
    */
    
    
    //COMPONENTDIDMOUNT METHOD:Called before  deleting component  and  rendering REACT ELEMENT(VIRTUAL DOM) in HTML ELEMENT(ACTUAL DOM)
    //                        
    /*
    componentWillUnMount(){   
    }
    */
   



    //}            

/* #endregion */

//FUNCTION COMPONENT
/* #region Main */
//fnName = ({dataFromParentComponent}) =>{   
    //COMPONENT HOOKS
    /*  

    useEffect(() => {code}}, [varName1/fnName1, varName2/fnName2]); -->use useEffect() for performing lifecycle hooks
                                                                     useEffect(fn)                        =fn called on when component mounts and unmounts 
                                                                     useEffect(fn,[statevar1,statevar2])  =fn called on mounts and unmounts and when componnet updates due to updation of any 1 state in dependency array
                                                                      
     */

    //COMPONENT DATA 
    /*
    const [count, setCount] = useState(0);        -->create state  where key is count value with defaultvalue 0 and setcount() is a fn to update count (import from 'react')
    count ,{count}                                -->use state                 
    setCount(count+1)                             -->update state
    */

    //COMPONENT DATA SENDING RECEIVING TO BACKEND
    /*
    const dispatch = useDispatch();                 -->calls action fn with  UIKaData 
    dispatch(fnName(UIKaData)); 
    
    const post = useSelector((state) => console.log(state.posts)); -->calls state in reduxStore  
    */
    
    //COMPONENT DATA SENDING RECEIVING BETWEEN COMPONENTS
    /*
    //PARENT TO CHILD
    const  ParentComponent =()=> {
      const [name, setName] = useState('Prasann');
      const [surName, setSurName] = useState('Patil');
        return (
          <childComponent name = {name},surName ={surName} >    -->pass data to child component
        )
    }

    const childComponent = ({name,surName})=>{      -->receive data in childComponent as props 
      return (
          <div>{name}</div>;                       -->Use data in child component 
        )
    }
    export default childComponent;


    //CHILD TO PARENT
    const  ParentComponent =()=> {
    const [name, setName] = useState('Prasann');
    return (
      <childComponent name = {name},setName ={setName} >    -->pass data and setDataFn to child
      )
    }

    const childComponent = ({name,surName})=>{              -->receive  data and setDataFn in childComponent as props
      const [rollNo, setName] = useState('32'); 
      return (
        <div onClick={() => setName(rollNo)}></div>;     -->set data using setData fn which can be triggered only inside onClick event 
        )
    }
    export default childComponent;


    //BETWEEN COMPONENTS
    Use Redux store to store states


    */

    //COMPONENT ROUTING
    /*
    Component.js
    const handleButtonClick = () => {       --on clicking button go to baseURL/posts ;for baseURL/posts go to component mentioned in index.js inside the components folder
      window.location = '/posts';             EG:Look in clientii ka Header.js file 
    };

    return(
      <button onClick = {()=>{handleButtonClick}>  
    )

    Component.js
      return (
          <CardContent>                       --create a Link for the tag which goes to  baseURL/id ;  baseURL/id  go to component mentioned in index.js inside the components folder    
            <Link to={"/user/" + item.UserId}>  EG:Look in clientii ka Drafts.js file 
          <>

    

    */
    

    //COMPONENT METHODS
    /*
    const fnNmme = async (params) => {}            -->create arrow fn
    fnName(arg)/fnName;                             -->use aarrow fn                   
    */



    
    //RETURN JSX: Converts JSX into REACT ELEMENT(VIRTUAL DOM)
    /*
    return(    
      JSX
    ); |
       |
    JSX
    <Tagname                                     -->TagName is HTML tag OR MaterialUI tag
        attr=value,                              -->attributes for tagname
        style/sx ={{"key1":"val1","key2":"val2"}}-->inline styling  (using your own styles)                    
        className = {classes.styleName},         -->External styling(using filename.css/styles.js by importing files OR BootStrap styles by importing bootstrap)
        eventName={()=>fnName(arg)/fnName},      -->events  are handled by fns(Eg onclick)
        propvarname={fnName(arg)/fnName/varName} -->propvar are given fns or variables of the fn
    </Tagname>                                         propvar are passed to childComponent and are caught function arguement of child component
                                                      (NOTE:key="uniqueProperty" is not considered a value and not passed from parent as it is used to uniquely identify values in dynamic for  
                                                      Eg:<div>{count.map((name)=>{<Component1 key=name.id ,value={this.state.count}})  

    VARIABLES IN JSX
    {varName/fnName(arg)/fnName}                              -->using varname, fnName dynamically in JSX

  
    IF IN JSX
    {name.length == 0 ?                                    -->if name ka length is 0 then button with colour black
      <Button color = 'black'></Button>                       else button with colour blue
      :
      <Button color = 'blue'></Button>
    }
    OR
    {name.length == 0 && <Button><Button>}             -->if name ka length is 0 is true then only move forward and show button

    FOR IN JSX
    names.map(                                     -->for every name in names show buttons with name 
      name =>(
        <Button>name<Button>
      )
    )

    */

//} 
/* #endregion */
const App = () => {
  const [currentId, setCurrentId] = useState(0);
  const classes = useStyles();
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getPosts());
  }, [currentId, dispatch]);

  return (
    <Container maxWidth="lg">
      <AppBar className={classes.appBar} position="static" color="inherit">
        <Typography className={classes.heading} variant="h2" align="center">Memories</Typography>
        <img className={classes.image} src={memories} alt="icon" height="60" />
      </AppBar>
      <Grow in>
        <Container>
          <Grid container justify="space-between" alignItems="stretch" spacing={3}>
            <Grid item xs={12} sm={7}>
              <Posts setCurrentId={setCurrentId} />
            </Grid>
            <Grid item xs={12} sm={4}>
              <Form currentId={currentId} setCurrentId={setCurrentId} />
            </Grid>
          </Grid>
        </Container>
      </Grow>
    </Container>
  );
};



//EXPORT  
export default App;
