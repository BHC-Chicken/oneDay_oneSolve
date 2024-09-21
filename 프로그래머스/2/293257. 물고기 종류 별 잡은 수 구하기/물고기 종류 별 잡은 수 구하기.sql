select count(fn.fish_type) as FISH_COUNT, FISH_NAME
from fish_name_info as fn join fish_info as fi on fn.fish_type = fi.fish_type
group by fn.fish_name
order by FISH_COUNT desc