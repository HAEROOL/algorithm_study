select count(e.ID) "COUNT"
from ECOLI_DATA e
where e.GENOTYPE & 2 != 2 and (e.GENOTYPE & 1 = 1 or e.GENOTYPE & 4 = 4)