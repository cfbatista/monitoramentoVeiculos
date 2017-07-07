 create procedure insere_Cidades_Duplicadas as
 begin 
 declare
  cursor marca_duplicadas is
         select distinct Marca
         from veiculo;
  begin
     for cm_dupli in marca_duplicadas loop     
       insert into MARCA(IDMARCA, NOME) values(SQ_MARCA.NEXTVAL, cm_dupli.Marca);     
     end loop;
  end;
end insere_Cidades_Duplicadas;