DECLARE
BEGIN
  FOR MARCA IN (SELECT IDMARCA, NOME FROM MARCA)
  LOOP 
    DBMS_OUTPUT.PUT_LINE('Copiando marca :' || MARCA.NOME);
    update veiculo v set v.idmarca = MARCA.idmarca where v.marca = MARCA.nome;
    commit;
  END LOOP;
END;