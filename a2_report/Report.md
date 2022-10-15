# CSC301 Assignment 2 -- Checkout Calculator -- Design Decision Report
>_Note_: This document is the report for design decision. For instructions to use the app and a detailed description for the UI, please refer to [the instruction file](https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/a2_report/Instruction.md).

## Brief Summary

We assume that our app needs to run on Android. After considering available options, incoporated the team's familiarity with different technologies, and our assumption to develope on Android, we chose to build an android app using Java on both frontend and backend as it is the official and one of the most popular languages for Android development.

Firstly, for the frontend UI, since the application does not require many complex interface navigation, we choose to use one single Activity with several fragments. This way, the application is more expandable since the fragments could be reused for different functionalities in further development. Also, the performance of navigating between fragments is more efficient.

For the backend, we included the logic of fetching data from the database and the calculations for the price and tax of the products. The backend has three main respsonsibility:
1. Read data from database: Menu and Cart data is fetched from menuItem and cartItem table in the databse respectively
2. Write data to database: When an item is added to cart, the model needs to update the cartItem table in the database
3. Price and tax calculation: After the cart data is fetched, we need to preform further calculations to obtain the price and tax information

Lastly, we chose Android Room as the database for this application since it can be set up and run locally on the Android device. Since it is able to  directly interact with the storage of the device, the data from the app can be stored in the phone itself and there is no need for deploying the database separately on a server. We could also implement user-friendly save and load feature for our calculator app. The database consits of 2 tables, namely cartItem and menuItem. The cartItem table stores the items in the cart and is updated corresponding to the user's action. The menuItem table provides information for each product on the menu, including the name, price and whether it is a taxed product. For simplicity of this project, the database is populated with a fixed set of data when the app starts, but this process could be replaced by using APIs to fetch data from a remote server in future updates.

The details of the design decisions made for the frontend, backend, and database are described in the following section.
 
## Frontend

#### i). Xamarin
**Pros**
- Mature cross platform language.
- Compatible with the MVVM architecture.
- Supports a wider variety of devices.
- Matured language that is getting more popular for recent Android Apps.

**Cons**
- Both team members have no experience with Xamarin.
- UI is challanging and time-consuming.
- App size tends to be large.

#### ii). Java (Chosen)
 
**Pros**
- Both members are familiar with Java programming.
- Same language as the course project.
- One of the most popular languages in software development.
- Full support for Android, can be used by both frontend and backend

**Cons**
- Only supports Android.
- Many tutorials for Java Android are old and contain deprecated functions.
- The structure of the code is somewhat heavy and can be difficult to understand.

#### ii). React Native
 
**Pros**
- Mature cross platform language.
- Compatible with the MVVM architecture.
- Team members have experience with JavaScript and React.
- One of the most popular languages in corss platform mobile development.

**Cons**
- Cross platform may require more time to develop.
- Components may behave differently for IOS and Android platforms.
- Testing can be difficult to manage.

## Backend

#### i). Django

**Pros**
- Since Django is a python-based platform, the code is easy to read and comprehen
- Django supports verious frameworks that works on server
- It has a diverse ecosystem, which means it has many librarys and packages for different uses

**Cons**
- Besides the mobile UI, we need to set up another Django server with Rest API
- It requires internet connection to transfer data. This would be a little overloaded for this project.
- We need to get familiar with another language for frontend developement

#### ii). Node.js

**Pros**
- It has frameworks such as AndroidJS that supports Android app development
- Javascript could also be used in frontend in Android development
- It can be used for developing cross-platform apps so we could build something that works on both Android and iOS

**Cons**
- Both of use are unfamiliar with Node.js
- AndroidJS framework needs to communicate with Native components in Android (which is written in Java) so it would be less efficient than using Java directly
- Node.js is more popular in web app development than in native mobile app development

#### iii). Java (Chosen)
 
**Pros**
- Most of the Android native libraries and components are written in Java
- Both of us had experience in Android development with Java
- Java is strongly supported by Android Studio, which is a powerful IDE that increases our efficiency in Android app development
- Both front and back end can be developed in Java

**Cons**
- Java is difficult to learn compared to python and javascript
- Java is less readable compared to python

## Database

#### i). Firebase
**Pros**
- Had experience using firebase in CSC207.
- Simple to setup by following the google tutorial.
- Interactive UI for database management.
- Ample database size.

**Cons**
- Needs to be deployed separately.
- Interaction between the App and the database is a little syntax heavy.

#### ii). PostgreSQL 
 
**Pros**
- Learning in CSC343.
- One of the most highly used DBMS in the industry.
- Supports a wide range of programming languages.
- Flexible text search.
- Ample database size.

**Cons**
- Relational database which could be more complex to setup.
- Needs to be deployed separately.

#### iii). Android Room (chosen)
 
**Pros**
- lighter than SQL DBMSs.
- Interacts directly with the storage on mobile devices.
- Does not need to be deployed separately on a server.

**Cons**
- Restricted database size.
- Both members are not familiar with Android Room.
- Data is not recoverable once deleted since there is no server.

## Frontend Structure

#### i). Building the UI using Activities

**Pros**
- Both team members have some experience in building the app using multiple activities. 
- Interaction between different activities are easier to manage.

**Cons**
- Not recommended since fragment is introduced in Android 11.
- Transition between activities is more expensive.
- Not resuable.

#### ii). Building the UI using one single Activity + several Fragments (Chosen)
 
**Pros**
- Fragments are reusable.
- Switching between fragments are more efficient.
- recommended structure by the 

**Cons**
- Both members are not familiar with fragment lifecycle.
- Interaction between a fragment and it's host activity can be difficult to understand/manage.
