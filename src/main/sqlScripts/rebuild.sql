#this script allows for efficent rebuilds

drop database farmhouse;  #nuke it
create database farmhouse;
use farmhouse;

source /mnt/d/webU/Kim_Deployable/src/main/sqlScripts/mainSchema.sql; #rebuild it
source /mnt/d/webU/Kim_Deployable/src/main/sqlScripts/testScript.sql;
