-- 수원, 연도별 평균 미세먼지, 평균 초미세먼지
select YEAR(YM) as YEAR, round(avg(PM_VAL1), 2) as PM10, round(avg(PM_VAL2), 2) as `PM2.5`
from AIR_POLLUTION
where LOCATION2 = '수원'
group by YEAR
order by YEAR