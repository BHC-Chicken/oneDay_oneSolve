select car_type, count(options) as CARS from car_rental_company_car where options like '%시트%'
group by car_type order by car_type