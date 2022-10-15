# CSC301 Assignment 2, Installation and Testing Instruction
> _Note:_ This is the instruction for installing and testing our android application. For more detailed description of the app and design decisions, please read [the design decision report](https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/main/report.md).

## Installation

### Requirements:
- An android device with Android 10 more higher.

### Step 1: Download the App From the Repo
[A short video for this step](https://youtube.com/shorts/n8KWAAbDvPM?feature=share)
- Please download the .apk file from [here](https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/releases/download/v1.0/CheckoutCalculator_v1.0.0.apk).
- Alternatively, you can go to the "Release" section on the GitHub page for the repository and download the apk there.
> _Note:_ If you have never installed an app outside of the Google Play, your device may prohibit you from installing. If that happens, please follow the instruction [here](https://www.maketecheasier.com/install-apps-from-unknown-sources-android/) to allow your phone to install from an unkown source. (We promise that our app does not contain any virus ;) )

### Step 2: Enjoy the App!

[A short Demo video!!!](https://youtu.be/Wh6iBVppPe8)

The App consists of 3 pages, the homepage, the menu page, and the cart page.

<img src="https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/images/pages.png">

Each pages contain different components and serve different functionalities:

**Home Page:** 
- welcomes the user when they enter the app. 
- direct the user to other pages.

**Menu Page:** 
- list the information of each item.
- allows the user to select item from an existing menu.

**Cart Page:** 
- list the item that the user has selected. 
- show the price, quantity, tax status and subtotal of each item.
- show the subtotal, tax, and toal price of the cart.
- allows the user to adjust or remove the quantity of the selected items.
- allows the user to enter and apply a discount rate.

### Product Highlights!
**Auto save/load**
The cart is automaically saved every time when an item is added or removed.

**Live update**
The calculated price are sychronously changed when an item is added or removed.

## Testing

### Basic Functionality Test

Please feel free to play around with the app to see if every feature described above behave correctly!


### Running Unit Tests

**unit tests that does not need an emulator**
- clone the repo to your local device using
```git clone https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg.git```
- cd to the directory of the source file
- run ```./gradlew test``` to run unit tests that does not need an emulator.
- Test result report are available at ```/app/build/reports/tests/testDebugUnitTest/index.html```

Expected terminal result:

<img src="https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/images/test1.jpg" width=700>


**unit tests that does need an emulator**
> _Note:_ make sure to uninstall the app before running this test
- connect an android emulator to your computer
- cd to the directory of the source file
- run ```./gradlew connectedCheck with a connected emulator```
- Test result report are available at ```/app/build/reports/androidTests/connected/index.html```

Expected terminal result:

<img src="https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/images/test2.jpg" width=700 >

## Auto Deployment

We've also implemented auto-deployment using GitHub Action in [a personal fork of the project](https://github.com/bbrianh/assignment-2-128-bbrianh-tynerg).

The following GitHub Action is triggered by new push or merge to the main branch (time limit 3 mins):

<img src="https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/images/autoDeployment.png" width=700>

An .apk file is automatically built after the workflow. 

Here's the yml file of the action:

<img src="https://github.com/csc301-fall-2022/assignment-2-128-bbrianh-tynerg/blob/report/images/yml%20file.png" width=700>"

