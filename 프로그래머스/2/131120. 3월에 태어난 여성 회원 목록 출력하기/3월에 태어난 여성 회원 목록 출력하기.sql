select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH from member_profile 
where month(date_of_birth) = '3' and gender = 'W' and tlno is not null order by member_id;