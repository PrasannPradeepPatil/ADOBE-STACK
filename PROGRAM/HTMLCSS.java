//INSTALL AND RUN
/*
//WINDOWS
INSTALL:Install extension Live server 
RUN: Right click on .html file and open with live server

//LINIX
INSTALL:Install extension Live server 
RUN: Right click on .html file and open with live server
*/



//STRUCTURE
/*
FILENAME.CSS
@import “./filename.css”                                            -->LINK CSS(all css seeletors will be imported  in this css file)
selector{key1:value1;key2:value2} most common #idname ; .classname)                                                
selector{key1:value1;key2:value2} 

FILENAME.HTML(Create Boilerplace code in VSCode by ! + enter )                   
<!DOCTYPE html>                                                                 
<html attr = value>                                                              
    <head attr = value>
            <link rel="stylesheet" href="./filenam.css">            -->LINK CSS(css seletors will select from all tags in file and style them  )      
            <headsubtag attr = value> </headsubtag>   	                     
    </head>                                                                                                                                                                                                                                     
    <body>                                              
               <script src = “./filename.js”>  </script>            --> Link JS
                <tagname style = "key1:val1";key2 :val2”>            -->InLine styling 
               <tagname id="idName", class="className" >               External styling(CSS fILE OR BootStrap)

              <bodysubtag attr = value> </bodysubtag>                     
     </body>                                                                                                                
</html>
<formatTags> --> dont affect code just code formatting and seo 



FILENAME.JS
filename.js
document.getElementById("id").innerText  --> returns just the text, without spacing and inner element tags   -->LINK HTML 
document.getElementById("id").innerHTML  --> returns the text, including all spacing and inner element tags.
document.getElementById("id").textContent-->  returns the text with spacing, but without inner element tags.
                                            EG
                                            <p id="demo">   This element has extra spacing     and contains <span>a span element</span>.</p>

                                            function getValues () {
                                            document.getElementById("demo").innerText --> "This element has extra spacing and contains a span element."
                                            document.getElementById("demo").innerHTML--> "   This element has extra spacing     and contains <span>a span element</span>
                                            document.getElementById("demo").textContent--> "   This element has extra spacing    and contains a span element."
                                            }

filename.js
import ./filename.css                 -->LINK CSS(css seletors will select from alltags in component1 JSX and style them) 
ReactDOM.render( <component1>)

component1.js
render(){
    return(
     <header className="App-header"> -->LINK CSS(particular css selctor will be applied to this tag)   
    )}
                                          EG REACT app ke files me
                                          index.js
                                          import 'bootstrap/dist/css/bootstrap.cs
                                          ReactDOM.render(                    
                                            <React.StrictMode>
                                                <component1 />     -->css seletors will select from all  tags in component1 JSX and style them                      
                                            </React.StrictMode>,
                                            document.getElementById('root')                
                                            );

                                            component1.jsx
                                            class Counter extends Component {    
                                                render(){
                                                    return(
                                                        <header className="App-header"> -->particular css selctor will be applied to this tag
                                                    )
                                                }



*/


//HTML
/*
<html>  </html> --> Top container
lang = "en" -> language for page 
*/

//HEAD
/*
<head></head> -->  contans title of the page, property of page ,external links of page
--


<metadata> --> metadata of page
charset = "UTF-8" -> character set of website 
name="author" content="name of author"
name="description"content="description of website(used for pagerank)"
name="keywords" content="description of website seperated by comma(used for pagerank)"
name="viewport" content="width=device-width" initial-scale =1.0" --> CONTROLS THE WEBSITE ACC TO DIFFERENT DEVICES (NECESARY LINE)
*/


//BODY
/*
<body></body> --> contains contents of page
--
*/

//CONTAINERS:
/*
<div>  content </div> --> put block containers on the element(block containers  take entire width )   imp  tag
<span> content</span> --> put inline containers on the  content(inline containers take as much width as req and can be put side by side)imp 
*/


//TEXT,INPUTTEXT,INPUTTEXTAREA
/*
<h1>text</h1> -> text with size 1(largest)to 6 smallest
<p>textparagraph</p> --> text written as paragraph
<b>text </b>-> text becomes bold
<i> text</i>-> text is italic
<u>text</u> -> text is underlined
<big>text</big>  --> text becomes a little bigger for particular  size
<small>text</small>--> text becomes a little smaller for particular  size
<sub>text</sub> --> text as subscript
<sup>text</sup>--> text as superscript
<br/> --> add a break line 
</hr> --> add a horizontal line


<input/> OR <input>-->creates a input text box
type= "text/password/date/email/checkbox/radio/submi/file" -->https://www.w3schools.com/html/html_form_input_types.asp
name = "name to textbox"
id = "unique id for the textbox"
value = "default value in ip textbox"

<textarea>default text</textarea>-->creates a input text box
name = "name to textbox"
id = "unique id for the textbox"
cols="columns for textbox ie its width" 
rows="rows for textbox ie its height"
*/


//LINK,IMAGE,VIDEO,IFRAME
/*
<a>content</a>---> convert content inside  to a link
href = "url path /filepathpath"  -->"http://127.0.0.1:5500/index2.html" ; "./subfolder/index2.html"
target = "_blank" --> click on link open a new tab ; if it is not given link will open in same tab



<img /> OR <img> --> add a image
src = "urlpath/filepath"
alt="text if image is absent"
height = "height of img in pixels" (give ht ; wt in proportion to aspect ratio 
width = "width of image in pixels"  if you give only 1 of them HTML automatically resizes other acc to aspect ratio)

<video>text if video is absent</video> --> add a video
src = "urlpath/filepath"
poster = "urlpath/filepath for thumbnail of video"
controls height = "height of img in pixels" (give ht ; wt in proportion to aspect ratio 
controls width = "width of image in pixels"  if you give only 1 of them HTML automatically resizes other acc to aspect ratio)
autoplay-> video plays automatically
loop -> video plays in loop

<iframe> text of website fails</iframe>--->embed website in out website
src = "urlpath/filepath"
height = "height of img in pixels" (give ht ; wt in proportion to aspect ratio 
width = "width of image in pixels"  if you give only 1 of them HTML automatically resizes other acc to aspect ratio)
frameborder = "size of the border surrunding our embedded website ; ideally keep 0"
Embedding YT VIDEOS::share and click on embed you will get html code to embedd just check the boxes and code is generated 
*/

//UNORDERED LISTS,ORDERED LIST , DESCRIPTIO LISTS , TABLES
/*
<ul>                              -->un ordered List
    <li>list item1 </li>
    <li>list item2 </li>
</ul>


<ol>                              -->ordered List
    <li>list item1 </li>
    <li>list item2 </li>
</ol>
type = "1(default)/A/a"

<dl>                              --> description List
    <dt>description term1 </dt>
    <dd>decription defination1</dd>
    <dt>description term2 </dt>
    <dd>decription defination2</dd>

</dl>

<table>                              -->Table
    <!-- tablename -->
    <caption>tableName</caption>
    
    <!-- row1 -->
    <tr>
        <th>tablehead1</th>
        <th>tableHead2</th>
    </tr>
    
    <!-- row2 -->
    <tr>
        <td>tableColumn1</td>
        <td>tableColumn2</td>
    </tr>
</table>
colspan = "2"(attribute of td/th) -->shows columnspan of that data 
<thead></thead> = Just Formatting tags for code readers to locate head ; body of table
<tbody></tbody>

*/


//SELECTOR(most common #idname ; .classname)
/* #region Main */

//SELECT BY ATTRIBUTE
/*
#idname -> select all the tags with attribute  id = "idname"  ONE TAG CAN HAVE ONLY 1 ID
           Eg #fancyBorder{} -> select all tags with <tagname id = "fancyBorder">

.classname -> select all tags with attribute  class = "classname" ONE TAG CAN HAVE MULIPLE CLASSNAME 
            Eg .fancyBorder{} -> select all tags  with <tagname class = "clasname">

.classname1.classname2  -> select all tags with attribute class = "classname1 classname2"
                             Eg .fancyBorder.fancyLayout{} -> select all tags  with <tagname class = "clasname1 classname2">

.classname1 .classname2  -> select all tags with attribute class = "classname2" that is descendant of tag with attribute class = 'classname1'
                             Eg .fancy1.fancy2{} -> select all tags  with <tagname class = "fancy2"> descendant of <tagname class="fancy1">



[attributename]  --> select all the tag  with attributename
                      Eg [target] select all tags with <tagname target = "anything">
[attributename="value"]  --> select all the tag  with attributename="value"
                             Eg [target="_blank"] select all tags with <tagname target ="_blank">
[attribute~="value"]  --> select all the tag  with attributename="containing value"
                      Eg [title~="flower"] select all tags with <tagname title ="word containing flower">
[attribute|="value"]  --> select all the tag  with attributename="starting with value"
                      Eg [title|="flow"] select all tags with <tagname title ="word starting with  flow">
                      Eg [title~="flower"] select all tags with <tagname title ="word containing flower">
[attribute^="value"]  --> select all the tag  with attributename="starting with value"
                      Eg [title^="flow"] select all tags with <tagname title ="word starting with  flow">
[attribute$="value"]  --> select all the tag  with attributename="ending with value"
                      Eg [title$="er"] select all tags with <tagname title ="word ending with er">
[attribute*="value"]  --> select all the tag  with attributename="substring value"
                      Eg [title*="er"] select all tags with <tagname title ="word containing er">

*/
//SELECT BY TAGNAME
/*
tagname{} -> select all tags with tagname 
           Eg div{} -> select all <div> tags
tagname1,tagname2{} -> select all tagname1,tagname2
                       Eg div,p{} -> select all <div> and <p> tags
tagname1 tagname2{} -> select all tagname2  which are child of tagname2
                       Eg div,p{} -> select all <p> inside  <div> tags
tagname1 > tagname2{}  --> select all the tagname2 where tagname1 is parent 
                            Eg ul > li{} ->select all <li> tags inside <ul>
tagname1+tagname2{}  --> select all the tagname2  where tagname2 placed after tagname1
                           Eg p+h2{} -> select all  <h2> tags just  after <p> tag 
tagname1~tagname2{}  --> select all the tagname2 where tagname2 is placed  before tagname1 
                           Eg p~h2{} -> select all <h2> tags just  before <p> tag 
*/
//SELECT BY PROPERTY
/* 
:checked    -->Selects all tags when  checked(when user clicks radio button it is checked)
              Eg input:checked -> select <input> when it is checked
:focus -->Selects all tags when  checked(user clicks  ip text box it is focussed)
              Eg input:checked -> select <input> when it is focussed
:focus -->Selects all tags when hovered(user hovers over h1 tag)
              Eg h1:hover-> select <h1> when we hover over it 
                          
Rest of them->https://www.w3schools.com/cssref/css_selectors.asp
*/
//SELECT BY ALL
/*
tagname.class    --> select all tagnames containing attribute class="classname"
                    Eg h1.fancyBox{} -> select all <h1 class="dancyBox">
tagname[attribute="value"] -->select all tagnames containing attribute attribute="value"
                              Eg a[href="https://..."] -> select all <a href ="https://...">

tagname[attribute="value"]:property ->select all tagnames whose attribute="value" and property
                                    Eg input[type="checkbox"]:checked -> select <input type="checkbox"> when we check it
*/

/* #endregion */


//{ KEY1:VALUE1 , KEY2:VALUE2} --> https://www.w3schools.com/cssref/css3_browsersupport.asp
/* #region Main */

//ARRANGEMENT   
/*     
display:value -->element displayed according to value:
                 block(default) :element takes entire screen width
                 inline -->element takes required width
                 flex --> elements are converted from verical to horizontal stack and size change with change in browser window 
                 other attributre -->https://www.w3schools.com/cssref/pr_class_display.asp
position:value-->elements are positioned according to value as we write code
                  static(default) :elements are positioned one below other as  we write code
                  relative ; top:tpx ; bottom: bpx ; left: lpx ; right : rpx--> element will position relative to ancestor eg if in container then relative to container otherwise relatove t entre document
                  position:absolute; top:tpx ; bottom: bpx ; left: lpx ; right : rpx --> element will position relative to  entire document
                  position:fixed;top:tpx ; bottom: bpx ; left: lpx ; right : rpx--> element will position relative to  viewport ie when we scroll down the element will be fixed

float :value--> the element will float according to value and  other elements will wrap around it
            left: element will float on left and other elements will wrap around it 
            right: element will float on right and other elements will wrap around it
            none:  element will vanish
justify-content: flex-start/flex-end/centre/space-between/space-around       -->align items to left/right/centre/add even space bw elements/add space around elements

.flex-box{       --> FLEX BOX IS A BOX CONTAINING ELEMENTS EG <div> containing elements and this is standard process https://jonitrythall.com/flexbox-cheatsheet                   
display:flex;  --> activate all the attributes written next  
flex-direction: value ->elements direction is set  acc to value
                        row: elements arranged as row                           
                        row-reverse:element arranged as row but in reverse order
                        column: element arranged as column                       
                        column-reverse:element arranged as column but in reverse order
justify-content: value -->elements "location wrt to main-axis(for dir:row across wt for dir:col across ht)" is set acc to value
                           flex-start  -> elements aligned at start
                           flex-end   -> elements aligned at end
                           centre     -> elements aligned at centre 
                           space-between -> elements aligned with equal space bw them
                           space-around  --> elements aligned with equal space bw and around them   

flex-wrap:value -->elements "location wrt to  viewport"(shrinking expanding browser)" acc to value
                  wrap          : elements are wrapped around each other while screen shrink expand 
                  wrap-reverse  :elements are wrapped around each other while screen shrink expand but reverse order
                  nowrap        : elements are not relocated so they themselves shrink or expand
align-items: value -->elements "location wrt to cross-axis(for dir:row across ht for dir:col across wt)" is set acc to value
                           stretched(default) : across the entire ross axis
                           flex-start  -> elements aligned at start
                           flex-end   -> elements aligned at end
                           centre     -> elements aligned at centre 
                           space-between -> elements aligned with equal space bw them
                           space-around  --> elements aligned with equal space bw and around them 
align-content: value  --> same as align-items: value but if we have multiline elements
align-self: value  --> same as align-items: value but if we want to align only a single item then we do this inline not in css <tagname style = "">

}
*/
//SIZE
/*          
width :  wpx OR w %;  --> width , height of the element
height :hpx OR h %;
max-width : wpx OR w %;
max-height : wpx OR w %;
*/
//BORDER
/*       
margin:value   --> set margin outside the  element acc to value value
                        n px OR n%      : all sides are set with same valuu
                        tpx rpx lpx bpx :all sides are set with value written clockwise as top right bottom left
                        margin-top:tp    :required side set
                        margin-bottom : bpx 
                        margin-left :  lpx
                        margin-right: rpx 
padding:value   --> set padding inside the the  element acc to value value
                        n px OR n%      : all sides are set with same valuu
                        tpx rpx lpx bpx :all sides are set with value written clockwise as top right bottom left
                        padding-top:tp    :required side set
                        padding-bottom : bpx 
                        padding-left :  lpx
                        padding-right: rpx     
border: widthvalue bordertype bordercolour; --> set the border acc to values
                                          widthvalue: wpx or w%
                                          bordertype : solid, dotted
                                          bordercolour: same as "color"
border-radius: value--> make  the rectangular edge of the borders as circular borders  with given value as  radius
                        npx or n% NOTE 50% means entire rect converted to circle
*/
//TEXTURE
/*
font-size: value --> set thetext font size of text acc to value
                     npx(pixels) or nem(change acc to browsers so recommended)
font-family :'fontvalue' backupvalue  --> set the text  font-family acc to value
                        'fontvalue': 'Times New Roman' 'Calibri'
                         backupvalue :backup to supported all browsers https://www.w3schools.com/cssref/css_websafe_fonts.asp
font-style: value--> set the font style acc to value
                      bold: set the font-style to bold
                      italics: set the font-style to bold
                      underline: set the font-style to bold
font-variant: value--> set the font variant as value
                        small-pr_class_display:  set the font-variant  to small-pr_class_display

color:value  --> set the colour of text acc to value  https://www.w3schools.com/colors/colors_picker.asp
                colourname: set acc to colourname  like red blue
                #ColourCode:set acc to colourcode  like #c4bdd2
                rgb(rvalue gvalue bvlue) :set acc to rvalue 0-255 gvalue 0-255 bvluelike 0-255  like rgb(255 0 13)
                hsl(hueValue saturation% light%);->Set acc to   hueValue saturation% light%      
background-color:value-->set the colour of background acc to value 
                colourname: set acc to colourname  like red blue
                #ColourCode:set acc to colourcode  like #c4bdd2
                rgb(rvalue gvalue bvlue) :set acc to rvalue 0-255 gvalue 0-255 bvluelike 0-255  like rgb(255 0 13)
                hsl(hueValue saturation% light%);->Set acc to   hueValue saturation% light%      

text-shadow:horizontalvalue verticalvalue blurrvalue colourvalue --> set the shadow for text
                                                                   horizontalvalue:set hor length of shadow in npx 
                                                                   verticallvalue:set ver length in npx 
                                                                   blurrvalue:set blurness length in npx 
                                                                   colourvalue:set set the colour of shadow same as color:value
box-shadow:horizontalvalue verticalvalue blurrvalue colourvalue --> set the shadow for any box element like image
                                                                   horizontalvalue:set hor length of shadow in npx 
                                                                   verticallvalue:set ver length in npx 
                                                                   blurrvalue:set blurness length in npx 
                                                                  colourvalue:set set the colour of shadow same as color:value
opaity : value --> set the opacity acc to value
                0.0(full transparent) to 1.1(fully opaque)
*/

/* #endregion */





//***FORMATTING TAGS
/*
FORMATTING TAGS-- DONT AFFECT THE VIEW BUT JUST TO FORMAT CODE FOR READIBILITY AND SEO
<header>                   --> website in 3 parts header , main , foter
    
    <nav> </nav>        ->   navigational elements  of website     
    <article></article> ->  aricle of website 
    <section></section> ->  section of website
    <aside></aside>     ->   aside elements not directly related tp of website
</header> 

<main> 
     SAME AS HEADER

</main>

<footer>
  SAME AS HEADER
</footer>
*/