#this script allows for efficent rebuilds

drop database farmhouse;  #nuke it
create database farmhouse;
use farmhouse;

source /home/ubuntu/site/src/main/sqlScripts/mainSchema.sql; #rebuild it
source /home/ubuntu/site/src/main/sqlScripts/testScript.sql;

