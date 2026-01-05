select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from item_info as i
left join item_tree as t on i.item_id = t.parent_item_id
where t.parent_item_id is null
order by i.item_id desc
