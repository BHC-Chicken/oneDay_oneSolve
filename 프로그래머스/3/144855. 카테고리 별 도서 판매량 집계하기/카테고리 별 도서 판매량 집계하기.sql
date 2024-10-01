select CATEGORY, sum(SALES) as TOTAL_SALES 
from BOOK as book
join BOOK_SALES as sales
on book.BOOK_ID = sales.BOOK_ID
where SALES_DATE like '2022-01%'
group by book.CATEGORY
order by book.CATEGORY