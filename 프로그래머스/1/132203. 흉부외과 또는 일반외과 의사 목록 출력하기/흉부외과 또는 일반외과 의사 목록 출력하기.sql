SELECT dc.DR_NAME, dc.DR_ID, dc.MCDP_CD, DATE_FORMAT(dc.HIRE_YMD, "%Y-%m-%d") as HIRE_YMD
from DOCTOR dc
where dc.MCDP_CD = 'CS' or dc.MCDP_CD = 'GS'
order by dc.HIRE_YMD desc, dc.DR_NAME;