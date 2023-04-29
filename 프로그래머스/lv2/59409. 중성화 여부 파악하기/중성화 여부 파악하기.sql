select animal_id, name, if(sex_upon_intake like '%neutered%' or sex_upon_intake like '%spayed%', 'O', 'X') as upon 
from animal_ins order by animal_id