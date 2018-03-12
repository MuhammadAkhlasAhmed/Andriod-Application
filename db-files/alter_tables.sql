ALTER TABLE `item_review` 
CHANGE COLUMN `item_id` `item_id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `movies_title`

CHANGE COLUMN `movie_id` `movie_id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `item_review` 
DROP COLUMN `foreign`;
