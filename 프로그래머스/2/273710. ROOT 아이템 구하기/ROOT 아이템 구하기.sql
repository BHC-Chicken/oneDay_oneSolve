select info.ITEM_ID, ITEM_NAME
from ITEM_INFO as info join ITEM_TREE as tree on info.ITEM_ID = tree.ITEM_ID
where tree.PARENT_ITEM_ID is null;