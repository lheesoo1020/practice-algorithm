select month(start_date) as month, car_id, count(*) as RECORDS
from car_rental_company_rental_history
where car_id in (
    select car_id
    from car_rental_company_rental_history
    where year(start_date) = 2022 and month(start_date) between 8 and 10
    group by car_id
    having count(*) >= 5)
    and month(start_date) between 8 and 10
group by month, car_id
order by month asc, car_id desc