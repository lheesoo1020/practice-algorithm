select distinct o.user_id, o.product_id
from online_sale as o
where o.user_id in (
    select user_id
    from online_sale as t
    where o.user_id = t.user_id
        and o.product_id = t.product_id
        and o.sales_date != t.sales_date)
order by o.user_id asc, o.product_id desc