select p.product_code,
       sum(sales_amount * price) as sales
from product p
join offline_sale os
on p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code asc