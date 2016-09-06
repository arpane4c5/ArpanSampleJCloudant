## Prerequisite Installations:

1. [JDK >= **1.7**](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
2. [NodeJS](https://nodejs.org/en/) for your OS 
3. Download Eclipse for EE developers and extract.
4. [CloudFoundry CLI](https://github.com/cloudfoundry/cli/releases). 
   Refer [this](http://docs.cloudfoundry.org/cf-cli/)
5. Web Browser (Chrome/Firefox)

Refer [this](https://www.youtube.com/embed/PnPij88rIF0) for Installation (in Windows)  
Refer [this](https://www.youtube.com/embed/4RBDyyOREVU) for Installation (in MAC)

Need to have an IBM account. Register [here](https://www.ibm.com/account/us-en/signup/register.html) 

**IMPORTANT: USE YOUR COLLEGE EMAIL ID TO REGISTER.** You may select the UK-GB region out of the 3 regions of sydney, US and UK.

## For Eclipse 
Goto Help -> Eclipse Marketplace --> Search for and install the following plugins
1. IBM Eclipse Tools for Bluemix for `<EclipseVersionName>`  
2. Enide.p2f - Eclipse Node.js IDE  
3. Eclipse Tools for Cloudfoundry  
4. IBM WebSphere Application Server Development Tools (WDT) Installer    
Refer [this](https://console.ng.bluemix.net/docs/manageapps/eclipsetools/eclipsetools.html#eclipsetools)  


## Local Web server for JSP developers:
Goto [link](https://developer.ibm.com/wasdev/downloads/) and either download WebSphere Liberty inside Eclipse or download the runtime externally and integrate in Eclipse as shown [here](https://developer.ibm.com/wasdev/docs/developing-applications-wdt-liberty-profile/)  


For an more detailed description, it is recommended that you follow the Bluemix Essentials course, which has an additional advantage of obtaining a certification badge. This course will show you how you can start working on a NodeJS application along with Cloudant-NoSQL-DB. 

**Note**: WebSphere Liberty Tools plugin can be used to set up remote servers with the Bluemix Server instance, but there was a problem in plugin download for Eclipse Neon. For older versions of Eclipse, it might work but I haven't tried.  


**Steps:**  

Add a Bluemix Server to Eclipse  
Goto Window -> Preferences -> Server -> Runtime Env -> Add.. -> IBM -> Bluemix Runtime -> Enter Credentials -> Choose eu-gb URL -> Validate -> Finish

Add a Local WebSphere Liberty (or for any other 3rd party webserver like Tomcat, JBoss etc.)  
Follow the above procedure, instead choose IBM -> WebSphere Liberty Server -> Choose the directory where the extracted server files are kept.


_________________________________________________________________

### Using DevOps for Complete Development-to-Deployment Pipelining

1. In Bluemix Dashboard, switched to Classic mode
2. Click Create App -> Choose Web -> Liberty for Java and Continue -> Enter a unique name (will be used in domain name, probably concat with your name) ArpanJavaDemoWebApp -> Finish
3. No need to create a separate DevOps account. It is attached to your Bluemix account. [https://hub.jazz.net/](https://hub.jazz.net/)
3. In the Dashboard, click on your application instance, then click Add Git in the top right corner. Choose an alias for your identity in the team, --> Create -> Continue.
4. When the Git repo is created, Goto *Edit Code* and Copy the GIT URL of the repo.
5. Goto Eclipse, *File* -> *Import* -> *Git* -> *Clone URI* -> Paste the URL in the URI textbox -> Enter User (alias) and Password (Bluemix) -> *Next* -> *Next* -> Choose the local directory to save the project (In an Eclipse Workspace) -> *Next* -> *Next* -> *Finish*

##### For Maven integration
For Eclipse Neon Users --> install new version of **m2e-wtp** as below:
Goto Help -> *Install New Software..* -> *Add..* -> *Name="m2e-wtp for Eclipse Neon"* and *Location="http://download.eclipse.org/m2e-wtp/milestones/neon/1.3/"* -> Tick all the three checkboxes  

In the jazz interface showing the git version of our code, Goto Build and Deploy to see the stages of our delivery pipeline. Check that the configurations of the build and deploy stages are as required with "automatically execute when commit" is ticked.  
Make the necessary changes in Eclipse and save.  
To trigger the pipeline from within Eclipse, right click your project properties --> *Team* --> *Commit..* --> Drag the unstaged files that have changed to the staging area, write a commit message, and click *Commit and Push*.   
Note: If multiple team members are working simultaneously on the same project using the same repository, then each member has to pull the changes first before pushing the changed code.   

Goto *Track and Plan* on the DevOps repo page. Check the *Enable Track and Plan* option under settings. Now you can explore options like *Backlog* and *Sprint Planning* etc.  
To configure DevOps inside Eclipse, sending and accepting team invitations see the [link](https://hub.jazz.net/docs/jazz_scm_client/)  


____________________________________________________________________

## Cloudant
Refer [link](https://cloudant.com/for-developers/crud/)  

Operations that can be performed using HTTP API --->  GET  POST  PUT  DELETE  COPY  

Cloudant Dashboard --> After Launch is clicked on the service instance  
JSONView plugin for Firefox and Chrome browsers  
Postman --> REST client Interface to send requests to the DB  

Eg. queries CRUD operations  
`curl -X GET -u ablanks 'https://ablanks.cloudant.com/_all_dbs'  `

Create a new DB for user ablanks and using PUT call  
`curl -X PUT -u ablanks 'https://ablanks.cloudant.com/newdb' | jq`  

For creating or deleting bulk docs, in JSONView use following URL, specify content-type as application/json in header. POST operation
https://ablanks.cloudant.com/newdb/_bulk_docs

Options (Query Endpoints)  
?include_docs=true  
Use doc_id endpoint  --> include both docID(_id) and the revision no (_rev) to ensure most recent version is updated  

Use doc_id attachment endpoint for uploading, reading binary files   
PUT <database>/<doc_id>/<attachment>

Pre-authenticated curl  
`acurl -X GET 'https://ablanks.cloudant.com/_all_dbs' | jq`

Verbose account info including Base64 encoded username and password, copy the "Authorization: Basic ...." line  
`curl -v -u ablanks 'https://ablanks.cloudant.com'`

Edit .bash_profile (in MAC), maybe .bashrc in Linux and add following line  
`alias acurl="curl -s --proto '=https' -g -H 'Authorization: Basic ....'"`

Reading a doc
https://[username].cloudant.com/crud/welcome		--here crud is the db name while "welcome" is the docID

Insert a doc in DB


________________________________________________________________________


### Ongoing Tasks


Add team members and concurrent edits to the DevOps pipeline
Use some new API, like struts or javamail

Using Struts2 with Maven -->  https://www.mkyong.com/struts2/struts-2-hello-world-example/

Add struts dependency tag in pom.xml
Create struts.xml file under resources

ArpanDemoApp (Refer https://www.mkyong.com/struts2/struts-2-hello-world-example/)
Make entry for struts2 in pom.xml
Created under resources/webapp  WEB-INF folder with web.xml file and copied lines (in src/main/webapp/WEB-INF)
Created resources folder under src/main/   and inside that created struts.xml
Inside src/main/java created dir structure for actions com/arpane4c5/action/
Under src/main/webapp  created User/pages/ dirs to store user pages --> created login.jsp and welcome_user.jsp inside those
Created WelcomeUserAction.java inside com/arpane4c5/action
Visit http://arpanjavademowebapp.eu-gb.mybluemix.net/User/Login.action

For cloudantDB, edit web.xml  -->  
https://github.com/cloudant/java-cloudant
https://github.com/cloudant/haengematte/blob/master/java/CrudWithEktorp/src/main/java/com/cloudant/CrudWithEktorp.java
Add entry in pom.xml


_____________________________________________________________________________


### References:
1. Youtube Video by IBM Pune team on [Bluemix](https://www.youtube.com/watch?v=O0wZtfa-vm8)  
2. [CloudantDB learning center](https://cloudant.com/learning-center/#bdu)  
3. Using IBM Watson Services with Bluemix. An app created during a hackathon. [Link](https://developer.ibm.com/bluemix/2014/10/17/building-java-ee-app-ibm-bluemix-using-watson-cloudant/)   
4. IBM Bluemix Essentials Course [Link](https://developer.ibm.com/courses/all-courses/get-started-with-bluemix/)   
5. Cloud Application Developer Certification Preparation. Course [Link](https://developer.ibm.com/courses/all-courses/cloud-app-developer-cert-prep/)  
6. Download free Redbook on Bluemix Architecture Series [Link](http://publib-b.boulder.ibm.com/abstracts/redp5184.html?Open)  
7. Setting up local Eclipse clients to work with Jazz source control. [Link](https://hub.jazz.net/docs/jazz_scm_client/)  
8. Connecting CloudantDB with Java [Github Link](https://github.com/cloudant/java-cloudant)   
9. Track and Plan using DevOps services. [Link](https://hub.jazz.net/tutorials/trackplan/)   

**Optional**:  Use the Latest Eclipse Che [Link](http://www.eclipse.org/che/)  


#### Contributors: 
Arpan Gupta @arpane4c5
