# Testing for SmartCare

[toc]

# White Box Testing (Unit Tests)



## DbConnection Test

test Connection is true



## Users Test

Initialise with a new User as ("test", "test", "doctor") at top of testing document

| Test Name            | Testing Function | Input     | Expected Output | Actual Output |
| -------------------- | ---------------- | --------- | --------------- | ------------- |
| testGetUsername      | getUsername      | -         | test            | test          |
| testSetValidUsername | setUsername      | UName     | UName           | UName         |
| testgetPassword      | getPassword      | -         | test            | test          |
| testgetValidPassword | setPassword      | THE BIG P | THE BIG P       | THE BIG P     |
| testgetRole          | getRole          | -         | doctor          | doctor        |
| testSetValidRole     | setRole          | nurse     | nurse           | nurse         |
| testSetInvalidRole   | setRole          | asf0-98   | Error           |               |



Proof that it's passed:

![image-20201209154125381](testing.assets/usersTest.png)

## Employees Test

get/set EID

get/set ENAME

get/set EADDRESS

get/set UNAME



## Patient Test

get/set CID (INT PK)

get/set CNAME (String)

get/set CADDRESS (String)

get/set CTYPE (NHS/Private)

get/set UNAME (String FK)



## Booking Test

get/set SID

get/set EID

get/set CID

get/set SDATE

get/set STIME



## Operations Test

get/set OID

get/set EID

get/set CID

get/set ODATE

get/set OTIME

get/set NSLOT

get/set CHARGE



## Prescription Test

get/set PrescriptionId

get/set CID

get/set EID

get/set Drug

get/set Amount

get/set Cost

get/set Reissue

get/set Date



[back to top](#testing-for-smartcare)

# Black Box Testing

## Feature 1: Login

Test Admin Login

Test Nurse/Doctor Login

Test Patient Login

Test Invalid Login

## Feature 2: Sign Up Function

Test Valid User Input

Test Duplicate User Input

Test Invalid User Input (Null Parameters Sent)

## Feature 3: Dashboards

Are all features here?
Do they link to correct pages?

Admin Dashboard



Nurse/Doctor Dashboard



Patient Dashboard

## Feature 4: Sessions

Go back to login page and see if you're still logged in.



## Feature 5: View Patient Timetables

Logged in as doctor/nurse user.
Click the view patient timetables button on the dashboard.

expected output : displays all of the patients timetabled appointments.


## Feature 6: Issue Prescriptions

## Feature 7: Client Booking

## Feature 8: Approve Staff User

## Feature 9: Produce Weekly Documents

## Feature 10: Generate Invoice

## Feature 11: Manage Staff

## Feature 12: Patient View Prescription





[back to top](#testing-for-smartcare)d