# LMS
Simple Leave Management Application

------------------------------------------------
Inserting some dummy data:

INSERT INTO EMPLOYEE_INFO VALUES ('1','aa@gmail.com','E2','gajendra','muriyal')


insert into employee_info values ('123','g@gmail.com','E1','Gajendra','Muriyal','gana@123','Gajendrasingh')
insert into employee_info values ('1234','ga@gmail.com','E2','Gajendras','Muriyalg','gana1@123','Gajendrasinghm')

insert into leave_details values ('1','3','20-03-2020','EARNED LEAVE','ABCDFEGH','23-03-2020','123','Gajendrasingh');

----------------------------------------------------------------------
To get The all leave details of an employee:

URL: http://localhost:8080/employee/1234
Method: GET



-----------------------------------------------------------------

Post the leave details of an employee 

URL:http://localhost:8080/employee/jpa/applyleave/1234/leaveId
Method: POST

Request Body:
     {
        "leaveType": "SICK LEAVE",
        "duration": 3,
        "fromDate": "23-03-2020",
        "toDate": "26-03-2020",
        "reason": "Not keeping well",
        "username":"Singh"
        
    }

--------------------------------------------------------
For vaildation purpose skip from date property in the request:
URL : http://localhost:8080/employee/jpa/applyleave/1234/leaveId
Method: POST

   {
        "leaveType": "Test LEAVE",
        "duration": 3,
         "toDate": "26-03-2020",
        "reason": "done",
        "username":"Singh"
        
    }

