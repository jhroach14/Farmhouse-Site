#this script allows for efficent rebuilds

drop database farmhouse;  #nuke it
create database farmhouse;
use farmhouse;

source /mnt/c/cygwin64/home/User/webU/farmhouse/src/main/sqlScripts/mainSchema.sql; #rebuild it
source /mnt/c/cygwin64/home/User/webU/farmhouse/src/main/sqlScripts/testScript.sql;