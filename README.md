# SAP_Mobile_platform_Android_APP
Migrating MBO Object API Android application to Harmonized OData SDK

What is it?
-----------
This GIT repository contains an android sample project (in Android Studio) that was part of an exercise where we took an exisitng MBO Object API based application, reused the existing layout and created a new Android app with the same funtionality using the Harmonized OData SDK in SMP 3.0

Get started!
------------
In order to run this app, you need to complete the following steps:

Step 1: Building OData Model: 
The following two guides explain how to create OData model in SAP Gateway to expose the same SAP backend (used in the MBO model) as OData services:
- How To… Build OData Services Using SAP Gateway (https://scn.sap.com/docs/DOC-64480): explains step-by-step procedure for designing and developing an end-to-end OData service focusing on the tasks that are most relevant in meeting the requirements of an MBO based application
- How To… Implement Delta Query Support in SAP Gateway OData Service (https://scn.sap.com/docs/DOC-64479): describes step-by-step procedure for designing and implementing an OData service with delta querying capabilities using an ABAP based delta request log and xChange Framework

Step 2: Creating app configuration
In the SMP management cockpit you can create application configurations. The application configuration or application definition must include a unique application identifier, connections to the back-end data source, and security profile settings. Details about creating the application configuration can be found here http://scn.sap.com/docs/DOC-64199

Step 3: Downloading this app
Follow the steps found in this guide (http://scn.sap.com/docs/DOC-65722) to set up the business partner sample app with Android Studio





