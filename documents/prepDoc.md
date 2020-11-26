# Smart Care Prep Documents



## Table of Contents

1. [Specification Condensed](#specification-condensed)
2. [Functional Requirements](#functional-requirements)
3. [Non Functional Requirements](#non-functional-requirements)
4. [Actors](#actors)
5. [User Stories](#user-stories)
6. [Feature List](#feature-list)
7. [Navigation](#navigation)
8. [Member Preferences](#member-preferences)
9. [Links](#links)

# Preamble

### Context

> GP Business
>
> * Requires 1 doctor, 1 Nurse serve on Mon and Fri
> * 2 Rest of Week
>
> * Everybody needs online access (different authentications)
> * NHS and Private (billing records, bills to either NHS, or customer).
> * Set time consultations.
> * Prescribed or forwarded to specialist doctors

# Specification Condensed

### Project Spec

4 types of user (doctor, nurse, patient, admin)

Doc and Nurse view patient timetables, and issue prescription.

Patients book online, can request repeating prescriptions.

Invoice generation.

Admin:

> Records
>
> User operations
>
> Produce all weekly documents:
>
> 	* Turnover
> 	* Private Payments
> 	* Charges to NHS
> 	* Calc Turnovers (daily, weekly, monthly)



Session timeouts on users.

Sign-up auth by admin for nurse and doctor.
Patient is auto.

Calendar functionality through Google Calendar API as a web service.
Address lookup can be handled through google maps.

Filtering chapter 13 of HF book for showing data required to user authentication level.

# Actors

Business owner

> Are the primary client, will benefit from the system however is unlikely to personally use it.
> Therefore the main deliverable to the client will be the result that it has on the business.
> The clients in this case are Mehmet and Chris and are required to be contacted formally if we're enquiring in the role of developer and client communications.

Admin

> Oversees the management of staff accounts.
> Can view timetabling but not individual data of patients.
> Is able to generate documents required for reports within the business including charges and turnover.

Doctor/Nurse

> Fulfil the same role in terms of the system, at least within the prototype as actors.
> 

Patient

> Interacts with the system in order to meet needs to book appointments and subscriptions.
> Normal access with no higher authorisation.

DB Handler

SmartWare Company (us)

> Developing this application prototype.
> Ideally easily maintainable code that could be handed to another team after prototyping is complete or even later on down the line.

Google Calendar API

Google Maps API

# User Stories

As *x* I want to *y* so I can *z*.

# Requirements Copied From Spec

## The Web Application is expected to meet the following requirements:

1)   At least the following pages are expected to be included:

a)  The main (home) page letting users select the type of user and action ahead

b)  Login/registration page for member users is required

c)  A Dashboard page for “doctor” users 

d)  A Dashboard page for “nurse” users

e)  A Dashboard page for “patient” users

f)   A Dashboard page for “admin” users that lets to process the operations as required

2)   A user should be able to navigate through the pages, smoothly, and especially be able to access to its own dashboard and the home page from any page. 

3)   A member should remain logged on until either the session is timeout or user is changed. With this respect, access to any different member’s dashboard must be secured. 

4)   A web service can be used for acquiring Google Calendar services (or any other calendar service or API) to use for booking appointment with doctors or nurse.  Also, another web service (e.g. Google Map services) can be used to look up users’ addresses, and retrieve them automatically. 

5)   The whole system should be using 

(i)      Java EE components following MVC patterns, 

(ii)     interacting with database (Java DB), and 

(iii)     deployed on a server, which has a container (GlassFish).



# Functional Requirements



# Non Functional Requirements

# Feature List



## Feature X: Feature Title

Description of Feature

Inputs

Returns

Additional details



## Feature 1: Login Function

### Description

The login function is used to gain access to the application.
Also used with the session feature to create cookies which will control access to different parts of the application based on role.

### Input

* Username (textbox)
* Password (textbox)
* Submit (Button)

### Returns 

* Role of user details entered.
* Or displays message stating incorrect username/password.

### Additional Details

Will be accessed from the 'home' page.



## Feature 2: Sign-up Function

Accessed via home view

Considering the SQL supplied for the database these details will be required for signup.

```sql 
INSERT INTO CLIENTS (CNAME, CADDRESS, CTYPE, UNAME) VALUES ('Prince Hassan', 'Non-UK street, Non-UK Town, Non_UK', 'private', 'princehassan')
```

Input: Full Name, Address, Type of Care (NHS or Private), Username, Password (All textbox).




## Feature 3: Dashboards



## Feature 4: Sessions



## Feature 5: Patient Timetables



## Feature 6: Issue Prescription



## Feature 7: Patient Booking



## Feature 8: Approve Staff User



## Feature 9: Produce Weekly Documents



## Feature 11: Assign Payments



# App Navigation



```mermaid
graph LR
a[Home] --> b1(Login/Signup)
	
	b1 --> c1(Patient Dashboard)
		c1 --> pd1(View Appointments)
		c1 --> pd2(Book Appointment)
		c1 --> pd3(Request Repeating Prescription)
		
	b1 --> c2(Staff Dashboard)
		c2 --> sd1(View Patient Timetables)
		c2 --> sd2(Issue Prescription)
		
	b1 --> c3(Admin Dashboard)
		c3 --> ad1(Produce Weekly Documents)
		c3 --> ad2(Approve Staff User)
		c3 --> ad3(View Patient Timetables)
```

# Member Preferences

Preferences out of list of - Model, View, Controller, Testing, Documentation.

* Carl - 

* Dan - View, Testing, Documentation

* Frank - 

* Reece - 

* Sam - 



# Links

GitHub: [YatesyTea/esd8SmartCare: Smart care systems project for UWE 3rd year Enterprise Systems Development module. (github.com)](https://github.com/YatesyTea/esd8SmartCare)

This Document: [esd8SmartCare/prepDoc.md at main · YatesyTea/esd8SmartCare (github.com)](https://github.com/YatesyTea/esd8SmartCare/blob/main/prepDoc.md)

Trackers: [Google Sheets Tracker](https://docs.google.com/spreadsheets/d/19khCFj7zJaRq_iWB3Ul_akeA11pgPlihyJvwMop_d0c/edit?usp=sharing)

Sprint Kanban's: [Projects · YatesyTea/esd8SmartCare (github.com)](https://github.com/YatesyTea/esd8SmartCare/projects)

[Back to Top](#smart-care-prep-documents)





