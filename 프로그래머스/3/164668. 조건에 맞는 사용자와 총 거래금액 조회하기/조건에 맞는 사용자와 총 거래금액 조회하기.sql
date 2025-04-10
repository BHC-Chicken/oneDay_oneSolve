select u.USER_ID, u.NICKNAME, ts.TOTAL_SALES
from USED_GOODS_USER u
join (
    select WRITER_ID as USER_ID, sum(PRICE) as TOTAL_SALES
    from USED_GOODS_BOARD
    where STATUS = "DONE"
    group by WRITER_ID
) ts on u.USER_ID = ts.USER_ID
where ts.TOTAL_SALES >= 700000
order by ts.TOTAL_SALES asc;
