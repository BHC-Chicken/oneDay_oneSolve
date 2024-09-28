select count(ID) as FISH_COUNT, month(TIME) as MONTH
from FISH_INFO
group by MONTH(TIME)
order by MONTH;