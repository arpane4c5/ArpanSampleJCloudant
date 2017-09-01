# Bluemix Setup instructions (SE 2017-18):

1. Use the link that has been forwarded by sir to get the 6 month trial promo code. There may be an error with eligibility, which will be fixed automatically within a few minutes/hours. Follow the instructions to get the promo code.  

2. Where the promo code is displayed follow the "instructions for students", which asks you to register on the Bluemix site and login using the new credentials. When you login, you will get a 30 day free trial which can be extended by applying the generated promo code. 

_______________________________________________________________________

# Creating a sample app:

1. Create a sample Tomcat application (These steps are specifically for Java users). It deploys a sample application. For NodeJS users, create a sample NodeJS app. Explore the different options given in the catalog.

2. Follow the instructions in the get-started section to download sample code using git.

3. You must have cloud foundry, Git, maven, Apache Tomcat Server installed on your system for running the application locally. For maven and Tomcat, just extract them in a folder and include the path of maven in the environment variable. In the command line, following commands should be working: `javac`, `cf`, `mvn`, `git`. 

4. You can use an IDE/Text Editor to import the sample project and make changes to it. Eg. Atom, Eclipse (Do not waste time in installing bluemix plugins, probably it won't work).

5. To run locally, your `mvn clean install` should download packages and generate a `.war` file in `target` directory, which needs to be copied to the `apache-tomcat-8.5.20/webapps` directory. Then run `startup.bat` file inside `apache-tomcat-8.5.20/bin` folder and access the site at `localhost:8000/GetStartedTomcat/`.