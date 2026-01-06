select i.NAME, i.DATETIME
from animal_ins as i
left join animal_outs as o on i.animal_id = o.animal_id
where o.datetime is null
order by i.datetime asc
limit 3