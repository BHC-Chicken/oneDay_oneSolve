select floor(price/10000) * 10000 as PRICE_GROUP, count(product_id) as PRODUCTS
from product
group by PRICE_GROUP
order by PRICE_GROUP;