select count(user_id) as USERS from USER_INFO 
where year(joined) = '2021' and age between 20 and 29;