select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(date_of_birth, "%Y-%m-%d") as DATE_OF_BIRTH
from member_profile
where DATE_FORMAT(DATE_OF_BIRTH, "%m") = 3 and TLNO is not null AND GENDER='W'