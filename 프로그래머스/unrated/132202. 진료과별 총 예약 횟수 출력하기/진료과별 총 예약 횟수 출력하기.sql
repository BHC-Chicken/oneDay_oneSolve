select mcdp_cd as '진료과코드', count(mcdp_cd) as '5월예약건수' from appointment 
where date_format(apnt_ymd, '%Y-%m-%d') between '2022-05-01' and '2022-05-31'
group by mcdp_cd order by 5월예약건수, 진료과코드