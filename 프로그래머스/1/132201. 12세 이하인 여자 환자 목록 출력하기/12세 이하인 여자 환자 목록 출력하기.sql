SELECT p.PT_NAME, p.PT_NO, p.GEND_CD, p.AGE, ifnull(p.TLNO, 'NONE') as TLNO
from PATIENT p
where p.AGE <= 12 and p.GEND_CD = 'W'
order by p.AGE desc, p.PT_NAME;