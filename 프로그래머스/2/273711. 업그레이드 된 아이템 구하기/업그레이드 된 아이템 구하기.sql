select c.ITEM_ID, c.ITEM_NAME, c.RARITY
from item_info as p
inner join item_tree as t on p.item_id = t.parent_item_id
inner join item_info as c on t.item_id = c.item_id
where p.rarity = 'RARE'
order by c.item_id desc;