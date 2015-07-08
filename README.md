# alexa-stocks
Example application for the Amazon Echo to retrieve Stock Information from Yahoo


Stocks is an example Skill for Amazon Echo. It allows you to ask for a company's stock information by company name or symbol. The project uses the Yahoo Query Language to get the results for the stock. If requesting the company by name it must be on the NASDAQ or NYSE. Any exchange can be returned by symbol. Below are the steps you will need to get the Skill up and running.  

When the application starts a SpeechletServlet instance created that extends a J2EE HTTPServlet. This is used to receive requests from the Echo. The Servlet creates a Speechlet which handles the core functionality. 

The Speechlet can receive intents.  Intents are mapped by what Amazon calls an “utterance” (think sentences). Intents have slots values (think words / numbers) that the developer can retrieve. For more information see 

https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/defining-the-voice-interface

Stocks has two intents StockCompanyName and StockSymbolName, which have slots CompanyName and Symbol.

For a walkthrough of the project and demo please watch the YouTube video <insert-video-link>.

###Prerequisites:
* AWS ToolKit for Eclipse
* Eclipse (needed for one click deploy) 
* Maven

#Importing the Maven Project into Eclipse

You will need to manually add the alexa-skills-kit-1.0.120.0.jar to your Maven repository. 

Download the Helloworld sample https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/using-the-alexa-skills-kit-samples-java

Navigate to the directory lib directory which contains alexa-skills-kit-1.0.120.0.jar and run

mvn install:install-file -Dfile=alexa-skills-kit-1.0.120.0.jar -DgroupId=com.amazon.speech -DartifactId=alexa-skills-kit -Dversion=1.0.120.0 -Dpackaging=jar

If successful you should be able to find the jar in your .m2 folder. You also will see the dependency resolved in your project.
The project was compiled and tested against JDK 7.

Update the src/AwsCredentials.properties in the project with your secretKey and AccessKey.
http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSGettingStartedGuide/AWSCredentials.html

#Deploying the Application

Right-clicking on the project you will be able to deploy to a AWS Elastic Beanstalk‎ instance. This will only work if you installed the AWS ToolKit for Eclipse.

Alternatively you can generate the war using the command below and deploy the war to your servlet container like Tomcat.

mvn compile war:war

##Generate the Self-Signed SSL certificate

https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/using-the-alexa-skills-kit-samples-java#setting-up-an-ssltls-java-keystore

http://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingServerCerts.html

(Sidenote: I was never able to generate the cert successful on my Mac running 10.10.4 using OpenSSL (0.9.8zf 19 Mar 2015). I used an Ubuntu VM and ran the openssl and aws command with no problem.)



#Creating the Skill
From the Amazon developer console.

Define the endpoint https://elastibeanstalk-hostname**/stocks**


Open the cert generated in the previous step and copy/paste it.


Also copy the contents of IntentSchema.json and SampleUtterances.baf into Intent Schema and Sample Utterances respectively.

#Test it!
From your Amazon Echo say:
* *Ask stocks. What's the stock price for company Facebook*
*  *Ask stocks. What's the stock price for symbol F*
 

--------------------------

These links helped me along the way:
* http://stackoverflow.com/questions/8826881/maven-install-on-mac-os-x (Installing Maven)
* http://docs.aws.amazon.com/AWSToolkitEclipse/latest/GettingStartedGuide/tke_setup_install.html (Installing the AWS Eclipse Plugin)
* http://www.jarloo.com/yahoo-stock-symbol-lookup/ (Yahoo Symbol Lookup)
* https://developer.yahoo.com/yql/console/ (Yahoo Query Language Console)
* http://www.jsonschema2pojo.org (For generating the Model for the YQL response)

