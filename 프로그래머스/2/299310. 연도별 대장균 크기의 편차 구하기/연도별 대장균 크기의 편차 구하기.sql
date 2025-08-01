SELECT YEAR(E.DIFFERENTIATION_DATE) AS YEAR, (
    SELECT MAX(SIZE_OF_COLONY)
    FROM ECOLI_DATA
    WHERE YEAR(DIFFERENTIATION_DATE) = YEAR(E.DIFFERENTIATION_DATE)
    GROUP BY YEAR(DIFFERENTIATION_DATE)
) - E.SIZE_OF_COLONY AS YEAR_DEV, E.ID
FROM ECOLI_DATA E
ORDER BY YEAR(E.DIFFERENTIATION_DATE), YEAR_DEV 