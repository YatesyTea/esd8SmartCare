# Testing for SmartCare

[toc]

# White Box Testing (Unit Tests)

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



# Black Box Testing

