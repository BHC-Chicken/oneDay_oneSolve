select  count(*) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from (select FISH_TYPE,ID,
    case when LENGTH is null then 10 else LENGTH end as LENGTH
  from FISH_INFO) AS adjusted
group by FISH_TYPE
having avg(LENGTH) >= 33
order by FISH_TYPE asc;