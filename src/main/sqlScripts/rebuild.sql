#this script allows for efficent rebuilds

drop database farmhouse;  #nuke it
create database farmhouse;
use farmhouse;

source ~/IdeaProjects/Farmhouse-Site/src/main/sqlScripts/mainSchema.sql; #rebuild it
source ~/IdeaProjects/Farmhouse-Site/src/main/sqlScripts/testScript.sql;
