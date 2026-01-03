select year(DIFFERENTIATION_DATE) as YEAR, 
max(SIZE_OF_COLONY) over (partition by year(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY as YEAR_DEV,
ID
from ecoli_data
group by year(DIFFERENTIATION_DATE), size_of_colony, id
order by year(DIFFERENTIATION_DATE) asc, YEAR_DEV 