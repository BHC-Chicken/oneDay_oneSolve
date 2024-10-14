select outs.ANIMAL_ID, outs.NAME from animal_outs as outs left outer join animal_ins as ins on ins.animal_id = outs.animal_id
where ins.intake_condition IS NULL 
   OR ins.intake_condition = '';