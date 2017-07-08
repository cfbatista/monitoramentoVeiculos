DECLARE
BEGIN
  FOR MARCA IN (SELECT IDMARCA, NOME FROM MARCA)
  LOOP 
    DBMS_OUTPUT.PUT_LINE('Copiando marca :' || MARCA.NOME);
    update veiculo v set v.idmarca = MARCA.idmar where v.marca = mrc.nome;
    commit;
  END LOOP;
END;