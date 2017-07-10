select longitude, latitude, count(1) 
from registro 
join camera using (idcamera)
where data_hora between to_Date('2017-03-28', 'YYYY-MM-DD') and to_Date('2017-03-29', 'YYYY-MM-DD')
group by longitude, latitude;

select to_Date('2017-03-28', 'YYYY-MM-DD') from dual;