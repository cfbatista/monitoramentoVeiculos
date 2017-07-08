Create tablespace VEICULODAT
 datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\veiculodat.dbf'
 size 100m
 autoextend on
 next 100m
 maxsize 2048m;

Create user VEICULO identified by VEICULO default tablespace VEICULODAT;
grant connect, resource, create view to VEICULO;