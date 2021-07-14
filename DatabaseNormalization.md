### Database Normalization

Take for example the table below that models a school scheduling system

| Student Name    | Course Code | Course Name   | Room Number | Professor | Grade |
| --------------- | ----------- | ------------- | ----------- | --------- | ----- |
| Maya Charlotte  | CS101       | Intro to Java | 1802        | Balderez  | 98    |
| James Fields    | CS101       | Intro to Java | 1802        | Balderez  | 82    |
| Michael Alcocer | CS101       | Intro to Java | 1650        | Su        | 65    |
| Maya Charlotte  | CS103       | Databases     | 1200        | Rojas     | 89    |
| Michael Alcocer | CS101       | Intro to Java | 1650        | Su        | 65    |
| James Fields    | CS101       | Intro to Java | 1802        | Balderez  | 82    |

This table has duplicate entries. We begin our pseudo-normalization by removing them.

| Student Name    | Course Code | Course Name   | Room Number | Professor | Grade |
| --------------- | ----------- | ------------- | ----------- | --------- | ----- |
| Maya Charlotte  | CS101       | Intro to Java | 1802        | Balderez  | 98    |
| James Fields    | CS101       | Intro to Java | 1802        | Balderez  | 82    |
| Michael Alcocer | CS101       | Intro to Java | 1650        | Su        | 65    |
| Maya Charlotte  | CS103       | Databases     | 1200        | Rojas     | 89    |

We are lacking a primary key since no field or combination of fields can identify a single row. (It may seem that student name and course code are a composite key but multiple students can have the same name in the same course).

| id  | Student Name    | Course Code | Course Name   | Room Number | Professor | Grade |
| --- | --------------- | ----------- | ------------- | ----------- | --------- | ----- |
| 0   | Maya Charlotte  | CS101       | Intro to Java | 1802        | Balderez  | 98    |
| 1   | James Fields    | CS101       | Intro to Java | 1802        | Balderez  | 82    |
| 2   | Michael Alcocer | CS101       | Intro to Java | 1650        | Su        | 65    |
| 3   | Maya Charlotte  | CS103       | Databases     | 1200        | Rojas     | 89    |

The course name is dependent on the course code. That's a non-prime dependency. Let's move these to a new table.

| id  | Student Name    | Course Code | Room Number | Professor | Grade |
| --- | --------------- | ----------- | ----------- | --------- | ----- |
| 0   | Maya Charlotte  | CS101       | 1802        | Balderez  | 98    |
| 1   | James Fields    | CS101       | 1802        | Balderez  | 82    |
| 2   | Michael Alcocer | CS101       | 1650        | Su        | 65    |
| 3   | Maya Charlotte  | CS103       | 1200        | Rojas     | 89    |

| Course Code | Course Name   |
| ----------- | ------------- |
| CS101       | Intro to Java |
| CS103       | Databases     |

Note that a course can be taught in different rooms by different teachers. The room number is dependent on course code and teacher combination. That's a dependency on non-prime attributes. Let's move those into a new table.

| id  | Student Name    | Course id | Grade |
| --- | --------------- | --------- | ----- |
| 0   | Maya Charlotte  | CS101-A   | 98    |
| 1   | James Fields    | CS101-A   | 82    |
| 2   | Michael Alcocer | CS101-B   | 65    |
| 3   | Maya Charlotte  | CS103-A   | 89    |

| id      | Course Code | Room Number | Professor |
| ------- | ----------- | ----------- | --------- |
| CS101-A | CS101       | 1802        | Balderez  |
| CS101-B | CS101       | 1650        | Su        |
| CS103-A | CS103       | 1200        | Rojas     |

| Course Code | Course Name   |
| ----------- | ------------- |
| CS101       | Intro to Java |
| CS103       | Databases     |

---


Question  :  Using pen and paper, normalize the database below. 
  
  Customer Name | Address | email | product purchased | price | seller | quantity ordered
  --- | --- | --- | --- | --- | --- | ---
  Agustine Riviera | 123 SunnyDale | arivi5@sample.com | Electric Toothbrush | 15.15 | Pitz | 5
  Agustine Riviera | 123 SunnyDale | arivi5@sample.com | Pencil | 3.12 | Pitz | 13
  Agustine Riviera | 422 Cruz Verde | agus.tino.riviera@example.com | Umbrella | 20.17 | Hardy | 1
  Rebecca Tonna | 5 Real Ortega | happyrio@example.com | Pencil | 3.12 | Pitz | 20
  Sonia Riviera | 123 SunnyDale | sonia.riviera@sample.com | Cellphone | 512.00 | Orange | 1
  Rebecca Tonna | 5 Real Ortega | happyrio@example.com | Cellphone | 512.00 | Orange | 1
  Jaime Torres | 15 Sunnydale |prof.torres@sample.edu| Camera | 327.99 | Orange | 1
