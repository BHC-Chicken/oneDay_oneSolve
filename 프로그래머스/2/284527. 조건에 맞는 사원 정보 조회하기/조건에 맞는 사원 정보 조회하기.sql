select sum(SCORE) as SCORE, emp.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES as emp join HR_GRADE as grade on emp.EMP_NO = grade.EMP_NO
where grade.YEAR = 2022
group by emp.EMP_NO
order by SCORE desc
limit 1