select date_format(datetime, '%H') as hour, count(date_format(datetime, '%H')) as count from animal_outs
group by hour having hour between 9 and 19
order by hour