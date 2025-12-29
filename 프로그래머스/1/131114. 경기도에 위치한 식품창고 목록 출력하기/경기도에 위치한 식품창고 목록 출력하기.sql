select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, ifnull(FREEZER_YN, 'N') as FREEZER_YN
from food_warehouse
where Address like '경기도%'
order by warehouse_id asc