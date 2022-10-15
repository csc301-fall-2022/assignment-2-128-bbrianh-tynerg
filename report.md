# CSC301 Assignment 2, Checkout Calculator

## Brief Summary

After considering available options, incoporated the team's familiarity with different technologies, and the requirements and tech stack of the course project, we chose to build an android app using Java with MVVM architecture. 

Firstly, for the frontend UI, since the application does not need many pages, we choose to use one single Activity with several fragments. This way, the application is more expandable since the fragments could be reused for different functionalities in further development. Also, the performance of navigating between fragments is more efficient.

For the backend, which is the Model part in MVVM architecture, We included the logic of fetching data from the database and the calculations about the price and tax of the products. The Model has three main respsonsibility:

1. Read data from database. Menu and Cart data is fetched from menuItem and cartItem table in the databse respectively
2. Write data to database. When an item is added to cart, the model needs to update the cartItem table in the database
3. Price and tax calculation. After the cart data is fetched, we need to preform further calculations to obtain the price and tax information

Lastly, we chose Android Room as the database for this application since it directly interacts with the storage of the device. Threrefore, the data from the app can be store in the phone itself and there is no need for deploying the database separately on a server.

The details of the design decisions made for the frontend, backend, and database are described in the following section.

## Part 1: Design Decisions
 
### Language

#### i). Kotlin
**Pros**
- Typically requires less code than Java for the same functionality.
- Lightweight and faster to compile.
- Complete and up to date Tutorial in the Google's Android developer.
- Matured language that is getting more popular for recent Android Apps.

**Cons**
- Both team members have no experience using Kotlin.
- The course project is not implemented using Kotlin.

#### ii). Java (Chosen)
 
**Pros**
- Both members are familiar with Java programming.
- Same language as the course project.
- Supports a wider variety of systems and devices.
- One of the most popular languages in software development.

**Cons**
- Many tutorials for Java Android are old and contain deprecated functions.
- The structure of the code is somewhat heavy and can be difficult to understand.
 
### Frontend

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

### Backend

#### i). TODO

**Pros**
- TODO

**Cons**
- TODO

#### ii). TODO (Chosen)
 
**Pros**
- TODO
**Cons**
- TODO

### Database

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









