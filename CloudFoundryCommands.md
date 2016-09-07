## Basic Cloud Foundry Commands

`cf l`  :- login

`cf t` :- target space or organization

`cf a` :- list apps in current space

`cf app <AppName>` :- display status for specific app in current space

`cf p` :- push (deploy or update) app

`cf s` :- show service info

`cf cs` :- create service

`cf ds` :- delete service

`cf bs` :- bind service to application

`cf st <AppName>` :- start app

`cf sp` :- stop app

`cf d` :- delete app

`cf scale` :- scale app

`cf logs` :- tail or show logs for app

______________________________________________________

### Walk-through 

`cf l -a https://api.eu-gb.bluemix.net -u <email> -p <passwd> -o <organization> -s <space>`

`cf t` :- To check what space you are logged into  
`cf t -s test` :- Switches to test space  
`cf spaces` :- to check which spaces exist in an organization  
`cf space dev` :- move to the dev space  

`cf marketplace` :- List the available services  

`cf cs cloudantNoSQLDB Shared sampleAppLNM`  :- Create a service instance of type cloudantNoSQLDB and Shared  

`cf push sampleAppLNM -c "node app.js" -m 128M --no-manifest --no-start`  
//"node app.js" run command, 128MB memory, don't upload manifest as such the cloudant instance will be attached to this, and do not autostart the app  

No autostart because it needs a db to run. Bind the service cloudant db to application  
`cf bs <appName> <serviceInstanceName>`
`cf bs sampleAppName sampleAppName`		//were same in this case

//Start an application  
`cf start sampleAppLNM`

//To make changes. Edit the files, delete the sample_db in cloud foundry service  
`cf push sampleAppLNM -c "node app.js" --no-manifest`		//no need for no-start

//Delete the app
`cf d <appName> -r`		//-r for deleting the routes  
`cf d sampleAppLNM`		//confirm  

//Delete the cloudant service  
`cf ds <serviceInstanceName>`  
`cf ds sampleAppLNM`		//delete the cloud foundry service  


__________________________________________________________________

`bluemix api https://api.eu-gb.bluemix.net`  

`bluemix login -u arpan@lnmiit.ac.in -o arpan -s swe2016`    

`bluemix push`  