#this script allows for efficent rebuilds

drop database farmhouse;  #nuke it
create database farmhouse;
use farmhouse;

<<<<<<< HEAD
source /mnt/d/webU/Kim_Deployable/src/main/sqlScripts/mainSchema.sql; #rebuild it
source /mnt/d/webU/Kim_Deployable/src/main/sqlScripts/testScript.sql;
=======
source ~/IdeaProjects/Farmhouse-Site/src/main/sqlScripts/mainSchema.sql; #rebuild it
source ~/IdeaProjects/Farmhouse-Site/src/main/sqlScripts/testScript.sql;
>>>>>>> 4c729c7a0f9b0dadcf68cd190530ffbc894a7675
