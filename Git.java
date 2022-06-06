//FILEPATHS
/*
//WINDOWS
ABSOLUTE PATH : dir\dir \filename --> if this path is used in a string supress or else it will count as special char EG cd C:\Users\DELL\Desktop ;let fs = require(“C:\\Users\\DELL\\Desktop")
RELATIVE PATH : ./dir/filename   --> . = pwd ; .. = parent directory


//LINUX
ABSOLUTE PATH : dir/dir /filename  
RELATIVE PATH : ./dir/filename   --> . = pwd ; .. = parent directory ; ~ = /home 
*/

//ENVIRONMANT VARIABLE  -->REQ TO ADD WHENEVER YOU INSTALL APPLICATION
/*         
//WINDOWS 
>Add to envvar --  varname pathOfFile             --> set env var(set PATH directly "OR" set specific var and then add that var to set PATH ) to filepath(your file ) 
                   PATH    path1;path2;%varname%      
                   PATH path1;path2;pathOfFile        



//LINUX
>export varname=filepath                           --> set env var(specific var) to filepath(your file)
>echo $varname                                     --> echo env var

EG:LOOK IN JAVA,PYTHON 

*/



//#########################################################################################################################################################//
//#########################################################################################################################################################//

//CONFIGURE GIT ,CONFIGURE SSH KEYS ,CONFIGURE HTTP KEYS
/*
//CONFIGURE GIT
git config --global user.name Name                    -> configure your git name  and email
git config --global user.email GithubEmail@gmail.com     so your commits will be visible by this username and gmail


//CONFIGURE SSH KEYS --> CONFIGURE SSH KEY REQUIRED AND UN, PASS NOT REQUIRED
a.GENERATE SSH KEY
ON YOUR PC:
ssh-keygen -t ed25519 -C GithubEmail@gmail.com -->keep pon pressing enter 
                                                This  will save your key on a path which can be fount in console
                                                Console OP:
                                                Your identification has been saved in C:\Users\prasannpradp/.ssh/id_ed25519.
                                                Your public key has been saved in C:\Users\prasannpradp/.ssh/id_ed25519.pub.
                                                The key fingerprint is:SHA256:cqs7E8ikwVd3HHFRye/4Tiv19NXsCBvkgfqXeV10jB8 prasannpradp@adobe.com
                                                
                                                Click on 2nd path "C:\Users\prasannpradp/.ssh/id_ed25519.pub" and VS Code will open it for you
                                                Copy the SSH key
                                                ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAEkcUw3DMYqk+25TTYNC8U5FDFZBpwySN+VXdUEzImQ prasannpradp@adobe.com


                                               

ON GITHUB:
go to settings -->SSH and GPC keys --> new ssh key -->
Title: PrasannPatil Desktop
Key:paste the key and press generate key


b.USE SSH KEY
Then use the SSH  key for remote add ,clone, pull , push etc and you will not be required to give credentials
UN:not required
PASS:Not required

//CONFIGURE HTTP KEY  --REQUIRE USERNAME/EMAIL AND PASSWORD  FOR LOGING INTO GITHUB AND UN/EMAIL AND PERSONAL ACESS TOKEN FOR CLONE,PULL PUSH
a.GENERATE PERSONALISED ACESS TOKEN
personal acess token is used for clone ,pull , push etc instead of password from AUGUST 13 2021 onwards
https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Fix-GitHubs-support-for-password-authentication-was-removed-error(tick all the boxes to allow full acess)

b.USE HTTP KEY
Then use the HTTP key for remote add ,clone, pull , push etc and you will be required to give credentials
For github.com/PrasannPradeepPatil
USERNAME:PrasannPradeepPatil                                     
EMAILID:prasannpatil98@gmail.com
PASS:prasann2788                                                                      
PERSONAL ACESS TOKEN : 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 
                                                                  

*/

//LOCAL REPOSITORY COMMANDS
/*  

git init                      --> created a .git file inside the current folder (look in .git and .gitignore)            
touch .gitignore              --> create a .gitignore inside the current folder(look in .git and .gitignore)   
git add branchname            --> add a branchname; branch will share 1st commit with its parent 
git checkout destinationBranch--> move to destinationBranch ka latest commit node
git checkout -b destinationBranch-->create and  move to destinationBranch ka latest commit node
git merge destinationBranch   --> merge the dest branch ka latest commit node with the current branch ka latest commit node;resolve the merge conflicts in VS code
git add foldername            --> add the folder   in current branch ka current commit node to staging area ((github(.)/gitlab(*) = All files ))
git commit –m “message ”      --> move to  current  branch  ka next commit node and commit the files in staging area 


git log     --> logs all the commits of current branch
git status -->status of which changes have been staged and which have not of current branch


Eg
git add *                        0                           |master|
git commit –m “commit1”          commit1
                                 head
  
git add *                        0 ----------->O              |master|
git commit –m “commit2”          commit1        commit2
                                                head

                                                              |prasann|                        
git branch prasann              0 ----------->O               |master|
                                commit1      commit2
                                             head

                                                     
                                head                                |prasann|                        
git branch prasann              0 ----------->O                     |master|
                                commit1        commit2
                                                                                  
                                    _______O                       |prasann|
                                  /        commit2
                                 /         head              
git add *                       0 ----------->O                     |master|
git commit –m “commit2”        commit1        commit2


                                  _______O                           |prasann|
                                 /      commit2
                                /                              
git checkout master             0 ----------->O                      |master|
                               commit1        commit2
                                               head  



                                  _______O                            |prasann|
                                 /       commit2
                                /                              
git commit –m “commit3”         0 ----------->O ------------------>0  |master|
                              commit1        commit2          commit3
                                                              head  

                                  _______O ___________                    |prasann|
                                 /   commit2         \
                                /                      \
git commit –m “commit3”         0 ----------->O --------->0               |master|
                               commit1        commit2     commit3
                                                          head  
*/

//GITHUB REPOSITORY COMMAND
/*
git remote add origin httpURL/sshURL                                            -->add url to origin variable (http = configuation not req but un/email and pass req for github login and un ; ssh = email and personal acess token required for clone pull push/configuration req but un/email pass not req
git push origin branchName                                                      -->Push the  localRepo branchName  to githubRepo  same branchName(CREATE BRANCH ON GITHUB --GUI)
git clone  httpURL/sshUrl                                                       --> Pull  from githubRepo master branch   to localRepo master branch(http  same as abobe ; ssh = same as above)
git pull origin branchName                                                      --> Pull  from githubRepo brancName  to localRepo  same branchName (CREATE BRANCH ON LOCAL --git branch bn) 
*/

//SERIES OF COMMANDS
/*

a.Configure git, configure ssh keys
configure git (only once)
configure http/ssh keys(only once)


b.Pull from github
git clone httpURL/SsshURL        (http  same as abobe ; ssh = same as above)                                           
cd live-desk-listener                                                                                                                    
git checkout -b branchName       (-b for creating a new branch 1st time)   
git remote add origin httplink   (only once)
git pull origin branchName

c.Push on github
git init                        (only once)
touch gitignore                 (only once)   
git checkout -b branchName      (-b for creating a new branch 1st time)             
git add  .
git commit -m "Initial commit" 
git remote add origin http/ssh (http  same as abobe ; ssh = same as above)  (only once)
git push origin branchName


*/


//.GIT ,.GITIGNORE,README.MD
/*

INITIALISE .GIT , .GITIGNORE
.git must be initialised inside the root folder which is converted to repository so everything inside that root folder will be pushed to github re[ository]
.gitignore must be initialised  inside the root folder as it requires a .git file 
 README.md must be initialised  anywhere 


INSIDE .GIT, 
.git handles all the branches , commits etc for the folder

INSIDE .GITIGNORE(https://git-scm.com/docs/gitignore)
.gitognore ignorres all the folders and files ; 
"/"        = directory seperator; 1st / is current directory   
"*""        = match all characters

NOTE:"gitignore is used only for files that are not already staged" 

INSIDE README.MD(https://medium.com/@saumya.ranjan/how-to-write-a-readme-md-file-markdown-file-20cb7cbcd6f)
README.md is used as a documentation
#,##             --h1 heading ; h2 heading and so on
'''languageName  --code specific to languagename can be written inside like python,javascript rtc
  code
'''
'code'           --any code 


 */